import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class Recursion {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int pathSum(TreeNode root, int sum) {
            // key是前缀和，value 是大小为 key 的前缀和出现的次数
            Map<Integer, Integer> prefixSumCount = new HashMap<> ();
            // 前缀和为 0 的一条路径
            prefixSumCount.put (0, 1);
            // 前缀和的递归回归思路
            return recursionPathSum (root, prefixSumCount, sum, 0);
        }

        /**
         * 前缀和的递归回溯思路
         * 从当前节点反推到根节点（反推比较好理解，正想其实也只有一条），有且有一条路径，因为这是一棵树
         * 如果此前有和为 currSum-target, 而当前的和又为 currSum，两者的差肯定为 target 了。
         * 所以，前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证不影响其它分支的结果
         */

        private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
            // 1. 递归终止条件
            if (node == null) {
                return 0;
            }
            // 2. 本层要做的事情
            int res = 0;
            // 当前路径的和
            currSum += node.val;

            // 核心代码
            // 看看 root到当前节点这条路上是否存在前缀和加上 target 为 currSum 的路径
            // 当前节点->root节点反推，有且只有一条路径，如果此前有和为 currSum-target，而当前的和又为 currSum
            // 两者的差值肯定为 target 了
            // currSum-target 相当于找路径的起点，起点的 sum + target = currSum, 当前点到起点的距离就是 target
            res += prefixSumCount.getOrDefault (currSum - target, 0);
            // 更新路径上当前节点前缀和的个数
            prefixSumCount.put (currSum, prefixSumCount.getOrDefault (currSum, 0) + 1);

            // 3. 进入下一层
            res += recursionPathSum (node.left, prefixSumCount, target, currSum);
            res += recursionPathSum (node.right, prefixSumCount, target, currSum);

            // 4. 回到本层，恢复状态，取出当前节点的前缀和数量
            prefixSumCount.put (currSum, prefixSumCount.get (currSum) - 1);
            return res;
        }
    }
}
