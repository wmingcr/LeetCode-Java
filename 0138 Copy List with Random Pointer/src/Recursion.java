import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Recursion {

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
        HashMap<Node, Node> map = new HashMap<> ();

        public Node copyRandomList(Node head) {
            // ending condition
            if (head == null) {
                return head;
            }

            if (map.containsKey (head)) {
                return map.get (head);
            }

            Node node = new Node (head.val);

            map.put (head, node);

            node.next = copyRandomList (head.next);
            node.random = copyRandomList (head.random);
            return map.get (head);
        }
    }
}