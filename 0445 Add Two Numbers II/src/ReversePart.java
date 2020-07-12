public class ReversePart {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode n1 = reverse (l1);
            ListNode n2 = reverse (l2);

            int carrier = 0;
            ListNode prev = null;
            while (n1 != null || n2 != null || carrier != 0) {
                int t1 = 0, t2 = 0;
                if (n1 != null) {
                    t1 = n1.val;
                    n1 = n1.next;
                }
                if (n2 != null) {
                    t2 = n2.val;
                    n2 = n2.next;
                }
                int sum = t1 + t2 + carrier;
                ListNode curr = new ListNode (sum % 10);
                curr.next = prev;
                prev = curr;
                carrier = sum / 10;
            }
            return prev;
        }

        private ListNode reverse(ListNode node) {
            ListNode prev = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            return prev;
        }
    }
}
