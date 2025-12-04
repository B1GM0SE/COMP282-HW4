// CSLinkedListDriver.java
// Starter file for the Linked List portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runLL3_CourseWaitlist).

import java.util.Comparator;

public class CSLinkedListDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runLL1_Playlist();
        //runLL2_TodoList();
        //runLL3_CourseWaitlist();
        //runLL4_TextEditorLines();
        //runLL5_RecentlyContacted();
        //runLL6_ShoppingListAddAfter();
        //runLL7_BusRouteStops();
        //runLL8_EventScheduleSorted();
        //runLL9_BugTrackerRemoveById();
        //runLL10_PlaylistShuffleCopy();
    }

    // Helper to print a CSLinkedList with indices
    private static <T> void printListWithIndices(String title, CSLinkedList<T> list) {
        System.out.println(title);
        if (list.isEmpty()) {
            System.out.println("  [empty]");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + i + ": " + list.get(i));
        }
    }


    // LL1 – Music Playlist Manager
    private static void runLL1_Playlist() {
        // TODO: Implement task LL1 here.
        // See the assignment handout for the scenario description.
        System.out.println("=== LL1: Music Playlist Manager ===\n");

        CSLinkedList<String> playlist = new CSLinkedList<>();

        // Step 1: Add songs to the end of the playlist
        System.out.println("Adding songs to the playlist...");
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        printPlaylist(playlist);

        // Step 2: Insert a new song at the top (index 0)
        System.out.println("\nAdding 'Intro Song' to the top of the playlist...");
        playlist.add(0, "Intro Song");
        printPlaylist(playlist);

        // Step 3: Remove a song from the middle
        System.out.println("\nRemoving 'Song B' from the playlist...");
        int index = playlist.indexOf("Song B"); // find its position
        if (index != -1) {
            playlist.remove(index);
        }
        printPlaylist(playlist);

        System.out.println("\n=== End of LL1 Demo ===");
    }
    public static void printPlaylist(CSLinkedList<String> playlist) {
        System.out.println("Current playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println("  " + i + ": " + playlist.get(i));
        }
    }


    // LL2 – To-Do List with Priorities
    private static void runLL2_TodoList() {
        // TODO: Implement task LL2 here.
        System.out.println("=== LL2: To-Do List with Priorities ===\n");

        CSLinkedList<String> todo = new CSLinkedList<>();

        // Regular tasks go to the end
        todo.add("Do laundry");
        todo.add("Study for exam");
        todo.add("Watch TV");
        printListWithIndices("Initial to-do list:", todo);

        // Urgent tasks go to the front
        System.out.println("\nAdding urgent task 'Pay rent' to the front...");
        todo.add(0, "URGENT: Pay rent");
        printListWithIndices("After adding 'Pay rent':", todo);

        System.out.println("\nAdding urgent task 'Finish project' to the front...");
        todo.add(0, "URGENT: Finish project");
        printListWithIndices("After adding 'Finish project':", todo);

        // Remove a completed task by index
        System.out.println("\nCompleting task at index 2 (if it exists)...");
        if (todo.size() > 2) {
            String removed = todo.remove(2);
            System.out.println("Completed and removed: " + removed);
        } else {
            System.out.println("Not enough tasks to remove index 2.");
        }
        printListWithIndices("Final to-do list:", todo);

        System.out.println("\n=== End of LL2 Demo ===");
    }



    // LL3 – Course Waitlist (No Duplicates)
    private static void runLL3_CourseWaitlist() {
        // TODO: Implement task LL3 here.
        // You may add a helper method addIfAbsent(E item) to CSLinkedList if needed.
        System.out.println("=== LL3: Course Waitlist (No Duplicates) ===\n");

        CSLinkedList<String> waitlist = new CSLinkedList<>();
        String[] attempts = { "Alice", "Bob", "Charlie", "Alice", "Dana", "Bob" };

        for (String name : attempts) {
            boolean added = waitlist.addIfAbsent(name);
            System.out.println("Trying to add " + name + " -> " +
                    (added ? "ADDED" : "ALREADY ON WAITLIST"));
        }

        System.out.println();
        printListWithIndices("Final waitlist:", waitlist);

        System.out.println("\n=== End of LL3 Demo ===");

    }

    // LL4 – Text Editor Line Manager
    private static void runLL4_TextEditorLines() {
        // TODO: Implement task LL4 here.
        System.out.println("=== LL4: Text Editor Line Manager ===\n");

        CSLinkedList<String> lines = new CSLinkedList<>();

        lines.add("int x = 0;");
        lines.add("x = x + 1;");
        lines.add("System.out.println(x);");

        printListWithIndices("Original lines:", lines);

        System.out.println("\nInserting a new line in the middle (index 1)...");
        lines.add(1, "// increment x");
        printListWithIndices("After inserting new line:", lines);

        System.out.println("\nDeleting line at index 2...");
        if (lines.size() > 2) {
            String removed = lines.remove(2);
            System.out.println("Deleted: " + removed);
        }
        printListWithIndices("Final lines:", lines);

        System.out.println("\n=== End of LL4 Demo ===");

    }

    // LL5 – Recently Contacted Friends (Move to Front)
    private static void runLL5_RecentlyContacted() {
        // TODO: Implement task LL5 here.
        // You may add a helper method moveToFront(E item) to CSLinkedList if needed.
        System.out.println("=== LL5: Recently Contacted Friends ===\n");

        CSLinkedList<String> friends = new CSLinkedList<>();
        friends.add("Alice");
        friends.add("Bob");
        friends.add("Charlie");
        friends.add("Dana");

        printListWithIndices("Initial recently contacted list:", friends);

        String[] contacts = { "Charlie", "Alice", "Eve", "Bob" };

        for (String name : contacts) {
            System.out.println("\nYou message: " + name);
            friends.moveToFront(name);
            printListWithIndices("After contacting " + name + ":", friends);
        }

        System.out.println("\n=== End of LL5 Demo ===");

    }

    // LL6 – Shopping List: Insert After Item
    private static void runLL6_ShoppingListAddAfter() {
        // TODO: Implement task LL6 here.
        // You may add a helper method addAfter(E target, E newItem) to CSLinkedList if needed.
        System.out.println("=== LL6: Shopping List: Insert After Item ===\n");

        CSLinkedList<String> shopping = new CSLinkedList<>();
        shopping.add("Milk");
        shopping.add("Coffee");
        shopping.add("Bread");

        printListWithIndices("Initial shopping list:", shopping);

        System.out.println("\nInserting 'Sugar' after 'Coffee'...");
        boolean inserted = shopping.addAfter("Coffee", "Sugar");
        System.out.println("Insert success? " + inserted);

        printListWithIndices("After inserting 'Sugar' after 'Coffee':", shopping);

        System.out.println("\n=== End of LL6 Demo ===");

    }

    // LL7 – Bus Route Stops
    private static void runLL7_BusRouteStops() {
        // TODO: Implement task LL7 here.
        System.out.println("=== LL7: Bus Route Stops ===\n");

        CSLinkedList<String> stops = new CSLinkedList<>();
        stops.add("Downtown");
        stops.add("Library");
        stops.add("Mall");
        stops.add("Airport");

        printListWithIndices("Original route:", stops);

        System.out.println("\nAdding a new stop 'University' between Library and Mall...");
        int indexOfMall = stops.indexOf("Mall");
        if (indexOfMall != -1) {
            stops.add(indexOfMall, "University");
        }
        printListWithIndices("After adding 'University':", stops);

        System.out.println("\nRemoving closed stop 'Library'...");
        int indexOfLibrary = stops.indexOf("Library");
        if (indexOfLibrary != -1) {
            stops.remove(indexOfLibrary);
        }
        printListWithIndices("Final route:", stops);

        System.out.println("\n=== End of LL7 Demo ===");

    }

    // LL8 – Event Schedule (Insert by Time)
    private static void runLL8_EventScheduleSorted() {
        // TODO: Implement task LL8 here.
        // You may add a helper method addInOrder(E item, Comparator<E> cmp) to CSLinkedList if needed.
        System.out.println("=== LL8: Event Schedule (Insert by Time) ===\n");

        CSLinkedList<String> events = new CSLinkedList<>();

        // Times are at the start of the string in HH:MM format,
        // so natural String order = time order.
        Comparator<String> byTime = Comparator.naturalOrder();

        events.addInOrder("09:00 Breakfast", byTime);
        events.addInOrder("13:30 Lunch with team", byTime);
        events.addInOrder("08:30 Check email", byTime);
        events.addInOrder("17:00 Gym", byTime);
        events.addInOrder("12:00 Stand-up meeting", byTime);

        printListWithIndices("Events in time order:", events);

        System.out.println("\n=== End of LL8 Demo ===");
    }

    // LL9 – Bug Tracker List (Remove by ID)
    private static void runLL9_BugTrackerRemoveById() {
        // TODO: Implement task LL9 here.
        // You may add a helper method removeFirstOccurrence(E item) to CSLinkedList if needed.
        System.out.println("=== LL9: Bug Tracker List (Remove by ID) ===\n");

        CSLinkedList<Integer> bugIds = new CSLinkedList<>();
        bugIds.add(101);
        bugIds.add(202);
        bugIds.add(303);
        bugIds.add(202);
        bugIds.add(404);

        printListWithIndices("Initial bug ID list:", bugIds);

        System.out.println("\nRemoving first occurrence of bug 202...");
        boolean removedOnce = bugIds.removeFirstOccurrence(202);
        System.out.println("Removed? " + removedOnce);
        printListWithIndices("After first removal:", bugIds);

        System.out.println("\nRemoving first occurrence of bug 202 again...");
        boolean removedTwice = bugIds.removeFirstOccurrence(202);
        System.out.println("Removed? " + removedTwice);
        printListWithIndices("After second removal:", bugIds);

        System.out.println("\n=== End of LL9 Demo ===");

    }

    // LL10 – Playlist Shuffle Copy
    private static void runLL10_PlaylistShuffleCopy() {
        // TODO: Implement task LL10 here.
        // You may add a helper method copy() to CSLinkedList if needed.
        System.out.println("=== LL10: Playlist Shuffle Copy ===\n");

        CSLinkedList<String> original = new CSLinkedList<>();
        original.add("Track 1");
        original.add("Track 2");
        original.add("Track 3");
        original.add("Track 4");

        printListWithIndices("Original playlist:", original);

        System.out.println("\nMaking a copy of the playlist...");
        CSLinkedList<String> copy = original.copy();
        printListWithIndices("Copied playlist:", copy);

        System.out.println("\nModifying the copied playlist (swap first and last, add 'Bonus Track')...");
        if (copy.size() > 1) {
            int lastIndex = copy.size() - 1;
            String first = copy.get(0);
            String last = copy.get(lastIndex);
            copy.set(0, last);
            copy.set(lastIndex, first);
        }
        copy.add("Bonus Track");

        printListWithIndices("Modified copy:", copy);
        printListWithIndices("Original playlist (unchanged):", original);

        System.out.println("\n=== End of LL10 Demo ===");

    }
}
