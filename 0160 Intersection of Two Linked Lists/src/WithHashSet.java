import java.util.HashSet;
import java.util.Set;

public class WithHashSet {
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

            Set<ListNode> set = new HashSet<> ();
            ListNode a = headA;
            while (a != null) {
                set.add (a);
                a = a.next;
            }

            ListNode b = headB;
            while (b != null) {
                if (set.contains (b)) {
                    return b;
                }
                b = b.next;
            }
            return null;
        }
    }
}
