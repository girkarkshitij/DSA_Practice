class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public void fun(int i, int[] a, int target, List<List<Integer>> ans, ArrayList<Integer> list){
        if(i == a.length || target == 0){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        if(a[i] <= target){
            list.add(a[i]);
            fun(i, a, target - a[i], ans, list);
            list.remove(list.size()-1);
        }
        fun(i+1, a, target, ans, list);
    }
}
