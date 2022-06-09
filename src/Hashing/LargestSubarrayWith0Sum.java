class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int count = 0, sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == 0){
                count = i+1;
            }else{
                if(prefixSum.containsKey(sum)){
                    count = Math.max(count, i-prefixSum.get(sum));
                }else{
                    prefixSum.put(sum, i);
                }
            }
        }
        
        return count;
    }
}
