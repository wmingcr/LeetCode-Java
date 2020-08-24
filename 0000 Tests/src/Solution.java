class Solution {
    public int[] searchRange(int[] nums, int target) {
        // corner case
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        // find the idx of target, return -1 if target not exists
        int idx = findTarget(nums, target);
        if(idx == -1){
            return new int[]{-1, -1};
        }

        // find left bound
        int L = findLeftBound(nums, target, idx);
        // find right bound
        int R = findRightBound(nums, target, idx);

        return new int[]{L, R};
    }

    private int findTarget(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            } else if (target < nums[mid]){
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    private int findLeftBound(int[] nums, int tar, int idx){
        int lo = 0, hi = idx, mid;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < tar){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int findRightBound(int[] nums, int tar, int idx){
        int lo = idx, hi = nums.length - 1, mid;
        while(lo < hi){
            mid = lo + (hi - lo + 1) / 2;
            if(nums[mid] > tar){
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}