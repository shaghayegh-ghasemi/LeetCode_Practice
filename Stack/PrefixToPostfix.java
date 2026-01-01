import java.util.Set;
import java.util.Stack;

public class PrefixToPostfix {

    private static final Set<Character> OPS = Set.of('+','-','*','/','^', '%');

    public String prefixToPostfix(String s){
        Stack<String> stack = new Stack<>();

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) continue;

            // Operands
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else if (OPS.contains(c)){

                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix: not enough operands for operator '" + c + "'");
                }

                String leftOperand = stack.pop();
                String rightOperand = stack.pop();
                stack.push(leftOperand + rightOperand + c);
            } else {
                throw new IllegalArgumentException("Invalid character in prefix: '" + c + "'");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix: leftover operands/operators (stack size = " + stack.size() + ")");
        }

        return stack.pop();
    }

    public static void main(String[] args){
        PrefixToPostfix solution = new PrefixToPostfix();

        String[] tests = {
                "+ab",           // ab+
                "-ab",           // ab-
                "*ab",           // ab*
                "/ab",           // ab/
                "%ab",           // ab%
                "^ab",           // ab^

                "+a*bc",         // abc*+
                "*+abc",         // ab+c*
                "-+abc",         // ab+c-
                "--abc",         // ab-c-
                "++a*bc/de",     // abc*+de/+
                "*+ab-^cd%ef",   // ab+cd^ef%-*
                "+*ab*cd",       // ab*cd*+
                "/*+ab-cd%ef",    // ab+cd-*ef%/

                // edge cases
                "-b",     // unary not supported
                "+a",     // missing operand
                "ab+",    // postfix, not prefix
                "++abc",  // leftover operands
                "+a#b",   // invalid char
                ""        // empty
        };

        for (String prefix : tests) {
            try {
                System.out.println("Prefix: " + prefix + " -> Postfix: " + solution.prefixToPostfix(prefix));
            } catch (Exception e) {
                System.out.println("Prefix: " + prefix + " -> ERROR: " + e.getMessage());
            }
        }
    }


}
