class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int lo = 0, hi = 0, count = 0;
        
        while(hi<s.length()){
            char c = s.charAt(hi);
            if(map.containsKey(c))
                lo = Math.max(map.get(c)+1, lo);
            map.put(c, hi);
            count = Math.max(count, hi-lo+1);
            hi++;
        }
        
        return count;
    }
}
