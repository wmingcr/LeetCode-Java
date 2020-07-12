public class GetLength {

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

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // corner case
            if (headA == null || headB == null) {
                return null;
            }

            int lenA = getLen (headA);
            int lenB = getLen (headB);

            int dif = Math.abs (lenA - lenB);

            int k = 0;
            while (k < dif) {
                if (lenA > lenB) {
                    headA = headA.next;
                } else {
                    headB = headB.next;
                }
                k++;
            }

            while (headA != null || headB != null) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }

            return null;
        }

        private int getLen(ListNode node) {
            int k = 0;
            while (node != null) {
                k++;
                node = node.next;
            }
            return k;
        }
    }
}
