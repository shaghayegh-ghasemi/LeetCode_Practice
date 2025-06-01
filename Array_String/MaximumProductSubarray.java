import java.util.Arrays;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxProduct = nums[0];

        for( int i = 1; i < nums.length; i++){
            int n = nums[i];
            int temp = currMax;

            currMax = Math.max(n, Math.max(n * currMax, n * currMin));
            currMin = Math.min(n, Math.min(n * temp, n * currMin));

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }

    public static void main(String[]args){
        MaximumProductSubarray solution = new MaximumProductSubarray();

        int[] nums = {2, 3, -2, 4};

        System.out.println("Array: " + Arrays.toString(nums));

        int result = solution.maxProduct(nums);

        System.out.println("Max product: " + result);

        int[] nums1 = {-2, 0, -1};

        System.out.println("\nArray: " + Arrays.toString(nums1));

        int result1 = solution.maxProduct(nums1);

        System.out.println("Number of subarrays: " + result1);
    }
}
