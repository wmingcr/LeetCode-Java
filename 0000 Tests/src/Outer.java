import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Outer {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<> ();
        res.add(3);
        res.add(3);
        res.add(3);
        res.add(3);
        res.add(3);
        res.toArray (new Integer[0]);
    }

}
