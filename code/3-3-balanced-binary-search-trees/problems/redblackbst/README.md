## Left Leaning Red Black Binary Search Tree

## Problem 
  Implement a Left Leaning Red Black Binary Search Tree

if the user enters a STRING value , it should be added to the BST as a key along with the Value ( the index of addition) .            
if the user enters a "@{KEY}" , the VALUE corresponding to the KEY should be retrieved.          
if the user enters a "!" , the BST size should be returned.         
if the user enters a "*" , the entire BST should be printed.        
  
## Problem Description 
 A binary search tree (BST) is a binary tree where each node has a Comparable key (and an associated value) and satisfies the restriction that the key in any node is larger than the keys in all nodes in that node's left subtree and smaller than the keys in all nodes in that node's right subtree.     

A 2-3 search tree is a tree that either is empty or:      
A 2node, with one key (and associated value) and two links, a left link to a 2-3 search tree with smaller keys, and a right link to a 2-3          
search tree with larger keys      
A 3node, with two keys (and associated values) and three links, a left link to a 2-3 search tree with smaller keys, a middle link to a 2-3 search tree with keys between the node's keys and a right link to a 2-3 search tree with larger keys.         

##Solution :
 A red black BST is a representation of the 2-3 search tree. A The basic idea behind red-black  BSTs is to encode 2-3 trees by starting with standard BSTs (which are made up of 2nodes) and adding extra information to encode 3nodes. We think of the links as being of two different types: red links, which bind together two 2nodes to represent 3nodes, and black links, which bind together the 2-3 tree. Specifically, we represent 3nodes as two 2nodes connected by a single red link that leans left. We refer to BSTs that represent 2-3 trees in this way as redblack BSTs  

To put a node    

	/**     
	 * If left child is black & right child is red --> rotate left      
	 * If left child is red and left grand-child is also red --> rotate right     
	 * If both children are red --> flip colors    
	 *   
	 * **/            
	 
Note : The solution description (not the code!!!) is taken from http://algs4.cs.princeton.edu/33balanced/           



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     

## Output           

S        
Putting Value ==> S          
E           
Putting Value ==> E                                             
A                   
Putting Value ==> A                         
R                     
Putting Value ==> R                
C                   
Putting Value ==> C                       
H                         
Putting Value ==> H               
X                      
Putting Value ==> X               
M                   
Putting Value ==> M                 
P                
Putting Value ==> P                    
L                    
Putting Value ==> L               
*         
C  
E                                          
H 
L               
M    
P  
R      
S    
X      
@M    
Getting the Value for Key ==> M ==> 8               
@X        
Getting the Value for Key ==> X ==> 7       
!        
Current Symbol Table Size ==> 10         





##References 



