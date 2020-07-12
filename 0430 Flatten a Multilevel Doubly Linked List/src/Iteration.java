import java.util.ArrayDeque;
import java.util.Deque;

public class Iteration {

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    class Solution {
        public Node flatten(Node head) {
            // corner case
            if (head == null) {
                return head;
            }

            Node pseudoHead = new Node ();
            Node curr, prev = pseudoHead;

            Deque<Node> stack = new ArrayDeque<> ();
            stack.push (head);

            while (!stack.isEmpty ()) {
                curr = stack.pop ();
                prev.next = curr;
                curr.prev = prev;

                if (curr.next != null) {
                    stack.push (curr.next);
                }
                if (curr.child != null) {
                    stack.push (curr.child);
                    curr.child = null;
                }
                prev = curr;
            }

            pseudoHead.next.prev = null;
            return pseudoHead.next;
        }
    }
}
