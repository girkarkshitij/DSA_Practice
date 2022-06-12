class Solution {
  public int minCoins(int V){
    ArrayList<Integer> ans = new ArrayList<>();
    
    int deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int n = deno.length;
    
    for(int i=n-1; i>=0; i--){
      while(V >= deno[i]){
        ans.add(deno[i]);
        V -= deno[i];
      }
    }
    
    for(int i=0; i<ans.size(); i++){
      System.out.println(" " + ans.get(i));
    }
  }
}
