## Bitonic Search

## Problem 
 An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of N distinct int values, determines whether a given integer is in the array. Your program should use ~ 3 lg N compares in the worst case.

## Problem Description  

##Solution 
 The solution is implemented in 2 parts. First we find the maximum (in ~ 1 lg N compares) similar to binary search. Then the array is split into 2 parts. In each part, binary search is done (in ~ 2 lg N compares). Hence total ~ 3 lg N compares


##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

Input Array ....... 23 35 46 78 98 101 56 24 12 6 3 1
Biotonic Max is at Index 5
78
Biotonic Search Result : Index of Key >> 78 is at >> 3
24
Biotonic Search Result : Index of Key >> 24 is at >> 7
35
Biotonic Search Result : Index of Key >> 35 is at >> 1
56
Biotonic Search Result : Index of Key >> 56 is at >> 6

##References



