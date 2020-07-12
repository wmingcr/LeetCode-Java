public class ThreePointers {


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

    /**
     * should use a dummy Node.
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // corner cases
            if (head == null) {
                return head;
            }
            // hold possible answer
            ListNode ans = head.next;
            // three pointers
            ListNode prev = null;
            ListNode first = head;
            ListNode second = head.next;

            while (first != null && second != null) {
                first.next = second.next;
                second.next = first;
                if (prev != null) {
                    prev.next = second;
                }
                prev = first;
                if (first != null) {
                    first = first.next;
                }
                if (first != null) {
                    second = first.next;
                }
            }

            return ans == null ? head : ans;
        }
    }
}

//class Solution {
//    public ListNode swapPairs(ListNode head) {
//        // ending condition for recursion
//        if(head == null || head.next == null){
//            return head;
//        }
//        // hold possible answer
//        ListNode ans = head.next;
//        // three pointers
//        ListNode prev = null;
//        ListNode first = head;
//        ListNode second = head.next;
//
//        while (first != null && second != null) {
//            first.next = second.next;
//            second.next = first;
//            if (prev != null) {
//                prev.next = second;
//            }
//            prev = first;
//            if (first != null) {
//                first = first.next;
//            }
//            if (first != null) {
//                second = first.next;
//            }
//        }
//
//        return ans;
//    }
//}
