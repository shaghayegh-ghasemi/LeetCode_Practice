import java.util.Set;
import java.util.Stack;

public class PrefixToInfix {

    private static final Set<Character> OPS = Set.of('+','-','*','/','^', '%');

    public String prefixToInfix(String s){
        Stack<String> stack = new Stack<>();

        for(int i = s.length() - 1; i >= 0; i--){ // iterate the prefix from right to left
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) continue;

            if(Character.isLetterOrDigit(c)){ // Operands
                stack.push(String.valueOf(c));
            } else if (OPS.contains(c)) { //Operators
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix: not enough operands for operator '" + c + "'");
                }

                String leftOperand = stack.pop();
                String rightOperand = stack.pop();
                stack.push("(" + leftOperand + c + rightOperand + ")");
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
        PrefixToInfix solution = new PrefixToInfix();

        String[] tests = {
                "+ab",
                "-ab",
                "*ab",
                "/ab",
                "%ab",
                "^ab",
                "+a*bc",
                "*+abc",
                "-+abc",
                "--abc",
                "++a*bc/de",
                "*+ab-^cd%ef",
                "+*ab*cd",
                "/*+ab-cd%ef",

                // invalid (should throw)
                "-b",
                "+a",
                "ab+",
                "++abc",
                "+a#b",
                ""
        };

        for (String prefix : tests) {
            System.out.println("Prefix: " + prefix + " -> Infix: " + solution.prefixToInfix(prefix));
        }
    }
}
