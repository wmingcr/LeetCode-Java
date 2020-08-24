import java.util.ArrayDeque;
import java.util.Queue;

public class Iteration {

    //* Definition for a binary tree node.
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
        public TreeNode invertTree(TreeNode root) {
            Queue<TreeNode> qq = new ArrayDeque<> ();
            if (root == null) {
                return null;
            }

            qq.add (root);

            while (!qq.isEmpty ()) {
                TreeNode node = qq.poll (), L = node.left, R = node.right;
                node.left = R;
                node.right = L;

                if (node.left != null) {
                    qq.add (node.left);
                }
                if (node.right != null) {
                    qq.add (node.right);
                }
            }

            return root;
        }
    }
}
