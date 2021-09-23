class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int max = 0, currMax = 0;
        for(int num : nums){
            if(set.contains(num-1)){
                continue;
            }else if(set.contains(num+1)){
                currMax = 1;
                num++;
                while(set.contains(++num)){
                    currMax++;
                }
                max = Math.max(max, currMax);
                currMax = 0;
            }
        }
        return max+1;
    }
