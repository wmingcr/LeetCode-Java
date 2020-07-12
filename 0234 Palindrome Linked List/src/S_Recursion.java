public class S_Recursion {

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
        ListNode s = null;
        public boolean isPalindrome(ListNode head) {
            s = head;
            return isP(head);
        }
        public boolean isP(ListNode e){
            if(e != null){
                if(isP(e.next) == false){
                    return false;
                }
                if(s.val != e.val){
                    return false;
                }
                s = s.next;
            }
            return true;
        }
    }
}
