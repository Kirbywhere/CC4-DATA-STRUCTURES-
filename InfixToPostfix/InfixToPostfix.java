import java.util.Scanner;
import java.util.Stack;

public class Main {

    static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c) || c == '"';
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            case '"':
                return 4; // String operand
        }
        return -1;
    }

    static void printDerivationStep(char token, Stack<Character> stack, StringBuilder output) {
        StringBuilder stackStr = new StringBuilder();
        for (char ch : stack) {
            stackStr.append(ch).append(" ");
        }
        String postfix = output.toString().replaceAll("#", "").trim(); // Remove hash from postfix
        System.out.printf("%-20s%-20s%-20s%n", token, stackStr, postfix.isEmpty() ? "Empty" : postfix);
    }

    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push('#'); // Add # to mark the bottom of the stack

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (isOperand(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    result.append(" ").append(stack.pop()).append(" ");
                }
                stack.pop(); // Pop the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(" ").append(stack.pop()).append(" ");
                }
                stack.push(c);
            }

            printDerivationStep(c, stack, result);
        }

        return result.toString().replaceAll("#", "").replaceAll("\\s+", " ").trim(); // Remove hash and extra spaces
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char tryAgain;

        do {
            System.out.print("Enter infix expression (include '#' at the end): ");
            String infixExpression = scanner.nextLine();
            
            System.out.println("Derivation Steps:");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%n", "Token (X)", "Stack (Y)", "Output (Postfix)");
            System.out.println("------------------------------------------------------");
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("------------------------------------------------------");
            System.out.println("Final postfix expression: " + postfixExpression);

            System.out.print("\nDo you want to convert another infix expression? (Y/N): ");
            tryAgain = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character

        } while (tryAgain == 'Y' || tryAgain == 'y');

        scanner.close();
    }
}
