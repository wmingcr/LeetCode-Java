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
    
    //Time Complexity, O(n), Space Complexity, O(1)
    private ListNode iteratively(ListNode head){
        //initialize a curr ListNode
        ListNode curr = head, last = null;
        
        //only while current is not null, we need to continue
        while(curr != null){
            
            //hold next ListNode 
            ListNode next = curr.next;
            
            //reverse current Node
            curr.next = last;
            
            //no need to hold last Node, so change it to curr
            last = curr;
            
            //change curr to next
            curr = next;
            
        }
        
        //this one is the head right now
        return last;
    }
    
}
