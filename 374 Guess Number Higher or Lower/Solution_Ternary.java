

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        //validity
        if(n <= 0){
            return -1;
        }
        
        //initialization
        int left = 1, right = n;
        
        //ternary search
        while(left <= right){
            
            //mid pointers
            int mid1 = left + (right-left)/3;
            int mid2 = right - (right-left)/3;
            
            if(guess(mid1) == 0){
                return mid1;
            }
            
            if(guess(mid2) == 0){
                return mid2;
            }
            
            if(guess(mid1) == -1){ // during in left part
                right = mid1 - 1;
            }else if (guess(mid2) == 1){ // during in right part
                left = mid2 + 1;
            }else{ // during in middle part
                left = mid1+1;
                right = mid2-1;
            }
        }
        
        //it doesnt matter what we will return here
        return -1;
    }
}
