import java.util.LinkedList;
import java.util.List;

public class Solution_NegativeValue {

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // validity
            if(nums == null || nums.length <= 1){
                return new LinkedList<Integer> ();
            }
            // type of returning object, List
            // initialization
            List<Integer> ans = new LinkedList<>();
            //get the length of nums
            int n = nums.length;
            // traverse all elements in nums, turn the value with index nums[i] to negative
            // if we find a number is negative, then it happened twice
            for(int i = 0; i < nums.length; i++){
                int a = Math.abs(nums[i]);
                if(a == n){
                    if(nums[0] < 0){
                        ans.add(a);
                    } else {
                        nums[0] *= -1;
                    }
                } else {
                    if (nums[a] < 0){
                        ans.add(a);
                    } else {
                        nums[a] *= -1;
                    }
                }
            }
            return ans;
        }
    }
}
