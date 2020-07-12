import java.util.HashSet;
import java.util.Set;

public class WithHashSet {


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            // validity
            if (head == null) {
                return false;
            }

            Set<ListNode> set = new HashSet<> ();

            while (head != null) {
                if (set.add (head) == false) { // head is already exist in set
                    return true;
                }
//                if(set.contains (head)){
//                    return true;
//                }
//                set.add (head);
                head = head.next;
            }

            return false;
        }
    }
}
