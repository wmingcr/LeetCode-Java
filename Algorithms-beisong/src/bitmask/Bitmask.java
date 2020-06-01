package bitmask;

public class Bitmask {

    public static void main(String[] args) {
        method2(5);

    }

    private static void method2(int x){
        int a = (int)Math.pow(2, x);
        int b = (int)Math.pow(2, x + 1);
        for(int i = a; i < b; i ++){
            String te = Integer.toBinaryString (i).substring (1);
            System.out.println ("te = " + te);
        }
    }

    private void method1(int x){
        int n = x;
        // 主要是为了，取到i的所有的0101010的值，
        int nthBit = 1 << n;
        for (int i = 0; i < (int) Math.pow (2, n); ++i) {
            // generate bitmask, from 0..00 to 1..11
            int te = i | nthBit;
            System.out.println ("te = " + te);

            String str = Integer.toBinaryString (te);
            System.out.println ("str = " + str);

            String bitmask = str.substring (1);
            System.out.println (bitmask);
        }
    }

}
