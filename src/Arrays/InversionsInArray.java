import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long mergeAndCount(long[] arr, long lo, long mid, long hi){
        long[] left = Arrays.copyOfRange(arr, (int)lo, (int)mid+1);
        long[] right = Arrays.copyOfRange(arr, (int)mid+1, (int)hi+1);
        
        int i = 0, j = 0, k = (int)lo;
        long count = 0;
        
        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                count += (mid+1) - (lo+i);
            }
        }
        
        while(i < left.length)
            arr[k++] = left[i++];
        while(j < right.length)
            arr[k++] = right[j++];
        return count;
    }
    
    static long mergeSortAndCount(long[] arr, long lo, long hi){
        long count = 0;
        if(lo < hi){
            long mid = lo + (hi - lo) /2;
            count += mergeSortAndCount(arr, lo, mid);
            count += mergeSortAndCount(arr, mid+1, hi);
            count += mergeAndCount(arr, lo, mid, hi);
        }
        return count;
    }
    
    static long inversionCount(long[] arr, long N)
    {
        return mergeSortAndCount(arr, 0, arr.length-1);
    }
}
