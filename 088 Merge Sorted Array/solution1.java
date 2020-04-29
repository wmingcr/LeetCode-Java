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
、、----
    class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //check validity
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return;
        }
        int i = m+n-1;
        n--;m--;
        for( ; i >= 0 && m >=0 && n >= 0; i --){
            if(nums1[m] > nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }else{
                nums1[i] = nums2[n];
                n--;
            }
        }
        while(m >= 0){
            nums1[i--] = nums1[m--];
        }
        while(n >= 0){
            nums1[i--] = nums2[n--];
        }
    }
}
