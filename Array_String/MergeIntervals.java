import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 56. Merge Intervals
public class MergeIntervals {

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else {
                merged.add(curr);
                curr = intervals[i];
            }
        }

        merged.add(curr);

        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Original Intervals: " + Arrays.deepToString(intervals));

        int[][] result = merge(intervals);
        System.out.println("Result: " + Arrays.deepToString(result));

        int[][] intervals1 = {{4, 5}, {1, 4}};
        System.out.println("\nOriginal Intervals: " + Arrays.deepToString(intervals1));

        int[][] result1 = merge(intervals1);
        System.out.println("Result: " + Arrays.deepToString(result1));
    }
}
