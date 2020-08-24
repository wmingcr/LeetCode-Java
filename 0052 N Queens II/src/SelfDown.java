public class SelfDown {

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
            for (int i = 0; i < c; i++) {
                if (board[r][i] == 'Q') {
                    return false;
                }
            }

            for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            for (int i = r + 1, j = c - 1; i < board.length && j > -1; i++, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }
    }
}
