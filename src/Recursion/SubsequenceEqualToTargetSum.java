import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();
        subsequenceSum(a, 0, 0, 5, list);
    }
    
    public static void subsequenceSum(int[] a, int i, int sum, int targetSum, ArrayList<Integer> list){
        if(i == a.length){
            if(sum == targetSum){
                System.out.println(list);
            }
            return;
        }
        
        list.add(a[i]);
        sum += a[i];
        subsequenceSum(a, i+1, sum, targetSum, list);  // take a[i]
        list.remove(list.size()-1);
        sum -= a[i];
        subsequenceSum(a, i+1, sum, targetSum, list); // do not take a[i]
    }
}

// Output
// [1, 4][2, 3][5]
