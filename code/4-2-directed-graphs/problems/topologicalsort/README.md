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