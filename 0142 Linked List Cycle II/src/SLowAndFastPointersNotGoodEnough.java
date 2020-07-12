public class SLowAndFastPointersNotGoodEnough {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

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
        public ListNode detectCycle(ListNode head) {
            // corner case
            if(head == null){
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;

            // this way also works,
            // but it's not a good way of understanding

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                // find the cycle
                if(fast == slow){
                    fast = head;
                    while(fast != slow){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            // after the ending of while loop,
            // if the programm is going here,
            // this means there is no cycle
            return null;

        }
    }
}
