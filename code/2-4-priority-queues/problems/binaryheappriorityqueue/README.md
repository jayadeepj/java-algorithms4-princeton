## Max Priority Queue by Binary Heap

## Problem 
 Priority queue is an abstract data type which is like a regular queue or stack data structure, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. If two elements have the same priority, they are served according to their order in the queue.Implement a Priority Queue data structure by using a Binary Heap data structure


## Problem Description 

 1. if the user enters a correct value , it should be enqueued to the Priority Queue. 
 2. if the user enters a "@" , the maximum value should be dequeued.
 3. if the user enters a "!" , the Priority Queue size should be returned.
 4. if the user enters a "*" , the Priority Queue should dequeue & return all the values using foreach.

##Solution

 A binary heap is a heap data structure created using a binary tree. It can be seen as a binary tree with two additional constraints

 Shape property: A binary heap is a complete binary tree; that is, all levels of the tree, except possibly the last one (deepest) are fully filled, and, if the last level of the tree is not complete, the nodes of that level are filled from left to right.

 Heap property: All nodes are either greater than or equal to or less than or equal to each of its children, according to a comparison predicate defined for the heap.

 The largest key in a heap-ordered binary tree is found at the root.A binary heap is a set of nodes with keys arranged in a complete heap-ordered binary tree, represented in level order in an array (not using the first entry).In a heap, the parent of the node in position k is in position k/2; and, conversely, the two children of the node in position k are in positions 2k and 2k + 1. We can travel up and down by doing simple arithmetic on array indices: to move up the tree from a[k] we set k to k/2; to move down the tree we set k to 2*k or 2*k+1.


##Dependencies 
 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency
 

## Output

F
Enqueing Value ==> F
Heap Status >> F 

W
Enqueing Value ==> W
Heap Status >> W F 

Y
Enqueing Value ==> Y
Heap Status >> Y F W 

I
Enqueing Value ==> I
Heap Status >> Y I W F 

K
Enqueing Value ==> K
Heap Status >> Y K W F I 

G
Enqueing Value ==> G
Heap Status >> Y K W F I G 

S
Enqueing Value ==> S
Heap Status >> Y K W F I G S 

C
Enqueing Value ==> C
Heap Status >> Y K W F I G S C 

V
Enqueing Value ==> V
Heap Status >> Y V W K I G S C F 

X
Enqueing Value ==> X
Heap Status >> Y X W K V G S C F I 

B
Enqueing Value ==> B
Heap Status >> Y X W K V G S C F I B 

M
Enqueing Value ==> M
Heap Status >> Y X W K V M S C F I B G 

@
Dequeued Value ==> Y
Heap Status >> X V W K I M S C F G B 

@
Dequeued Value ==> X
Heap Status >> W V S K I M B C F G 

@
Dequeued Value ==> W
Heap Status >> V K S G I M B C F 

!
Current Queue Size ==> 9
Heap Status >> V K S G I M B C F 

z
Enqueing Value ==> z
Heap Status >> z V S G K M B C F I 

@
Dequeued Value ==> z
Heap Status >> V K S G I M B C F 

@
Dequeued Value ==> V
Heap Status >> S K M G I F B C 

*

Dequeing All Values ==> S  M  K  I  G  F  C  B 
 
##References

All images & descriptions are taken from http://algs4.cs.princeton.edu/24pq/

