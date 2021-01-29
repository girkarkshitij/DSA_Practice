import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
        // [1, 3, 2]
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if (i >= 0){
            int j = n - 1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, n - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }
}
