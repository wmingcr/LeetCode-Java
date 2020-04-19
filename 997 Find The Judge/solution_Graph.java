class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N == 1 && trust.length == 0){
            return 1;
        }
        GraphDemo gd = new GraphDemo();
        gd.buildGraph(trust);
        LinkedList<Node> ans = gd.getNums();
        if(ans.size() == 1 && ans.get(0).ch.size() == (N-1)){
            return ans.get(0).x;
        }else{
            return -1;
        }
    }
    
    class Node{
        HashSet<Node> fa = new HashSet<>();
        HashSet<Node> ch = new HashSet<>();
        int x;
        Node(int x){
            this.x = x;
        }
    }
    
    class GraphDemo{
        LinkedList<Node> nodeStore = new LinkedList<>();
        public void buildGraph(int[][] arr){
            // if(arr.length <= 0){
            //     return -1; error1: no return values for this method
            // }
            if(arr.length == 0){
                return;
            }
            for(int i = 0; i < arr.length; i ++){
                // if(arr[i].length != 2){
                //     return -1;
                // }
                if(arr[i].length != 2){
                    return;
                }
                Node left = getNode(arr[i][0]);
                Node right = getNode(arr[i][1]);
                left.fa.add(right);
                right.ch.add(left);
            }
        }
        private Node getNode(int num){
            ListIterator<Node> it = nodeStore.listIterator();//eror2, it's ListIterator not Iterator
            //error3, method name is listIterator, not ListIterator, lower case letter
            //error4, there is no "<>" on the right side, nodeStore.listIterator"<>"();
            while(it.hasNext()){
                //error5, it.hasNext, this is a method, should be it.hasNext(), dont miss "()"
                Node temp = it.next();
                if(temp.x == num){
                    return temp;
                }
            }
            Node node = new Node(num);
            nodeStore.add(node);
            return node;
        }
        public LinkedList<Node> getNums(){
            ListIterator<Node> it = nodeStore.listIterator();
            LinkedList<Node> ans = new LinkedList<>();
            while(it.hasNext()){
                Node node = it.next();
                if(node.fa.size() == 0){
                    ans.add(node);
                }
            }
            return ans;
        }
    }
}
