import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lexicographic_BitMask2 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            // recording answers
            List<List<Integer>> ans = new ArrayList<> ();
            // validity
            if(nums == null || nums.length == 0){
                return ans;
            }
            // get length
            int n = nums.length;
            int a = (int)Math.pow(2, n);
            int b = (int)Math.pow(2, n + 1);
            for(int i = a; i < b; i ++){
                // get mask
                String bitMask = Integer.toBinaryString(i).substring(1);
                // List, to store a subset
                List<Integer> tem = new LinkedList<> ();
                // pick numbers
                for(int j = 0; j < bitMask.length(); j ++){
                    if(bitMask.charAt(j) == '1'){
                        tem.add(nums[j]);
                    }
                }
                ans.add(tem);
            }
            return ans;
        }
    }
}
