public class Solution_TwoPointers {


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
            if(head == null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    return true;
                }
            }

            return false;



//         do {
//             if(fast != null && fast.next != null){
//                 slow = slow.next;
//                 fast = fast.next.next;
//             } else {
//                 return false;
//             }
//         } while (slow != fast);

//         return true;
        }
    }
}
