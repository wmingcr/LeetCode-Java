import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BackTrackDFS {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill (board[i], '.');
            }

            List<List<String>> res = new ArrayList<> ();
            dfs (board, 0, res);
            return res;
        }

        private void dfs(char[][] board, int col, List<List<String>> res) {
            if (col == board.length) {
                res.add (construct (board));
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (validate (board, i, col)) {
                    board[i][col] = 'Q';
                    dfs (board, col + 1, res);
                    board[i][col] = '.';
                }
            }
        }

        private boolean validate(char[][] board, int x, int y) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private List<String> construct(char[][] board) {
            List<String> res = new LinkedList<String> ();
            for (int i = 0; i < board.length; i++) {
                res.add (new String (board[i]));
            }
            return res;
        }
    }
}
