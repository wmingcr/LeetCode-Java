public class DFSs {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int res = 0, m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        DFSMarking (grid, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void DFSMarking(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }

            grid[i][j] = '0';
            DFSMarking (grid, i, j - 1);
            DFSMarking (grid, i, j + 1);
            DFSMarking (grid, i - 1, j);
            DFSMarking (grid, i + 1, j);
        }
    }
}
