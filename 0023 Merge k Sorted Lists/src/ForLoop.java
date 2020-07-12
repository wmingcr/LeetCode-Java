public class ForLoop {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            ListNode ans = null;
            for(int i = 0; i < lists.length; i ++){
                ans = merge(ans, lists[i]);
            }
            return ans;
        }
        private ListNode merge(ListNode a, ListNode b){
            if(a == null || b == null){
                return a == null ? b : a;
            }
            ListNode dummy = new ListNode(), curr = dummy;
            while(a != null && b != null){
                if(a.val > b.val){
                    curr.next = b;
                    b = b.next;
                } else {
                    curr.next = a;
                    a = a.next;
                }
                curr = curr.next;
            }
            if(a != null){
                curr.next = a;
            }
            if(b != null){
                curr.next = b;
            }
            return dummy.next;
        }
    }
}
