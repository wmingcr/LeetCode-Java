class Solution {
    public int thirdMax(int[] nums) {
        //check validity
        if(nums == null || nums.length <= 0){
            return -1;
        }
        /** Method 1, many ifs, 
        * Obvoiusly, it's not the best way. 
        * T, O(n), S, O(1)
        * Runtime: 3 ms, faster than 51.60% 
        */
        //return manyIfs(nums);
        
        /** Method2, sortion
        * T, O(n), S, O(1)
        * Even it's O(nlgn), it's still 88.44% faster, which means ArrayList is pretty efficient.
        */
        //return sortArray(nums);
        
        /** Method 3, ArrayList
        * Runtime: 3 ms, faster than 51.43%
        * About type conversion of Int and Long, see repo Java_learning 026
        */
        //return arrayList(nums);
    }
    
    private int arrayList(int [] nums){
        ArrayList<Long> al = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            al.add(Long.MIN_VALUE);
        }
        for(int num : nums){
            if(al.contains((long)num) || num < al.get(2)){
                continue;
            }
            if(num < al.get(1)){
                al.set(2, (long)num);
            }else if(num < al.get(0)){
                al.set(2, al.get(1));
                al.set(1, (long)num);
            }else{
                al.set(2, al.get(1));
                al.set(1, al.get(0));
                al.set(0, (long)num);
            }
            /**
            if(num > al.get(0)){
                al.set(2, al.get(1));
                al.set(1, al.get(0));
                al.set(0, num);
            }else if (num > al.get(1)){
                al.set(2, al.get(1));
                al.set(1, num);
            }else if (num > al.get(2)){
                al.set(2, num);
            }
            */
        }
        
        if(al.get(2) != Long.MIN_VALUE){
            return Math.toIntExact(al.get(2));
        }
        return Math.toIntExact(al.get(0));
    }
    
    private int sortArray(int [] nums){
        Arrays.sort(nums);
        ArrayList<Integer> al = new ArrayList<>();//Error, missed Integer inside generic
        for(int j = nums.length - 1; j >= 0; j --){
            if(al.contains(nums[j])){
                continue;
            }
            al.add(nums[j]);//still i after changed i to j as index
            if(al.size() == 3){
                break;
            }
        }
        if(al.size() < 3){
            return al.get(0);
        }
        return al.get(2);
    }
    
    private int manyIfs(int [] nums){//parameter declare error, int nums NOT JUST nums
                                    //Error 2, it's int [] nums NOT int nums
        //Error 1, 我取到了最大的三个值，实际上需要的是三个不同的值
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            al.add(null);
        }
        for(int num : nums){
            if(al.contains(num)){
                continue;
            }
            if(al.get(0) == null){
                al.set(0, num);
            }else if(al.get(1) == null){
                if(al.get(0) < num){
                    al.set(1, al.get(0));
                    al.set(0, num);
                }else{
                    al.set(1, num);
                }
            }else if(al.get(2) == null){
                if(al.get(0) < num){
                    al.set(2, al.get(1));
                    al.set(1, al.get(0));
                    al.set(0, num);
                }else if(al.get(1) < num){
                    al.set(2, al.get(1));
                    al.set(1, num);
                }else{
                    al.set(2, num);
                }
            }else{
                if(al.get(0) < num){
                    al.set(2, al.get(1));
                    al.set(1, al.get(0));
                    al.set(0, num);
                    
                }else if(al.get(1) < num){
                    al.set(2, al.get(1));
                    al.set(1, num);
                }else if (al.get(2) < num){
                    al.set(2, num);
                }
            }
        }
        
        if(al.get(2) != null){
            int tem = al.get(2);
            return tem;
        }
        int tem = al.get(0);
        return tem;
    }
}
