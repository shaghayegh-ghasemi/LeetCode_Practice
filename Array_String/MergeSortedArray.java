import java.util.Arrays;

// 88. Merge Sorted Array
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = m + n - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]){
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }

        // Copy remaining elements from nums2 (if any)
        while (n >= 0) {
            nums1[k] = nums2[n];
            k--;
            n--;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n =3;
        System.out.println("Original array #1: " + Arrays.toString(nums1));
        System.out.println("Original array #2: " + Arrays.toString(nums2));

        merge(nums1, m, nums2, n);

        System.out.println("Result: " + Arrays.toString(nums1));

        int[] nums3 = {0};
        int[] nums4 = {1};
        int m1 = 0, n1 =1;
        System.out.println("\nOriginal array #1: " + Arrays.toString(nums3));
        System.out.println("Original array #2: " + Arrays.toString(nums4));

        merge(nums3, m1, nums4, n1);

        System.out.println("Result: " + Arrays.toString(nums3));
    }
}
