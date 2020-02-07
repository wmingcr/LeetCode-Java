# First thoughts

If arr[i] <= arr[i+1], it's fine, continue;

If arr[i] > arr[i+1], we can just change value for one of them, and then use another for loop to check whether it's non-decreasing or not. However, we are not sure which one to change. Also, Time Complexity is n^2, not very efficent. 

===================================above is not working===================================
