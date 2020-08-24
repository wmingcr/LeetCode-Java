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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            Map<Integer, Integer> map = new HashMap<> ();
            for (int i = 0; i < n; i++) {
                map.put (inorder[i], i);
            }
            return helper (inorder, 0, n - 1, postorder, 0, n - 1, map);
        }

        private TreeNode helper(int[] inorder, int in_left, int in_right, int[] postorder, int po_left, int po_right, Map<Integer, Integer> map) {
            if (in_left > in_right) {
                return null;
            }

            int root_val = postorder[po_right];
            TreeNode root = new TreeNode (root_val);
            int idx_root = map.get (root_val);

            int size_right_subtree = in_right - idx_root;

            root.left = helper (inorder, in_left, idx_root - 1, postorder, in_left, po_right - size_right_subtree - 1, map);
            root.right = helper (inorder, idx_root + 1, in_right, postorder, po_right - size_right_subtree, po_right - 1, map);
            return root;
        }
    }
}
