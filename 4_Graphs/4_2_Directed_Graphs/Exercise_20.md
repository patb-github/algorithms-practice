## Exercise 20
True or false: The reverse postorder of a digraph's reverse is the same as the postorder of the digraph.

## Solution
Definitions for **depth-first orders**: Depth-first search search visits each vertex exactly once. Three vertex orderings are of interest in typical applications:
- **Preorder**: Put the vertex on a queue before the recursive calls.
- **Postorder**: Put the vertex on a queue after the recursive calls.
- **Reverse postorder**: Put the vertex on a stack after the recursive calls.

Consider the simple cyclic digraph with two vertices and one edge: 0 → 1 and 1 → 0.

Part 1: The reverse of the digraph is the same digraph. dfs(1) is called by dfs(0), so we push 1 and 0 on the stack in that order. Therefore, the reverse postorder is 0 1.

Part 2: Since dfs(1) is called by dfs(0), the postorder of the digraph is 1 0. 

So, the answer is *false*, as shown by this counterexample.