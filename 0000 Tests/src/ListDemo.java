import java.util.ArrayList;
import java.util.List;

public class ListDemo<String> {
    List<String> res;
    ListDemo(){
        res = new ArrayList<> ();
    }

    public void add(String str){
        res.add(str);
    }

    @Override
    public java.lang.String toString() {
        return res.toString ();
    }
}
