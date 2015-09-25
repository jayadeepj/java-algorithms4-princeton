## Stack implementation using Linked List

## Problem 
 A Stack is a collection that is based on the last-in-first-out (LIFO) policy. A linked list is a recursive data structure that is either empty (null) or a reference to a node having a generic item and a reference to a linked list. Implement a generic stack using a Linked List. The Stack should be able to handle generic entities. Test the stack with a specific client.

 1. if the user enters a correct value , it should be pushed to the Stack. 
 2. if the user enters a "-" , the Stack should be popped.
 3. if the user enters a "!" , the Stack size should be returned.
 4. if the user enters a "*" , the Stack should pop all the values using foreach.

## Problem Description  

##Solution



##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency

## Output

7

Pushing Value ==> 7

3

Pushing Value ==> 3

8

Pushing Value ==> 8

!

Current Stack Size ==> 3

'-'

Popped Value ==> 8

'-'

Popped Value ==> 3

!

Current Stack Size ==> 1

6

Pushing Value ==> 6

*

Popping All Values ==> 

  6  7

9

Pushing Value ==> 9

'-'


Popped Value ==> 9

'-'

Exception in thread "main" java.lang.RuntimeException: No More Elements to POP

##References



