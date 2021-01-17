public class MiddleOfThree {
    public static void main(String[] args) {
        System.out.println(middle(900, 400, 500));
    }

    public static int middle(int A, int B, int C){
        if((A-B)*(A-C)<0)
            return A;
        else if((B-A)*(B-C)<0)
            return B;
        else return C;
    }
}
