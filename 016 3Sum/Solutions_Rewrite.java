class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        //new list
        List<List<Integer>> ans = new ArrayList<>();
        
        //validity
        if(nums == null || nums.length < 3){
            return ans;
        }
        
        //sort the array
        Arrays.sort(nums);
        
        //first three element
        if(nums[0] + nums[1] + nums[2] > 0){
            return ans;
        }
        
        //last three elements
        int n = nums.length;
        if(nums[n-1] + nums[n-2] + nums[n-3] < 0){
            return ans;
        }
        
        //find the conbination
        for(int i = 0; i < n-2; i ++){
            //skip duplicate elements
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            
            //first three elements
            if(nums[i] + nums[i+1] + nums[i+2] > 0){
                return ans;
            }
            
            //left pointer, right pointer
            int m = i+1, k = n-1;
            while(m < k){
                //get sum
                int sum = nums[i] + nums[m] + nums[k];
                if(sum > 0){
                    k--;
                }else if (sum < 0){
                    m++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[k]);
                    ans.add(list);
                    ++m;
                    while(nums[m]==nums[m-1] && m < k){
                        m++;
                    };
                    --k;
                    while(nums[k]==nums[k+1] && m < k){
                        k--;
                    };
                }
            }
        }
        return ans;
    }
}



