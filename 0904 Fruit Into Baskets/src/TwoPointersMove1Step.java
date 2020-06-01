import java.util.HashMap;

public class TwoPointersMove1Step {



    class Solution {
        public int totalFruit(int[] tree) {
            // validity
            if(tree == null || tree.length == 0){
                return 0;
            }

            int start = 0;
            int end = 0;
            int max = 0;
            HashMap<Integer, Integer> map = new HashMap<>();

            while(end < tree.length){
                map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
                end ++;
                while(map.size() > 2){
                    map.put(tree[start], map.get(tree[start]) - 1);
                    if(map.get(tree[start]) == 0){
                        map.remove(tree[start]);
                    }
                    start++;
                }
//                if(map.size() == 2){
//                    max = Math.max(max, end - start);
//                }
                // two baskets could store only one fruit, or two kinds of fruit
                // so, we cant restraint map.size() == 2
                max = Math.max(max, end - start);
            }
            return max;
        }
    }
}
