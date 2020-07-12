public class ThirdSlowAndFast {


    //Definition for singly-linked list.
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
            // corner case
            if (head == null) {
                return null;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (true) {
                // make sure fast and fast.next are not null
                if (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                } else {
                    return null; // there is no cycle, Do not apply to this problem
                }
                if (fast == slow) { // got a cycle
                    break;
                }
            }

            fast = head;

            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;

        }
    }
}
