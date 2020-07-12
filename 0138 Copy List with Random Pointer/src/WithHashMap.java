import java.util.HashMap;

public class WithHashMap {

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
            // corner case
            if (head == null) {
                return head;
            }

            var visited = new HashMap<Node, Node> ();
            Node curr = head;
            while (curr != null) {
                visited.put (curr, new Node (curr.val));
                curr = curr.next;
            }

            curr = head;
            while (curr != null) {
                visited.get (curr).next = visited.get (curr.next);
                visited.get (curr).random = visited.get (curr.random);
                curr = curr.next;
            }

            return visited.get (head);
        }
    }
}
