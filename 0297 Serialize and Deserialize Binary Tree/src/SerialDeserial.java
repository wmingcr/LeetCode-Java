import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SerialDeserial {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder ();
            buildString (root, sb);
            return sb.toString ();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append (NN).append (spliter);
                return;
            }

            sb.append (node.val).append (spliter);
            buildString (node.left, sb);
            buildString (node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<> ();
            List<String> list = Arrays.asList (data.split (spliter));
            nodes.addAll (list);
            return buildTree (nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String str = nodes.remove ();
            if (str.equals (NN)) {
                return null;
            }

            TreeNode node = new TreeNode (Integer.parseInt (str));
            node.left = buildTree (nodes);
            node.right = buildTree (nodes);

            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
