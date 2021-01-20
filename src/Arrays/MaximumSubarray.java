public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{4, 3, -2, -1}, 4));
        // 7
    }

    /**
     * Kadane's Algorithm
     */
    public static int maxSubarraySum(int[] arr, int n) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum < 0)
                sum = 0;
            max = Math.max(max, sum);
        }

        return max;
    }
}
