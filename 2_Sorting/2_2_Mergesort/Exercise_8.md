## Exercise 8
Suppose that top-down mergesort is modified to skip the call on merge() whenever a[mid] ≤ a[mid+1]. Prove that the number of compares used for an array in sorted order is linear.

## Solution
Top-down mergesort refers to the recursive implementation of mergesort. For a sorted array, merge() is never called. 

Let C(N) be the number of compares for an array of size N, with C(1) = 0.

**Proposition**. C(N) = N − 1 for all positive integers N.

Proof. We can show this by strong induction. The base case C(1) = 0 is true. Now suppose that C(n) = n − 1 for all n = 1, 2, ..., N − 1, where N ≥ 2. 

For N ≥ 2, the number of compares satisfies C(N) = C(⌊N/2⌋) + C(N − ⌊N/2⌋) + 1. By the inductive hypothesis, we then have C(N) = (⌊N/2⌋ − 1) + (N − ⌊N/2⌋ − 1) + 1 = N − 1, which closes the induction.

Therefore, the number of compares is linear.

Note: in the inductive step, we assumed that 1 ≤ ⌊N/2⌋ ≤ N − 1 and 1 ≤ N − ⌊N/2⌋ ≤ N − 1.  