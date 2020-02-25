# Thoughts

# Method 1, Brute Force

T, O(kn), S, O(1)

# Method 2, new Array with length k

T, O(n+k), S, O(k)

# Method3, new Array with length n,

T, O(n), S, O(n)

# Method 4, reverse array three times,

T, O(n/2 + k/2 + (n-k)/2), which is O(n), 

S, O(1)

# Method 5, Genius, pass values like many circles

T, O(n), S, (1)

I know how to do, but don't know to code it. The one who figured it out must be genius. 

See solutionFinal for details.

# One question for Method 5

While there is a circle beginning with start, how to prove (start+1) is not covered after fisrt circle?
