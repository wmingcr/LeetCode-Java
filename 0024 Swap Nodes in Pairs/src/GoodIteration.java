public class GoodIteration {


    // see official approach #2


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
        public ListNode swapPairs(ListNode head) {
            // ending condition for recursion
            if (head == null || head.next == null) {
                return head;
            }

            // we can use a dummy node in the first,
            // so there is no need to check whether head.next == null
            ListNode dummy = new ListNode (-1);
            dummy.next = head;

            ListNode prev = dummy;

            while (head != null && head.next != null) {
                ListNode first = head;
                ListNode second = head.next;

                prev.next = second;
                first.next = second.next;
                second.next = first;

                prev = first;
                head = first.next;
            }
            return dummy.next;
        }
    }
}
