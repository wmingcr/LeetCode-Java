# tips

Record its sign first, keep it positive and change it into String, using StringBuffer to get a reversed String of it, at the end, according to its sign to return the expected answer, HOWEVER, it is the worst way.

# errors made

1. String str = String.valueOf(Object); here, Object can't be type of StringBuilder, have to use sb.toString();
2. length of array and String: arr.length vs str.length();

# challenges

How to decide whether reversed a integer is overflow?

Q: if x = Integer.MIN_VALUE, Long m = x * -1; why this way failed?
This way works: long m = Long.valueOf(x) * -1;

Second way, if num > Int.MAX, then num/10 > Int.MAX/10 || (num/10 == Int.MAX/10 && x%10>8)

or, num/10 < Int.MIN/10 || (num/10 == Int.MIN/10 && x%10 < -8)



Integer.MAX_VALUE = 2147483647

Integer.MIN_VALUE = -2147483648
