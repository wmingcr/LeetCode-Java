import java.util.HashSet;
import java.util.Set;

public class WithHashSet {

    // Set is not good enough,
    // but it is a way of solving this problem


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // corner case
            if(head == null){
                return null;
            }

            ListNode curr = head;

            Set<ListNode> set = new HashSet<> ();

            while(curr != null){
                // curr is already stored in set
                // which means curr is the entry point
                if(set.add(curr) == false){
                    return curr;
                }
                curr = curr.next;
            }

            // while curr == null, there is no cycle
            return null;
        }
    }
}
