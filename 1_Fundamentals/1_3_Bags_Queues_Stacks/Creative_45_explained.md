## Problem
**45. Stack generability**. Suppose that we have a sequence of intermixed push and pop operations as with our test stack client, where the integers 0, 1, ..., N-1 in that order (push directives) are intermixed with N minus signs (pop directives). Devise an algorithm that determines whether the intermixed sequence causes the stack to underflow. (You may use only an amount of space independent of N—you cannot store the integers in a data structure.) 
Devise a linear-time algorithm that determines whether a given permutation can be generated as output by our test client (depending on where the pop operations occur).

## Solution
The first part of the problem is fairly simple: the stack underflows at any point when there number of pop operations so far exceeds the current number of push operations. Thus, we just keep a counter initialized as 0, then decrement by 1 if we encounter a pop directive and increment by 1 otherwise. 

For the second part of the problem, the given solution is
> If a given permutation can be generated, it is uniquely generated as follows: if the next integer in the permutation is in the top of the stack, pop it; otherwise, push the next integer in the input sequence onto the stack (or stop if N-1 has already been pushed). The permutation can be generated if and only if the stack is empty upon termination.

The algorithm essentially creates a sequence for the push/pop operations that creates the permutation and executes it at the same time, as demonstrated by the permutationInputSequence method. The generated output depends on the order of the numbers on the stack, so we have to wait until the next integer in the permutation is in the top of the stack to pop it. 

Take for instance the permutation 1 2 4 3 0. We want to intersperse minuses (pop-directives) between 0 1 2 3 4 so that it generates the permutation. Since 1 is the first number in the permutation, we have to wait for 0 and 1 to be pushed, in that order. 

We repeat this until N - 1 is pushed because the permutation only consists of integers from 0 to N - 1. After that, we only allow pops, so at this point the tail of the output is already determined. If the tail of the permutation corresponds to stack, it can be generated; if not, our program terminates, and the stack will be non-empty. In our example, our stack would be (bottom)0 3 4(top) once 4 is pushed. Now, the only possible tail of the output that we can generate from popping the stack is 4 3 0, so our permutation is valid. Had our permutation been 1 2 4 0 3, our program would terminate when the permutation pointer points to 0.  

To prove the statement "The permutation can be generated if and only if the stack is empty upon termination" we consider the last part of our program: Once N - 1 has been pushed, the tail of the possible permutation has already been determined. If the permutation can be generated, all of the remaining integers on the stack will be popped. If the permutation cannot be generated, then the integers in the stack cannot all be popped, so the stack is non-empty upon termination.

## Running Time Analysis
The worst-case running time of the first algorithm is linear in the length of the input sequence. We iterate through the whole sequence if there is no underflow, less so if the stack underflows.

Using the stack pop/push operations as the cost mmodel, the worst-case running time of the second algorithm is linear in the length of the permutation. Given a permutation of length N, we push N times (for the digits 0, 1, ..., N - 1) and pop at most N times (for valid permutations). In total, at most 2N stack operations are performed.
