public class Better {
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
            if (headA == headB)
                return headA;
            if (headA == null || headB == null) {
                return null;
            }

//         check if both intersect other, also take lengths;
            ListNode currA = headA;
            int la = 0;
            while (currA.next != null) {
                la++;
                currA = currA.next;
            }
            ListNode currB = headB;
            int lb = 0;
            while (currB.next != null) {
                lb++;
                currB = currB.next;
            }

            //check if does not meets;
            if (currA != currB)
                return null;

            //both intersect after above comparison to false;
            // ListNode = ia;
            // ListNode = ib;
            currA = headA;
            currB = headB;
            if (la != lb) {
                if (la > lb) {
                    for (int i = 0; i < la - lb; i++)
                        currA = currA.next;
                } else {
                    for (int i = 0; i < lb - la; i++)
                        currB = currB.next;
                }
            }

            //above they are at same position now
            while (currA != currB) {
                currA = currA.next;
                currB = currB.next;
            }
            return currA;
        }
    }
}
