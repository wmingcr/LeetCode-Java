public class Ss1 {


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
        public ListNode partition(ListNode head, int x) {
            ListNode less = new ListNode ();
            ListNode grea = new ListNode ();
            ListNode l = less, r = grea;

            while (head != null) {
                if (head.val < x) {
                    l.next = head;
                    l = head;
                } else {
                    r.next = head;
                    r = head;
                }
                head = head.next;
            }
            /**
             * this step is very important
             */
            r.next = null;
            l.next = grea.next;
            return less.next;
        }
    }
}
