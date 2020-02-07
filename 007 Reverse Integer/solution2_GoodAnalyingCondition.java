class Solution {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            //this condition is for checking whether (ans * 10 ) overflow or not
            /**
            * if ans * 10 is verflow, then (ans * 10) / 10 can't be itself,
            * important analyzing condition
            */
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}
