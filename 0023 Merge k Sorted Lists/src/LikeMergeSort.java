public class LikeMergeSort {

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
            return merge(lists, 0, lists.length-1);
        }

        private ListNode merge(ListNode[] lists, int start, int end){
            if(start == end){
                return lists[start];
            }
            int mid = start + (end - start)/2;
            ListNode left = merge(lists, start, mid);
            ListNode right = merge(lists, mid+1, end);
            return sort(left, right);
        }

        private ListNode sort(ListNode a, ListNode b){
            if(a == null){
                return b;
            }
            if(b == null) {
                return a;
            }
            ListNode dummy = new ListNode(), curr = dummy;
            while(a != null && b != null){
                if(a.val <= b.val){
                    curr.next = a;
                    curr = a;
                    a = a.next;
                } else {
                    curr.next = b;
                    curr = b;
                    b = b.next;
                }
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
