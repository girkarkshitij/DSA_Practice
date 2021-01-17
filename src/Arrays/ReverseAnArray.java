import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverse(int[] arr){
        int start = 0, end = arr.length-1, temp;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
