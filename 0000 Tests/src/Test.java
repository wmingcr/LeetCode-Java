import java.util.*;

public class Test {

    public static void main(String[] args) {

        String str = "LEETCODE";
        String str1 = "ABA";
        String str2 = "LEETCODE";
        String str3 = "LEETCODE";
        String str4 = "LEETCODE";
        String str5 = "LEETCODE";
        String str6 = "LEETCODE";
        String str7 = "LEETCODE";
        System.out.println (count (str));
        System.out.println (count (str1));

    }

    private static int count(String s){
        Set<Character> set1 = new HashSet<> ();
        Set<Character> set2 = new HashSet<> ();

        for(int i = 0, n = s.length (); i < n; i ++){
            if(set1.add (s.charAt (i))){
                set2.add(s.charAt (i));
            } else {
                set2.remove (s.charAt (i));
            }
        }
        return set2.size();
    }

}