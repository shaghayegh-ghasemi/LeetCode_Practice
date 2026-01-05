import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancedParentheses {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        Set<Character> opening = Set.of('(', '{', '[');

        for(int i = 0; i < s.length(); i++){
            char p = s.charAt(i);
            if(opening.contains(p)){
                stack.push(p);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (p == ')' && top != '(') return false;
                if (p == '}' && top != '{') return false;
                if (p == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        BalancedParentheses solution = new BalancedParentheses();

        String[] test = {
                "",            // empty string → valid
                "()",          // simple
                "()[]{}",      // multiple types
                "(]",          // mismatch
                "([])",        // nested
                "([)]",        // wrong order
                "]",           // closing first
                "{",           // opening only
                "{{{{}}}}",    // deep nesting
                "{[()()]}",    // complex valid
                "{[(])}",     // complex invalid
                "((()))",      // same type nested
                "(()",         // missing closing
                "())",         // extra closing
        };

        for (String p: test){
            System.out.println("Parentheses: " + p + " --> Valid? " + ((solution.isValid(p)) ? "YES" : "NO"));
        }
    }
}
