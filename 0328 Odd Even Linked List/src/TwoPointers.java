public class TwoPointers {


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
        public ListNode oddEvenList(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummyodd = new ListNode (-1);
            ListNode dummyeven = new ListNode (-1);
            ListNode odd = dummyodd;
            ListNode even = dummyeven;
            ListNode curr = head;
            int count = 1;

            while (curr != null) {
                // odd
                if (count % 2 == 1) {
                    odd.next = curr;
                    odd = odd.next;
                } else { // even
                    even.next = curr;
                    even = even.next;
                }

                curr = curr.next;
                count++;
            }
            odd.next = dummyeven.next;
            even.next = null;

            return head;
        }
    }
}

// the following has optimized curr
//class Solution {
//    public ListNode oddEvenList(ListNode head) {
//        // corner case
//        if(head == null || head.next == null){
//            return head;
//        }
//
//        ListNode dummyodd = new ListNode(-1);
//        ListNode dummyeven = new ListNode(-1);
//        ListNode odd = dummyodd;
//        ListNode even = dummyeven;
//        int count = 1;
//
//        while(head != null){
//            // odd
//            if(count % 2 == 1){
//                odd.next = head;
//                odd = odd.next;
//            }
//            else { // even
//                even.next = head;
//                even = even.next;
//            }
//
//            head = head.next;
//            count ++;
//        }
//
//        odd.next = dummyeven.next;
//        even.next = null;
//
//        return dummyodd.next;
//    }
//}
