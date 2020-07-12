package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

    }

    private static void sort(int[] arr){
        // get hash codes
        final int[] code = hash(arr);

        // create and initialize buckets to ArrayList: O(n)
        List[] buckets = new List[code[1]];
        for(int i = 0; i < code[1]; i ++){
            buckets[i] = new ArrayList ();
        }

        // distribute data into buckets: O(n)
        for(int i : arr){
            buckets[hash(i, code)].add(i);
        }

        // sort each bucket O(n)
        for (List bucket : buckets){
            Collections.sort(bucket);
        }

        int idx = 0;
        // merge the buckets: O(n)
        for(int b = 0; b < buckets.length; b++){
//            for(Integer v : buckets[b]){
//                arr[idx++] = v;
//            }
        }
    }

    private static int[] hash(int[] arr){
        int m = arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(m < arr[i]){
                m = arr[i];
            }
        }
        return new int[] {m, (int)Math.sqrt(arr.length)};
    }

    private static int hash(int i, int[] code){
        return (int) ((double) i / code[0] * (code[1] - 1));
    }
}
