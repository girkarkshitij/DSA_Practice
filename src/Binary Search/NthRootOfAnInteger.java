class Solution
{
    public int NthRoot(int n, int m){
        double lo = 1, hi = m, eps = 1E-6;
        
        while((hi-lo)>eps){
            double mid = lo + (hi-lo)/2;
            if(multiply(mid, n) > m)
                hi = mid;
            else
                lo = mid;
        }
        
        int ans = (int)Math.ceil(lo);
        if(multiply(ans, n) == m)
            return ans;
        else
            return -1;
    }
    
    public double multiply(double num, int n){
        double ans = 1.0;
        for(int i=1; i<=n; i++){
            ans *= num;
        }
        return ans;
    }
}
