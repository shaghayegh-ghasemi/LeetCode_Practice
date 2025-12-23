import java.util.Stack;

public class InfixToPostfix {

    static int checkPriority(char o){
        if (o == '^') return 3;
        else if (o == '/' || o == '*' ) {
            return 2;
        } else if (o == '+' || o == '-') {
            return 1;
        }
        return -1;
    }

    static boolean isRightAssociative(char o){
        return o == '^';
    }

    public String infixToPostfix(String s){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // when we see an operand - add it to result
            if(Character.isLetterOrDigit(c)){
                postfix.append(c);
            } else if (c == '(') { // push opening parentheses to stack
                stack.push(c);
            } else if (c == ')') { // pop until opening parentheses and add it to result
                while (!stack.isEmpty() && stack.peek() != '('){
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else { // other operators
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (checkPriority(c) < checkPriority(stack.peek()) ||
                                (checkPriority(c) == checkPriority(stack.peek()) && !isRightAssociative(c)))) {
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

        String[] tests = {"a+b*c", "(a+b)*c", "a-b-c", "a^b^c", "(a+b)*c"};
        for (String infix : tests) {
            System.out.println("Infix: " + infix + " -> Postfix: " + solution.infixToPostfix(infix));
        }
    }
}
