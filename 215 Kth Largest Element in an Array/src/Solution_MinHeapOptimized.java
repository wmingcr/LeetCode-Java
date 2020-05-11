import java.util.PriorityQueue;

class Solution_MinHeapOptimized {

    public int findKthLargest(int[] nums, int k) {
        //validity
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }

        //initialization
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // add k elements
        for(int i = 0; i < k; i ++){
            heap.add(nums[i]);
        }

        //only add the element which is greater than the smallest element in the heap
        for(int i = k;  i < nums.length; i ++){

            Integer te = heap.peek(); // take the first element, which is the smallest one

            if(nums[i] > te){
                heap.poll(); // remove the first one
                heap.add(nums[i]); // add new element and do sortion
            }
        }

        return heap.poll();

    }

}

