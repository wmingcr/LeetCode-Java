// official ans, return curr.next

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //validity
        if(l1 == null){
            return l2;
        }
        
        //validity
        if(l2 == null){
            return l1;
        }
        
        //initialization
        ListNode dummy = new ListNode();
        
        //hold first node
        ListNode curr = dummy;
        
        //carrier
        int carrier = 0;
        
        //addition
        while(l1 != null || l2 != null || carrier != 0){
            //number 1
            int t1 = 0;
            if(l1 != null){
                t1 = l1.val;
                l1 = l1.next;
            }
            
            //number 2
            int t2 = 0;
            if(l2 != null){
                t2 = l2.val;
                l2 = l2.next;
            }
            
            //sum
            int te = t1 + t2 + carrier;
            
            curr.next = new ListNode();
            
            //remainder
            curr.next.val = te%10;
            
            //update carrier
            carrier = te/10;
            
            //update current node
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
