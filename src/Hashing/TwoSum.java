class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i=0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                int ansIndex = map.get(temp);
                if(i == ansIndex){
                    continue;
                }
                ans[0] = i;
                ans[1] = ansIndex;
                break;
            }
            map.put(nums[i],i);
        }
        
        return ans;
    }
}
