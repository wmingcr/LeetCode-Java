import java.util.ArrayDeque;
import java.util.Deque;

public class WithStack {


    static class Solution {
        public int findUnsortedSubarray(int[] nums) {
            // brute force
            // corner case
            if(nums == null || nums.length == 0){
                return 0;
            }
            // get length
            int n = nums.length;
            int l = n, r = -1;
            Deque<Integer> qq = new ArrayDeque<> ();

            for(int i = 0; i < n; i ++){
                while(qq.isEmpty() == false && nums[qq.peek()] > nums[i]){
                    l = Math.min(l, qq.pop());
                }
                qq.push(i);
            }

            qq.clear();
            for(int i = n-1; i >= 0; i --){
                while(qq.isEmpty() == false && nums[qq.peek()] < nums[i]){
                    r = Math.max(r, qq.pop());
                }
                qq.push(i);
            }
            return r - l > 0 ? r-l+1 : 0;
        }
    }
}
