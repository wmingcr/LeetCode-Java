import java.util.ArrayList;
import java.util.List;

public class TheEasiestToUnderstand {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] chess = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chess[i][j] = '.';
                }
            }

            List<List<String>> res = new ArrayList<> ();
            backtrack (res, chess, 0);
            return res;
        }

        private void backtrack(List<List<String>> res, char[][] chess, int row) {
            if (row == chess.length) {
                res.add (construct (chess));
                return;
            }

            for (int i = 0; i < chess.length; i++) {
                if (valid (chess, row, i)) {
                    chess[row][i] = 'Q';
                    backtrack (res, chess, row + 1);
                    chess[row][i] = '.';
                }
            }
        }

        private boolean valid(char[][] chess, int x, int y) {
            for (int i = 0; i < x; i++) {
                if (chess[i][y] == 'Q') {
                    return false;
                }
            }

            for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                if (chess[i][j] == 'Q') {
                    return false;
                }
            }

            for (int i = x - 1, j = y + 1; i >= 0 && j < chess.length; i--, j++) {
                if (chess[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
        }

        private List<String> construct(char[][] chess) {
            List<String> res = new ArrayList<> ();
            for (int i = 0; i < chess.length; i++) {
                res.add (new String (chess[i]));
            }
            return res;
        }
    }
}
