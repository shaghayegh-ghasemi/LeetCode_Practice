import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

    private int checkPriority(char o){
        if (o == '^') return 3;
        else if (o == '/' || o == '*' ) {
            return 2;
        } else if (o == '+' || o == '-') {
            return 1;
        }
        return -1;
    }

    public String infixToPostfix(String s){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // when we see an operand / add it to result
            if(Character.isLetterOrDigit(c)){
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(' && !stack.isEmpty()){
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && checkPriority(c) < checkPriority(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            postfix.append(stack.pop());
        }

        return postfix.toString();

    }

    public static void main(String[] args) {
        InfixToPostfix solution = new InfixToPostfix();

        String infix1 = "a+b*c";
        String postfix1 = solution.infixToPostfix(infix1);

        System.out.println("Result of converting infix expression: " + infix1 + " to postfix expression is: " + postfix1);

        String infix2 = "(a+b)*c";
        String postfix2 = solution.infixToPostfix(infix2);

        System.out.println("Result of converting infix expression: " + infix2 + " to postfix expression is: " + postfix2);

    }
}
