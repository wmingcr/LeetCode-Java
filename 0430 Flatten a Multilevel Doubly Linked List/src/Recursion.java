import org.w3c.dom.Node;

public class Recursion {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;

    class Solution {
        public Node flatten(Node head) {
            // corner case
            if (head == null) {
                return head;
            }

            Node newHead = new Node ();
            flattenDFS (newHead, head);
            newHead.next.prev = null;

            return newHead.next;
        }

        private Node flattenDFS(Node prev, Node curr) {
            if (curr == null) {
                return prev;
            }

            prev.next = curr;
            curr.prev = prev;

            Node next = curr.next;
            Node tail = flattenDFS (curr, curr.child);
            curr.child = null;

            return flattenDFS (tail, next);
        }
    }
}
