public class MoveNegativeToBeginning {
    public static void main(String[] args) {
        int[] a = new int[]{12, 11, -13, -5, 6, -7, 5, -3, -6};
        solve(a, a.length);

        for (int temp : a) {
            System.out.println(temp);
        }
    }

    public static void solve(int[] a, int n) {
        int lo = 0;
        int hi = n - 1;
        int temp;
        while (lo < hi) {
            if (a[lo] > 0 && a[hi] < 0) {
                temp = a[lo];
                a[lo] = a[hi];
                a[hi] = temp;
                lo++;
                hi--;
            } else if (a[lo] < 0) {
                lo++;
            } else if (a[hi] > 0) {
                hi--;
            }
        }
    }
}
