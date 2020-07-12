public class Insert1 {
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
        public ListNode insertionSortList(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode ();
            while (head != null) {
                ListNode next = head.next;
                ListNode prev = dummy, curr = dummy.next;
                while (curr != null && curr.val < head.val) {
                    prev = curr;
                    curr = curr.next;
                }
                head.next = curr;
                prev.next = head;
                head = next;
            }
            return dummy.next;
        }
    }
}
