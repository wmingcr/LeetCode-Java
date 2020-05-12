## Reference ans

DP, while search for the first element which is greater than nums[i], 
必须改变tail数组中第一个大于nums[i]的值，而不是改变tail数组中最后一个值。
例如：

[1, 2, 8, 9, 7, 6, 3, 4, 5, 6, 12]

1, 2, 8, 9, --> 1, 2, 12 wrong,

1, 2, 8, 9, 

1, 2, 7, 9,

1, 2, 6, 9,

1, 2, 3, 9,

1, 2, 3, 4,

1, 2, 3, 4, 5, 

1, 2, 3, 4, 5, 6, 

1, 2, 3, 4, 5, 6, 12,

The Best solution:

[liweiwei1419] (https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/)