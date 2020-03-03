
class Solution {
    public int thirdMax(int[] nums) {       
        Set<Integer> maximums = new HashSet<Integer>();
        for (int num : nums) {
            maximums.add(num);
        }
        
        if (maximums.size() < 3) {
        //size is less than 3, return the max value
            return Collections.max(maximums);
        }
        
        //while size is greater or eaqual to 3, remove the biggest two values;
        maximums.remove(Collections.max(maximums));
        maximums.remove(Collections.max(maximums));
        //return the third max value;
        return Collections.max(maximums);
    }
}
