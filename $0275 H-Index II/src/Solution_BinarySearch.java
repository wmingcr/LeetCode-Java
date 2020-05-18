public class Solution_BinarySearch {

    class Solution {
        public int hIndex(int[] citations) {
            //validity
            if(citations == null || citations.length == 0){
                return 0;
            }

            // two pointers
            int l = 0, r = citations.length-1, n = citations.length;

            // binary search
            while(l <= r){

                // mid pointer
                int mid = l + ((r - l) >> 1);

                // value of elements in left side is less than mid, definitely don't greater that n-mid+x
                if(citations[mid] == n-mid){
                    return n-mid;
                } else if (citations[mid] < n-mid){
                    l = mid + 1;
                } else if (citations[mid] > n-mid){
                    r = mid - 1;
                }
            }

            return n-l;
        }
    }
}
