# Ideas

Seems not too hard.

Two pointers, if value right pointer equals target, move it to next one; if not, pass its value to left pointer;

# Tips

1. At the beginning, if right and left both are 0, it's a little complex to change values of them. So, set left beginning with -1 is a preaty smart move. In this way, there is no need to consider if they are both pointing to the same value which is not equivalent to target.

# Optimization

Smart move. 

If an array is like [1,2,3,4,5], what I did already checked if left and right pointers are pointing to the same value; and there is no need to do assignment.

However, if the array is [5,4,3,2,1], and target is 5. I might assign values for n-1 times.

What we can do is that if the element equals to target, we change it with last element in the array. In this way, we can avoid many unnecessary assigning process. 

Solution 2 describes how we could do it. 

References: https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/

# update 042820

Solution2 is not good enough, if the array is like [3,3,3,3,3,3,3,3,3] and our target is 3. We have to do assignment n-1 times.
