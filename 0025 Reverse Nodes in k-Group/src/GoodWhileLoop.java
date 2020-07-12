public class GoodWhileLoop {

    // This is the official answer, which I didn't come up with
    // at the first time

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

        public ListNode reverseKGroup(ListNode head, int k) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode hair = new ListNode (-1);
            hair.next = head;
            ListNode prev = hair;

            while (head != null) {
                // got k nodes
                ListNode tail = prev;
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) {
                        return hair.next;
                    }
                }

                // get node after tail
                ListNode next = tail.next;
                ListNode[] arr = myReverse (head, tail);
                head = arr[0];
                tail = arr[1];
                prev.next = head;
                tail.next = next;
                prev = tail;
                head = tail.next;

            }
            return hair.next;
        }

        private ListNode[] myReverse(ListNode head, ListNode tail) {

            ListNode newHead = head;
            ListNode newTail = tail;
            ListNode prev = tail.next;
            ListNode next = tail.next;
            while (head != next) {
                ListNode temnext = head.next;
                head.next = prev;
                prev = head;
                head = temnext;
            }
            return new ListNode[]{newTail, newHead};

        }
    }
}
