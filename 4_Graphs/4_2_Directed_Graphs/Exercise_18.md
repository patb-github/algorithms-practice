## Exercise 18
What are the strong components of a DAG?

## Solution
A few definitions from the booksite:
- We say that two vertices *v* and *w* are **strongly connected** if they are mutually reachable: there is a directed path from *v* to *w* and a directed path from *w* to *v*.
- A **Directed Acyclic Graph** (DAG) is a directed graph without cycles.
- It can be verified that strong connectivity is an equivalence relation on the set of vertices. Hence strong connectivity partitions the vertices into equivalence classes, which we refer to as **strong components** for short.

It is easy to see that the strong components of a DAG can only have one element each: 
Suppose for the sake of contradiction that there are more than two vertices in some partition P. Let v and w be vertices in P. Then there is a directed path from v to w and a directed path from w to v. So, there is a directed cycle, which contradicts the fact that we have a DAG.

Therefore, each vertex is its own strong component.