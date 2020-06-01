public class SlidingWindowOptimized {


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

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i]) {
                count++;
            }
        }

        for (int i = 0; i < s2.length () - s1.length (); i++) {
            if (count == 26) {
                return true;
            }

            int r = s2.charAt (i + s1.length ()) - 'a';
            int l = s2.charAt (i) - 'a';

            arr2[r]++;

            if (arr2[r] == arr1[r]) {
                count++;
            } else if (arr2[r] == arr1[r] + 1) {
                count--;
            }
            arr2[l]--;
            if (arr2[l] == arr1[l]) {
                count++;
            } else if (arr2[l] == arr1[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }
}

