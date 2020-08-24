import java.util.ArrayDeque;

public class EasyToUnderstand {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            int[] res = new int[n - k + 1];

            for(int i = 0; i < n; i ++){
                if(!deq.isEmpty() && deq.peek() == i - k){
                    deq.removeFirst();
                }
                while(!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
                    deq.removeLast();
                }
                deq.add(i);
                int idx = i - k + 1;
                if(idx > -1){
                    res[idx] = nums[deq.peek()];
                }
            }

            return res;
        }
    }
}
