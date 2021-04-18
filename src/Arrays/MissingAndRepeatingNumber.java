// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        int xor = 0;
        
        for(int i=0; i<n; i++){
            xor ^= arr[i];
        }
        
        for(int i=1; i<=n ;i++){
            xor ^= i;
        }
        
        int set_bit_no = xor & ~(xor - 1);
        int x = 0, y = 0;
        
        for(int i=0; i<n; i++){
            if ((arr[i] & set_bit_no) != 0)
                /* first set */
                x = x ^ arr[i];
            else
                /* second set*/
                y = y ^ arr[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* first set */
                x = x ^ i;
  
            else
                /* second set*/
                y = y ^ i;
        }
        for(int i=0; i<n; i++){
            if(arr[i] == x){
                ans[0] = x;
                ans[1] = y;
                break;
            }else if(arr[i] == y){
                ans[0] = y;
                ans[1] = x;
                break;
            }
        }
        return ans;
        
    }
}
