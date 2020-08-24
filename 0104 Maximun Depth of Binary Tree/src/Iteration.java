import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
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
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> que = new ArrayDeque<> ();

            int level = 0;
            if (root == null) {
                return level;
            }

            que.add (root);
            while (que.size () > 0) {
                level++;
                int n = que.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode curr = que.poll ();
                    if (curr.left != null) {
                        que.add (curr.left);
                    }
                    if (curr.right != null) {
                        que.add (curr.right);
                    }
                }
            }
            return level;
        }
    }
}
