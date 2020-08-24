package InPostPreOrder;

public class Morris3Traversal {

    public void inorder(Node root) {
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.println (curr.val + ", ");
                curr = curr.right;
            } else {
                Node predecessor = curr.left;
                while(predecessor.right != curr && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    System.out.println (curr.val + ", ");
                    curr = curr.right;
                }
            }
        }
    }

    public void preorder(Node root){
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.println (curr.val + ", ");
                curr = curr.right;
            } else {
                Node predecessor = curr.left;
                while(predecessor.right != curr && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = curr;
                    System.out.println (curr.val + ", ");
                    curr = curr.left;
                } else {
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}