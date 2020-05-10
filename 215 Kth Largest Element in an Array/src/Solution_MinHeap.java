import java.util.PriorityQueue;

public class Solution_MinHeap {

    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        //initialization
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //traverse
        for(int num : nums){

            //store elements
            heap.add(num);

            if(heap.size() > k){
                heap.poll();
            }

        }

        return heap.poll();
    }
}
