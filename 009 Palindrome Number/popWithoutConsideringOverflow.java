class Solution {
    public boolean isPalindrome(int x) {
        //rebustness
        if(x < 0){
            return false;
        }
        int newX = 0;
        int xCopy = x;
        //pop, 
        while(xCopy!=0){
            int remain = xCopy%10;
            xCopy = xCopy/10;
            newX = newX * 10 + remain;
        }
        
        //good return;
        return newX == x;
    }
}
