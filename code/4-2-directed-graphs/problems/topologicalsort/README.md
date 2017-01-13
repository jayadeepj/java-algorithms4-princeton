## Topological sort.

## Problem
  
  Given a digraph, put the vertices in order such that all its directed edges point from a vertex earlier in the order to a vertex later in the order (or report that doing so is not possible)
  
  In addition check if the given Diagraph is a DAG i.e whether the Diagraph does not contain any cycles.

## Problem Description 
  
## Solution 

  A digraph has a topological order if and only if it is a DAG.
  With depth-first search, we can topologically sort a DAG in time proportional to V + E.
   
  An application of Topological Sort may be ,  a college student planning a course schedule, under the constraint that certain courses are prerequisite for certain other courses. Then in what order the courses need to be considered ?


	
##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     
 
## Output 
-- diagraphrepresentation/tinyDAG.txt

DiaGraph Created with  13  vertices &  15 Edges
X
String representation ==> 13 vertices, 15 edges 
0: 6 1 5 
1: 
2: 3 0 
3: 5 
4: 
5: 4 
6: 4 9 
7: 6 
8: 7 
9: 12 10 11 
10: 
11: 12 
12: 

#
Preorder >> 
Pre order: >>
0 6 4 9 12 10 11 1 5 2 3 7 8 
This Diagraph is a DAG.
Topologically sorted nodes: >>
8 7 2 3 0 5 1 6 9 11 10 12 4 

-- diagraphrepresentation/tinyDG.txt


DiaGraph Created with  13  vertices &  22 Edges
X
String representation ==> 13 vertices, 22 edges 
0: 1 5 
1: 
2: 3 0 
3: 2 5 
4: 2 3 
5: 4 
6: 0 8 4 9 
7: 9 6 
8: 6 
9: 10 11 
10: 12 
11: 12 4 
12: 9 

#
This Diagraph has cycles. Hence Can't be topology sorted.
Directed Cycle >> 
2
3
2

