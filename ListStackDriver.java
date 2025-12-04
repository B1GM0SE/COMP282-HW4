// ListStackDriver.java
// Starter file for the Stack portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runS4_ReverseWord).

public class ListStackDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runS1_BrowserBackButton();
        //runS2_TextEditorUndo();
        //runS3_BalancedParentheses();
        //runS4_ReverseWord();
        //runS5_DirectoryNavigation();
        //runS6_CalculatorHistory();
        //runS7_PalindromeChecker();
        //runS8_FunctionCallStack();
        //runS9_StackOfPlates();
    }

    // S1 – Browser Back Button
    private static void runS1_BrowserBackButton() {
        // TODO: Implement task S1 here.
        System.out.println("=== S1: Browser Back Button ===\n");

        ListStack<String> history = new ListStack<>();

        // Simulate visiting pages
        visitPage(history, "home");
        visitPage(history, "about");
        visitPage(history, "contact");
        visitPage(history, "help");

        System.out.println("\nPressing Back three times...\n");
        goBack(history);
        goBack(history);
        goBack(history);

        System.out.println("\n=== End of S1 Demo ===");
    }

    private static void visitPage(ListStack<String> history, String url) {
        history.push(url);
        System.out.println("Visit: " + url);
        System.out.println("Current page: " + url);
    }

    private static void goBack(ListStack<String> history) {
        System.out.println("Back button pressed");
        if (history.isEmpty()) {
            System.out.println("  No history to go back to.\n");
            return;
        }
        String leaving = history.pop();
        System.out.println("  Leaving: " + leaving);
        if (history.isEmpty()) {
            System.out.println("  Now on: [no page]\n");
        } else {
            System.out.println("  Now on: " + history.peek() + "\n");
        }
    }

    // S2 – Undo in a Text Editor
    private static void runS2_TextEditorUndo() {
        // TODO: Implement task S2 here.
        System.out.println("=== S2: Undo in a Text Editor ===\n");

        ListStack<String> history = new ListStack<>();
        String text = "";

        // Save initial state
        history.push(text);
        System.out.println("Start: \"" + text + "\"");

        // Simulate edits
        text = text + "Hello";
        history.push(text);
        System.out.println("After typing 'Hello': \"" + text + "\"");

        text = text + " world";
        history.push(text);
        System.out.println("After typing ' world': \"" + text + "\"");

        text = text + "!";
        history.push(text);
        System.out.println("After typing '!': \"" + text + "\"");

        // Undo twice
        text = undoEdit(history);
        text = undoEdit(history);

        System.out.println("\nFinal text after undos: \"" + text + "\"");
        System.out.println("\n=== End of S2 Demo ===");
    }

    private static String undoEdit(ListStack<String> history) {
        if (history.isEmpty()) {
            System.out.println("\nUndo: nothing to undo.");
            return "";
        }

        String current = history.pop();
        System.out.println("\nUndo: Reverting from \"" + current + "\"");

        if (history.isEmpty()) {
            System.out.println("Now empty document.");
            return "";
        } else {
            String prev = history.peek();
            System.out.println("Text is now: \"" + prev + "\"");
            return prev;
        }
    }

    // S3 – Checking Balanced Parentheses
    private static void runS3_BalancedParentheses() {
        // TODO: Implement task S3 here.
        System.out.println("=== S3: Checking Balanced Parentheses ===\n");

        String[] tests = {
                "()",
                "(())",
                "(()",
                "())(",
                "a * (b + c)",
                "((1 + 2) * 3)",
                ")(a+b)(",
                "",
                "no parentheses here"
        };

        for (String expr : tests) {
            boolean balanced = isBalanced(expr);
            System.out.println("Expression: \"" + expr + "\"");
            System.out.println("  -> " + (balanced ? "Balanced" : "NOT balanced"));
            System.out.println();
        }

        System.out.println("=== End of S3 ===");

    }

    /**
     * Returns true if the given expression has balanced parentheses.
     * Only '(' and ')' are considered; all other characters are ignored.
     */
    private static boolean isBalanced(String expr) {
        ListStack<Character> stack = new ListStack<>();

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // Need a matching '(' on the stack
                if (stack.isEmpty()) {
                    return false; // closing paren with nothing to match
                }
                stack.pop();
            }
        }

        // At the end, all '(' must have been matched
        return stack.isEmpty();
    }


    // S4 – Reversing a Word Using a Stack
    private static void runS4_ReverseWord() {
        // TODO: Implement task S4 here.
        System.out.println("=== S4: Reversing a Word Using a Stack ===\n");

        String[] words = { "hello", "Stack", "racecar" };

        for (String word : words) {
            String reversed = reverseWord(word);
            System.out.println("Original: " + word);
            System.out.println("Reversed: " + reversed);
            System.out.println();
        }

        System.out.println("=== End of S4 Demo ===");
    }

    private static String reverseWord(String word) {
        ListStack<Character> stack = new ListStack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // S5 – Directory Navigation (cd / cd ..)
    private static void runS5_DirectoryNavigation() {
        // TODO: Implement task S5 here.
        System.out.println("=== S5: Directory Navigation (cd / cd ..) ===\n");

        ListStack<String> dirs = new ListStack<>();

        // Start at root
        dirs.push("/");
        System.out.println("Starting in root:");
        printCurrentDirectory(dirs);

        cd(dirs, "home");
        cd(dirs, "user");
        cd(dirs, "projects");
        cdUp(dirs);        // cd ..
        cd(dirs, "music");
        cdUp(dirs);        // cd ..
        cdUp(dirs);        // cd ..
        cdUp(dirs);        // cd .. from root (should not go further)

        System.out.println("\n=== End of S5 Demo ===");
    }

    private static void cd(ListStack<String> dirs, String folder) {
        System.out.println("\ncd " + folder);
        dirs.push(folder);
        printCurrentDirectory(dirs);
    }

    private static void cdUp(ListStack<String> dirs) {
        System.out.println("\ncd ..");
        if (dirs.isEmpty()) {
            System.out.println("Already at top; cannot go up.");
        } else {
            String leaving = dirs.pop();
            System.out.println("Leaving: " + leaving);
        }
        printCurrentDirectory(dirs);
    }

    private static void printCurrentDirectory(ListStack<String> dirs) {
        if (dirs.isEmpty()) {
            System.out.println("Current directory: [none]");
        } else {
            System.out.println("Current directory (top of stack): " + dirs.peek());
        }
    }

    // S6 – History of Calculator Operations
    private static void runS6_CalculatorHistory() {
        // TODO: Implement task S6 here.
        System.out.println("=== S6: History of Calculator Operations ===\n");

        ListStack<String> history = new ListStack<>();

        performCalc(history, 5, "+", 3);
        performCalc(history, 8, "*", 2);
        performCalc(history, 16, "-", 4);

        System.out.println("\nUndoing last two operations...\n");
        undoOperation(history);
        undoOperation(history);

        System.out.println("\nRemaining history (most recent first):");
        printHistoryFromTop(history);

        System.out.println("\n=== End of S6 Demo ===");
    }

    private static void performCalc(ListStack<String> history, int a, String op, int b) {
        int result = 0;
        switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = b != 0 ? a / b : 0; break;
            default:  result = 0;
        }
        String record = a + " " + op + " " + b + " = " + result;
        history.push(record);
        System.out.println("Calculated: " + record);
    }

    private static void undoOperation(ListStack<String> history) {
        if (history.isEmpty()) {
            System.out.println("No operations to undo.");
        } else {
            String removed = history.pop();
            System.out.println("Undo: removed \"" + removed + "\"");
        }
    }

    private static void printHistoryFromTop(ListStack<String> history) {
        if (history.isEmpty()) {
            System.out.println("  [empty]");
            return;
        }
        int i = 0;
        while (!history.isEmpty()) {
            System.out.println("  " + i + ": " + history.pop());
            i++;
        }
    }

    // S7 – Palindrome Checker
    private static void runS7_PalindromeChecker() {
        // TODO: Implement task S7 here.
        System.out.println("=== S7: Palindrome Checker ===\n");

        String[] words = { "racecar", "level", "hello", "abba", "abcba" };

        for (String word : words) {
            boolean isPal = isPalindrome(word);
            System.out.println("Word: " + word + " -> " +
                    (isPal ? "palindrome" : "not palindrome"));
        }

        System.out.println("\n=== End of S7 Demo ===");
    }

    private static boolean isPalindrome(String word) {
        ListStack<Character> stack = new ListStack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return word.equals(reversed.toString());
    }

    // S8 – Function Call Stack Simulator
    private static void runS8_FunctionCallStack() {
        // TODO: Implement task S8 here.
        System.out.println("=== S8: Function Call Stack Simulator ===\n");

        ListStack<String> callStack = new ListStack<>();

        callFunction(callStack, "main");
        callFunction(callStack, "loadConfig");
        returnFromFunction(callStack);
        callFunction(callStack, "processData");
        callFunction(callStack, "computeAverage");
        returnFromFunction(callStack);
        callFunction(callStack, "logResults");
        returnFromFunction(callStack);
        returnFromFunction(callStack);
        returnFromFunction(callStack);

        System.out.println("\n=== End of S8 Demo ===");
    }

    private static void callFunction(ListStack<String> stack, String name) {
        System.out.println("Call " + name + "()");
        stack.push(name);
        printCallStack(stack);
    }

    private static void returnFromFunction(ListStack<String> stack) {
        System.out.println("\nreturn");
        if (stack.isEmpty()) {
            System.out.println("Call stack is already empty.");
            return;
        }
        String finished = stack.pop();
        System.out.println("Finished " + finished + "()");
        printCallStack(stack);
    }

    private static void printCallStack(ListStack<String> stack) {
        if (stack.isEmpty()) {
            System.out.println("  [call stack empty]");
            return;
        }

        ListStack<String> temp = new ListStack<>();
        System.out.println("  Call stack (top first):");
        int i = 0;
        while (!stack.isEmpty()) {
            String f = stack.pop();
            System.out.println("    " + i + ": " + f);
            temp.push(f);
            i++;
        }
        // Restore
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // S9 – Stack of Plates (Capacity-Limited Stack)
    private static void runS9_StackOfPlates() {
        // TODO: Implement task S9 here.
        System.out.println("=== S9: Stack of Plates (Capacity-Limited Stack) ===\n");

        final int CAPACITY = 3;
        ListStack<String> plates = new ListStack<>();

        pushPlate(plates, "Plate 1", CAPACITY);
        pushPlate(plates, "Plate 2", CAPACITY);
        pushPlate(plates, "Plate 3", CAPACITY);
        pushPlate(plates, "Plate 4", CAPACITY); // should hit capacity

        System.out.println("\nTaking two plates off the stack...\n");
        popPlate(plates);
        popPlate(plates);

        System.out.println("\nTrying to add another plate...\n");
        pushPlate(plates, "Plate 5", CAPACITY);

        System.out.println("\n=== End of S9 Demo ===");
    }

    private static void pushPlate(ListStack<String> stack, String plate, int capacity) {
        System.out.println("Trying to push: " + plate);
        if (stack.size() >= capacity) {
            System.out.println("  Cannot push, stack is at capacity (" + capacity + ").");
        } else {
            stack.push(plate);
            System.out.println("  Pushed. Current top: " + stack.peek());
        }
    }

    private static void popPlate(ListStack<String> stack) {
        if (stack.isEmpty()) {
            System.out.println("  No plates to pop.");
        } else {
            String plate = stack.pop();
            System.out.println("  Popped: " + plate);
        }
    }
}
