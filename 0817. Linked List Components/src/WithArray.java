public class WithArray {

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
        public int numComponents(ListNode head, int[] G) {
            // corner case
            boolean[] set = new boolean[10001];
            for(int g : G){
                set[g] = true;
            }

            ListNode curr = head;
            int ans = 0;
            while(curr != null){
                if(set[curr.val] && (curr.next == null || !set[curr.next.val])){
                    ans++;
                }
                curr = curr.next;
            }

            return ans;
        }
    }
}
