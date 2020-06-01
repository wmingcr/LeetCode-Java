public class SlidingWindowArray {

    // The most important thing is to find
    // in what kind of condition, enlarging right side
    // in what kind of condition, shrinking left side

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            // validity
            if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
                return false;
            }
            // get length
            int m = s1.length();
            int n = s2.length();
            // store char and frequencies from s1, pattern
            //HashMap<Character, Integer> map = new HashMap<>();

            // since we find that manipulating an array is faster than HashMap
            // let's try to use an array to store chars and their frequency
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            // change string to char array is faster, altough it's a little space consuming
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();

            // if there is a char and its frequency matching, target++
            int target = 0;
            // recording frequency and char
            for(int i = 0; i < m; i ++){
                int idx = cs1[i] - 'a';
                arr1[idx]++;
                if(arr1[idx] == 1){
                    target++;
                }
            }
            // when count == target, we get a permutation
            int count = 0;

            for(int i = 0; i < n; i ++){
                // enlarging right side
                int idx = cs2[i] - 'a';
                arr2[idx] ++;

                if(arr2[idx] == arr1[idx]){
                    count ++;
                } else if (arr2[idx] == arr1[idx] + 1){
                    count --;
                }

                if(i > m - 1){
                    idx = cs2[i - m] - 'a';
                    arr2[idx]--;
                    if(arr2[idx] == arr1[idx]){
                        count++;
                    } else if (arr2[idx] == arr1[idx] - 1){
                        count--;
                    }
                }
                if(count == target){
                    return true;
                }
            }
            return false;
        }
    }
}
