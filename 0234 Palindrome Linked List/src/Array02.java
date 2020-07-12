public class Array02 {

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
            int[] arr = new int[50000];

            ListNode curr = head;

            int n = 0;
            while(curr != null){
                arr[n++] = curr.val;
                curr = curr.next;
            }

            int half = n/2;
            for(int i = 0, j = n-1; i < half; i ++, j --){
                if(arr[i] != arr[j]){
                    return false;
                }
            }

            return true;
        }
    }
}
