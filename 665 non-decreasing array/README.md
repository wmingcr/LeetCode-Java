# First thoughts

--> If arr[i] <= arr[i+1], it's fine, continue;

--> Step2, If arr[i] > arr[i+1], we can just change value for one of them, and then use another for loop to check whether it's non-decreasing or not. However, we are not sure which one to change. Also, Time Complexity is n^2, not very efficent. 

===================================above is not working===================================

After step2, we can change value for one of them; then there is no need to restart the process, just continue;

So, T is just O(n).

