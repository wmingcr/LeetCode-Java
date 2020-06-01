import java.util.PriorityQueue;

public class MinHeap {

    class Solution {
        public int maxProduct(int[] nums) {
            // validity
            if(nums == null || nums.length == 0){
                return 0;
            }

            PriorityQueue<Integer> qq = new PriorityQueue<>();

            for(int i = 0; i < nums.length; i ++){
                qq.add(nums[i]);
                if(qq.size() > 2){
                    qq.poll();
                }
            }
            return (qq.poll() - 1) * (qq.poll() - 1);
        }
    }
}
