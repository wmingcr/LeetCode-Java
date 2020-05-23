public class Solution_Counting {

    // first pass, count the number of reds, whites and blues
    // filling red with 0s, white with 1s, blue with 2s

    class Solution {
        public void sortColors(int[] nums) {
            // validity
            if(nums == null || nums.length <= 1){
                return;
            }

            int numReds = 0;
            int numBlues = 0;
            int n = nums.length;
            for(int i = 0; i < n; i ++){
                if(nums[i] == 0){
                    numReds ++;
                } else if (nums[i] == 2){
                    numBlues ++;
                }
            }

            // [0, numReds - 1], red
            // [numReds, length - numBlues] white
            // else, blue,
            for(int i = 0; i < n; i ++){
                if(i < numReds){
                    nums[i] = 0;
                } else if (i < n - numBlues){
                    nums[i] = 1;
                } else {
                    nums[i] = 2;
                }
            }
        }
    }
}
