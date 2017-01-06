# Quick Sort

# Problem 
  Quick Sort


# Problem Description 
 

#Solution 
 Quicksort is a divide-and-conquer method for sorting. It works by partitioning an array into two parts, then sorting the parts independently.
 
 The crux of the method is the partitioning process, which rearranges the array to make the following three conditions hold:   
 The entry a[pivot] is in its final place in the array, for some pivot.   
 No entry in a[lo] through a[pivot-1] is greater than a[pivot].   
 No entry in a[pivot+1] through a[hi] is less than a[pivot].   

 The time complexity is O(NlogN) in best case i.e when the partioning splits the array evenly into 2. In worst case it is O(N^2) if each subsequent pivot splits the array to 1 & N-1 (skewed to one side). Best case memory complexity is O(1)



#Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

# Output

input array >>
10 56 26 45 78 98 23 11 54 49 27 

sorted array >>
10 11 23 26 27 45 49 54 56 78 98 
 
#References



