public class MinNoOfJumps {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr)); // 3
        System.out.println(minJumps2(arr)); // 3
    }

    /**
     * DP : O(N^2)
     */
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int[] jumps = new int[n];
        int min;

        jumps[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] == 0)
                jumps[i] = Integer.MAX_VALUE;
            else if (arr[i] >= n - i - 1)
                jumps[i] = 1;
            else {
                min = Integer.MAX_VALUE;
                for (int j = i + 1; j < n && j <= arr[i] + i; j++) {
                    if (min > jumps[j])
                        min = jumps[j];
                }
                if (min != Integer.MAX_VALUE)
                    jumps[i] = min + 1;
                else
                    jumps[i] = min;
            }
        }
        int ans = jumps[0];
        if (ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }

    /**
     * O(N)
     */
    public static int minJumps2(int[] arr) {
        if (arr[0] == 0)
            return -1;

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length - 1; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0){
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return jump;
    }
}
