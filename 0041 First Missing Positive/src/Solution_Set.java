import java.util.HashSet;
import java.util.Set;

public class Solution_Set {
    // according to runtime details, set is slower than int array,
    class Solution {
        public int firstMissingPositive(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return 1;
            }
            // length of array
            int n = nums.length;
            // set to store elements from nums
            Set<Integer> set = new HashSet<> ();
            for(int num : nums){
                if(num > 0 && num <= n){
                    set.add(num);
                }
            }
            // return the first missing positive number
            for(int i = 1; i <= n; i ++){
                if(set.contains(i) == false){
                    return i;
                }
            }
            // otherwise, it must be n+1
            return n+1;
        }
    }
}
