## Order-Of-Growth

## Problem 
 Give the order of growth (as a function of N) of the running times of each of the following code fragments:

Problem 1)
int sum = 0;
for (int n = N; n > 0; n /= 2)
   for (int i = 0; i < n; i++) 
      sum++;

Problem 2)

int sum = 0;
for (int i = 1; i < N; i *= 2)
   for(int j = 0; j < i; j++)
      sum++;
	  
Problem 3)  

int sum = 0;
for (int i = 1; i < N; i *= 2)
   for (int j = 0; j < N; j++)
      sum++;

## Problem Description  

##Solution 
 The solution is in the attached pdfs