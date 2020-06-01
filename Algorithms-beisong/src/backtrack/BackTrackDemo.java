package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BackTrackDemo {

    /**
     * for 选择 in 选择列表:
     *     # 做选择
     *     将该选择从选择列表移除
     *     路径.add(选择)
     *     backtrack(路径, 选择列表)
     *     # 撤销选择
     *     路径.remove(选择)
     *     将该选择再加入选择列表
     *
     * 作者：labuladong
     * 链接：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */


    static List<List<Integer>> ans = new LinkedList<> ();

    public static void main(String[] args) {
        int[] num = {1,2,3};
        backtrack (new LinkedList<> (), num);
        System.out.println (ans);
    }

    private static void backtrack(LinkedList<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            ans.add(new LinkedList<>(temp));
            return;
        }

        for(int num : nums){
            if(temp.contains(num)){
                continue;
            }
            temp.add(num);
            backtrack (temp, nums);
            temp.removeLast();
        }
    }
}
