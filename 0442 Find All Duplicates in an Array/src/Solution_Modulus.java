import java.util.LinkedList;
import java.util.List;

public class Solution_Modulus {

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

            for(int i = 0; i < nums.length; i++){
                nums[i]--;
            }

            // adding n to that value with specific index
            for(int i = 0; i < nums.length; i ++){
                int te = nums[i] % n;
                nums[te] += n;
                if(nums[te] / n >= 2){
                    ans.add(te+1);
                }
            }
            return ans;
        }
    }
}
