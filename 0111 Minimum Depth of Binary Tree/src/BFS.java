import java.util.LinkedList;

public class BFS {
    class Pair<TreeNode, Integer> {
        TreeNode node;
        Integer val;

        Pair(TreeNode node, Integer val) {
            this.node = node;
            this.val = val;
        }

        public TreeNode getKey() {
            return this.node;
        }

        public Integer getValue() {
            return this.val;
        }
    }

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
        public int minDepth(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<> ();
            if (root == null) {
                return 0;
            }
            stack.add (new Pair (root, 1));
            int curr_depth = 0;

            while (stack.isEmpty () == false) {
                Pair<TreeNode, Integer> current = stack.poll ();
                root = current.getKey ();
                curr_depth = current.getValue ();
                if ((root.left == null) && (root.right == null)) {
                    break;
                }
                if (root.left != null) {
                    stack.add (new Pair (root.left, curr_depth + 1));
                }
                if (root.right != null) {
                    stack.add (new Pair (root.right, curr_depth + 1));
                }
            }

            return curr_depth;
        }
    }
}
