package StackImplementation;

public class StackDemo {

    SinglyLinkedList sll;

    StackDemo() {
        sll = new SinglyLinkedList ();
    }

    public void push(int x){
        sll.push (x);
    }

    public int pop(){
        return sll.pop();
    }

    public boolean isEmpty(){
        return sll.isEmpty ();
    }

    public int size(){
        return sll.size ();
    }

}
