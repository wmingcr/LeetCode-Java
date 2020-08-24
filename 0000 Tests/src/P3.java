import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

class P3 {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 0, 0};
        int[][] queries = {{0, 3}};
        System.out.println (Arrays.toString (a));
        codeWriting (queries, a);
        System.out.println (Arrays.toString (a));
    }

    public static int codeWriting(int[][] queries, int[] a){
        if(queries == null || queries.length == 0){
            return - 1;
        }

        for(int[] query : queries){
            // alloc type query, when query[0] = 0
            if(query[0] == 0){
                int x = query[1];
                for(int i = 0; i < a.length; i ++){
                    if(a[i] != 0){
                        continue;
                    }
                    int start = i, end = i + x - 1;
                    if(end >= a.length){
                        return -1;
                    }
                    int idx = start;
                    while(idx <= end && a[idx] == 0){
                        idx ++;
                    }
                    if(idx > end){
                        setOnes(a, start, end);
                        return start;
                    } else {
                        i = idx;
                    }
                }
            }
            // eraseID
            else{

            }
        }

        return -1;
    }

    private static void setOnes(int[] a, int L, int R){
        while(L <= R){
            a[L++] = 1;
        }
    }
}