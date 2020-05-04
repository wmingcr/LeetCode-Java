// Too sleepy, Dont know what I coded

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //validity
        if(arr == null || arr.length == 0 || k <= 0){
            return new LinkedList<Integer>();
        }
        
        //initializint answer
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
            
            if(te < 0){//from the first element
                te = 0;
            }
            
            while(te < arr.length){
                ans.add(arr[te++]);
            }
            return ans;
        }
        
        //find the element which is the closest to x
        int idx_Closest = findClosestIdx(arr, x);
        
        //find the first element to be returned
        int leftBound = findLeftBound(arr, k, x, idx_Closest);
        
        //storing k elements
        int newIdx = 0;
        while(newIdx++ < k){
            ans.add(arr[leftBound++]);
        }
        
        return ans;
    }
    
    //find the first element to be stored in List
    private int findLeftBound(int[] arr, int k, int x, int idx){
        
        //while we already found idx, so te can just start from 1
        int te = 1, left = idx, right = idx;
        
        while(te < k){
            int leftABS = x - arr[left-1];
            int rightABS = x - arr[right+1];
            
            if(Math.abs(leftABS) <= Math.abs(rightABS)){ // with "=", get the left element
                left--;
            }else{
                right++;
            }
            
            te++; // increasing by 1
            
            if(left == 0){ //incase out of left bound
                return 0; 
            }
            if(right == arr.length-1){ // incase out of right bound
                return arr.length - k;
            }
        }
        return left;
    }
    
    //find the element which is the closest one to x
    private int findClosestIdx(int[] arr, int x){
        //idx, index of element closest to x
        int idx = 0, abs = Integer.MAX_VALUE;
        
        //initialization for binary search
        int left = 0, right = arr.length-1;
        
        //binary search
        while(left <= right){
            
            //mid pointer
            int mid = left + ((right-left)>>1);
            
            //got a new abs
            int newAbs = Math.abs(x - arr[mid]);
            
            if(newAbs < abs){
                idx = mid; // renew index
            }
            
            if(arr[mid] == x){
                return idx; // ending condition
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

