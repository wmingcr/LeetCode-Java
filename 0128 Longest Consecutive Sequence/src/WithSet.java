import java.util.HashSet;
import java.util.Set;

public class WithSet {
    class Solution {
        public int longestConsecutive(int[] nums) {
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }

            Set<Integer> set = new HashSet<> ();
            for(int num : nums){
                set.add(num);
            }

            int res = 1;

            for(int num : nums){
                int left = num - 1;
                int right = num + 1;

                while(set.remove(left)){
                    left--;
                }
                while(set.remove(right)){
                    right++;
                }
                res = Math.max(res, right - left - 1);

                if(set.isEmpty()){
                    return res;
                }
            }

            return res;
        }
    }
}
