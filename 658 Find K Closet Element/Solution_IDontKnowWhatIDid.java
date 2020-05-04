// Too sleepy, Dont know what I coded

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //validity
        if(arr == null || arr.length == 0 || k <= 0){
            return new LinkedList<Integer>();
        }
        
        List<Integer> ans = new LinkedList<>();
        
        //corner case, x is less or equal than the first element
        if(x <= arr[0]){
            int idx = 0, te = Math.min(k, arr.length);
            while(idx < te){
                ans.add(arr[idx++]);
            }
            return ans;
        }
        
        int n = arr.length - 1;
        
        //coner case, x is greater or equal than the last element
        if(x >= arr[n]){
            int te = arr.length - k;
            
            if(te < 0){
                te = 0;
            }
            
            while(te < arr.length){
                ans.add(arr[te++]);
            }
            return ans;
        }
        
        int idx_Closest = findClosestIdx(arr, x);
        
        int leftBound = findLeftBound(arr, k, x, idx_Closest);
        
        int newIdx = 0;
        
        while(newIdx++ < k){
            ans.add(arr[leftBound++]);
        }
        
        return ans;
    }
    
    private int findLeftBound(int[] arr, int k, int x, int idx){
        int te = 1, left = idx, right = idx;
        
        while(te < k){
            int leftABS = x - arr[left-1];
            int rightABS = x - arr[right+1];
            
            if(Math.abs(leftABS) <= Math.abs(rightABS)){
                left--;
            }else{
                right++;
            }
            te++;
            if(left == 0){
                return 0;
            }
            if(right == arr.length-1){
                return arr.length - k;
            }
        }
        return left;
    }
    
    private int findClosestIdx(int[] arr, int x){
        int idx = 0, abs = Integer.MAX_VALUE;
        int left = 0, right = arr.length-1;
        
        while(left <= right){
            
            int mid = left + ((right-left)>>1);
            
            int newAbs = Math.abs(x - arr[mid]);
            
            if(newAbs < abs){
                idx = mid;
            }
            
            if(arr[mid] == x){
                return idx;
            }
            
            if(arr[mid] > x){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }
        return idx;
    }
}
