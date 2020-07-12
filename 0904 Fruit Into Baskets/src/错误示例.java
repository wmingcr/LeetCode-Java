import java.util.HashMap;

public class 错误示例 {
    public static void main(String[] args) {
        // 当数组是：[1,0,1,4,1,4,1,2,3]
        // 就能看出这个解法有一个弊端，当map中含有前四个数，1 0 1 4 时
        // 需要 删到0，而不是，删到右边的1的位置，所以还是需要用双指针一点一点来移动
    }

    

    static class Solution {
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
                map.put(tree[end], end);
                end ++;

                while(map.size() > 2){
                    start = map.remove(tree[start]) + 1;
                }

                max = Math.max(max, end - start);
            }
            return max;
        }
    }
}
