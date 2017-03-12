package dynamic.gridpaths;

public class GridPathsCount {

	public static void main(String[] args) {
		/**Initialize grid**/
		int N = 8;
		int[][] grid = new int[N][N];
		
		/**Blocked cells**/
		grid[1][2] = -1;
		grid[1][6] = -1;
		
		grid[2][4] = -1;
		grid[3][0] = -1;
		grid[3][2] = -1;
		grid[3][5] = -1;
		
		grid[4][2] = -1;
		grid[5][3] = -1;
		grid[5][4] = -1;
		grid[5][6] = -1;
		grid[6][1] = -1;
		grid[6][5] = -1;

		print2DArray(grid, N, N, "Original Grid");
		
		System.out.println("The count of paths by Recursion>> "+countOfPathsToParent(grid,N-1, N-1));
		countPaths(grid, N);
		System.out.println("The count of paths by DP>> "+grid[0][0]);

		

	}
	
	/**
	 * This method does a brute force recursion without any memoization
	 * The complexity is minimum 2 ^N 
	 * @param grid
	 * @param i
	 * @param j
	 * @return
	 */
	private static int countOfPathsToParent(int[][] grid, int i, int j){
		if(i<0 || j<0)
			return 0;
		
		if(grid[i][j]==-1)
			return 0;
		
		if(i==0 && j==0)
			return 1;
		
		return countOfPathsToParent(grid,i-1, j) + countOfPathsToParent(grid,i, j-1);
	}
	
	private static void countPaths(int[][] grid, int N)
	{
		parentOf(grid, N-1, N-1);
		print2DArray(grid, N, N, "Memoized Grid");
	}
	
	/**]]Solution using Dynamic Programming. 
	 * @param grid
	 * @param i
	 * @param j
	 */
	private static void parentOf(int[][] grid, int i, int j){
		if(i<0 || j<0)
			return;
		
		if(grid[i][j]==-1)
			return;
		
		grid[i][j]+=1;
		parentOf(grid,i-1, j);
		parentOf(grid,i, j-1);
	}

	private static void print2DArray(int[][] multiArray, int m, int n, String suffix) {
		System.out.println(suffix+" >>");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int element = multiArray[i][j];
				System.out.format("%3d",element);
			}
			System.out.println();
		}
		System.out.println();
	}
}
