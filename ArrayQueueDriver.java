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
        System.out.println("=== Q2: Call Center Queue ===\n");

        ArrayQueue<String> callQueue = new ArrayQueue<>();

        // Enqueue callers as they arrive
        System.out.println("Incoming calls...");
        callQueue.offer("Alice");
        callQueue.offer("Bob");
        callQueue.offer("Charlie");
        callQueue.offer("Dana");

        printQueue("Current waiting callers (front to back):", callQueue);
        System.out.println();

        // Dequeue as calls are answered
        while (!callQueue.isEmpty()) {
            String caller = callQueue.poll();
            System.out.println("Answering call from: " + caller);
            printQueue("Remaining callers in queue:", callQueue);
            System.out.println();
        }

        System.out.println("No more callers waiting.");
        System.out.println("\n=== End of Q2 Demo ===");
    }

    // Q3 – Theme Park Ride Line
    private static void runQ3_ThemeParkRideLine() {
        // TODO: Implement task Q3 here.
        System.out.println("=== Q3: Theme Park Ride Line ===\n");

        ArrayQueue<String> line = new ArrayQueue<>();

        // People get in line
        System.out.println("People joining the line for the ride...");
        line.offer("Rider 1");
        line.offer("Rider 2");
        line.offer("Rider 3");
        line.offer("Rider 4");
        line.offer("Rider 5");

        printQueue("Initial line (front to back):", line);
        System.out.println();

        // People board the ride from the front
        while (!line.isEmpty()) {
            String rider = line.poll();
            System.out.println(rider + " boards the ride.");
            printQueue("Line after boarding:", line);
            System.out.println();
        }

        System.out.println("All riders have boarded; the line is empty.");
        System.out.println("\n=== End of Q3 Demo ===");

    }

    // Q4 – Customer Service Tickets
    private static void runQ4_CustomerServiceTickets() {
        // TODO: Implement task Q4 here.
        System.out.println("=== Q4: Customer Service Tickets ===\n");

        ArrayQueue<Integer> tickets = new ArrayQueue<>();

        // Enqueue some ticket IDs
        System.out.println("Creating support tickets...");
        tickets.offer(1001);
        tickets.offer(1002);
        tickets.offer(1003);
        tickets.offer(1004);

        printQueue("Tickets waiting to be handled:", tickets);
        System.out.println();

        // Handle tickets in FIFO order
        while (!tickets.isEmpty()) {
            Integer ticketId = tickets.poll();
            System.out.println("Handling ticket #" + ticketId);
            printQueue("Tickets still waiting:", tickets);
            System.out.println();
        }

        System.out.println("All tickets have been handled.");
        System.out.println("\n=== End of Q4 Demo ===");

    }

    // Q5 – Task Scheduling Queue
    private static void runQ5_TaskSchedulingQueue() {
        // TODO: Implement task Q5 here.
        System.out.println("=== Q5: Task Scheduling Queue ===\n");

        ArrayQueue<String> taskQueue = new ArrayQueue<>();

        // Enqueue tasks for the CPU
        System.out.println("Adding tasks to the CPU queue...");
        taskQueue.offer("Load data");
        taskQueue.offer("Process request A");
        taskQueue.offer("Process request B");
        taskQueue.offer("Write results to disk");

        printQueue("Tasks waiting to run:", taskQueue);
        System.out.println();

        // Dequeue tasks as they are "run"
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Running task: " + task);
            printQueue("Remaining tasks:", taskQueue);
            System.out.println();
        }

        System.out.println("All tasks have been processed.");
        System.out.println("\n=== End of Q5 Demo ===");

    }

    // Q6 – Checkout Line at a Store
    private static void runQ6_CheckoutLine() {
        // TODO: Implement task Q6 here.
        System.out.println("=== Q6: Checkout Line at a Store ===\n");

        ArrayQueue<String> customers = new ArrayQueue<>();

        // Customers arrive
        System.out.println("Customers arriving at checkout...");
        customers.offer("Customer A");
        customers.offer("Customer B");
        customers.offer("Customer C");
        customers.offer("Customer D");

        printQueue("Line at checkout (front to back):", customers);
        System.out.println();

        // Customers are served in FIFO order
        while (!customers.isEmpty()) {
            String current = customers.poll();
            System.out.println(current + " is checking out and paying.");
            printQueue("Remaining customers in line:", customers);
            System.out.println();
        }

        System.out.println("All customers have checked out.");
        System.out.println("\n=== End of Q6 Demo ===");

    }

    // Q7 – Message Queue in a Chat App
    private static void runQ7_MessageQueueChatApp() {
        // TODO: Implement task Q7 here.
        System.out.println("=== Q7: Message Queue in a Chat App ===\n");

        ArrayQueue<String> messages = new ArrayQueue<>();

        // Messages are sent in order
        System.out.println("Enqueuing chat messages...");
        messages.offer("User1: hi!");
        messages.offer("User2: hey, what's up?");
        messages.offer("User1: not much, working on CS homework");
        messages.offer("User3: anyone up for a game later?");

        printQueue("Messages waiting to be delivered:", messages);
        System.out.println();

        // Deliver messages in the same order
        while (!messages.isEmpty()) {
            String msg = messages.poll();
            System.out.println("Delivering message: " + msg);
            printQueue("Messages still queued:", messages);
            System.out.println();
        }

        System.out.println("All messages have been delivered in order.");
        System.out.println("\n=== End of Q7 Demo ===");

    }

    // Q8 – Print Spooling with Burst of Jobs
    private static void runQ8_PrintSpoolingBurst() {
        // TODO: Implement task Q8 here.
        System.out.println("=== Q8: Print Spooling with Burst of Jobs ===\n");

        ArrayQueue<String> spooler = new ArrayQueue<>();

        // A burst of jobs arrives at once
        System.out.println("Burst of print jobs arriving...");
        spooler.offer("Job 1: Essay.docx");
        spooler.offer("Job 2: Slides.pptx");
        spooler.offer("Job 3: Image.png");
        spooler.offer("Job 4: Report.pdf");
        spooler.offer("Job 5: Code.java");

        printQueue("Queue after burst of jobs:", spooler);
        System.out.println("Current queue size: " + spooler.size());
        System.out.println();

        // Now the printer starts working through the queue
        System.out.println("--- Starting to print jobs from the spooler ---\n");

        while (!spooler.isEmpty()) {
            String job = spooler.poll();
            System.out.println("Printing: " + job);
            System.out.println("Queue size now: " + spooler.size());
            printQueue("Remaining jobs:", spooler);
            System.out.println();
        }

        System.out.println("All burst jobs have been printed; spooler is empty.");
        System.out.println("\n=== End of Q8 Demo ===");

    }

    // Q9 – Round-Robin Service (Single Queue Version)
    private static void runQ9_RoundRobinService() {
        // TODO: Implement task Q9 here.
        System.out.println("=== Q9: Round-Robin Service (Single Queue) ===\n");

        // We'll represent each person as "Name (remainingTurns)"
        class Client {
            String name;
            int remainingTurns;

            Client(String name, int remainingTurns) {
                this.name = name;
                this.remainingTurns = remainingTurns;
            }

            @Override
            public String toString() {
                return name + " (" + remainingTurns + " turns left)";
            }
        }

        ArrayQueue<Client> queue = new ArrayQueue<>();

        // Enqueue clients with how many turns they need
        queue.offer(new Client("Alice", 2));
        queue.offer(new Client("Bob", 3));
        queue.offer(new Client("Charlie", 1));

        int maxRounds = 7;
        int round = 1;

        System.out.println("Initial queue:");
        printClientQueue(queue);
        System.out.println();

        while (!queue.isEmpty() && round <= maxRounds) {
            System.out.println("--- Round " + round + " ---");

            Client current = queue.poll();  // next client gets a turn
            System.out.println("Serving: " + current.name);
            current.remainingTurns--;

            if (current.remainingTurns > 0) {
                System.out.println(current.name + " still needs service, going to back of queue.");
                queue.offer(current); // back of queue
            } else {
                System.out.println(current.name + " is done and leaves the queue.");
            }

            printClientQueue(queue);
            System.out.println();

            round++;
        }

        System.out.println("Round-robin service finished.");
        System.out.println("\n=== End of Q9 Demo ===");
    }

    // Helper specifically for Q9 to print Client queue nicely
    private static void printClientQueue(ArrayQueue<?> queue) {
        System.out.println("Current queue (front to back):");
        if (queue.isEmpty()) {
            System.out.println("  [empty]");
            return;
        }
        int i = 0;
        for (Object obj : queue) {
            System.out.println("  " + i + ": " + obj);
            i++;
        }
    }

    // Helper: print queue contents from front to rear
    private static <T> void printQueue(String title, ArrayQueue<T> queue) {
        System.out.println(title);
        if (queue.isEmpty()) {
            System.out.println("  [empty]");
            return;
        }
        int index = 0;
        for (T item : queue) {
            System.out.println("  " + index + ": " + item);
            index++;
        }
    }

}
