## 
Quick Union - Union Find

## Problem 
  Write a  class represents a union-find data structure using the QUICK UNION method. It should support union & find operations, along with methods for determining whether two objects are in the same component and the total number of components.

	Implement a Union Find API encapsulates the basic operations below

 public boolean connected(int p, int q) ## check if there is a connection between p & q 
 public void union(int p, int q)  ## add a connection between p & q if a connection already do not exist




## Problem Description 

Dynamic connectivity problem:  The input is a sequence of pairs of integers, where each integer represents an object of some type and we are to interpret the pair (p , q) as meaning "p is connected to q." An equivalence relation partitions the objects into equivalence classes. In this case, two objects are in the same equivalence class if and only if they are connected. Our goal is to write a program to filter out extraneous pairs (pairs where both objects are in the same equivalence class) from the sequence. In other words, when the program reads a pair p q from the input, it should write the pair to the output only if the pairs it has
seen to that point do not imply that p is connected to q. If the previous pairs do imply that p is connected to q, then the program should ignore the pair p q and proceed to read in the next pair. To achieve the desired goal, we need to devise a data structure that can remember sufficient information about the pairs it has seen to be able to decide whether or not a new pair of objects is connected. Informally, we refer to the task of designing such a method as the dynamic connectivity problem.

##Solution 

QUICK UNION method. This method is based on the same data structure—the site-indexed index[] array—but it uses a different interpretation of the values that leads to more complicated structures. Specifically, the index[] entry for each site will be the name of another site in the same component (possibly itself). To implement find() we start at the given site, follow its link to another site, follow that sites link to yet another site, and so forth, following links until reaching a root, a site that has a link to itself. Two sites are in the same component if and only if this process leads them to the same root. 

Refer the image (taken from alg4 book-site & my written explanation)

connected(p,q) : return true if root(p) ==root(q)
union(p,q): set root(p) to replace root(q) .

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

******************************************************
           Final Array Values with index                
******************************************************
0 1 2 3 4 5 6 7 8 9 
6 2 7 4 9 6 9 6 4 9 
******************************************************


##References

You may find a better implementation @ http://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html 
http://algs4.cs.princeton.edu/15uf/



