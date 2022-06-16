class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        fun(0, nums, ans, new ArrayList<>());
        return ans;
    }
    
    public void fun(int ind, int[] a, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        // no need to explicitly add base condition (ind >= a.length), since it is mentioned in the for loop
        
        for(int i = ind; i<a.length; i++){
            if(i > ind && a[i]==a[i-1])
                continue;
            
            ds.add(a[i]);
            fun(i+1, a, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
