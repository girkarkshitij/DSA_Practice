// Merge two sorted arrays without using extra space

import java.util.*;
import java.io.*;
import java.io.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int arr1[] = new int[n];
		    int arr2[] = new int[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    new MergeSort().merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class MergeSort
{
    public static void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here
        int gap = n+m;
        int i,j;
        for(gap = nextGap(gap); gap>0; gap = nextGap(gap)){
            for(i=0; i+gap<n; i++){
                if(arr1[i]>arr1[i+gap]){
                    int temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }
            for(j = gap>n ? gap-n : 0; i<n && j<m ;i++, j++){
                if(arr1[i] > arr2[j]){
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            if(j<m){
                for(j=0; j+gap<m; j++){
                    if(arr2[j]>arr2[j+gap]){
                        int temp=arr2[j];
                        arr2[j]=arr2[j+gap];
                        arr2[j+gap]=temp;
                    }   
                }
            }
        }
    }
    
    public static int nextGap(int gap){
        if(gap<=1)
            return 0;
        return (int)Math.ceil((double)gap/2);
    }
}
