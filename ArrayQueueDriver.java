// ArrayQueueDriver.java
// Starter file for the Queue portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runQ2_CallCenterQueue).

public class ArrayQueueDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        runQ1_PrintQueue();
        //runQ2_CallCenterQueue();
        //runQ3_ThemeParkRideLine();
        //runQ4_CustomerServiceTickets();
        //runQ5_TaskSchedulingQueue();
        //runQ6_CheckoutLine();
        //runQ7_MessageQueueChatApp();
        //runQ8_PrintSpoolingBurst();
        //runQ9_RoundRobinService();
    }

    // Q1 – Print Queue
    private static void runQ1_PrintQueue() {
        // TODO: Implement task Q1 here.
        System.out.println("=== Q1: Print Queue ===\n");

        ArrayQueue<String> printQueue = new ArrayQueue<>();

        // Enqueue several documents
        enqueueDocument(printQueue, "Report.pdf");
        enqueueDocument(printQueue, "Homework1.docx");
        enqueueDocument(printQueue, "Photo.png");
        enqueueDocument(printQueue, "Slides.pptx");

        System.out.println("\n--- Starting to print documents ---");

        // Dequeue to "print" them in FIFO order
        while (!printQueue.isEmpty()) {
            String nextDoc = printQueue.poll(); // front of the queue
            System.out.println("Printing: " + nextDoc);
            System.out.println("Remaining queue:");
            printQueueContents(printQueue);
            System.out.println();
        }

        System.out.println("All documents have been printed.");
        System.out.println("\n=== End of Q1 Demo ===");
    }

    // Helper: enqueue a document and show the queue state
    private static void enqueueDocument(ArrayQueue<String> queue, String docName) {
        System.out.println("Enqueuing: " + docName);
        queue.offer(docName); // add to the rear of the queue
        System.out.println("Current queue:");
        printQueueContents(queue);
        System.out.println();
    }

    // Helper: print the contents of the queue from front to rear
    private static void printQueueContents(ArrayQueue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("  [empty]");
            return;
        }

        int position = 0;
        for (String doc : queue) { // uses ArrayQueue's iterator
            System.out.println("  " + position + ": " + doc);
            position++;
        }
    }


    // Q2 – Call Center Queue
    private static void runQ2_CallCenterQueue() {
        // TODO: Implement task Q2 here.
    }

    // Q3 – Theme Park Ride Line
    private static void runQ3_ThemeParkRideLine() {
        // TODO: Implement task Q3 here.
    }

    // Q4 – Customer Service Tickets
    private static void runQ4_CustomerServiceTickets() {
        // TODO: Implement task Q4 here.
    }

    // Q5 – Task Scheduling Queue
    private static void runQ5_TaskSchedulingQueue() {
        // TODO: Implement task Q5 here.
    }

    // Q6 – Checkout Line at a Store
    private static void runQ6_CheckoutLine() {
        // TODO: Implement task Q6 here.
    }

    // Q7 – Message Queue in a Chat App
    private static void runQ7_MessageQueueChatApp() {
        // TODO: Implement task Q7 here.
    }

    // Q8 – Print Spooling with Burst of Jobs
    private static void runQ8_PrintSpoolingBurst() {
        // TODO: Implement task Q8 here.
    }

    // Q9 – Round-Robin Service (Single Queue Version)
    private static void runQ9_RoundRobinService() {
        // TODO: Implement task Q9 here.
    }
}
