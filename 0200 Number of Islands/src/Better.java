public class Better {
    class Solution {
        int m, n;

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int res = 0;
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res += sink (grid, i, j);
                }
            }
            return res;
        }

        private int sink(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') {
                return 0;
            }

            grid[i][j] = '0';

            sink (grid, i + 1, j);
            sink (grid, i, j + 1);
            sink (grid, i - 1, j);
            sink (grid, i, j - 1);

            return 1;
        }
    }
}
