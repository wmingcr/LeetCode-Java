# Idea 1

(It seems greater square values are located in two sides of the array)

It seems not to hard. If we don't create new array. We can modify the array we are given.

Compare the sqaure values of two ellements from each side. If right ellement is greater, just assign the square value to it. If left ellement is greater, swap the two values and then assign the square value to it. 

T, O(n); S, O(1)

================================[-3,-3,-2,1] turned out I'm wrong================================================

# Idea 2

Create a new array and use two pointers, left and right; we can compare the square of the two ellements, pass the greater value of the square of the ellement into the last index of the new array. 

For this way, T is O(n), S is also O(n).

# Second Thoughts

Is idea 1 not working at all? for T, O(n); S, O(1)

