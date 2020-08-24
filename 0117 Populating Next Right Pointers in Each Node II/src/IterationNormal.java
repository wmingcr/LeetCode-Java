import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class IterationNormal {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            Queue<Node> queue = new ArrayDeque<> ();
            queue.add (root);

            while (!queue.isEmpty ()) {
                int n = queue.size ();
                Node prev = null, curr = null;
                for (int i = 0; i < n; i++) {
                    curr = queue.poll ();
                    if (prev != null) {
                        prev.next = curr;
                    }
                    prev = curr;

                    if (curr.left != null) {
                        queue.add (curr.left);
                    }

                    if (curr.right != null) {
                        queue.add (curr.right);
                    }
                }
            }

            return root;

        }
    }
}
