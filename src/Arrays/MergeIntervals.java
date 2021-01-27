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
        int[] current = new int[2];
        current[0] = intervals[0][0];
        current[1] = intervals[0][1];
        for (int[] temp : intervals) {
            if (temp[0] <= current[1]) {
                current[1] = Math.max(temp[1], current[1]);
            } else {
                merged.add(current);
                current = temp;
            }
        }
        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }
}
