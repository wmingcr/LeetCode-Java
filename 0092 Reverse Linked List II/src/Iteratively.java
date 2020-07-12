public class Iteratively {

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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode prev = null;
            ListNode curr = head;

            while (m > 1) {
                prev = curr;
                curr = curr.next;
                m--;
                n--;
            }

            ListNode con = prev, tail = curr;

            ListNode third = null;
            while (n > 0) {
                third = curr.next;
                curr.next = prev;
                prev = curr;
                curr = third;
                n--;
            }

            if (con == null) {
                head = prev;
            } else {
                con.next = prev;
            }

            tail.next = curr;
            return head;
        }
    }
}
