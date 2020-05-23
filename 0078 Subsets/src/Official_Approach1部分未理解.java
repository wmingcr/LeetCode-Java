import java.util.ArrayList;
import java.util.List;

public class Official_Approach1部分未理解 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> output = new ArrayList ();

            output.add (new ArrayList<Integer> ());

            for (int num : nums) {

                List<List<Integer>> newSubsets = new ArrayList ();

                for (List<Integer> curr : output) {
                    newSubsets.add (new ArrayList<Integer> (curr) {
                        {
                            add (num);
                        }
                    });
                }

                for (List<Integer> curr : newSubsets) {
                    output.add (curr);
                }
            }

            return output;

        }
    }

}
