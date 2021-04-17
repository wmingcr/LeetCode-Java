import java.util.LinkedList;

public class Stu {


    private static int getSum(int[] nums, int k, int len) {
        int res = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum == k) {
            res++;
        }
        for (int i = len; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - len];
            if (sum == k) {
                res++;
            }
        }
        return res;
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 1; i <= nums.length; i++) {
            res += getSum (nums, k, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println (subarraySum (new int[]{-1, -1, 1}, 0));
    }

}
