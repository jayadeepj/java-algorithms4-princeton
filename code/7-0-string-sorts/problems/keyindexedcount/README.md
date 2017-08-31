## Key Indexed Sort

## Problem
  
  Consider a teacher maintaining grades for a class with students assigned to sections, which are numbered 1, 2, 3, and so forth. On some occasions, it is necessary to have the class listed by section. Given a list of keyed student names, sort student list by section. However within the section, the students are kept in the same order as input       

  

## Problem Description        
  
## Solution                  

  Step 1: Compute frequency counts. The first step is to count the frequency of occurrence of each key value, using an int array frequency[]                    
  Step 2: Transform frequency to indices. Next,we use frequency[] to compute, for each key value, the starting index positions in the sorted order of items with that key. Store it in int[] sortedKeyStartIndex               
  Step 3: With the help of index table (sortedKeyStartIndex[]), perform actual sort by moving the items to an auxiliary array Item[] sortedItems                

## Complexity                

 The complexity is proportional to N + R . Exactly 8N+3R (if we consider the copying back from auxiliary array back to original array). Still better than NlogN if we were to use quick/merge sort. When R is a constant factor of N, this is linear time sort

	
## Dependencies               
    
 
## Output 

Frequency >>        
0 3 5 6 6           
Starting Index >>             
0 0 3 8 14          
Sorted Items >>              
Item [key=1, name=Harris]        
Item [key=1, name=Martin]            
Item [key=1, name=Moore]          
Item [key=2, name=Anderson]          
Item [key=2, name=Martinez]         
Item [key=2, name=Miller]         
Item [key=2, name=Robinson]         
Item [key=2, name=White]          
Item [key=3, name=Brown]        
Item [key=3, name=Davis]         
Item [key=3, name=Jackson]                     
Item [key=3, name=Jones]             
Item [key=3, name=Taylor]        
Item [key=3, name=Williams]               
Item [key=4, name=Garcia]        
Item [key=4, name=Johnson]        
Item [key=4, name=Smith]        
Item [key=4, name=Thomas]          
Item [key=4, name=Thompson]                                 
Item [key=4, name=Wilson] 

## References

 