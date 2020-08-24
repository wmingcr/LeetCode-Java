import java.util.ArrayList;
import java.util.List;

public class Boyer_Moore {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<> ();
            if (nums == null || nums.length == 0) {
                return res;
            }

            int num1 = nums[0], cut1 = 0;
            int num2 = nums[0], cut2 = 0;

            for (int n : nums) {
                if (n == num1) {
                    cut1++;
                } else if (n == num2) {
                    cut2++;
                } else if (cut1 == 0) {
                    num1 = n;
                    cut1 = 1;
                } else if (cut2 == 0) {
                    num2 = n;
                    cut2 = 1;
                } else {
                    cut1--;
                    cut2--;
                }
            }

            cut1 = 0;
            cut2 = 0;
            for (int n : nums) {
                if (n == num1) {
                    cut1++;
                } else if (n == num2) {
                    cut2++;
                }
            }

            int limit = nums.length / 3;

            if (cut1 > limit) {
                res.add (num1);
            }
            if (cut2 > limit) {
                res.add (num2);
            }

            return res;
        }
    }
}
