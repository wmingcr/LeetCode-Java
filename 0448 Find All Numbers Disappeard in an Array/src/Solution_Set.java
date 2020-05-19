import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution_Set {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new LinkedList<> ();
            // validity
            if(nums == null){
                return ans;
            }

            // using set
            Set<Integer> set = new HashSet<> ();
            // store elements into set
            for(int num : nums){
                set.add(num);
            }
            // find missing numbers
            for(int i = 1; i <= nums.length; i ++){
                if(set.contains(i) == false){
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
