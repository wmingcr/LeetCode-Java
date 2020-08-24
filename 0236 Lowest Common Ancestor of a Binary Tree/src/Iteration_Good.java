import java.util.*;

public class Iteration_Good {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            HashMap<TreeNode, TreeNode> map = new HashMap<> ();
            if (root == null) {
                return null;
            }

            map.put (root, null);
            Deque<TreeNode> stack = new ArrayDeque<> ();
            stack.push (root);

            while (map.containsKey (q) == false || map.containsKey (p) == false) {
                TreeNode node = stack.pop ();
                if (node.left != null) {
                    map.put (node.left, node);
                    stack.push (node.left);
                }
                if (node.right != null) {
                    map.put (node.right, node);
                    stack.push (node.right);
                }
            }

            Set<TreeNode> ancestors = new HashSet<> ();
            while (p != null) {
                ancestors.add (p);
                p = map.get (p);
            }
            while (!ancestors.contains (q)) {
                q = map.get (q);
            }
            return q;
        }
    }
}
