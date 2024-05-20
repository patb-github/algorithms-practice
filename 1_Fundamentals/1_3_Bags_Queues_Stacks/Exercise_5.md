## Problem
**5. What does the following code fragment print when n is 50? Give a high-level description of what it does when presented with a positive integer n. **. 
```java
Stack<Integer> s = new Stack<Integer>();
while (n > 0) {
   s.push(n % 2);
   n = n / 2;
}
while (!s.isEmpty())
    System.out.print(s.pop());
System.out.println();
```

## Solution

The given solution is
> Prints the binary representation of N (110010 when n is 50).

Why? 

