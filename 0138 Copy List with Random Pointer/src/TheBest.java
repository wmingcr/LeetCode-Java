public class TheBest {

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
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                curr.next = new Node (curr.val);
                curr.next.next = next;
                curr = next;
            }

            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            Node d1 = new Node (0), n1 = d1;
            Node d2 = new Node (0), n2 = d2;
            while (head != null) {
                n1.next = head;
                n1 = head;
                n2.next = head.next;
                n2 = n2.next;
                head = n2.next;
            }
            n1.next = null;
            return d2.next;
        }
    }
}
