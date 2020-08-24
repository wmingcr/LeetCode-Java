public class Function {

    class Solution {
        public int numTrees(int n) {
            // note: we should use type long, otherwise it might be overflow for int
            long C = 1L;
            for(int i = 0; i < n; i++){
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }

}
