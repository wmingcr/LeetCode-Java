public class InPlace {

    class Solution {
        public void gameOfLife(int[][] board) {
            if(board == null || board.length == 0 || board[0].length == 0){
                return;
            }

            int m = board.length, n = board[0].length;

            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    int lives = getLives(i, j, m, n, board);
                    if(board[i][j] == 1){
                        if(lives < 2 || lives > 3){
                            board[i][j] = 3;
                        }
                    } else {
                        if(lives == 3){
                            board[i][j] = 2;
                        }
                    }
                }
            }

            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j ++){
                    if(board[i][j] == 3){
                        board[i][j] = 0;
                    }
                    if(board[i][j] == 2){
                        board[i][j] = 1;
                    }
                }
            }
        }

        private int getLives(int i, int j, int m, int n, int[][] board){
            int count = 0;
            for(int x = Math.max(0, i-1); x <= Math.min(m - 1, i + 1); x ++){
                for(int y = Math.max(0, j-1); y <= Math.min(n - 1, j + 1); y ++){
                    if(board[x][y] % 2 == 1){
                        count++;
                    }
                }
            }

            count -= board[i][j] % 2;

            return count;
        }
    }
}
