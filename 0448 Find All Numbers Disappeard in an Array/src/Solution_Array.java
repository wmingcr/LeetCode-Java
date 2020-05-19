import java.util.LinkedList;
import java.util.List;

public class Solution_Array {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> ans = new LinkedList<> ();
            // validity
            if (nums == null) {
                return ans;
            }
            // get length
            int n = nums.length;
            // initialization
            int[] arr = new int[n + 1];
            // store frequency of element from nums into array ans
            for (int i = 0; i < n; i++) {
                arr[nums[i]]++;
            }
            // find all disappearer elements with frequency equals to 0
            for (int i = 1; i <= n; i++) {
                if (arr[i] == 0) {
                    ans.add (i);
                }
            }
            return ans;
        }
    }
}
