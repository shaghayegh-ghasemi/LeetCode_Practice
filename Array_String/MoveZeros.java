import java.util.Arrays;

// 283. Move Zeros

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int idx = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;

                idx++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros solution = new MoveZeros();

        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Original array: " + Arrays.toString(nums));

        solution.moveZeroes(nums);

        System.out.println("Modified array: " + Arrays.toString(nums));
    }
}
