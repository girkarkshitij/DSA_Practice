class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }else if(n == 0){
            return 0;
        }
        
        int i = 0, j = 1;
        
        while(i<n && j<n){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        
        return i+1;
    }
}
