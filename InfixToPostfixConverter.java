import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfixConverter {
    
    public static String convertToPostfix(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            if (isOperand(currentChar)) {
                postfixExpression.append(currentChar);
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), currentChar)) {
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(currentChar);
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop(); // Discard '(' from stack
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }

    public static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean hasHigherPrecedence(char op1, char op2) {
        int precedence1 = getOperatorPrecedence(op1);
        int precedence2 = getOperatorPrecedence(op2);

        return precedence1 >= precedence2;
    }

    public static int getOperatorPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the infix expression: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = convertToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);

        scanner.close();
    }
}
