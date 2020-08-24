import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class GetOrder_ReBuild {


    // Definition for a binary tree node.
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
        List<Integer> list = new ArrayList<> ();

        public TreeNode balanceBST(TreeNode root) {
            inOrder (root);
            return reBuild (0, list.size () - 1);
        }

        private TreeNode reBuild(int l, int r) {
            if (l > r) {
                return null;
            }
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode (list.get (mid));
            root.left = reBuild (l, mid - 1);
            root.right = reBuild (mid + 1, r);
            return root;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder (root.left);
            list.add (root.val);
            inOrder (root.right);
        }
    }
}
