## Heap Sort

## Problem
  Heap Sort


## Problem Description
 Heap Sort

## Solution
 We can use any priority queue to develop a sorting method. We insert all the keys to be sorted into a minimum-oriented priority queue, then repeatedly use remove the minimum to remove them all in order. When using a heap for the priority queue, we obtain heapsort.

Focusing on the task of sorting, we abandon the notion of hiding the heap representation of the priority queue and use swim() and sink() directly. Doing so allows us to sort an array without needing any extra space, by maintaining the heap within the array to be sorted. Heapsort breaks into two phases: heap construction, where we reorganize the original array into a heap, and the sortdown, where we pull the items out of the heap in decreasing order to build the sorted result.

 The time complexity is O(NlogN). The heapification/heap construction takes NlogN & the sortdown takes 2NLogN.


## Dependencies


## Output

input array >>    
null 56 26 45 78 98 23 11 54 49 27    

heapified array >>  
null 98 78 45 54 56 23 11 26 49 27     

sorted array >>      
null 11 23 26 27 45 49 54 56 78 98    

## References

http://algs4.cs.princeton.edu/24pq/
