/*
举个例子：1221 这个数字。

通过计算 1221 / 1000， 得首位1
通过计算 1221 % 10， 可得末位 1
进行比较
再将 22 取出来继续比较

*/

class Solution {
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
/*
作者：MisterBooo
链接：https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/*
