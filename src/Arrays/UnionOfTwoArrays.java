import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3};
        System.out.println(doUnion(a, a.length, b, b.length));
        // 5
    }

    public static int doUnion(int[] a, int n, int[] b, int m) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            set.add(b[i]);
        }
        return set.size();
    }
}
