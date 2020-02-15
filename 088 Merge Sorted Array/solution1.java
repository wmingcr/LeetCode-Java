//O(m+n), O(1)
//last part of Merge Sort,
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        for( ; k >= 0 && i >= 0 && j >= 0; ){
          //choose the bigger one,
            if(nums1[i] >= nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
      //check any elements left here,
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
      //check any elements left here,
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
