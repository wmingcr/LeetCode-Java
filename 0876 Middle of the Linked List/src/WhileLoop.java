public class WhileLoop {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // corner case
            if (head == null) {
                return head;
            }

            ListNode hair = new ListNode (0);
            hair.next = head;

            ListNode fast = hair;
            ListNode slow = hair;
            int k = 0;

            while (fast != null) {
                if (k <= n) {
                    fast = fast.next;
                    k++;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }

            slow.next = slow.next.next;
            /**
             * Have to return hair, since head might be deleted.
             */
            return hair.next;
        }
    }
}
