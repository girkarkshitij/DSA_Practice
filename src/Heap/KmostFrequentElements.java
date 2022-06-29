class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            if(map.containsKey(temp))
                map.put(temp, map.get(temp)+1);
            else
                map.put(temp, 1);
        }
        
        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                return m1.getValue() - m2.getValue();
            }
        });
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k)
                minHeap.remove();
        }
        
        for(int i=0; i<k; i++){
            ans[i] = minHeap.remove().getKey();
        }
        
        return ans;
    }
}

