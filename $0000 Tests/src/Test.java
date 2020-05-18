import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {

        Comparator<Integer> con = new Comparator<Integer>(){

            @Override
            public int compare(Integer t1, Integer t2) {
                return t1-t2;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<> (con);


        // (x) -> System.out.println(x);
        // (x, y) -> **********;


        // (t1, t2) -> t1 - t2;

        PriorityQueue<Integer> pqq = new PriorityQueue<> ((x, y) -> x - y);


    }

    private static int get(){
        return 9;
    }
}
