class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        fun(arr, N, 0, ans, 0);
        return ans;
    }
    
    public static void fun(ArrayList<Integer> a, int n, int i, ArrayList<Integer> ans, int sum){
        if(i == n){
            ans.add(sum);
            return;
        }
        
        fun(a, n, i+1, ans, sum+a.get(i));
        fun(a, n, i+1, ans, sum);
    }
}
