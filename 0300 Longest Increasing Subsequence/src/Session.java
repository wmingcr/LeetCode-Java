import java.util.Arrays;

public class Session {

    public static void main(String[] args) {

        int [] arr = {4,10,4,3,8,9};

        int ans = new Solution().lengthOfLIS (arr);

        System.out.println (ans);

        Arrays.fill (arr,2);

        System.out.println (Arrays.toString (arr));
    }
}
