public class SlowAndFastPointers {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // corner case
            if(head == null){
                return false;
            }
            // slow and fast pointers
            ListNode slow = head;
            ListNode fast = head;

            do{
                if(fast != null && fast.next != null){
                    slow = slow.next;
                    fast = fast.next.next;
                } else {
                    return false;
                }
            } while(fast != slow);

            // slow == fast
            return true;


            /**
             * for the following method,
             * 必须要先指向下一个节点，下下一个节点，
             * 然后再进行判断是否相等。
             */
            // the following is another way
//            ListNode slow = head;
//            ListNode fast = head;
//
//            while(fast != null && fast.next != null){
//                slow = slow.next;
//                fast = fast.next.next;
//                if(slow == fast){
//                    return true;
//                }
//            }
//            return false;
        }
    }
}
