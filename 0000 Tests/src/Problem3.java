import java.util.Arrays;

public class Problem3 {

    public static void main(String[] args) {
        int [] arr = {4, 2, 1, 3};
        int[][] res = new Problem3().almostTetris (4, 4, arr);
        for(int[]  r : res){
            System.out.println (Arrays.toString (r));
        }
    }

    public int[][] almostTetris(int n, int m, int[] figures){
        // corner case
        if(n < 1 || m < 1 || figures == null || figures.length == 0){
            return new int[0][0];
        }

        int[][] res = new int[n][m];

        for(int i = 0; i < figures.length; i ++){
            if(figures[i] < 1 || figures[i] > 5){
                continue;
            }
            mid: for(int r = 0; r < n; r ++){
                for(int c = 0; c < m; c ++){
                    if(res[r][c] != 0){
                        continue;
                    }
                    if(fitAndSet (r, c, res, figures[i], i+1)){
                        break mid;
                    }
                }
            }
        }

        return res;
    }

    private boolean fitAndSet(int r, int c, int[][] res, int figure, int idx){
        if(figure == 1){
            if(res[r][c] != 0){
                return false;
            }
            res[r][c] = idx;
            return true;
        } else if (figure == 2){
            if(c > res[0].length - 3){
                return false;
            }
            for(int i = c; i < c + 3; i ++){
                if(res[r][c] != 0){
                    return false;
                }
            }
            for(int i = c; i < c + 3; i ++){
                res[r][i] = idx;
            }
            return true;
        } else if (figure == 3){
            if(c > res[0].length - 2 || r > res.length - 2){
                return false;
            }
            for(int i = r; i < r + 2; i ++){
                for(int j = c; j < c + 2; j ++){
                    if(res[i][j] != 0){
                        return false;
                    }
                }
            }
            for(int i = r; i < r + 2; i ++){
                for(int j = c; j < c + 2; j ++){
                    res[i][j] = idx;
                }
            }
            return true;
        } else if (figure == 4){
            if(r > res.length - 3 || c > res[0].length - 2){
                return false;
            }
            for(int i = r; i < r + 3; i ++){
                if(res[i][c] != 0){
                    return false;
                }
            }
            if(res[r+1][c+1] != 0){
                return false;
            }
            for(int i = r; i < r + 3; i ++){
                res[i][c] = idx;
            }
            res[r+1][c+1] = idx;
            return true;
        } else { // 5,
            if(c > res[0].length - 3 || r == 0 || r > res.length - 2){
                return false;
            }
            for(int i = c; i < c + 3; i ++){
                if(res[r][i] != 0){
                    return false;
                }
            }
            if(res[r-1][c+1] != 0){
                return false;
            }
            for(int i = c; i < c +3; i ++){
                res[r][i] = idx;
            }
            res[r-1][c+1] = idx;
            return true;
        }
    }

}
