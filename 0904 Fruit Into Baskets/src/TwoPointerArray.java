public class TwoPointerArray {

    // if your code didn't pass all tests,
    // there must be something wrong with your code.

    static class Solution {
        public int totalFruit(int[] tree) {
            // we assume all numbers in tree is less or equal than the length of tree
            if(tree == null || tree.length == 0){
                return 0;
            }

            int n = tree.length;
            int[] es = new int[n+1];
            int left = 0, right = 0, max = 0, count = 0;

            while(right < n){
                es[tree[right]]++;

                if(es[tree[right]] == 1){
                    count++;
                }

                right++;

                while(count > 2){
                    es[tree[left]]--;
                    if(es[tree[left]] == 0){
                        count--;
                    }
                    left++;
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }
}
