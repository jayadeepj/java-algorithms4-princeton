# N queens problem.


## Problem 

 Place 8 queens on an 8-by-8 chess board so that no two queens are in the same row, column, or diagonal. 
 There are 8! = 40,320 ways in which no two queens are placed in the same row or column. 
 Any permutation p[] of the integers 0 to 7 gives such a placement: put queen i in row i, column p[i]. 
 Your program Queens.java should take an integer command-line argument n and enumerate all solutions to the n-queens problem 
 by drawing the location of the queens in ASCII like the solution below.
 
* * * * Q    
* Q * * *    
* * * Q *    
Q * * * *    
* * Q * *    

## Problem Description 

## Solution

 Any permutation p[] of the integers 0 to 7 gives such a placement: put queen i in row i, column p[i]
 
 If p[i+x] == p[i]+x or If p[i+x] == p[i]-x then it means that the 2 elements are diagonally related & hence not a valid queen position

##Dependencies 


## Output
Enter the board length/height  >>    
4   
* Q * *     
* * * Q    
Q * * *    
* * Q *    
****************   
* * Q *     
Q * * *     
* * * Q    
* Q * *     
****************  

##References