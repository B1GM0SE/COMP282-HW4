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
        runS3_BalancedParentheses();
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
    }

    // S2 – Undo in a Text Editor
    private static void runS2_TextEditorUndo() {
        // TODO: Implement task S2 here.
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

        System.out.println("=== End of S3 Demo ===");

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
    }

    // S5 – Directory Navigation (cd / cd ..)
    private static void runS5_DirectoryNavigation() {
        // TODO: Implement task S5 here.
    }

    // S6 – History of Calculator Operations
    private static void runS6_CalculatorHistory() {
        // TODO: Implement task S6 here.
    }

    // S7 – Palindrome Checker
    private static void runS7_PalindromeChecker() {
        // TODO: Implement task S7 here.
    }

    // S8 – Function Call Stack Simulator
    private static void runS8_FunctionCallStack() {
        // TODO: Implement task S8 here.
    }

    // S9 – Stack of Plates (Capacity-Limited Stack)
    private static void runS9_StackOfPlates() {
        // TODO: Implement task S9 here.
    }
}
