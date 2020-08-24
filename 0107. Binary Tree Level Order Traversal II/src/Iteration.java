import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Iteration {

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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            // 换成 LinkedList 更好点
            List<List<Integer>> ans = new ArrayList<> ();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new ArrayDeque<> ();
            queue.add (root);

            while (queue.size () != 0) {
                List<Integer> currList = new ArrayList<> ();
                int n = queue.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode currNode = queue.poll ();
                    currList.add (currNode.val);
                    if (currNode.left != null) {
                        queue.add (currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add (currNode.right);
                    }
                }
                ans.add (0, currList);
            }

            return ans;
        }
    }
}
