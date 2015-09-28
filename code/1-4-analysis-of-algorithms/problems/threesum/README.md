## Efficient Three-sum 

## Problem 
 Read in N integers and count the number of triples that sum to exactly 0. Though this can be easily implemented in cubic running time (N^3), write the code such that it takes <= N^2logN running time



## Problem Description 

##Solution 
 The solution is implemented using a combination of Merge Sort & Binary Search. The IF loop is executed N^2 times and the binary search run time is log N. Hence the total run time is N^2*log N



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

Input Array ....... 23 -43 65 98 -12 39 56 76 -11 67 92 11 -21 -86 34 -18 -16

Found a Tripple >> 23 , -12 , -11

Found a Tripple >> 98 , -12 , -86

Found a Tripple >> 39 , -21 , -18

Found a Tripple >> 34 , -18 , -16

Total Tripples in the Array By Brute Force (N^3) is >> 4



Input Array ....... 23 -43 65 98 -12 39 56 76 -11 67 92 11 -21 -86 34 -18 -16

Found a Tripple >> -86 , -12 , 98

Found a Tripple >> -21 , -18 , 39

Found a Tripple >> -18 , -16 , 34

Found a Tripple >> -12 , -11 , 23

Total Tripples in the Array By Merge Sort & Binary Search (N^2logN) is >> 4



##References



