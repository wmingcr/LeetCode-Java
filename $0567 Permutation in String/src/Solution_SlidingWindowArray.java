public class Solution_SlidingWindowArray {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length () > s2.length ()) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length (); i++) {
            arr1[s1.charAt (i) - 'a']++;
            arr2[s2.charAt (i) - 'a']++;
        }

        for (int i = 0; i < s2.length () - s1.length (); i++) {
            if (match (arr1, arr2)) {
                return true;
            }
            arr2[s2.charAt (s1.length () + i) - 'a']++;
            arr2[s2.charAt (i) - 'a']--;
        }
        return match (arr1, arr2);
    }

    private boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

