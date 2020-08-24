import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

class IsCloseD {
    char[] dif = new char[2];
    int n;
    public static void main(String[] args) {
        String str1 = "abbzccc";
        String str2 = "babzzcz";
        System.out.println (new IsCloseD ().isClose (str1, str2));
    }

    public boolean isClose(String str1, String str2) {
        // str1 is totally different with str2
        // if anyone of them is null, then it's not an illegal class name
        if (str1 == null || str2 == null || str1.length () != str2.length ()) {
            return false;
        }
        // str1 equals with str2
        if (Objects.equals (str1, str2)) {
            return true;
        }
        this.n = str1.length();
        char[] char1 = str1.toCharArray ();
        char[] char2 = str2.toCharArray ();
        return isSwappedOccurrences (str1, str2) && isSwappedTwoSymbols (char1, char2);
    }

    private boolean isSwappedTwoSymbols (char[] char1, char[] char2){

        int x = -1, y = -1, num = 0;

        for(int i = 0; i < n; i ++){
            if( (char1[i] == dif[0] || char1[i] == dif[1]) && (char2[i] == dif[0] || char2[i] == dif[1]) ){
                continue;
            }
            if(char1[i] == char2[i]){
                continue;
            }
            num ++;
            if(num == 1){
                x = i;
            } else if (num == 2){
                y = i;
            } else {
                return false;
            }
        }
        if(x == -1){
            return true;
        } else if (y == -1){
            return false;
        }

        swap(x, y, char1);

        for(int i = 0; i < n; i ++){
            if( (char1[i] == dif[0] || char1[i] == dif[1]) && (char2[i] == dif[0] || char2[i] == dif[1]) ){
                continue;
            }
            if(char1[i] != char2[i]){
                return false;
            }
        }

        return true;
    }

    private void swap(int x, int y, char[] c){
        char tem = c[x];
        c[x] = c[y];
        c[y] = tem;
    }

    private boolean isSwappedOccurrences(String s1, String s2){
        int n = s1.length ();
        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        char c1, c2;
        for(int i = 0; i < n; i ++){
            c1 = s1.charAt (i);
            map1.put(c1, map1.getOrDefault (c1, 0) + 1);
            c2 = s2.charAt (i);
            map2.put(c2, map2.getOrDefault (c2, 0) + 1);
        }

        int numOfDifference = 0, n1 = 0, n2 = 0;
        Set<Character> keySet = map1.keySet ();
        for(char c : keySet){
            int num1 = map1.get(c);
            int num2 = map2.get(c);
            if(num1 == num2){
                continue;
            }
            numOfDifference++;
            if(numOfDifference == 1){
                dif[0] = c;
                n1 = num1;
                n2 = num2;
            } else if (numOfDifference == 2) {
                dif[1] = c;
                if(n1 != num2 || n2 != num1){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
