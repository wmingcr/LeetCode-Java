import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            Queue<TreeNode> queNode = new LinkedList<> ();
            Queue<Integer> queVal = new LinkedList<> ();
            queNode.offer (root);
            queVal.offer (root.val);

            while (queNode.isEmpty () == false) {
                TreeNode curr = queNode.poll ();
                int tem = queVal.poll ();
                if (curr.left == null && curr.right == null) {
                    if (tem == sum) {
                        return true;
                    }
                    continue;
                }
                if (curr.left != null) {
                    queNode.offer (curr.left);
                    queVal.offer (curr.left.val + tem);
                }
                if (curr.right != null) {
                    queNode.offer (curr.right);
                    queVal.offer (curr.right.val + tem);
                }
            }

            return false;
        }
    }
}
