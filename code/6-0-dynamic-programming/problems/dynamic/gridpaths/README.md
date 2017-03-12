# Count of Grid Paths Problem


## Problem 

 Given a 2-D matrix with M rows and N columns, find the number of ways to reach the right-bottom corner cell i.e. the cell with coordinates (N-1,N-1) from starting cell (0,0) under the condition that you can only travel one step right or one step down.
 
 The additional constraint is that some of the cells could be blocked i.e. no traversal is allowed through that cell.

## Problem Description 

## Solution

 To reach a cell (i,j), one must first reach either the cell (i-1,j) or the cell (i,j-1) and then move one step down or to the right respectively to reach cell (i,j). 
 
 This can be done using plain recursion  .  
 countOfPathsToParent(i,j) = countOfPathsToParent(i-1,j) + countOfPathsToParent(i,j-1)
 However it is inefficient due to with 2^N complexity
 
 This problem indeed satisfies the optimal sub-structure and overlapping subproblems properties, hence we can formulate a bottom-up dynamic programming solution where each grid element stores the count of paths so far

##Dependencies 


## Output

The blocked cells are marked as -1.

Original Grid >>
  0  0  0  0  0  0  0  0
  0  0 -1  0  0  0 -1  0
  0  0  0  0 -1  0  0  0
 -1  0 -1  0  0 -1  0  0
  0  0 -1  0  0  0  0  0
  0  0  0 -1 -1  0 -1  0
  0 -1  0  0  0 -1  0  0
  0  0  0  0  0  0  0  0

The count of paths by Recursion>> 27

Memoized Grid >>
 27 17 12 12  7  4  1  1
 10  5 -1  5  3  3 -1  1
  5  5  2  2 -1  3  3  1
 -1  3 -1  2  1 -1  2  1
  7  3 -1  1  1  1  1  1
  4  3  3 -1 -1  0 -1  1
  1 -1  3  2  1 -1  2  1
  1  1  1  1  1  1  1  1

The count of paths by DP>> 27


##References