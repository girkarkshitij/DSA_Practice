class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return ans;
    }
    
    public void fun(int[] a, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == a.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<a.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(a[i]);
                fun(a, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
}
