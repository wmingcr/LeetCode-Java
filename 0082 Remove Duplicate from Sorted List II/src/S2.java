public class S2 {


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
        public ListNode deleteDuplicates(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode (Integer.MIN_VALUE), prev = dummy;
            for (ListNode l = head, r = head; l != null; l = r) {
                while (r != null && r.val == l.val) {
                    r = r.next;
                }
                if (r == l.next) {
                    prev.next = l;
                    prev = l;
                    prev.next = null;
                }
            }
            return dummy.next;
        }
    }
}
