import java.util.ArrayList;
import java.util.List;

public class Solution_Rearrange {

    // see https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/solution/chou-ti-yuan-li-ji-yu-yi-huo-yun-suan-jiao-huan-li/

    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            // validity
            if(nums == null || nums.length <= 1){
                return new ArrayList<Integer>();
            }
            // initialization
            List<Integer> ans = new ArrayList<>();
            // rearrange elements to its relative index
            for(int i = 0; i < nums.length; i ++){
                while(nums[nums[i] - 1] != nums[i]){
                    int te = nums[i];
                    nums[i] = nums[te-1];
                    nums[te-1] = te;

                    /**
                     int te = nums[i];
                     nums[i] = nums[nums[i] - 1]; // it has to be a variable,
                     nums[nums[i] - 1] = te; // nums[i] is already changed in last step
                     */

                }
            }
            // get the duplicates
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] != i + 1){
                    ans.add(nums[i]);
                }
            }
            return ans;
        }
    }
}
