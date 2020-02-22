# Method 1, Brute Force

T, O(n^2), S, O(1)

Nested Loop, count duplicated times of every element.

# Method 2, HashMap

T, O(n), S, O(n)

For loop, search every element, check if it's contained in HashMap. If not, store it and duplicated times : 1; otherwise, increasing duplicated times by 1. 

# Method 3, Sort, return nums(n/2)

Reference, https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/

# Method 4, Boyer-Moore voting

Gorgeous, https://leetcode-cn.com/problems/majority-element/solution/qiu-zhong-shu-by-leetcode-2/

Several way to code, see solutions.
