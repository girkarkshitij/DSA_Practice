class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        fun(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    
    public void fun(int ind, int[] a, int target, List<Integer> ds, List<List<Integer>> ans){
        if(ind == a.length || target == 0){
            if(target == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }
        
        
        for(int i = ind; i<a.length; i++){
            if(i > ind && a[i] == a[i-1])
                continue;
            
            if(a[i] > target)
                break;
            
            ds.add(a[i]);
            fun(i+1, a, target-a[i], ds, ans);
            
            ds.remove(ds.size()-1);
        }
    }
}
