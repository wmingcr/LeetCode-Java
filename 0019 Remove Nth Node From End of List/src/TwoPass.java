public class TwoPass {


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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // corner case
            if (head == null) {
                return head;
            }
            // get the length of ListNode
            int len = 0;
            ListNode curr = head;
            while (curr != null) {
                len++;
                curr = curr.next;
            }
            // corner cases
            if (len < n) {
                return head;
            }
            // remove the first elements
            if (len == n) {
                return head.next;
            }

            curr = head;
            int idx = 0;
            while (idx < len - n - 1) {
                idx++;
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return head;
        }
    }
}
