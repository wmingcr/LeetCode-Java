public class Solution_Math {

    class Solution {
        public int uniquePaths(int m, int n) {
            double a = 1;
            for(int i = m; i <= m+n-2; i ++){
                a *= i;
            }
            double b = 1;
            for(int i = 1; i < n; i ++){
                b *= i;
            }
            return (int)(a / b);
        }
    }
}
