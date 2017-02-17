## Breadth First Search.

## Problem
  
  Find all vertices connected in a Graph from a given vertex

## Problem Description 
  
## Solution 

   To implement this strategy, we maintain a queue of all vertices that have been marked but whose adjacency lists have not been checked. We put the source vertex on the queue, then perform the following steps until the queue is empty:
		
		Remove the next vertex v from the queue.
		Put onto the queue all unmarked vertices that are adjacent to v and mark them.
   

	
##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     
 
## Output 

Graph Created with  13  vertices &  13 Edges
X
String representation ==> 13 vertices, 13 edges 
0: 5 1 2 6     
1: 0       
2: 0   
3: 4 5  
4: 3 6 5      
5: 0 4 3    
6: 4 0   
7: 8    
8: 7    
9: 12 10 11    
10: 9    
11: 12 9    
12: 9 11    


0#7    
Initiating Breadth First Search to find the path between ==> 0   and 7   
Shortest Distance ==>  2147483647   
Shortest Path ==>     
  
0#3   
Initiating Breadth First Search to find the path between ==> 0   and 3   
Shortest Distance ==>  2   
Shortest Path ==>  3 5 0           