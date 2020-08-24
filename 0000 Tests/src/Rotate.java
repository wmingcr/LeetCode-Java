import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[][] m = {
                {1,  2,  3,  4,  5 },
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] res = new Rotate().rotate (m, 1);
        for(int[] i : res){
            System.out.println (Arrays.toString (i));
        }
    }

    public int[][] rotate(int[][] matrix, int k){
        if(k == 4){
            return matrix;
        }
        int len = matrix.length;
        if(k == 1){
            return rotate1(matrix, len);
        } else if (k == 2){
            return rotate2(matrix, len);
        } else {
            return rotate3(matrix, len);
        }
    }

    private int[][] rotate1(int[][] m, int len){
        for(int r = 0; r < len / 2; r ++){
            for(int c = r + 1; c < len - (r + 1); c ++){
                int temp = m[r][c];
                m[r][c] = m[len-c-1][r];
                m[len-c-1][r] = m[len-r-1][len-c-1];
                m[len-r-1][len-c-1] = m[c][len-r-1];
                m[c][len-r-1] = temp;
            }
        }
        return m;
    }

    private int[][] rotate2(int[][] m, int len){
        for(int r = 0; r < len / 2; r ++){
            for(int c = r + 1; c < len - (r + 1); c ++){
                int temp = m[r][c];
                m[r][c] = m[len-r-1][len-c-1];
                m[len-r-1][len-c-1] = temp;

                temp = m[len-c-1][r];
                m[len-c-1][r] = m[c][len-r-1];
                m[c][len-r-1] = temp;
            }
        }
        return m;
    }

    private int[][] rotate3(int[][] m, int len){
        for(int r = 0; r < len / 2; r ++){
            for(int c = r + 1; c < len - (r + 1); c ++){
                int temp = m[r][c];
                m[r][c] = m[c][len-r-1];
                m[c][len-r-1] = m[len-r-1][len-c-1];
                m[len-r-1][len-c-1] = m[len-c-1][r];
                m[len-c-1][r] = temp;
            }
        }
        return m;
    }

}
