import java.util.*;

// Print all subsequences 
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



// Print only first subsequence
class HelloWorld {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();
        subsequenceSum(a, 0, 0, 5, list);
    }
    
    public static boolean subsequenceSum(int[] a, int i, int sum, int targetSum, ArrayList<Integer> list){
        if(i == a.length){
            if(sum == targetSum){
                System.out.println(list);
                return true;
            }
            return false;
        }
        
        list.add(a[i]);
        sum += a[i];
        if(subsequenceSum(a, i+1, sum, targetSum, list)){
            return true;
        }
        
        list.remove(list.size()-1);
        sum -= a[i];
        if(subsequenceSum(a, i+1, sum, targetSum, list)){
            return true;
        }
        
        return false;
    }
}

// Output
// [1, 4]


// Print count of subsequences
class HelloWorld {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(subsequenceSum(a, 0, 0, 5, list));
    }
    
    public static int subsequenceSum(int[] a, int i, int sum, int targetSum, ArrayList<Integer> list){
        if(i == a.length){
            if(sum == targetSum){
                return 1;
            }
            return 0;
        }
        
        list.add(a[i]);
        sum += a[i];
        int l = subsequenceSum(a, i+1, sum, targetSum, list);
        
        list.remove(list.size()-1);
        sum -= a[i];
        int r = subsequenceSum(a, i+1, sum, targetSum, list);
        
        return l+r;
    }
}

// Output
// 3
