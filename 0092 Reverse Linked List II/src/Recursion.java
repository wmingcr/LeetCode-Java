public class Recursion {

    // Definition for singly-linked list.
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

        private ListNode left;
        private boolean stop;

        public ListNode reverseBetween(ListNode head, int m, int n) {
            this.left = head;
            this.stop = false;
            reverse (head, m, n);
            return head;
        }

        private void reverse(ListNode right, int m, int n) {

            if (n == 1) {
                return;
            }

            right = right.next;

            if (m > 1) {
                left = left.next;
            }

            reverse (right, m - 1, n - 1);

            if (right == left || right.next == left) {
                stop = true;
            }

            if (stop == false) {
                int t = left.val;
                left.val = right.val;
                right.val = t;

                left = left.next;
            }
        }
    }
}
