## Exercise 4
Does the abstract inplace merge produce proper output if and only if the two input subarrays are in sorted order? Prove your answer, or provide a counterexample.

## Solution
*True*. Let A and B be the input subarrays. 

If A and B are sorted, then the merge produces a sorted array because in each iteration we take the lesser of A[i] and B[j].

Now suppose it is not true that both of the input subarrays are sorted; say A is unsorted. Since we iterate through the subarrays from left to right, the relative order of the elements of A remains unchanged in the merged array. To be more precise, since A is unordered, there exist indices 0 ≤ i < j < A.length such that A[i] > A[j]. If the merged subarray is X, then X[p] = A[i] and X[q] = A[j] for 0 ≤ p < q < X.length, so X is unordered.