## Quick Find - Union Find

## Problem 
   Write a  class represents a union-find data structure using the QUICK FIND method. It should support union & find operations, along with methods for determining whether two objects are in the same component and the total number of components.

  Implement a Union Find API encapsulates the basic operations below

 public boolean connected(int p, int q) ## check if there is a connection between p & q 
 public void union(int p, int q)  ## add a connection between p & q if a connection already do not exist


## Problem Description  

Dynamic connectivity problem:  The input is a sequence of pairs of integers, where each integer represents an object of some type and we are to interpret the pair (p , q) as meaning "p is connected to q." An equivalence relation partitions the objects into equivalence classes. In this case, two objects are in the same equivalence class if and only if they are connected. Our goal is to write a program to filter out extraneous pairs (pairs where both objects are in the same equivalence class) from the sequence. In other words, when the program reads a pair p q from the input, it should write the pair to the output only if the pairs it has
seen to that point do not imply that p is connected to q. If the previous pairs do imply that p is connected to q, then the program should ignore the pair p q and proceed to read in the next pair. To achieve the desired goal, we need to devise a data structure that can remember sufficient information about the pairs it has seen to be able to decide whether or not a new pair of objects is connected. Informally, we refer to the task of designing such a method as the dynamic connectivity problem.

##Solution 

QUICK FIND method : This structure is built by ensuring that p and q are connected if and only if index[p] is equal to index[q]. In other words, all sites in a component must have the same value in index[].

Refer the image (taken from alg4 book-site & my written explanation)

FIND : Check if p & q have the same root
UNION : Set root(index[p]) to the root(index[q])


##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

 Is (4 & 3) connected ? false
 Connecting (4 & 3) 

 Is (3 & 8) connected ? false
 Connecting (3 & 8) 

 Is (6 & 5) connected ? false
 Connecting (6 & 5) 

 Is (9 & 4) connected ? false
 Connecting (9 & 4) 

 Is (2 & 1) connected ? false
 Connecting (2 & 1) 

 Is (8 & 9) connected ? true
 Is (5 & 0) connected ? false
 Connecting (5 & 0) 

 Is (7 & 2) connected ? false
 Connecting (7 & 2) 

 Is (6 & 1) connected ? false
 Connecting (6 & 1) 

 Is (1 & 0) connected ? true
 Is (6 & 7) connected ? true
 Is (9 & 3) connected ? true
 Is (7 & 0) connected ? true
 Is (8 & 7) connected ? false
 Connecting (8 & 7) 

 Is (1 & 9) connected ? true
 Is (1 & 4) connected ? true
 Is (3 & 0) connected ? true


##References

You may find a better implementation @ http://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html 
http://algs4.cs.princeton.edu/15uf/



