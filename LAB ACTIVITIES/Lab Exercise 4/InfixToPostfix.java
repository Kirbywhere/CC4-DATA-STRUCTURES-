import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

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
        }
        return -1;
    }

    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        expression += "#"; // Add # to mark the end of the expression

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                // If the character is a digit, keep appending until a non-digit is encountered
                while (i < expression.length() && (Character.isLetterOrDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    result.append(expression.charAt(i++));
                }
                result.append(" "); // Add space for clarity
                i--; // Adjust index to process the correct character next iteration
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                    result.append(" "); // Add space for clarity
                }
                stack.pop(); // Pop the '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                    result.append(" "); // Add space for clarity
                }
                stack.push(c);
            }

            // Display each step of the derivation
            System.out.printf("%-20s%-20s%-20s%n", c, stack.isEmpty() ? "# " : "#" + stack.toString().replace("[", "").replace("]", "").replace(",", "").replaceAll("\\s", ""), result.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char tryAgain;

        do {
            System.out.print("Enter infix expression: ");
            String infixExpression = scanner.nextLine();

            // Remove whitespaces from the infix expression
            infixExpression = infixExpression.replaceAll("\\s+", "");

            // Display each line of derivation correctly
            System.out.println("\nDerivation Steps:");
            System.out.println("------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%n", "Token", "Stack", "Postfix");
            System.out.println("------------------------------------------------------");
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("------------------------------------------------------");
            System.out.println("\nFinal Postfix Expression: " + postfixExpression);

            System.out.print("\nDo you want to try again? (Y/N): ");
            tryAgain = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline character

        } while (tryAgain == 'Y' || tryAgain == 'y');

        scanner.close();
    }
}
