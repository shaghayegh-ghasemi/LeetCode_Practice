import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path){
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String part: parts){
            if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else if (part.equals(".") || part.equals("")) {
                continue;
            } else {
                stack.push(part);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args){
        SimplifyPath solution = new SimplifyPath();

        String[] tests = {
                "/home/",                    // "/home"
                "/../",                      // "/"
                "/home//foo/",               // "/home/foo"
                "/a/./b/../../c/",           // "/c"
                "/a/../../b/../c//.//",      // "/c"
                "/a//b////c/d//././/..",     // "/a/b/c"
                "/",                         // "/"
                "/.",                        // "/"
                "/.../a/../b/c/../d/./",     // "/.../b/d"
                "/foo/bar/..",               // "/foo"
                "/foo/./bar",                // "/foo/bar"
                "/foo/.../bar",              // "/foo/.../bar"  (since "..." is a normal folder)
                "///",                       // "/"
                "/..hidden",                 // "/..hidden" (not special, because not exactly "..")
        };

        String[] expected = {
                "/home",
                "/",
                "/home/foo",
                "/c",
                "/c",
                "/a/b/c",
                "/",
                "/",
                "/.../b/d",
                "/foo",
                "/foo/bar",
                "/foo/.../bar",
                "/",
                "/..hidden"
        };

        for (int i = 0; i < tests.length; i++) {
            String out = solution.simplifyPath(tests[i]);
            System.out.println("Input:    " + tests[i]);
            System.out.println("Output:   " + out);
            System.out.println("Expected: " + expected[i]);
            System.out.println(out.equals(expected[i]) ? "PASS\n" : "FAIL\n");
        }
    }

}

// problem description: https://leetcode.com/problems/simplify-path/description/
