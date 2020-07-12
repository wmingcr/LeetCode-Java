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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode head = null;
            ListNode dummyNode = new ListNode (0);
            ListNode curr = dummyNode;
            int carry = 0;

            while (l1 != null || l2 != null) {

                int node1 = l1 != null ? l1.val : 0;
                int node2 = l2 != null ? l2.val : 0;
                int sum = node1 + node2 + carry;
                carry = sum / 10;
                ListNode node = new ListNode (sum % 10);
                curr.next = node;
                curr = curr.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;

            }

            if (carry == 1) {
                curr.next = new ListNode (1);
            }
            return dummyNode.next;
        }
    }
}
