# Ideas

binary search，O(lgn)

# Missed points

Not only "left <= right", but also they can't be out of bound. 

while target is in the range and no element equals to target, left should be returned.

# Amazing

For three cases: 1. target is greater than any elements in the array; 2. target is smaller than any elments in the array; 3. Target is in the range, but does not equal to any elements in the array.

For all 3 cases above, left pointer should be returned.
