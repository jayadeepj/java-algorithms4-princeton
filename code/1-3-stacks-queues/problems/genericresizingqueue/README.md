# Generic Resizing Queue

##
## Problem 

 Implement a generic queue using a resizing array. With a resizing array, dynamically adjust the size of the array so that it is both sufficiently large to hold all of the items and not so large as to waste an excessive amount of space. Double the size of the array in enqueue() if it is full; Also halve the size of the array in dequeue() if it is less than one-quarter full. The Queue should be able to handle generic entities. Test the queue with a specific client.

 1. if the user enters a correct value , it should be EnQueued. 
 2. if the user enters a "-" , the Queue should be DeQueued.
 3. if the user enters a "!" , the Queue size should be returned.

## Problem Description -

## Solution

##Dependencies 

 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

8

Enqueing Value ==> 8

3

Enqueing Value ==> 3

6

Enqueing Value ==> 6

!

Current Queue Size ==> 3

-

DeQueued Value ==> 8

-

DeQueued Value ==> 3

!

Current Queue Size ==> 1

-

DeQueued Value ==> 6

-

Exception in thread "main" java.lang.RuntimeException: Currently No Elements in GenericResizingQueue to POP 


##References