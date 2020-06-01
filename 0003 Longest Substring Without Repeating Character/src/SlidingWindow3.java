class SlidingWindow3 {

    public int lengthOfLongestSubstring(String s) {
        //validity
        if(s == null || s.length() == 0){
            return 0;
        }

        int len = 0, lo = 0, hi = 0, n = s.length();
        // store indexes of char inside s
        int[] arr = new int[128];

        while(lo < n && hi < n){
            // update lo
            lo = Math.max(arr[s.charAt(hi)], lo);
            len = Math.max(hi-lo+1, len);
            arr[s.charAt(hi)] = hi+1;
            hi++;
        }

        return len;
    }
}