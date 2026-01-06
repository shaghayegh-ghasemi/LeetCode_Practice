import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public int[] nextSmallerElement(int[] arr){
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) result.add(-1);
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i-- ){
            while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();

            if(!stack.isEmpty()) result.set(i, stack.peek());

            stack.push(arr[i]);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args){
        NextSmallerElement solution = new NextSmallerElement();

        int[][] tests = {
                {},                 // empty
                {5},                // single
                {1, 2, 3, 4},        // increasing
                {4, 3, 2, 1},        // decreasing
                {4, 8, 5, 2, 25},    // mixed
                {2, 2, 1},           // duplicates
                {3, 7, 1, 7, 8, 4},  // classic
                {-1, -2, 0, -3},     // negatives
                {5, 5, 5}            // all equal
        };

        int[][] expected = {
                {},
                {-1},
                {-1, -1, -1, -1},
                {3, 2, 1, -1},
                {2, 5, 2, -1, -1},
                {1, 1, -1},
                {1, 1, -1, 4, 4, -1},
                {-2, -3, -3, -1},
                {-1, -1, -1}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] out = solution.nextSmallerElement(tests[i]);
            System.out.println("Input:    " + Arrays.toString(tests[i]));
            System.out.println("Output:   " + Arrays.toString(out));
            System.out.println("Expected: " + Arrays.toString(expected[i]));
            System.out.println();
        }
    }
}
