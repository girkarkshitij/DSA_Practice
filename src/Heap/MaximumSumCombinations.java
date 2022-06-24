import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class A1 {
    int sum;
    int i;
    int j;

    A1(int s, int i1, int j1) {
        sum = s;
        i = i1;
        j = j1;
    }
}


class solComparator implements Comparator<A1> {
    public int compare(A1 p1, A1 p2) {
        if (p1.sum < p2.sum)
            return 1;
        else if (p1.sum > p2.sum)
            return -1;
        else
            return 0;
    }
}

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {

        int n = A.length;

        PriorityQueue<A1> p = new PriorityQueue<A1>(new solComparator());
        Arrays.sort(A);
        Arrays.sort(B);

        HashSet<String> hs = new HashSet<>();

        p.add(new A1(A[n - 1] + B[n - 1], n - 1, n - 1));
        hs.add(new String((n - 1) + " " + (n - 1)));


        int i = n - 1, j = n - 1;
        int k1 = C;

        int ans[] = new int[C];
        int y = 0;

        for (int p1 = 0; p1 < C; p1++) {
            ans[y] = p.peek().sum;
            y++;

            i = p.peek().i;
            j = p.peek().j;
            p.poll();

            if (i > 0 && j > 0) {
                if (!hs.contains(new String((i - 1) + " " + j))) {
                    p.add(new A1(A[i - 1] + B[j], i - 1, j));
                    hs.add(new String((i - 1) + " " + j));
                }

                if (!hs.contains(new String(i + " " + (j - 1)))) {
                    p.add(new A1(A[i] + B[j - 1], i, j - 1));
                    hs.add(new String(i + " " + (j - 1)));
                }
            }
        }
        return ans;
    }
}

