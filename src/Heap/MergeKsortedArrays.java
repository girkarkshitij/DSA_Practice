import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[][] arr = {{2, 6, 12, 12, 13, 14},
                {1, 9},
                {23, 34, 90}};
        System.out.println(merge(arr, 3));
    }

    public static ArrayList<Integer> merge(int[][] a, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < a.length; i++) {
            heap.add(new Pair(i, 0, a[i][0]));
        }

        while (!heap.isEmpty()) {
            Pair curr = heap.remove();
            ans.add(curr.val);

            if (curr.col < a[curr.row].length - 1) {
                heap.add(new Pair(curr.row, curr.col + 1, a[curr.row][curr.col + 1]));
            }
        }

        return ans;
    }
}

class Pair {
    int row, col, val;

    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
