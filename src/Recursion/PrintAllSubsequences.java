import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        ArrayList<Integer> list = new ArrayList<>();
        printSubsequences(a, 0, list);
    }
    
    public static void printSubsequences(int[] a, int i, ArrayList<Integer> list){
        if(i == a.length){
            System.out.println(list);
            return;
        }
        
        list.add(a[i]);
        printSubsequences(a, i+1, list); // take a[i] in next subsequence
        list.remove(list.size()-1); // don't take a[i] in next subsequence
        printSubsequences(a, i+1, list);
    }
}

// Output
// [1, 2, 3]
// [1, 2]
// [1, 3]
// [1]
// [2, 3]
// [2]
// [3]
// []
