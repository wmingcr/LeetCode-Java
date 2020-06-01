import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // see: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
    class Solution {

        class Node{
            private int left;
            private int right;
            private String s;
            Node(String str, int left, int right){
                this.s = str; this.left = left; this.right = right;
            }
        }
        public List<String> generateParenthesis(int n) {
            List<String> ans = new LinkedList<> ();
            if (n <= 0) {
                return ans;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("", n, n));
            while(queue.isEmpty() == false){
                Node curr = queue.poll();
                if(curr.left == 0 && curr.right == 0){
                    ans.add(curr.s);
                }
                if(curr.left > 0){
                    queue.offer(new Node(curr.s+"(", curr.left-1, curr.right));
                }
                if(curr.left < curr.right){
                    queue.offer(new Node(curr.s+")", curr.left, curr.right-1));
                }
            }
            return ans;
        }
    }
}
