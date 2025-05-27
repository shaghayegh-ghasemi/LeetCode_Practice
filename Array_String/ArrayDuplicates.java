import java.util.Arrays;

// problem description: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class ArrayDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n <= 1) return n;

        int idx = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] !=  nums[i-1]){
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        ArrayDuplicates solution = new ArrayDuplicates();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Original array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, nums.length)));

        int newLength = solution.removeDuplicates(nums);

        System.out.println("Length after removing duplicates: " + newLength);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, newLength)));
    }
}
