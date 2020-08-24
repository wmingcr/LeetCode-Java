import java.lang.ref.PhantomReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Operation {

    public static void main(String[] args) {
        String[] strs = { "INSERT Code", "INSERT Signal", "DELETE", "UNDO" };
        String ans = operate (strs);
        System.out.println (ans);
    }

    private static String operate(String[] strs){

        StringBuffer sb = new StringBuffer();
        Deque<Integer> stackIdx = new ArrayDeque<> ();
        Deque<String> stackString = new ArrayDeque<>();

        String copy = "", prevOperation = null;

        for(int i = 0; i < strs.length; i ++){
            // 拿到第一个空格的 idx
            int idxOfSpace = getIdx(strs[i]);
            // 得到 operation，和后面的 text
            String operation = strs[i].substring(0, idxOfSpace);

            String text = "";
            if(idxOfSpace + 1 < strs[i].length()){
                text = strs[i].substring (idxOfSpace + 1);
            }

            // 进行操作
            if(Objects.equals (operation, "INSERT")){
                // update prevSize
                int size = sb.toString ().length ();
                stackIdx.push(size);
                sb.append (text);
                prevOperation = operation;
            } else if (Objects.equals(operation, "DELETE")){
                // 如果为空的话，会不会报错？
                int preSize = -1;
                try{
                    preSize = stackIdx.pop();
                } catch ( Exception e){
                    System.out.println ("当前没有任何内容可以抛出");
                }

                int curSize = sb.toString ().length ();
                String deleteString = sb.substring (preSize, curSize);
                stackString.push(deleteString);
                sb.delete(preSize, curSize);
                prevOperation = operation;
            } else if (Objects.equals (operation, "COPY")){
                int startCopyIdx = Integer.parseInt(text);
                if(startCopyIdx >= sb.toString().length()){
                    copy = "";
                } else {
                    copy = sb.substring (startCopyIdx);
                }
                prevOperation = operation;
            } else if (Objects.equals (operation, "PASTE")){
                stackIdx.push(sb.toString ().length ());
                sb.append (copy);
                prevOperation = operation;
            } else { // undo
                // 只能 undo 一次，undo 多次的话需要给delete掉的内容添加的stack中，
                if (prevOperation == null) {
                    continue;
                }
                if (prevOperation == "COPY") {
                    copy = "";
                } else if (prevOperation == "INSERT" || prevOperation == "PASTE") {
                    int preSize = stackIdx.pop ();
                    int curSize = sb.toString ().length ();
                    sb.delete (preSize, curSize);
                } else if (prevOperation == "DELETE") {
                    int preSize = sb.toString ().length ();
                    stackIdx.push (preSize);
                    String tempText = stackString.pop ();
                    sb.append (tempText);
                }
                prevOperation = null;
            }
        }
        return sb.toString();
    }

    private static int getIdx(String str){
        int i = 0;
        while(i < str.length () && str.charAt(i) != ' '){
            i++;
        }
        return i;
    }
}
