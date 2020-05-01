class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //create a new list
        List<List<Integer>> ans = new ArrayList<>();
        
        //validity
        if(nums == null || nums.length < 4){
            return ans;
        }
        
        //sort the array
        Arrays.sort(nums);
        
        //check the four smallest elements
        if(nums[0] + nums[1] + nums[2] + nums[3] > target){
            return ans;
        }
        
        //check the four biggest elements
        int n = nums.length;
        if(nums[n-4] + nums[n-1] + nums[n-2] + nums[n-3] < target){
            return ans;
        }
        for(int one = 0; one < n-3; one ++){
            if(one > 0 && nums[one]==nums[one-1]){
                continue;
            }
            for(int two = one+1; two < n-2; two ++){
                if(two > one+1 && nums[two] == nums[two-1]){
                    continue;
                }
                int thr = two+1, four = nums.length-1;
                while(thr < four){
                    int sum = nums[one] + nums[two] + nums[thr] + nums[four];
                    if(sum < target){
                        thr++;
                    }else if (sum > target){
                        four--;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[one]);
                        list.add(nums[two]);
                        list.add(nums[thr]);
                        list.add(nums[four]);
                        ans.add(list);
                        while(nums[thr] == nums[++thr] && thr < four){};
                        while(nums[four] == nums[--four] && thr < four){};
                    }
                }
            }
        }
        return ans;
    }
}






