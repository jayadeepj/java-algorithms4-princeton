## Symbol Table using Unordered Linked List

## Problem 
  Implement a symbol table with a unordered linked list of nodes that contain keys and values. 

if the user enters a STRING value , it should be added to the symbol table with the index number of addition. 
if the user enters a "-{KEY}" , the VALUE corresponding to the KEY should be retrieved.
if the user enters a "!" , the Symbol Table size should be returned.
if the user enters a "*" ,  return all the values of Symbol Table using foreach iterator.

## Problem Description 
 A symbol table A symbol table is a data structure that associates a value with a key. It supports two primary operations: insert (put) a new pair into the table and search for (get) the value associated with a given key. Implement a symbol table with a unordered linked list of nodes that contain keys and values. 

##Solution 
 We use Sequential Search . To implement get(), we scan through the list, using equals() to compare the search key with the key in each node in the list. If we find the match, we return the associated value; if not, we return null. To implement put(), we also scan through the list, using equals() to compare the client key with the key in each node in the list. If we find the match, we update the value associated with that key to be the value given in the second argument; if not, we create a new node with the given key and value and insert it at the beginning of the list. This method is known as sequential search.



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

A   
Putting Value ==> A   
B   
Putting Value ==> B   
C   
Putting Value ==> C   
D   
Putting Value ==> D   
-C   
Getting the Value for Key ==> C ==> 2   
-A   
Getting the Value for Key ==> A ==> 0   
!   
Current Symbol Table Size ==> 4   
*   
Displaying All Values ==>    
  D  C  B  A   
   
-P    
Getting the Value for Key ==> P ==> null   
   

## References



