public class Recursion3 {
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
        public ListNode reverseList(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode[] arr = reverse (head);

            return arr[1];
        }

        private ListNode[] reverse(ListNode head) {

            if (head == null || head.next == null) {
                return new ListNode[]{head, head};
            }

            ListNode[] arr = reverse (head.next);

            arr[0].next = head;
            head.next = null;
            arr[0] = head;

            return arr;
        }
    }
}
