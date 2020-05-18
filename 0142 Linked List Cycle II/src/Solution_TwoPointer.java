public class Solution_TwoPointer {


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // validity
            if (head == null) {
                return null;
            }
            // two pointers
            ListNode slow = head, fast = head;
            // check whether there is a cycle
            do {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
            } while (slow != fast);
            // there IS a cycle, initializing slow pointer
            slow = head;
            // find the entry site
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            // got the entry site
            return slow;
        }
    }
}
