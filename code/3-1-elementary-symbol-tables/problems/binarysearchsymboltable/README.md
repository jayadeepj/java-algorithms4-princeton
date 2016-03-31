## Binary Searchable Symbol Table using Ordered Parallel Arrays

## Problem 
 Implement a symbol table with Ordered Parallel Arrays containing keys and values. The order of growth of search in the table with N keys uses no more than lg N + 1 compares  (successful or unsuccessful) in the worst case.

if the user enters a STRING value , it should be added to the symbol table with the index number of addition.    
if the user enters a "-{KEY}" , the VALUE corresponding to the KEY should be retrieved.    
if the user enters a "!" , the Symbol Table size should be returned.     
if the user enters a "*" ,  return all the values of Symbol Table using foreach iterator.    

## Problem Description 
 A symbol table A symbol table is a data structure that associates a value with a key. It supports two primary operations: insert (put) a new pair into the table and search for (get) the value associated with a given key. Implement a symbol table with Ordered Parallel Arrays containing keys and values.      

##Solution : The underlying data structure is two parallel array, with the keys kept in order. The heart of the implementation is the rank() method, which returns the number of keys smaller than a given key. For get(), the rank tells us precisely where the key is to be found if it is in the table (and, if it is not there, that it is not in the table). For put(), the rank tells us precisely where to update the value when the key is in the table, and precisely where to put the key when the key is not in the table. We move all larger keys over one position to make room (working from back to front) and insert the given key and value into the proper positions in their respective arrays.     

Note : The solution description is taken from http://algs4.cs.princeton.edu/31elementary/       



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency    

## Output    

F        
Putting Value ==> F      
D      
Putting Value ==> D     
A    
Putting Value ==> A     
H    
Putting Value ==> H    
E     
Putting Value ==> E     
S      
Putting Value ==> S     
*    
Displaying All Keys & Values ==>       
 Key >> A Value >> 2     
 Key >> D Value >> 1     
 Key >> E Value >> 4    
 Key >> F Value >> 0    
 Key >> H Value >> 3       
 Key >> S Value >> 5    
U        
Putting Value ==> U          
D        
Putting Value ==> D         
A      
Putting Value ==> A          
*           
Displaying All Keys & Values ==>             
 Key >> A Value >> 2                 
 Key >> D Value >> 8           
 Key >> E Value >> 7        
 Key >> F Value >> 0           
 Key >> H Value >> 3       
 Key >> S Value >> 5        
 Key >> U Value >> 6             


##References



