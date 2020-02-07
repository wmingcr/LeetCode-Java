# Thoughts

This one is preaty easy. 

Using two pointers, start from left and right side separately. 

From left, if it's even, just ignore it; likewise, from right side, if it's odd, ignore it too. 

Otherwise, swap them.

# TC, SC

As we scan every ellement in the array, TC is O(n);

No use of new array with length relating to n, SC is O(1).
