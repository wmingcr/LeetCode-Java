import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        List<String> a = new LinkedList<> ();
        a.add ("e");
        a.add ("d");
        a.add ("f");
        a.add ("g");
        Set<String> set = new HashSet<> (a);

        System.out.println (set);
    }
}
