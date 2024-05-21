## Problem
**5. What does the following code fragment print when n is 50? Give a high-level description of what it does when presented with a positive integer n.** 
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

Why? We will assume that there is a bijection between base-10 integers and base-2 integers. Let the binary string representation of n be b<sub>k</sub>b<sub>k-1</sub>…b<sub>1</sub>b<sub>0</sub> (which is what we are computing), where each b<sub>i</sub> is either 0 or 1. Note that the first while loop calculates the binary string in reverse, starting with b<sub>0</sub>. 

How do we calculate each digit b<sub>i</sub>? It is easier to work with the binary representation. Since n is represente by b<sub>k</sub>b<sub>k-1</sub>…b<sub>1</sub>b<sub>0</sub>, we have n = b<sub>k</sub>2<sup>k</sup> + b<sub>k-1</sub>2<sup>k-1</sup> + … + b<sub>1</sub>2<sup>1</sup> + b<sub>0</sub>2<sup>0</sup>. Then n ≡ b<sub>0</sub> (mod 2), so taking mod 2 of n gives us our first digit. Next, we calculate n/2. Note that when n is an int in Java, n/2 means ⌊n/2⌋; i.e., it rounds down. So, our new n is b<sub>k</sub>2<sup>k-1</sup> + b<sub>k-1</sub>2<sup>k-2</sup> + … + b<sub>1</sub>2<sup>0</sup>. We can then repeat the process by taking modulo 2 to get b<sub>1</sub>. Repeating this process will give the rest of the digits.
