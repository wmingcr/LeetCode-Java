public class ReverseHalfList {

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
        public boolean isPalindrome(ListNode head) {
            // corner case
            if(head == null){
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            if(fast != null){
                slow = slow.next;
            }

            ListNode prev = null;
            while(slow != null){
                ListNode next = slow.next;
                slow.next = prev;
                prev = slow;
                slow = next;
            }

            ListNode left = head;
            ListNode right = prev;

            while(right != null){
                if(left.val != right.val){
                    return false;
                }
                right = right.next;
                left = left.next;
            }
            return true;
        }
    }
}
