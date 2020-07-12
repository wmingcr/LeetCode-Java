import org.w3c.dom.Node;

public class NSquare2 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Node dummy = new Node (0), prev = dummy;
            Node curr = head;
            while (curr != null) {
                prev.next = new Node (curr.val);
                prev = prev.next;
                curr = curr.next;
            }

            curr = head;
            prev = dummy.next;
            while (curr != null) {
                if (curr.random != null) {
                    Node l = head, r = dummy.next;
                    while (l != curr.random) {
                        l = l.next;
                        r = r.next;
                    }
                    prev.random = r;
                }
                curr = curr.next;
                prev = prev.next;
            }
            return dummy.next;
        }
    }
}
