# Generic Resizing Stack

## Problem 
 Implements a generic stack using a resizing array. With a resizing array, dynamically adjust the size of the array so that it is both sufficiently large to hold all of the items and not so large as to waste an excessive amount of space. Double the size of the array in push() if it is full; Also halve the size of the array in pop() if it is less than one-quarter full. The Stack should be able to handle generic entities. Test the stack with a specific client.

 1. if the user enters a correct value , it should be pushed to the Stack. 
 2. if the user enters a "-" , the Stack should be popped.
 3. if the user enters a "!" , the Stack size should be returned.

## Problem Description  

## Solution



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

2

Pushing Value ==> 2

7

Pushing Value ==> 7

!

Current Stack Size ==> 2

'-'

Popped Value ==> 7

!

Current Stack Size ==> 1

8

Pushing Value ==> 8

'-'

Popped Value ==> 8

'-'

Popped Value ==> 2


##References



