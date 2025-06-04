
// 33. Search in Rotated Sorted Array

import java.util.Arrays;

public class SearchRotatedArray {

    public int search(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if( nums[mid] == target ) return mid;

            // left half is sorted
            if(nums[mid] >= nums[right]) {
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right half is sorted
                if( target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        SearchRotatedArray solution = new SearchRotatedArray();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;

        int result1 = solution.search(nums1, target1);

        System.out.println("Result of searching " + target1 +
                " in input array " + Arrays.toString(nums1) + ": " + result1);

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;

        int result2 = solution.search(nums2, target2);

        System.out.println("\nResult of searching " + target2 +
                " in input array " + Arrays.toString(nums2) + ": " + result2);

        int[] nums3 = {1};
        int target3 = 0;

        int result3 = solution.search(nums3, target3);

        System.out.println("\nResult of searching " + target3 +
                " in input array " + Arrays.toString(nums3) + ": " + result3);

        int target4 = 1;

        int result4 = solution.search(nums3, target4);

        System.out.println("\nResult of searching " + target4 +
                " in input array " + Arrays.toString(nums3) + ": " + result4);
    }
}
