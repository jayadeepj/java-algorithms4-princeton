# Crossword Recursion


## Problem 


## Problem Description 


## Solution

Step 1: Find All Required Empty Word Positions from the problem
Step 2: Recursively Fill the matrix, by cloning the matrix for each iteration. At each step all the remaining words are iterated.

Recursion tree              
            
P1,W1 ->             
        -> P2,W2            
                   -> P3,W3            
                             -> P4,W4            
                   -> P3,W4             
                             -> P4,W3                  
         -> P2,W3            
                   -> P3,W2            
                             -> P4,W4            
                   -> P3,W4             
                             -> P4,W2                           
         -> P2,W4                   
                   ->             
                   ->                
                     
P1,W2 -> ->             
         ->             
         ->                     
         ->            

P1,W3 -> ->             
         ->             
         ->                     
         ->            

            

##Dependencies             


## Output            

Empty CrossWord >>       
+-++++++++      
+-++-+++++      
+-------++      
+-++-++-++      
+-++-++-++      
+-++-++-++      
++++-++-++      
+--------+      
++++++++++      
----------      

CALIFORNIA LASVEGAS NIGERIA CANADA TELAVIV ALASKA       
      
Filled Crossword >>      
+C++++++++      
+A++T+++++      
+NIGERIA++      
+A++L++L++      
+D++A++A++      
+A++V++S++      
++++I++K++      
+LASVEGAS+      
++++++++++      
CALIFORNIA      



##References