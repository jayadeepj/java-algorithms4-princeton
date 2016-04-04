## Simple Binary Search Tree (BST)   

## Problem 
  Implement a Simple Binary Search Tree     

if the user enters a STRING value , it should be added to the BST as a key along with the Value ( the index of addition) .           
if the user enters a "@{KEY}" , the VALUE corresponding to the KEY should be retrieved.              
if the user enters a "!" , the BST size should be returned.        
if the user enters a "*" , the entire BST should be printed.             

## Problem Description 
 A binary search tree (BST) is a binary tree where each node has a Comparable key (and an associated value) and satisfies the restriction that the key in any node is larger than the keys in all nodes in that node's left subtree and smaller than the keys in all nodes in that node's right subtree.        

## Solution 
 A BST implements the ordered symbol-table API using a binary search tree. We define a inner private class to define nodes in BST. Each node contains a key, a value, a left link, a right link, and a node count. The left link points to a BST for items with smaller keys, and the right link points to a BST for items with larger keys.               

Search. A recursive algorithm to search for a key in a BST follows immediately from the recursive structure: If the tree is empty, we have a search miss; if the search key is equal to the key at the root, we have a search hit. Otherwise, we search (recursively) in the appropriate subtree. The recursive get() method implements this algorithm directly. It takes a node (root of a subtree) as first argument and a key as second argument, starting with the root of the tree and the search key.           

Insert. Insert is not much more difficult to implement than search. Indeed, a search for a key not in the tree ends at a null link, and all that we need to do is replace that link with a new node containing the key. The recursive put() method accomplishes this task using logic similar to that we used for the recursive search: If the tree is empty, we return a new node containing the key and value; if the search key is less than the key at the root, we set the left link to the result of inserting the key into the left subtree; otherwise, we set the right link to the result of inserting the key into the right subtree.            

Note : The solution description (not the code!!!) is taken from http://algs4.cs.princeton.edu/32bst/  .                 



## Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency                 

## Output 

V            
Putting Value ==> V          
X          
Putting Value ==> X             
Q             
Putting Value ==> Q              
C                 
Putting Value ==> C                    
Y                
Putting Value ==> Y        
W            
Putting Value ==> W               
T         
Putting Value ==> T                
*         
Printing All Keys in Order from Left to Right ==>                       
 Key: >> C Value :>> 4 Size :>> 1                 
 Key: >> T Value :>> 7 Size :>> 1             
 Key: >> Q Value :>> 3 Size :>> 3                  
 Key: >> W Value :>> 6 Size :>> 1             
 Key: >> Y Value :>> 5 Size :>> 1           
 Key: >> X Value :>> 2 Size :>> 3          
 Key: >> V Value :>> 1 Size :>> 7              



## References



