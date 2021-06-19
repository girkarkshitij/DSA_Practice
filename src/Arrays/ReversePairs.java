class Solution {
    public int reversePairs(int[] nums) {
        return mergeCount(nums, 0, nums.length-1);
    }
    
    public int mergeCount(int[] a, int lo, int hi){
        int count = 0;
        if(lo < hi){
            int mid = lo + (hi-lo)/2;
            count += mergeCount(a, lo, mid);
            count += mergeCount(a, mid+1, hi);
            count += merge(a, lo, mid, hi);
        }
        return count;
    }
    
    public int merge(int[] a, int lo, int mid, int hi){
        int count = 0;
        
        int j = mid+1;
        
        for(int i=lo; i<=mid; i++){
            while(j <= hi && a[i] > ((long)2*a[j])){
                j++;
            }
            count += (j-(mid+1));
        }
        
        int left[] = Arrays.copyOfRange(a, lo, mid+1);
        int right[] = Arrays.copyOfRange(a, mid+1, hi+1);
        
        int i = 0, k = lo;
        j = 0;
        
        while(i<left.length && j<right.length){
            if(left[i] < right[j])
                a[k++] = left[i++];
            else
                a[k++] = right[j++];
        }
        
        while(i < left.length)
            a[k++] = left[i++];
        while(j < right.length)
            a[k++] = right[j++];
        
        return count;
    }
}
