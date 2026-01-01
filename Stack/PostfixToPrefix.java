import java.util.Set;
import java.util.Stack;

public class PostfixToPrefix {

    private static final Set<Character> OPS = Set.of('+','-','*','/','^', '%');

    public String postfixToPrefix(String s){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (Character.isWhitespace(c)) continue;

            // Operands
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else if (OPS.contains(c)){

                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix: not enough operands for operator '" + c + "'");
                }

                String rightOperand = stack.pop();
                String leftOperand = stack.pop();
                stack.push(String.valueOf(c) +  leftOperand + rightOperand);
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
        PostfixToPrefix solution = new PostfixToPrefix();

        String[] tests = {
                "ab+",          // +ab
                "ab-",          // -ab
                "ab*",          // *ab
                "ab/",          // /ab
                "ab%",          // %ab
                "ab^",          // ^ab

                "abc*+",        // +a*bc
                "ab+c*",        // *+abc
                "ab-c-",        // --abc  ( (a-b)-c )
                "abc++",        // +a+bc
                "abc^^",        // ^a^bc

                "ab+c*d+",      // +*+abc d   -> actually: + * + a b c d  (structure check)
                "ab+cd+*",      // *+ab+cd
                "ab+cde+**",    // *+ab* c + d e
                "abc+*d/",      // /*a+bc d
                "ab+cd-*ef%+",  // +-*+ab cd %ef
                "abc*+d-",      // -+a*bc d
                "abc*+d-e/",    // /-+a*bc d e

                // edge cases
                "a+",     // not enough operands
                "ab++",   // not enough operands at some point
                "ab",     // leftover operands
                "ab#+"    // invalid character

        };

        for (String postfix : tests) {
            try {
                System.out.println("Postfix: " + postfix + " -> Prefix: " + solution.postfixToPrefix(postfix));
            } catch (Exception e) {
                System.out.println("Postfix: " + postfix + " -> ERROR: " + e.getMessage());
            }
        }
    }
}
