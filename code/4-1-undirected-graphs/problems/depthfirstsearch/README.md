## Depth First Search.

## Problem
  
  Find all vertices connected in a Graph from a given vertex

## Problem Description 
  
## Solution 1 

   Depth-first search can be implemented by classic recursive method for systematically examining each of the vertices and edges in a graph. To visit a vertex first mark it as having been visited then Visit (recursively) all the vertices that are adjacent to it and that have not yet been marked. 
   
## Solution 2 

   Depth-first search can be implemented by a non-recursive method by examining each of the vertices and edges in a graph. A push-down stack can be used achieve non-recursive Depth-first search
   
   	/**     
	 * procedure DFS-iterative(G,v):
	 * let S be a stack
	 * S.push(v)
	 * while S is not empty
	 *       v = S.pop()
	 *       if v is not labeled as discovered:
	 *           label v as discovered
	 *           for all edges from v to w in G.adjacentEdges(v) do
	 *               S.push(w)  
	 *   
	 * **/   
   
    Note : In both cases to find path to a target vertex, we remember the edge v-w that takes us to each vertex w for the first time by setting edgeTo[w] to v. In other words, v-w is the last edge on the known path from s to w. The result of the search is a tree rooted at the source; edgeTo[] is a parent-link representation of that tree
	
##Dependencies 

 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     
 
## Output 