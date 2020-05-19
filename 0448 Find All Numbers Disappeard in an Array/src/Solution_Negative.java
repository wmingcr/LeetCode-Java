import java.util.LinkedList;
import java.util.List;

public class Solution_Negative {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new LinkedList<> ();
            // validity
            if(nums == null || nums.length == 0){
                return ans;
            }
            // get length
            int n = nums.length;
            // change the value with that specific elements to negative number
            // to show that number(index) appeared
            for(int i = 0; i < n; i ++){
                int a = nums[i] % n;
                a = Math.abs(a); // make sure a is non negative
                nums[a] = -Math.abs(nums[a]);
            }
            // find all elements with positive numbers
            // special case, n % n == 0
            if(nums[0] > 0){
                ans.add(n);
            }
            // other elements
            for(int i = 1; i < n; i ++)
            {
                if(nums[i] > 0){
                    ans.add(i);
                }
            }

            return ans;
        }
    }
}
