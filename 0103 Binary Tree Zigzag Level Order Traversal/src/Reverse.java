import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Reverse {

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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<> ();
            if (root == null) {
                return ans;
            }

            boolean fromLeft = true;

            LinkedList<TreeNode> qq = new LinkedList<> ();
            qq.add (root);

            while (!qq.isEmpty ()) {
                ArrayList<Integer> curr = new ArrayList<> ();
                int n = qq.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode node = qq.removeFirst ();
                    curr.add (node.val);
                    if (node.left != null) qq.add (node.left);
                    if (node.right != null) qq.add (node.right);
                }
                if (!fromLeft) {
                    reverse (curr);
                }
                ans.add (curr);
                fromLeft = !fromLeft;
            }
            return ans;
        }

        private void reverse(ArrayList<Integer> curr) {
            for (int i = 0, j = curr.size () - 1; i < j; i++, j--) {
                int val = curr.get (i);
                curr.set (i, curr.get (j));
                curr.set (j, val);
            }
        }
    }
}
