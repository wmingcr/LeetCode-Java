# Ideas

Seems not too hard.

Two pointers, if value right pointer equals target, move it to next one; if not, pass its value to left pointer;

# Tips

1. At the beginning, if right and left both are 0, it's a little complex to change values of them. So, set left beginning with -1 is a preaty smart move. In this way, there is no need to consider if they are both pointing to the same value which is not equivalent to target.
