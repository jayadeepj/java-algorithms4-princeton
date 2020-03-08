import java.util.Scanner;
import java.util.Stack;

/**
 * Dijkstra's 2-stack algorithm to solve an arithmetic expression
 * 1. Push operands onto the operand stack.
 * 2. Push operators onto the operator stack.
 * 3. Ignore left parentheses.
 * 4. On encountering a right parenthesis, pop an operator,
 * pop the requisite number of operands, and push onto the operand stack
 * the result of applying that operator to those operands.
 */
public class ExpressionSolver {
    public static void main(String[] args) {
        ExpressionSolver solver = new ExpressionSolver();
        String expression = solver.read();
        solver.solve(expression);
    }

    private String read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression  >> ");
        String expression = sc.nextLine();
        return expression;
    }

    private void solve(String expression) {
        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char element = expression.charAt(i);
            switch (element) {
                case '(':
                    //Nothing to do here
                    break;
                case ')':
                    String operator = operators.pop();
                    int result = operate(operator, operands);
                    operands.push(result);
                    break;
                case '+':
                case '-':
                case '/':
                case '*': {
                    operators.push(Character.toString(element));
                    break;
                }
                default:
                    operands.push(
                            Integer.parseInt(Character.toString(element)));
            }
        }
        System.out.println("The final result is " + operands.pop());
    }

    private int operate(String operator, Stack<Integer> operands) {
        int right = operands.pop();
        int left = operands.pop();
        int result;
        switch (operator.charAt(0)) {
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '/':
                result = left / right;
                break;
            case '*':
                result = left * right;
                break;
            default:
                throw new RuntimeException("Invalid operand");
        }
        return result;
    }
}
