# tips

Record its sign first, keep it positive and change it into String, using StringBuffer to get a reversed String of it, at the end, according to its sign to return the expected answer, HOWEVER, it is the worst way.

# errors made

1. String str = String.valueOf(Object); here, Object can't be type of StringBuilder, have to use sb.toString();
2. length of array and String: arr.length vs str.length();

# big challenge

How to decide whether reversed integer is overflow?

Q: if x = Integer.MIN_VALUE, Long m = x * -1;

