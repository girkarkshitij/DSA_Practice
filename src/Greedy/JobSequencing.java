class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int[] ans = new int[2];
        
        Arrays.sort(arr, new Comparator<>(){
            @Override
            public int compare(Job j1, Job j2){
                return j2.profit - j1.profit;
            }
        });
        
        int maxDuration = 0;
        for(Job j: arr){
            if(j.deadline > maxDuration)
                maxDuration = j.deadline;
        }
        
        //1 based
        int[] schedule = new int[maxDuration+1];
        
        for(int i=0; i<n; i++){
            int temp = arr[i].deadline;
            
            while(temp >= 1){
                if(schedule[temp] == 0){
                    schedule[temp] = arr[i].id;
                    ans[1] += arr[i].profit;
                    ans[0]++;
                    break;
                }
                temp--;
            }
        }
        
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
