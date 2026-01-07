import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums2) map.put(num, -1); // keep the NGE for every element in nums2

        for(int j = nums2.length - 1; j >= 0; j--){
            while (!stack.isEmpty() && stack.peek() <= nums2[j]){
                stack.pop();
            }

            if (!stack.isEmpty()) map.put(nums2[j], stack.peek());

            stack.push(nums2[j]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int num: nums1) result.add(map.getOrDefault(num, -1));

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args){
        NextGreaterElement solution = new NextGreaterElement();

        int[][] nums1Tests = {
                {4, 1, 2},
                {2, 4},
                {1, 2, 3},
                {5, 4, 3},
                {1, 3, 5}
        };

        int[][] nums2Tests = {
                {1, 3, 4, 2},
                {1, 2, 3, 4},
                {1, 2, 3},
                {5, 4, 3, 2, 1},
                {6, 1, 2, 3, 4, 5}
        };

        int[][] expected = {
                {-1, 3, -1},
                {3, -1},
                {2, 3, -1},
                {-1, -1, -1},
                {2, 4, -1}
        };

        for (int i = 0; i < nums1Tests.length; i++){
            int[] out = solution.nextGreaterElement(nums1Tests[i], nums2Tests[i]);
            System.out.println("nums1:     " + Arrays.toString(nums1Tests[i]));
            System.out.println("nums2:     " + Arrays.toString(nums2Tests[i]));
            System.out.println("output:    " + Arrays.toString(out));
            System.out.println("expected:  " + Arrays.toString(expected[i]));
            System.out.println();
        }
    }
}

// problem description: https://leetcode.com/problems/next-greater-element-i/description/