class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        char ans = '\u0000';
        
        if(letters == null || letters.length == 0){
            return ans;
        }
        
        int left = 0, right = letters.length;
        
        while(left < right){
            
            int mid = left + ((right-left)>>1);
            
            if(letters[mid] == target){
                left = mid + 1;
            }else if(letters[mid] < target){
                left = mid + 1;
            }else if(letters[mid] > target){
                right = mid;
            }
        }
        return letters[left%letter.length];
    }
}
