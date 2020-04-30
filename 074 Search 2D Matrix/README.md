## Binary Search

Like normal binary search, just convert the row and column to 1D array.

For one, we consider the 2D array as a whole, do the binary search.

For two, we do binary search for row/column first, then make sure row is during the range; then do binary search for column to find the element.

https://leetcode-cn.com/problems/search-a-2d-matrix/solution/c-liang-ge-er-fen-fa-jie-jue-by-mecury/

TC, lgm + lgn = O(lgmn)

## validity

It's not ( matrix == null || matrix.length == 0 || matrix[0].length == 0 )

It's ( matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 )

