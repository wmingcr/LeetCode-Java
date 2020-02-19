class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //check validity
        if(numbers == null || numbers.length <2){
            return new int [] {-1, -1};
        }
        
        /** method 1
        Brute force
        Time complexity: O(n^2), Space complexity: O(1)
        Runtime: 168 ms, faster than 5.35% of Java online submissions for Two Sum II - Input array is sorted.
        */
        //return bruteForce(numbers, target);
        
        /** method 2
        Thinking about HashMap, coule reduce it to O(n)
        Time complexity: O(n), Space complexity: O(N)
        NOT GOOD ENOUGH. 
        Runtime: 1 ms, faster than 53.66% of Java online submissions for Two Sum II - Input array is sorted. 
        */
        //return withHashMap(numbers, target);//still, not good enough
        
        /** method 3
        Two pinters
        Time complexity: O(n), Space complexity: O(1)
        Runtime: 1 ms, faster than 53.66% of Java online submissions for Two Sum II - Input array is sorted.
        Still, not good enough,
        */
        //return twoPointers(numbers, target);
        
        /** method 4
        Binary Search
        However, Time complexity: O(nlgn), Space complexity: O(1)
        It still is not very efficient.
        Runtime: 2 ms, faster than 29.48% of Java online submissions for Two Sum II - Input array is sorted.
        */
        //return binarySearchDemo(numbers, target);
        
        /** method 5 EXCELLENT
        Still Two Pointers, but we use binary search to find its right position, This could help save some time.
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
        Time complexity, max is O(n), but normally it's less than O(n)
        Space Complexity, O(1)
        */
        return twoPointers_BinarySerach(numbers, target);
        
    }
    //no more than O(n), O(1)
    private int [] twoPointers_BinarySerach(int [] arr, int target){
        int left = 0;
        int right = binarySerachForRightPosition(arr, target - arr[0]);
        while(left < right){
            if(target == arr[left] + arr[right])
                return new int [] {++left, ++right};
            else if (target < arr[left] + arr[right])
                right --;
            else
                left ++;
        }
        return new int [] {-1, -1};
    }
    //O(lgn), O(1)
    private int binarySerachForRightPosition(int [] arr, int target){
        int left = 1, right = arr.length - 1;
        for(int mid = left + ((right - left)>>1); left <= right; mid = left + ((right - left)>>1)){
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left - 1;//important, left is where we can insert the target into the array and maintain the array is not descending,
    }
    //O(nlgn), O(1)
    private int [] binarySearchDemo(int [] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(target < arr[i])
                return new int [] {-1, -1};
            int dif = target - arr[i];
            int left = i + 1, right = arr.length - 1;
            for(int mid = left + ((right - left)>>1); left <= right; mid = left + ((right - left)>>1)){
                if(dif == arr[mid])
                    return new int [] {i + 1, mid + 1};
                else if(dif >= arr[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return new int [] {-1, -1};
    }
    //O(n), O(1)
    private int [] twoPointers(int [] arr, int target){
        int left = 0, right = arr.length - 1;//error 2, not target.length
        while(left < right){
            if(arr[left] + arr[right] == target){
                return new int [] {++left, ++right};
            }else if(arr[left] + arr[right] <= target){
                left ++;
            }else{
                right --;//error 1 right++
            }
        }
        return new int [] {-1, -1};
    }
    //O(n), O(n)
    private int [] withHashMap(int [] arr, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            /**if(arr[i] > target)
                break;//very good error, the other element might be on left side
                For HashMap, with arr[i], the dif must be in left side, which means it might be less than 0, and arr[i] might greater than target.
            */
            if(hm.containsKey(target - arr[i])){
                return new int [] {hm.get(target - arr[i]) + 1, i + 1};
            }
            hm.put(arr[i], i);
        }
        return new int [] {-1, -1};
    }
    //O(n^2), O(1)
    private int [] bruteForce(int [] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > target){//error 2, extra =, with =, [-1, 0] looking sum -1 is not working
                break;
            }
            int dif = target - arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] == dif)
                    return new int [] {i+1, j+1};//error 1, missing new,
            }
        }
        return new int [] {-1, -1};
    }
}
