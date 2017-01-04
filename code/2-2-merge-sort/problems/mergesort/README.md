# Merge Sort

# Problem 
  Merge Sort


# Problem Description 
 

#Solution 
 MergeSort is based on a simple operation known as merging: combining two ordered arrays to make one larger ordered array. This operation immediately lends itself to a simple recursive sort method known as mergesort: to sort an array, divide it into two halves, sort the two halves (recursively), and then merge the results.
 The time complexity is O(NlogN). Best case memory complexity is O(1)

##Complexity Calculation   
 T(N) = 2T(N/2) + N  
 T(N/2) = 2T(N/4) + N/2
 T(N) = 2 * (2T(N/4) + N/2 )+ N
 T(N) = 4T(N/4) + 2N

 When N=32, the equation becomes 
 32T(N/32)+5N  ( 5 is log 32 to the base 2)

 T(32) = N T(32/32) + 32Log32
 
 Generalising   
 
 T(N) = N * T(1) + NLogN 
 T(N) = NLogN

#Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

# Output

input array >>
10 56 26 45 78 98 23 11 54 49 27 

sorted array >>
10 11 23 26 27 45 49 54 56 78 98 
 
#References



