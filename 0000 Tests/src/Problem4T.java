import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem4T {

    class Paired{
        int idx;
        int value;
        Paired(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    //    冒泡排序
    public static void main(String[] args) {


    }

    private int findMissingNum(String[][] quarter) {

        int sum16 = 0;
        for(int i = 1; i < 17; i ++){
            sum16 += i;
        }

        int m = quarter.length;
        int n = quarter[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrList = new ArrayList<> ();
        for(int i = 0; i < n; i += 4){
            int sum = sum16;
            int x = 0, y = 0;
            for(int a = i; a < i + 4; a ++){
                for(int b = 0; b < 4; b ++){
                    if(quarter[a][b] == "?"){
                        x = a;
                        y = b;
                    } else {
                        sum -= Integer.parseInt (quarter[a][b]);
                    }
                }
            }
            quarter[x][y] = String.valueOf(sum);
            map.put(i, sum);
        }

        for(int i = 0; i < n; i += 4){
            for(int j = i + 4; j < n; j += 4){

            }
        }

    }

}
