# Thoughts

This one is preaty easy. 

Using two pointers, start from left and right side separately. 

From left, if it's even, just ignore it; likewise, from right side, if it's odd, ignore it too. 

Otherwise, swap them.

# TC, SC

As we scan every ellement in the array, TC is O(n);

No use of new array with length relating to n, SC is O(1).

# Discussion

Other ways, like creat a new array with length equals to length of Array A. Scan the array twice, first time assign even values, second time assign odd values. It might be easy to understand. However, it's not efficient. Have to scan the array twice, and create a new array.
