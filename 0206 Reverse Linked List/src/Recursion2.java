public class Recursion2 {

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
        public ListNode reverseList(ListNode head) {
            //validity
            if(head == null){
                return null;
            }

            //return iteratively(head);
            return recursively(null, head);
        }

        private ListNode recursively(ListNode last, ListNode curr){
            //hole the next Node
            ListNode next = curr.next;

            //reverse the order
            curr.next = last;

            //ending condition
            if(next == null){
                return curr;
            }

            //continue to do next
            return recursively(curr, next);
        }

    }

}
