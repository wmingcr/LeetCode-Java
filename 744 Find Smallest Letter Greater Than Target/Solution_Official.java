//approach#1
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/solution/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        char ans = '\u0000';
        
        if(letters == null || letters.length == 0){
            return ans;
        }
        
        boolean [] seen = new boolean[26];
        
        for(char c : letters){
            seen[c - 'a'] = true;
        }
        
        while(true){
            target++;
            if(target > 'z'){
                target = 'a';
            }
            if(seen[target - 'a']){
                return target;
            }
        }
    }
}
