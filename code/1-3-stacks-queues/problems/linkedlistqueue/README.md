## Queue implementation using Linked List

## Problem 
 A Queue is a collection that is based on the last-in-first-out (FIFO) policy. A linked list is a recursive data structure that is either empty (null) or a reference to a node having a generic item and a reference to a linked list. Implement a generic queue using a Linked List. The Queue should be able to handle generic entities. Test the queue with a specific client.

 1. if the user enters a correct value , it should be enqueued to the Queue. 
 2. if the user enters a "-" , the value should be dequeued.
 3. if the user enters a "!" , the Queue size should be returned.
 4. if the user enters a "*" , the Queue should dequeue & return all the values using foreach.

## Problem Description 

##Solution


##Dependencies 

 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

8

Enqueing Value ==> 8

9

Enqueing Value ==> 9

'-'

Dequeued Value ==> 8

'-'

Dequeued Value ==> 9

3

Enqueing Value ==> 3

4

Enqueing Value ==> 4

6

Enqueing Value ==> 6

!

Current Queue Size ==> 3

7

Enqueing Value ==> 7

*

Dequeing All Values ==> 3  4  6  7 

##References



