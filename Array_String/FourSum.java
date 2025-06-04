import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 18. 4Sum

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 3; i++){
            if( i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            for( int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                int left = j + 1, right = n - 1;

                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if ( sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++; // skip duplicates
                        while (left < right && nums[right] == nums[right + 1]) right--; // skip duplicates
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        FourSum solution = new FourSum();

        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> result1 = solution.fourSum(nums1, target1);

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Target: " + target1);
        System.out.println("Result: " + result1);

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        List<List<Integer>> result2 = solution.fourSum(nums2, target2);

        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Target: " + target2);
        System.out.println("Result: " + result2);
    }
}
