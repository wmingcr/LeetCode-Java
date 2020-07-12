public class S_Recursion {


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

    // This is a good way of doing it
    // however, space complexity is O(n), not the best

    class Solution {
        private int height = 0;

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return head;
            }

            ListNode next = removeNthFromEnd(head.next, n);

            if (++height == n) {
                return next;
            }

            head.next = next;
            return head;
        }


    }
}
