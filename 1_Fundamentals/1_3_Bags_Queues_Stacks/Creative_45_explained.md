## Problem
**45. Stack generability**. Suppose that we have a sequence of intermixed push and pop operations as with our test stack client, where the integers 0, 1, ..., N-1 in that order (push directives) are intermixed with N minus signs (pop directives). Devise an algorithm that determines whether the intermixed sequence causes the stack to underflow. (You may use only an amount of space independent of N—you cannot store the integers in a data structure.) 
Devise a linear-time algorithm that determines whether a given permutation can be generated as output by our test client (depending on where the pop operations occur).

## Solution
The first part of the problem is fairly simple: the stack underflows at any point when there number of pop operations so far exceeds the current number of push operations. Thus, we just keep a counter initialized as 0, then decrement by 1 if we encounter a pop directive and increment by 1 otherwise. 

For the second part of the problem, the given solution is
> If a given permutation can be generated, it is uniquely generated as follows: if the next integer in the permutation is in the top of the stack, pop it; otherwise, push the next integer in the input sequence onto the stack (or stop if N-1 has already been pushed). The permutation can be generated if and only if the stack is empty upon termination.
The algorithm essentially creates a sequence for the push/pop operations that creates the permutation and executes it at the same time. This can be seen by the fact that permutationInputSequence method follows almost the same steps as isValidPermutation. 

## Running Time Analysis
The worst-case running time of the first algorithm is linear in the length of the input sequence. We iterate through the whole sequence if there is no underflow, less so if the stack underflows.

Using the stack pop/push operations as the cost mmodel, the worst-case running time of the second algorithm is linear in the length of the permutation. Given a permutation of length N, we push at most N times (for the digits 0, 1, ..., N - 1) and pop at most N times (for valid permutations). In total, at most 2N stack operations are performed.
