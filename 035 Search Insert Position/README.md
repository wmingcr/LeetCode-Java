# Ideas

First thought, binary search; For time complexity, it would be a good solution.

# Missed points

First, Conditions for ending for loop: Not only "left <= right", but also they can't be out of bound. 

Second, The most important thing is one case: while target is in the range and no element equals with it. Left should be returned.

# Amazing finding

For three cases: 1. target is greater than any elements in the array; 2. target is smaller than any elments in the array; 3. Target is in the range, but does not equal to any elements in the array.

For all 3 cases above, left pointer should be returned.
