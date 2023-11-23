class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int s = 1, d = 2, h = 3;
        solve(n , s, d, h);
    }
    public static void solve(int n, int s, int d, int h){
        if(n == 1){
            System.out.println("Moving plate " + n + " from " + s + " to " + d);
            return;
        }
        solve(n - 1, s, h, d);
        System.out.println("Moving plate " + n + " from " + s + " to " + d);
        solve(n - 1, h, d, s);
    }
}
