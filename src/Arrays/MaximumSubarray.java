public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{4, 3, -2, -1}, 4));
        // 7
    }

    /**
     * Kadane's Algorithm 
     */
    public static int maxSubarraySum(int[] nums, int n) {
        int max = nums[0];
        int current_max = nums[0];
        for(int i = 1 ; i<nums.length; i++){
            current_max = Math.max(nums[i], nums[i]+current_max);
            max = Math.max(max, current_max);
        }
        return max;
    }
}
