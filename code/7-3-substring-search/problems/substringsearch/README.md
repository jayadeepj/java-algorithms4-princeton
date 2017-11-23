# Substring Search


## Problem 

 Given a text string of length N and a pattern string of length M, find if there is an occurrence of the pattern within the text.

## Problem Description 

## Solution

For text of length n and p patterns of combined length m

1. Brute Force => O(mn)
2. Robin-Karp => Average and best case running time is O(n+m) in space O(p), but its worst-case time is O(nm) when all the hashes collide.
3. KMP => Best & worst running time is O(n+m)

##Dependencies 


## Output

1
5
10 1 10 1 10
The max sum by DP 36


##References