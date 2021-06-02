class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long num = n;
        
        if(num < 0)
            num *= -1;
        
        while(num > 0){
            if(num % 2 != 0)
                ans *= x;
            num /= 2;
            x *= x;
        }
        
        if(n < 0)
            ans = (double)(1.0) / (double)(ans);
        
        return ans;
    }
}
