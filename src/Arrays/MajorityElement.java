class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int el = 0;
        
        for(int x: nums){
            if(count == 0)
                el = x;
            
            if(el == x)
                count++;
            else
                count--;
        }
      
        return el;
    }
}
