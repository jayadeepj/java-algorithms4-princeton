## Breadth First Search for Diagraph.

## Problem
  
  Single-source shortest directed paths: given a digraph and source s, is there a directed path from s to v

## Problem Description 
  
## Solution 

   To implement this strategy, we maintain a queue of all vertices that have been marked but whose adjacency lists have not been checked. We put the source vertex on the queue, then perform the following steps until the queue is empty:
		
		Remove the next vertex v from the queue.
		Put onto the queue all unmarked vertices that are adjacent to v and mark them.
   

	
##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     
 
## Output 