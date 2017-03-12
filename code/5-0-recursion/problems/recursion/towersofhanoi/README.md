# Towers of Hanoi


## Problem 

In the towers of Hanoi problem, we have three poles and n discs that fit onto the poles. The discs differ in size and are initially stacked on one of the poles, in order from largest (disc n) at the bottom to smallest (disc 1) at the top. The task is to move all n discs to another pole, while obeying the following rules:

 1. Move only one disc at a time.
 2. Never place a larger disc on a smaller one.


## Problem Description 

## Solution

It is a 3 step process.

First we move the top n−1 discs to an empty pole, then we move the largest disc to the other empty pole, then complete the job by moving the n−1 discs onto the largest disc. 

Function is defined as 

T(X, Beg, Aux, End) => Move X number of pegs from peg "Beg" to peg "End" using peg "Aux" as the auxiliary.

Then the recursive process for moving N discs for Peg A to Peg C using Peg B can be summed up as 

T(N-1, A, C, B ) ==> Move N-1 disc to the auxiliary peg B
T(1, A, B, C) ==> Move one large disc  to the final peg
T(N-1 , B , A, C) ==> Move N-1 from Auxiliary peg to the final peg

##Dependencies 


## Output

Enter number of discs >> 3

A => C
A => B
C => B
A => C
B => A
B => C
A => C


##References