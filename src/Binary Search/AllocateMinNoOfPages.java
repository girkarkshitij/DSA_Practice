public class Solution {
    public int books(int[] A, int B) {
        if(B > A.length)
            return -1;
        int lo = A[0], hi = A[0];
        for(int i=1; i<A.length; i++){
            lo = Math.min(lo, A[i]);
            hi += A[i];
        }
        
        int ans = 0;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(possible(A, B, mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        
        return ans;
    }
    
    public boolean possible(int[] a, int students, int maxPages){
        int count = 0, allocated = 0;
        
        for(int i=0; i<a.length; i++){
            if(allocated+a[i] > maxPages){
                count++;
                allocated = a[i];
                if(allocated > maxPages)
                    return false;
            }else{
                allocated += a[i];
            }
        }
        
        if(count < students)
            return true;
        else
            return false;
    }
}
