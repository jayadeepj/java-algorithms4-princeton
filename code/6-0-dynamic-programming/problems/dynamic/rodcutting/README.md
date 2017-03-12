# Rod Cutting Problem


## Problem 

Given a rod of length n inches and a table of prices pi for i = 1,2, …. n, determine the maximum revenue Rn obtain- able by cutting up the rod and selling the pieces.
Note that if the price Pn for a rod of length n is large enough, an optimal solution may require no cutting at all. 

## Problem Description 

Refer rod_cutting_dp.pdf

## Solution

we can frame the values rn for n 􏰃 1 in terms of optimal revenues from shorter rods:
Rn = Max(Pn , R1+R(n-1) , R2+ R(n-2) , ......)

The first argument, Pn, corresponds to making no cuts at all and selling the rod of length n as is. The other n 􏰐- 1 arguments to max correspond to the maximum revenue obtained by making an initial 
cut of the rod into two pieces of size i and n 􏰐 i , for i = 1,2, …. n - 1, and then optimally cutting up those pieces further, obtaining revenues Ri and Rn-i 
from those two pieces. Since we don’t know ahead of time which value of i optimizes revenue, we have to consider all possible values for i and pick the one that maximizes revenue. 
We also have the option of picking no i at all if we can obtain more revenue by selling the rod uncut.

##Dependencies 


## Output



##References