import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoPointers {


    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new LinkedList<> ();
            // corner case #1
            if(nums == null || nums.length < 4){
                return ans;
            }

            // get length
            int n = nums.length;

            // sort the array
            Arrays.sort(nums);

            // // corner case
            // if(target < nums[0]){ // can't be ==, since 0 0 0 0, sum = 0
            //                     // also can't be <, since all are negative numbers
            //     return ans;
            // }

            // corner cases should be like the following
            if(nums[0] + nums[1] + nums[2] + nums[3] > target){
                return ans;
            }
            if(nums[n-4] + nums[n-1] + nums[n-2] + nums[n-3] < target){
                return ans;
            }

            for(int i = 0; i <= n - 4; i ++){
                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                for(int j = i+1; j <= n - 3; j ++){
                    if(j > i+1 && nums[j] == nums[j-1]){
                        continue;
                    }
                    for(int l = j+1, r = n-1; l < r; ){
                        if(l > j+1 && nums[l] == nums[l-1]){
                            l++;
                            continue;
                        }
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if(sum < target){
                            l++;
                        } else if(sum > target){
                            r--;
                        } else {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            r--;
                            while(l < r && nums[l] == nums[l-1]){
                                l++;
                            }
                            while(l < r && nums[r] == nums[r+1]){
                                r--;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}
