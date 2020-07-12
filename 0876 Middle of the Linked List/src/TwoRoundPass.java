public class TwoRoundPass {
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
        public ListNode middleNode(ListNode head) {
            // corner case
            if (head == null) {
                return head;
            }

            int n = 0;
            ListNode curr = head;

            while (curr != null) {
                n++;
                curr = curr.next;
            }

            int tar = n / 2;
            int k = 0;

            while (k < tar) {
                k++;
                head = head.next;
            }

            return head;
        }
    }
}
