# Thougts

## Method 1, Brute Force

* T, O(n^2), S, O(1), 
* Runtime: 1548 ms, faster than 5.07% 
* Not efficient at all,

## Method 2, Optimized Brute Force

* For inner loop, just search within k length; out of k, it's false definitely.

* T, O(n^2), S, O(1)
* Runtime: 1285 ms, faster than 6.60%

## Method 3, Two Pointers

* Just have the idea, but can't code it out. The one who figured it out is a GENIUS. (From accepted solutions, columns)

* see solutions 3,

* However, it won't work for two duplicated elements within about (k-2?), 
* Like, [1,2,3,4,5,6,7,1,1,2,3,4,5,6,8], k = 4. I hide two 1s in the array. It should be true, but for this way, it returns false;
* WHAT A PITY.

## Method 4, TreeSet

* Check wheather the element is stored in the set, if yes return true; if false, add it. In the meantime, keep the size of set less than or equal to k. If it's size is greater than k, remove the very first element.
* However, for search(), remove(), add(), it takes two much time.

## Method 5, HashSet

* Same like method 4. But, for methods like search(), remove(), add(), it almost take constant time for HashSet. It is more efficient. 

### Reference

[力扣题解](https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/)

