public class SecondeValid {
    class Solution {
        int res;

        public int totalNQueens(int n) {
            if (n == 0 || n == 1) {
                return n;
            }

            res = 0;
            char[][] board = new char[n][n];

            BFS (board, n, 0);
            return res;
        }

        private void BFS(char[][] board, int n, int col) {
            if (col == n) {
                res++;
                return;
            }

            for (int i = 0; i < n; i++) {
                if (valid (board, i, col)) {
                    board[i][col] = 'Q';
                    BFS (board, n, col + 1);
                    board[i][col] = '\u0000';
                }
            }
        }

        private boolean valid(char[][] board, int r, int c) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < c; j++) {
                    if (board[i][j] == 'Q' && (i + j == r + c || i + c == j + r || r == i)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
