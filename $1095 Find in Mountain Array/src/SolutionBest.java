
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class SolutionBest {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // validity
        if (mountainArr == null) {
            return -1;
        }
        // get the idx with max value
        int maxIdx = findMax (mountainArr);

        // check max
        if (mountainArr.get (maxIdx) == target) {
            return maxIdx;
        }
        // check left side first
        int ans = findTargetIdxLeft (mountainArr, 0, maxIdx - 1, target);
        if (ans != -1) {
            return ans;
        } else {
            // return ans or -1 from right side,
            return findTargetIdxRight (mountainArr, maxIdx + 1, mountainArr.length () - 1, target);
        }
    }

    // increasing order
    private int findTargetIdxLeft(MountainArray mountainArr, int lo, int hi, int t) {
        if (lo > hi) {
            return -1;
        }
        while (lo <= hi) {
            // mid point
            int mid = lo + ((hi - lo) >> 1);
            int midValue = mountainArr.get (mid);
            if (t == midValue) {
                return mid;
            } else if (t > midValue) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    // decreasing order
    private int findTargetIdxRight(MountainArray mountainArr, int lo, int hi, int t) {
        if (lo > hi) {
            return -1;
        }
        while (lo <= hi) {
            // mid point
            int mid = lo + ((hi - lo) >> 1);
            int midValue = mountainArr.get (mid);
            if (t == midValue) {
                return mid;
            } else if (t > midValue) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    // using binary search to find the index with max value
    private int findMax(MountainArray mountainArr) {
        // two pointers
        int lo = 0, hi = mountainArr.length () - 1;
        // binary search
        while (lo < hi) {
            // mid pointer
            int mid = lo + ((hi - lo) >> 1);
            int midValue = mountainArr.get (mid);
            int midRValue = mountainArr.get (mid + 1);
            if (midValue > midRValue) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }


            /*
            不能使用mid - 1, 因为折半取中间，是取的靠做的边的中间值
            所以mid - 1 可能存在越界问题，非常重要
            while (lo < hi) {
                // mid pointer
                int mid = lo + ((hi - lo) >> 1);
                int midValue = mountainArr.get (mid);
                int midLValue = mountainArr.get (mid - 1);
                int midRValue = mountainArr.get (mid + 1);
                if (midValue > midLValue && midValue > midRValue) {
                    return mid;
                } else if (midValue > midLValue) {
                    lo = mid + 1;
                } else if (midValue > midRValue) {
                    hi = mid - 1;
                }
            }
            */
        return lo;
    }
}


class MountainArray{
    public int get(int x){
        return 0;
    }
    public int length(){
        return 0;
    }
}