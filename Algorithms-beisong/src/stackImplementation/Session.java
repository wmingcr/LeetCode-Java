package stackImplementation;

import java.util.HashSet;
import java.util.Stack;

public class Session {

    public static void main(String[] args) {

        StackDemo sd = new StackDemo ();

        System.out.println (sd.isEmpty ());

        sd.push (1);
        sd.push (2);
        sd.push (3);
        sd.push (4);

        System.out.println (sd.size ()); // 4

        sd.push (5);
        sd.push (6);
        sd.push (7);
        sd.push (8);

        System.out.println (sd.size ()); // 8

        System.out.println (sd.isEmpty ());

        while (sd.isEmpty () == false) {
            System.out.println (sd.pop ());
        }

        System.out.println (sd.isEmpty ());

        System.out.println (sd.size ());

        HashSet<String> hs = new HashSet<> ();

        Stack<String> stack = new Stack<> ();

        stack.add ("23");
    }
}
