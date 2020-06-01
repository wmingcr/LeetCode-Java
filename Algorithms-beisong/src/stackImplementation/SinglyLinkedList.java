package stackImplementation;

public class SinglyLinkedList {

    private class Node {

        int val;

        Node next;

        Node() {

        }

        Node(int val) {
            this.val = val;
        }

    }

    Node head;

    int length = 0;

    SinglyLinkedList() {

    }

    SinglyLinkedList(int x) {
        head = new Node (x);
    }

    public void push(int val) {

        Node newNode = new Node (val);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;

    }

    public int pop() {
        if (size () == 0) {

            return -1;

        } else {

            Node newNode = head;

            head = head.next;

            length--;

            return newNode.val;
        }

    }

    public boolean isEmpty(){
        return length == 0;
    }


    public int size() {
        return length;
    }
}



