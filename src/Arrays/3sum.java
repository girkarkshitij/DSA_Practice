class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++){
            if(i == 0 || (i>0 && nums[i]!=nums[i-1])){
                int lo=i+1, hi=n-1;
                int target = 0-nums[i];
                
                while(lo < hi){
                    if(nums[lo]+nums[hi] == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[lo]);
                        list.add(nums[hi]);
                        ans.add(list);
                        
                        while(lo<hi && nums[lo]==nums[lo+1])
                            lo++;
                        
                        while(lo<hi && nums[hi]==nums[hi-1])
                            hi--;
                        
                        lo++;
                        hi--;
                    }else if(nums[lo]+nums[hi] < target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        
        return ans;
    }
}
