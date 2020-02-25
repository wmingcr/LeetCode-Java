//I have this thought, but couldn't code it, 
//Thanks to https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
class Solution {
    public void rotate(int[] nums, int k) {
        //check validity
        if(nums == null || nums.length <= 0 || k <= 0){
            return;
        }
        //in case k is greater than nums.length
        k = k % nums.length;//do not fail here again
        for(int start = 0/*start position*/, i = 0, position = start, positionK = (position/*此为position，not start(altough it's fine)*/ + k)%nums.length; i < nums.length/*make sure only n numbers transferred*/; start ++, position = start%nums.length/*it won't our of bound, but still in case...*/, positionK = (start + k)%nums.length){
            int te = nums[position];//preV, to be transferred
            do{
                int teK = nums[positionK];
                nums[positionK] = te;
                te = teK;
                i ++;//one element has been transferred
                position = positionK;//update position and positionK
                positionK = (position + k)%nums.length;
            }while(position != start);
        }
    }
}
