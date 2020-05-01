//using info from high school
https://leetcode-cn.com/problems/count-number-of-teams/solution/tong-ji-zuo-zhan-dan-wei-shu-by-leetcode-solution/

class Solution {
    public int numTeams(int[] rating) {
        //validity
        if(rating == null || rating.length < 3){
            return 0;
        }
        
        //initialize answer
        int ans = 0;
        
        //find teams, 
        for(int i = 1; i < rating.length-1; i ++){
            //进行排列组合
            int LLess = 0, LMore = 0, RMore = 0, RLess = 0;
            
            //optimization
            for(int k = 0; k < i; k ++){
                if(rating[k] < rating[i]){
                    LLess++;
                }else if (rating[k] > rating[i]){
                    LMore++;
                }
            }
            for(int k = i+1; k < rating.length; k++){
                if(rating[k] < rating[i]){
                    RLess++;
                }else if (rating[k] > rating[i]){
                    RMore++;
                }
            }
            /**for(int k = 0; k < rating.length; k++){
                if(k < i && rating[k] < rating[i]){
                    LLess++;
                }else if (k < i && rating[k] > rating[i]){
                    LMore++;
                }else if (k > i && rating[k] < rating[i]){
                    RLess++;
                }else if (k > i && rating[k] > rating[i]){
                    RMore++;
                }
            }
            */
            ans += LLess*RMore + LMore*RLess;
        }
        return ans;
    }
}
