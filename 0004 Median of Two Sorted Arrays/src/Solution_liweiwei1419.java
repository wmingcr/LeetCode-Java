public class Solution_liweiwei1419 {
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // change nums1 to the array with small length
            if(nums1.length > nums2.length){
                int[] tem = nums1; nums1 = nums2; nums2 = tem;
            }

            // length
            int m = nums1.length, n = nums2.length;

            // two pointer
            int left = 0, right = m, leftTotal = (m+n+1)>>>1;

            // binary search
            while(left < right){
                int i = (left+right)>>>1;
                int j = leftTotal - i;
                // 这里不需要考虑j-1越界
                // 首先nums2的长度>=nums1，以为着j最多取值到0
                // 当j==0的时候，left == right，也不会进入这层判断
                // 我们把while(left < right) --> while(left <= right)
                // 就会得到角标越界的结果，反过来证明我们思考的正确性。
                if(nums2[j-1] > nums1[i]){
                    left = i + 1;
                } else {
                    right = i;
                }
            }

            int i = left;
            int j = leftTotal - i;

            int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

            int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

            if((m + n) % 2 == 1){ // odd
                return Math.max(nums1LeftMax, nums2LeftMax);
            } else { // even
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0; // has to be 2.0, not just 2. Otherwise, 2.5 will be 2, loss some value
            }

        }
    }
}
