public class Solution_Optimized {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // validity
            if(nums1 == null || nums2 == null || m < 0 || n < 0){
                return;
            }

            int left = m-1, right = n - 1, tail = m+n-1;

            while(left >= 0 && right >= 0){
                if(nums1[left] >= nums2[right]){
                    nums1[tail--] = nums1[left--];
                } else {
                    nums1[tail--] = nums2[right--];
                }
            }

            /**
             If all elements from nums2 are sorted into nums1, then merge process is over.
             There is no need to continue merge for nums1 only.
             */
//         while(left >= 0){
//             nums1[tail--] = nums1[left--];
//         }

            while(right >= 0){
                nums1[tail--] = nums2[right--];
            }

        }
    }
}
