// regular binary search, module #1



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
        
        //binary search
        while(left <= right){ // with "=", no element will be missed
            
            //mid point
            int mid = left + ((right-left)>>1);
            
            if(guess(mid) == 0) {
                return mid;
            }else if(guess(mid) == -1){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        //since the number is between 1 to n, so method will be ended inside of while loop
        //it doesn't matter what we will return, 
        return -1;
    }
}
