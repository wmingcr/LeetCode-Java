import java.util.List;

public class Session {

    public static void main(String[] args) {

        int[] arr = new int[] {4,3,2,7,8,2,3,1};

        List<Integer> ans = new Solution_Rearrange ().new Solution().findDuplicates (arr);

        System.out.println (ans);
    }
}
