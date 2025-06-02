
// 414. Third Maximum Number

import java.util.Arrays;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for(int n : nums){
            if ((first != null && first == n) ||
                    (second != null && second == n) ||
                    (third != null && third == n)) continue;

            if(first == null || n > first){
                third = second;
                second = first;
                first = (long) n;
            } else if (second == null || n > second) {
                third = second;
                second = (long) n;
            } else if (third == null || n > third) {
                third = (long) n;
            }
        }

        return (third == null) ? first.intValue() : third.intValue();
    }

    public static void main(String[] args){
        ThirdMax solution = new ThirdMax();

        int[] nums = {3, 2, 1};
        int output = solution.thirdMax(nums);
        System.out.println("Array: " + Arrays.toString(nums) + ", Third distinct maximum number: " + output);

        int[] nums1 = {1, 2};
        int output1 = solution.thirdMax(nums1);
        System.out.println("\nArray: " + Arrays.toString(nums1) + ", Third distinct maximum number: " + output1);

        int[] nums2 = {2, 2, 3, 1};
        int output2 = solution.thirdMax(nums2);
        System.out.println("\nArray: " + Arrays.toString(nums2) + ", Third distinct maximum number: " + output2);

    }
}
