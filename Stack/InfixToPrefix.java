import java.util.Stack;

public class InfixToPrefix {

    static int checkPriority(char o){
        if (o == '^') return 3;
        else if (o == '/' || o == '*' || o == '%') {
            return 2;
        } else if (o == '+' || o == '-') {
            return 1;
        }
        return -1;
    }

    static boolean isRightAssociative(char o){
        return o == '^';
    }

    static String infixToPostfix(String s){
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
            } else { // other operators - can't push 2 powers together in stack
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        (checkPriority(c) < checkPriority(stack.peek()) ||
                                (checkPriority(c) == checkPriority(stack.peek()) && isRightAssociative(c)))) {
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

    public String infixToPrefix(String s){
        StringBuilder input = new StringBuilder(s);

        // step 1: reverse the infix expression and replace ( and )
        input.reverse();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);

            if( c == '('){
                input.setCharAt(i, ')');
            } else if (c == ')') {
                input.setCharAt(i, '(');
            }
        }

        // step 2: convert reversed infix to postfix
        String postfix = infixToPostfix(input.toString());

        // step 3: reverse the postfix to have the prefix
        StringBuilder prefix = new StringBuilder(postfix);
        prefix.reverse();

        return prefix.toString();
    }

    public static void main(String[] args){
        InfixToPrefix solution = new InfixToPrefix();

        String[] tests = {"x+y*z/w+u", "a+b", "(a+b)*c", "a^b^c", "a+b*c", "a-b-c"};
        for (String infix : tests) {
            System.out.println("Infix: " + infix + " -> Prefix: " + solution.infixToPrefix(infix));
        }
    }
}
