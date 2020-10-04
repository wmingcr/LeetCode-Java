public class Session {

    public static void main(String[] args) {
        double a = 0.1D;
        double b = 0.2D;
        System.out.println (a + b);

    }

    private static int getSum(String N){
        int res = 0;
        for(int i = 1, n = Integer.parseInt (N); i <= n; i ++){
            if(i % 5 != 0 && i % 7 != 0){
                res += i;
            }
        }
        return res;
    }
}
