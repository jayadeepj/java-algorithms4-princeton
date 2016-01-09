## Closest 2D points in Cartesian plane (Divide & Conquer Algorithm)

## Problem 
 Find the distance between the closest 2D points in a set of N 2D points. Write a Point2D.java client that takes an integer value N from the command line, generates N random points in the unit square, and computes the distance separating the closest pair of points


## Problem Description 
 The closest pair of points problem or closest pair problem is a problem of computational geometry: given n points in metric space, find a pair of points with the smallest distance between them. The closest pair problem for points in the Euclidean plane was among the first geometric problems which were treated at the origins of the systematic study of the computational complexity of geometric algorithms.

##Solution

The solution is implemented using 2 approaches    

1. Divide & Conquer Algorithm O(N log N)    
2. Brute Force  O(N^2)    

Steps for the Divide & Conquer Algorithm   

Divide & Conquer approach O(N log N)   

Step 1: Sort the Array by X coordinate   
Step 2: Find the median index of x to divide the set by half   
Step 3: Divide the set into 2 sets P & Q in Cartesian plane   
        i.e. points to the left of median and points to the right of median    
Step 4: delta = Min {ClosestPair(P),ClosestPair(Q)}    
Step 5: find pDeltaPointArray subset of P between  xmid-delta & xmid sorted by Y coordinate   
Step 6: find qDeltaPointArray subset of P between  xmid & xmid+delta  sorted by Y coordinate   
Step 7: for every point in pDeltaPointArray, find the closest point by Y coordinate in qDeltaPointArray   
Step 8: Extending Step 7 find the nearest possible 16 (can be 8 as well) by by Y coordinate in qDeltaPointArray   
Step 9: Take new delta = Min{ClosestPair(P),ClosestPair(Q),distance from  each point in pDeltaPointArray to each of the the nearest possible 16 in qDeltaPointArray}   
Step 10: return the new delta   

##Dependencies 
 The Point2D.java @ http://algs4.cs.princeton.edu/12oop/Point2D.java is used as dependency

## Output   

Generated points == > (100.0, 148.0)(23.0, 194.0)(15.0, 6.0)(16.0, 123.0)(9.0, 49.0)(38.0, 114.0)(159.0, 126.0)(97.0, 178.0)(1.0, 45.0)(78.0, 182.0)(188.0, 72.0)(5.0, 102.0)(148.0, 119.0)(20.0, 48.0)(102.0, 64.0)(60.0, 80.0)(163.0, 33.0)(89.0, 22.0)(104.0, 52.0)(24.0, 27.0)(146.0, 53.0)(185.0, 63.0)(176.0, 163.0)(27.0, 105.0)(9.0, 137.0)(118.0, 44.0)(12.0, 143.0)(28.0, 35.0)(38.0, 146.0)(9.0, 121.0)(197.0, 124.0)(162.0, 23.0)(131.0, 73.0)(50.0, 195.0)(183.0, 48.0)(142.0, 129.0)(142.0, 75.0)(170.0, 49.0)(63.0, 91.0)(157.0, 124.0)(123.0, 50.0)(136.0, 100.0)(163.0, 150.0)(180.0, 176.0)(140.0, 183.0)(48.0, 16.0)(93.0, 166.0)(50.0, 115.0)(177.0, 97.0)(109.0, 11.0)
********************************************************************************************************

Closest Pair distance By Brute Force == > 2.8284271247461903 between ==>(159.0, 126.0)(157.0, 124.0)
********************************************************************************************************

Closest Pair distance  By Divide & Conquer== > 2.8284271247461903 between ==>(157.0, 124.0)(159.0, 126.0)
********************************************************************************************************




##References
https://en.wikipedia.org/wiki/Closest_pair_of_points_problem

This video is simply magnificent!!
https://www.youtube.com/watch?v=xi-WF07rAQw


