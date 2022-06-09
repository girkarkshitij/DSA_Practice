public class Solution {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0, count = 0;

        for(int temp: A){
            xor = xor ^ temp;
            int Y = xor ^ B;

            if(map.containsKey(Y)){
                count += map.get(Y);
            }
            if(xor == B){
                count++;
            }
            if(map.containsKey(xor)){
                map.put(xor, map.get(xor)+1);
            }else{
                map.put(xor, 1);
            }
        }

        return count;
    }
}
