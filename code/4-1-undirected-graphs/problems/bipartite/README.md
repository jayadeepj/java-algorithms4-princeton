## Two Color-ability in Undirected Graph

## Problem

  Can the vertices of a given graph be assigned one of two colors in such a way that no edge connects vertices of the same color?. Use adjacency-lists representation to represent a graph

## Problem Description

## Solution
   Uses depth-first search to determine whether a graph has a bipartition; if so, return one; if not, return an odd-length cycle. It takes time proportional to V + E in the worst case.

##Dependencies
 The stdlib.jar @ http://introcs.cs.princeton.edu/java/stdlib/ is used as dependency     

## Output

Graph Created with  13  vertices &  13 Edges
#
Checking if the graph is Bipartite ....
The graph is not Bipartite. The odd length cycle is : >>
9 11 12 9


Graph Created with  13  vertices &  13 Edges
#
Checking if the graph is Bipartite ....
The graph is Bipartite. The color set is : >>
0 -> RED
1 -> BLUE
2 -> BLUE
3 -> RED
4 -> RED
5 -> BLUE
6 -> BLUE
7 -> RED
8 -> BLUE
9 -> RED
10 -> BLUE
11 -> BLUE
12 -> BLUE 
