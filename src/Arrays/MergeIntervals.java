import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3}, {2, 6}, {7, 9}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(a)));
        //[[1, 6], [7, 10], [15, 18]]
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] temp : intervals) {
            if (temp[0] <= end) {
                end = Math.max(temp[1], end);
            } else {
                merged.add(new int[]{start, end});
                start = temp[0];
                end = temp[1];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }
}
