import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Comparator;

public class CSLinkedList<E> extends AbstractList<E> {

  private static final class Node<E> {
    E data;
    Node<E> next;
    Node(E d, Node<E> n) { data = d; next = n; }
  }

  private final Node<E> head;
  private Node<E> tail;
  private int size;

  public CSLinkedList() {
    head = new Node<>(null, null);
    tail = null;
    size = 0;
  }

  @Override
  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  private void checkElementIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private void checkPositionIndex(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private Node<E> nodeAt(int index) {
    checkElementIndex(index);
    Node<E> cur = head.next;
    for (int i = 0; i < index; i++) cur = cur.next;
    return cur;
  }

  @Override
  public boolean add(E e) {
    Node<E> n = new Node<>(e, null);
    if (size == 0) {
      head.next = n;
      tail = n;
    } else {
      tail.next = n;
      tail = n;
    }
    size++;
    modCount++;
    return true;
  }

  @Override
  public void add(int index, E e) {
    checkPositionIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> n = new Node<>(e, prev.next);
    prev.next = n;
    if (index == size) tail = n;
    size++;
    modCount++;
  }

  @Override
  public E get(int index) {
    return nodeAt(index).data;
  }

  @Override
  public E set(int index, E e) {
    Node<E> n = nodeAt(index);
    E old = n.data;
    n.data = e;
    return old;
  }

  @Override
  public E remove(int index) {
    checkElementIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> target = prev.next;
    prev.next = target.next;
    if (target == tail) {
      tail = (prev == head && prev.next == null) ? null : prev;
    }
    size--;
    modCount++;
    return target.data;
  }

  @Override
  public int indexOf(Object o) {
    int i = 0;
    for (Node<E> cur = head.next; cur != null; cur = cur.next, i++) {
      if (o == null ? cur.data == null : o.equals(cur.data)) return i;
    }
    return -1;
  }

    // LL3 – add only if item is not already present
    public boolean addIfAbsent(E item) {
        if (indexOf(item) != -1) {
            return false; // already there
        }
        add(item); // use existing add(E e)
        return true;
    }

    // LL5 – move an existing item to the front (index 0)
    public void moveToFront(E item) {
        if (size == 0) return;

        Node<E> prev = head;
        Node<E> cur = head.next;

        while (cur != null) {
            if (item == null ? cur.data == null : item.equals(cur.data)) {
                // Already at front
                if (prev == head) return;

                // Unlink cur from its current position
                prev.next = cur.next;
                if (cur == tail) {
                    // If we removed the tail, update it
                    tail = (prev == head && prev.next == null) ? null : prev;
                }

                // Insert cur right after head (front of list)
                cur.next = head.next;
                head.next = cur;
                if (tail == null) {
                    tail = cur;
                }

                modCount++;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    // LL6 – insert newItem after the first occurrence of target
    public boolean addAfter(E target, E newItem) {
        for (Node<E> cur = head.next; cur != null; cur = cur.next) {
            if (target == null ? cur.data == null : target.equals(cur.data)) {
                Node<E> n = new Node<>(newItem, cur.next);
                cur.next = n;
                if (cur == tail) {
                    tail = n;
                }
                size++;
                modCount++;
                return true;
            }
        }
        return false; // target not found
    }

    // LL8 – insert item so that the list stays sorted according to cmp
    public void addInOrder(E item, Comparator<E> cmp) {
        Node<E> prev = head;
        Node<E> cur = head.next;

        while (cur != null && cmp.compare(item, cur.data) > 0) {
            prev = cur;
            cur = cur.next;
        }

        Node<E> n = new Node<>(item, cur);
        prev.next = n;

        if (cur == null) {
            // inserted at the end
            tail = n;
        }
        if (size == 0) {
            tail = n;
        }

        size++;
        modCount++;
    }

    // LL9 – remove only the first occurrence of item
    public boolean removeFirstOccurrence(E item) {
        Node<E> prev = head;
        Node<E> cur = head.next;

        while (cur != null) {
            if (item == null ? cur.data == null : item.equals(cur.data)) {
                prev.next = cur.next;
                if (cur == tail) {
                    tail = (prev == head && prev.next == null) ? null : prev;
                }
                size--;
                modCount++;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    // LL10 – copy the list into a new CSLinkedList
    public CSLinkedList<E> copy() {
        CSLinkedList<E> result = new CSLinkedList<>();
        for (Node<E> cur = head.next; cur != null; cur = cur.next) {
            result.add(cur.data);
        }
        return result;
    }


    @Override
  public void clear() {
    head.next = null;
    tail = null;
    size = 0;
    modCount++;
  }

  @Override
  public Iterator<E> iterator() {
    return new Itr();
  }

  private final class Itr implements Iterator<E> {
    private Node<E> prev = head;
    private Node<E> cursor = head.next;
    private Node<E> lastPrev = null;
    private Node<E> lastRet = null;
    private int expectedMod = modCount;

    @Override
    public boolean hasNext() { return cursor != null; }

    @Override
    public E next() {
      checkForComod();
      if (cursor == null) throw new NoSuchElementException();
      lastPrev = prev;
      lastRet = cursor;
      prev = cursor;
      cursor = cursor.next;
      return lastRet.data;
    }

    @Override
    public void remove() {
      checkForComod();
      if (lastRet == null) throw new IllegalStateException();
      lastPrev.next = lastRet.next;
      if (lastRet == tail) {
        tail = (lastPrev == head && lastPrev.next == null) ? null : lastPrev;
      }
      size--;
      modCount++;
      expectedMod++;
      lastRet = null;
    }

    private void checkForComod() {
      if (expectedMod != modCount) throw new ConcurrentModificationException();
    }
  }
}
