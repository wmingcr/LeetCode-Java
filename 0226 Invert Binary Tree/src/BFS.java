import java.util.LinkedList;

public class BFS {

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
            var qq = new LinkedList<TreeNode> ();
            if (root == null) {
                return null;
            }

            qq.add (root);

            while (!qq.isEmpty ()) {
                int n = qq.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode node = qq.removeFirst ();
                    TreeNode L = node.left, R = node.right;
                    node.left = R;
                    node.right = L;

                    if (node.left != null) {
                        qq.add (node.left);
                    }
                    if (node.right != null) {
                        qq.add (node.right);
                    }
                }
            }

            return root;
        }
    }
}
