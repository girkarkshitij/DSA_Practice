public class CyclicRotateArray {
    public static void main(String[] args) {
        long[] arr = new long[]{1, 2, 3, 4, 5};
        rotate(arr, arr.length);
        // 5 1 2 3 4
    }

    public static void rotate(long[] arr, long n) {
        long last = arr[(int)n-1];
        for (int i = (int) (n-1); i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
}
