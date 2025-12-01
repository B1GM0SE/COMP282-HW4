// CSLinkedListDriver.java
// Starter file for the Linked List portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runLL3_CourseWaitlist).

import java.util.Comparator;

public class CSLinkedListDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        runLL1_Playlist();
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
    }

    // LL3 – Course Waitlist (No Duplicates)
    private static void runLL3_CourseWaitlist() {
        // TODO: Implement task LL3 here.
        // You may add a helper method addIfAbsent(E item) to CSLinkedList if needed.
    }

    // LL4 – Text Editor Line Manager
    private static void runLL4_TextEditorLines() {
        // TODO: Implement task LL4 here.
    }

    // LL5 – Recently Contacted Friends (Move to Front)
    private static void runLL5_RecentlyContacted() {
        // TODO: Implement task LL5 here.
        // You may add a helper method moveToFront(E item) to CSLinkedList if needed.
    }

    // LL6 – Shopping List: Insert After Item
    private static void runLL6_ShoppingListAddAfter() {
        // TODO: Implement task LL6 here.
        // You may add a helper method addAfter(E target, E newItem) to CSLinkedList if needed.
    }

    // LL7 – Bus Route Stops
    private static void runLL7_BusRouteStops() {
        // TODO: Implement task LL7 here.
    }

    // LL8 – Event Schedule (Insert by Time)
    private static void runLL8_EventScheduleSorted() {
        // TODO: Implement task LL8 here.
        // You may add a helper method addInOrder(E item, Comparator<E> cmp) to CSLinkedList if needed.
    }

    // LL9 – Bug Tracker List (Remove by ID)
    private static void runLL9_BugTrackerRemoveById() {
        // TODO: Implement task LL9 here.
        // You may add a helper method removeFirstOccurrence(E item) to CSLinkedList if needed.
    }

    // LL10 – Playlist Shuffle Copy
    private static void runLL10_PlaylistShuffleCopy() {
        // TODO: Implement task LL10 here.
        // You may add a helper method copy() to CSLinkedList if needed.
    }
}
