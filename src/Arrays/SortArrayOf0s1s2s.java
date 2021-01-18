public class SortArrayOf0s1s2s {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2,2, 1,2, 0, 1,2 ,1};
        sort012(arr,arr.length);
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void sort012(int[] a, int n){
        int[] counter = new int[3];
        for (int i = 0; i < n; i++) {
            counter[a[i]]++;
        }
        int num = 0;
        int j = 0;
        while(true) {
            for (int i = 0; i < counter[num]; i++) {
                a[j] = num;
                j++;
            }
            if (num!=2)
                num++;
            else
                break;
        }
    }
}
