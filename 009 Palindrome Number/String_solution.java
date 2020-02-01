class Solution {
    public boolean isPalindrome(int x) {
        //negative numbers don't work
        if(x < 0){
            return false;
        }
        //StringBuilder is a easy way, especially its method, charAt 
        StringBuilder sb = new StringBuilder();

        sb.append(x);

        for(int i = 0, j = sb.length() - 1; i < j; i++, j--){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
