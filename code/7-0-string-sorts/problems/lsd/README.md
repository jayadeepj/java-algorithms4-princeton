## LSD string sort

## Problem
  
  Sort the given license plate numbers (alphanumric [0-9A-Z]) list in linear time      

  

## Problem Description        
  
## Solution                  

  Step 0: Starting from the least significant digit (W-1) to MSD (0) for each of the index , consider the key as the item.charAt(index) and perform the Step 1 to Step 3      
  Step 1: Compute frequency counts. The first step is to count the frequency of occurrence of each key value, using an int array frequency[]                    
  Step 2: Transform frequency to indices. Next,we use frequency[] to compute, for each key value, the starting index positions in the sorted order of items with that key. Store it in int[] sortedKeyStartIndex               
  Step 3: With the help of index table (sortedKeyStartIndex[]), perform actual sort by moving the items to an auxiliary array Item[] sortedItems                

## Complexity                

 The complexity is proportional to W(N + R) . Exactly 7WN􏰄 + 3WR (if we consider the copying back from auxiliary array back to original array). Still better than NlogN X W^2 if we were to use quick/merge sort. When R & W are small, this can be considered as linear sort

	
## Dependencies               
    
 
## Output     

Input Items >>      
4PGC938                
2IYE230           
3CIO720       
1ICK750      
1OHV845     
4JZY524       
1ICK750      
3CIO720       
1OHV845            
1OHV845              
2RLA629       
2RLA629      
3ATW723           
              
Final Sorted Items >>             
1ICK750       
1ICK750          
1OHV845                        
1OHV845       
1OHV845      
2IYE230               
2RLA629          
2RLA629         
3ATW723       
3CIO720       
3CIO720       
4JZY524       
4PGC938             


## References
 http://algs4.cs.princeton.edu/51radix/
 
