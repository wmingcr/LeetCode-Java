import javax.swing.tree.TreeNode;

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
        // 这个比我自己写的那个方式简单的多
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree (p.right, q.right) && isSameTree (p.left, q.left);
        }


/*        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree (p.left, q.left) && isSameTree (p.right, q.right);
        }*/
    }
}
