public class FirstS {


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

            ListNode hair = new ListNode (0);
            hair.next = head;

            ListNode r = hair;
            ListNode l = hair;
            ListNode prev = hair;

            int dif = n - m;
            int k = 0;
            while (k < dif) {
                k++;
                r = r.next;
            }

            k = 0;
            while (k < m) {
                k++;
                prev = l;
                r = r.next;
                l = l.next;
            }

            ListNode next = r.next;

            ListNode curr = l;
            ListNode temPrev = prev;

            while (curr != next) {
                ListNode tem = curr.next;
                curr.next = temPrev;
                temPrev = curr;
                curr = tem;
            }

            prev.next.next = next;
            prev.next = temPrev;

            return hair.next;
        }
    }
}
