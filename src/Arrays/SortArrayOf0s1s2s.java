public class SortArrayOf0s1s2s {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2,2, 1,2, 0, 1,2 ,1};
        sort012(arr,arr.length);
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void sort012(int[] a, int n){
      // Dutch National Flag Algorithm
        int low = 0, mid = 0, high = n - 1, temp;

        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    temp = a[low];
                    a[low] = a[mid];
                    a[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
            }
        }
    }
}
