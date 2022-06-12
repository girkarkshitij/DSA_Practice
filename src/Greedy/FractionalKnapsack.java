/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<>(){
            @Override
            public int compare(Item o1, Item o2){
                double r1 = (double)o1.value/o1.weight;
                double r2 = (double)o2.value/o2.weight;
                
                if(r1<r2)
                    return 1;
                else if(r1>r2)
                    return -1;
                else
                    return 0;
            }
        });
        
        int currWeight = 0;
        double ans = 0.0;
        
        for(int i=0; i<n; i++){
            if(currWeight + arr[i].weight <= W){
                currWeight += arr[i].weight;
                ans += arr[i].value;
            }else{
                int remain = W - currWeight;
                ans += (double)remain*((double)arr[i].value/arr[i].weight);
                break;
            }
        }
        
        return ans;
    }
}
