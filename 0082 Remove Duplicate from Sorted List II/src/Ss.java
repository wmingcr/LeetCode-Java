public class Ss {


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
            if (head == null) {
                return head;
            }

            ListNode dummy = new ListNode ();

            ListNode tail = dummy;

            ListNode l = head, r = head;

            while (r != null) {
                while (r != null && r.val == l.val) {
                    r = r.next;
                }
                if (l.next == r) {
                    tail.next = l;
                    tail = l;
                    tail.next = null;
                }
                l = r;
            }

            return dummy.next;
        }
    }
}
