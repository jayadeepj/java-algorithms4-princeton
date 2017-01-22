## Shortest Path (Dijkstra's algorithm).

## Problem
  
  Given an edge-weighted diagraph, find a shortest path from vertex s to vertex t is a directed path from s to t with the property that no other such path has a lower weight.
  

## Problem Description 
  
## Solution 

  Dijkstra's algorithm initializing dist[s] to 0 and all other distTo[] entries to positive infinity. Then, it repeatedly relaxes and adds to the tree a non-tree vertex with the lowest distTo[] value, continuing until all vertices are on the tree or no non-tree vertex has a finite distTo[] value.

	
##Dependencies 
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     
 
## Output 

DirectedEdgeWeightedGraph Created with  8  vertices &  15 DirectedEdges          
X      
String representation ==> No of Vertices >> 8 No of Edges >> 15            
0: DirectedEdge [from=0, to=4, edgeWeight=0.38]  DirectedEdge [from=0, to=2, edgeWeight=0.26]        
1: DirectedEdge [from=1, to=3, edgeWeight=0.29]       
2: DirectedEdge [from=2, to=7, edgeWeight=0.34]         
3: DirectedEdge [from=3, to=6, edgeWeight=0.52]        
4: DirectedEdge [from=4, to=5, edgeWeight=0.35]  DirectedEdge [from=4, to=7, edgeWeight=0.37]       
5: DirectedEdge [from=5, to=4, edgeWeight=0.35]  DirectedEdge [from=5, to=7, edgeWeight=0.28]  DirectedEdge [from=5, to=1, edgeWeight=0.32]         
6: DirectedEdge [from=6, to=2, edgeWeight=0.4]  DirectedEdge [from=6, to=0, edgeWeight=0.58]  DirectedEdge [from=6, to=4, edgeWeight=0.93]       
7: DirectedEdge [from=7, to=5, edgeWeight=0.28]  DirectedEdge [from=7, to=3, edgeWeight=0.39]      

#0#6    
Getting the shortest path from 0 >> ==>6        
The Shortest Path edges are >>    
0 => 2 => 7 => 3 => 6The Shortest Distance from 0 >> ==>6 >> 1.5100000000000002     