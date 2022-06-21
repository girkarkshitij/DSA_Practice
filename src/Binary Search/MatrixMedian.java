public class Solution {
    public int findMedian(int[][] A) {
        int r = A.length, c = A[0].length;
        int lo = 0, hi=(int)1e9;    
        int ans = -1;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int count = 0;
            for(int i=0; i<r; i++){
                count+=fun(A[i], mid);
            }
            if(count <= (r*c)/2){
                lo = mid+1;
                ans = mid;
            }
            else
                hi = mid-1;
        }
        
        return ans;
    }
    
    public static int fun(int[] A, int val){
        int count = 0;
        int lo = 0, hi = A.length-1;
        
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(A[mid]<val){
                count = mid+1;
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        
        return count;
    }
}
