import java.util.Set;
import java.util.Stack;

public class PostfixToInfix {

    private static final Set<Character> OPS = Set.of('+','-','*','/','^', '%');

    public String postfixToInfix(String s){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) continue;

            // Operands
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else if (OPS.contains(c)) { // Operators

                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix: not enough operands for operator '" + c + "'");
                }

                String rightOperand = stack.pop();
                String leftOperand = stack.pop();
                stack.push("(" + leftOperand + c + rightOperand + ")");
            } else {
                throw new IllegalArgumentException("Invalid character in postfix: '" + c + "'");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix: leftover operands/operators (stack size = " + stack.size() + ")");
        }

        return stack.pop();
    }

    public static void main(String[] args){
        PostfixToInfix solution = new PostfixToInfix();

        String[] tests = {"ab+", "abc*+", "abc+*d/", "ab*c+", "abc++", "abc^^", "ab^c^", "a+"};
        for (String postfix : tests) {
            System.out.println("Postfix: " + postfix + " -> Infix: " + solution.postfixToInfix(postfix));
        }
    }
}
