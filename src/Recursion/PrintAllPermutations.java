// Method 1 : useing frquency array -> i.e. more space complexity
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

// Method 2: Swapping array elements -> Less space complexity than method 1
class Solution {
    public void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i = 0;i<nums.length;i++) {
                ds.add(nums[i]); 
            }
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        for(int i = index;i<nums.length;i++) {
            swap(i, index, nums); 
            recurPermute(index+1, nums, ans); 
            swap(i, index, nums); 
        }
    }
    public void swap(int i, int j, int[] nums) {
        int t = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        recurPermute(0, nums, ans);
        return ans; 
    }
}
