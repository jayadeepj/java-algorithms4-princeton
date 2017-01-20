## Minimum Spanning Tree (Prim's Algorithm).

## Problem

  Given an edge-weighted graph, which is a graph where we associate weights or costs with each edge find the minimum spanning tree.  MST of an edge-weighted graph is a spanning tree whose weight (the sum of the weights of its edges) is no larger than the weight of any other spanning tree.


## Problem Description

## Solution

  Prim's algorithm. Prim's algorithm works by attaching a new edge to a single growing tree at each step: Start with any vertex as a single-vertex tree; then add V-1 edges to it, always taking next (coloring black) the minimum-weight edge that connects a vertex on the tree to a vertex not yet on the tree (a crossing edge for the cut defined by tree vertices).We use a priority queue to hold the crossing edges and find one of minimal weight. Each time that we add an edge to the tree, we also add a vertex to the tree. To maintain the set of crossing edges, we need to add to the priority queue all edges from that vertex to any non-tree vertex. Any edge connecting the vertex just added to a tree vertex that is already on the priority queue now becomes ineligible (it is no longer a crossing edge because it connects two tree vertices). The lazy implementation leaves such edges on the priority queue, deferring the ineligibility test to when we remove them.



##Dependencies
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     

## Output


EdgeWeightedGraph Created with  8  vertices &  16 Edges       
X      
String representation ==> No of Vertices >> 8 No of Edges >> 16
0: Edge [u=0, v=7, edgeWeight=0.16]  Edge [u=0, v=4, edgeWeight=0.38]  Edge [u=0, v=2, edgeWeight=0.26]  Edge [u=6, v=0, edgeWeight=0.58]      
1: Edge [u=1, v=5, edgeWeight=0.32]  Edge [u=1, v=7, edgeWeight=0.19]  Edge [u=1, v=2, edgeWeight=0.36]  Edge [u=1, v=3, edgeWeight=0.29]         
2: Edge [u=2, v=3, edgeWeight=0.17]  Edge [u=0, v=2, edgeWeight=0.26]  Edge [u=1, v=2, edgeWeight=0.36]  Edge [u=2, v=7, edgeWeight=0.34]  Edge [u=6, v=2, edgeWeight=0.4]           
3: Edge [u=2, v=3, edgeWeight=0.17]  Edge [u=1, v=3, edgeWeight=0.29]  Edge [u=3, v=6, edgeWeight=0.52]           
4: Edge [u=4, v=5, edgeWeight=0.35]  Edge [u=4, v=7, edgeWeight=0.37]  Edge [u=0, v=4, edgeWeight=0.38]  Edge [u=6, v=4, edgeWeight=0.93]          
5: Edge [u=4, v=5, edgeWeight=0.35]  Edge [u=5, v=7, edgeWeight=0.28]  Edge [u=1, v=5, edgeWeight=0.32]            
6: Edge [u=6, v=2, edgeWeight=0.4]  Edge [u=3, v=6, edgeWeight=0.52]  Edge [u=6, v=0, edgeWeight=0.58]  Edge [u=6, v=4, edgeWeight=0.93]          
7: Edge [u=4, v=7, edgeWeight=0.37]  Edge [u=5, v=7, edgeWeight=0.28]  Edge [u=0, v=7, edgeWeight=0.16]  Edge [u=1, v=7, edgeWeight=0.19]  Edge [u=2, v=7, edgeWeight=0.34]         

#
Finding the minimum spanning tree....       
The spanning tree edges are >>          
Edge [u=6, v=2, edgeWeight=0.4]      
Edge [u=4, v=5, edgeWeight=0.35]      
Edge [u=5, v=7, edgeWeight=0.28]     
Edge [u=2, v=3, edgeWeight=0.17]        
Edge [u=0, v=2, edgeWeight=0.26]
Edge [u=1, v=7, edgeWeight=0.19]      
Edge [u=0, v=7, edgeWeight=0.16]      
 
