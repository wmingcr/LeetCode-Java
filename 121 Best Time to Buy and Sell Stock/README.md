# Thoughts

It might be easy to understand using nested for loops. Just to find the greatest value, using an int variable to store it. 

For nested loops, T: O(n^2), S: O(1).

# Tips

//T: O(n), S: O(1).

Check the lower price, and the bigger range at the same time.

If it's lower than the minPrice, then record it; if not, check the profit is greater or not.

# divide and conquer

solution3.

We cand divide it into two half, find max left and right profit, and cross profit, then return the max profit.

//T: O(nlgn), S: O(lgn)//since using recursion, using the stack,

# new

Math.max(a, b); Math.min(a, b);

# References

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

2020Spring, 6205pdf, page 627.
