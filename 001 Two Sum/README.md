# Tips

1. local variables, like i & j inside of for loop, at the end memory will be released
2. an effective way to return an array, return new int [ ] {a, b, c...}; like anonymous
3. before any algorithm, it's better to check whether parameters passed are legal or not,
4. for reference parameter, check whether it's null, its length validity if possible

# Optimization

Most easiest way is nesting for loop, easy to understand,

For nested for loop, time complexity is O(n^2), space complexity is O(1)

However, HashMap is a better way. TC could be O(N), SC is O(N).

Even more, we could traverse hashmap only once.

# Errors made,

1. HashMap, not Hashmap,

2. HashMap map = new HashMap();

--> return type of method map.get(key) is Object, so we need to use generic

--> HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

Second time,

map.containsKey(), not map.contains();

return array, return new int [] {-1, -1}; not return {-1, -1};
  
# PS

Good Good Study, Day Day Up

references:

https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/

https://leetcode.com/problems/two-sum/solution/

