import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFSLevelOrder {


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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<> ();
            Queue<TreeNode> queue = new ArrayDeque<> ();

            if (root != null) {
                queue.add (root);
            }

            while (queue.isEmpty () == false) {
                List<Integer> curr = new ArrayList<> ();
                int n = queue.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll ();
                    curr.add (node.val);
                    if (node.left != null) queue.add (node.left);
                    if (node.right != null) queue.add (node.right);
                }
                ans.add (curr);
            }

            return ans;
        }
    }

}
