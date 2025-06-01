import java.util.Arrays;
import java.util.HashMap;

public class SubarrayEqualsK {

    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int n: nums){
            sum += n;

            if(map.containsKey(sum - k)){
                total += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }

    public static void main(String[]args){
        SubarrayEqualsK solution = new SubarrayEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("k: " + k);

        int result = solution.subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);

        int[] nums1 = {1, 2, 3};
        int k1 = 3;

        System.out.println("\nOriginal Array: " + Arrays.toString(nums1));
        System.out.println("k: " + k1);

        int result1 = solution.subarraySum(nums1, k1);

        System.out.println("Number of subarrays: " + result1);
    }
}
