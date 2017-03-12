package dynamic.knapsack;

import java.util.Random;
import java.util.Scanner;

/**
 * Solution using Dynamic Programming.Computes solution in N X W time.
 *
 */
public class KnapsackDynamicProg {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Items >> ");
		int N = sc.nextInt();
		System.out.println("Enter max Weight >> ");
		int W = sc.nextInt();

		int[] values = new int[N];
		int[] weights = new int[N];

		/** generate values between 1 & W **/
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 1 + random.nextInt(W - 1);
		}

		/** generate values between $10 & $50 **/
		for (int i = 0; i < values.length; i++) {
			values[i] = 10 + random.nextInt(40);
		}

		/*** Some test values ****/
		// int[] weights = new int[] { 4, 3, 1, 5 };
		// int[] values = new int[] { 5, 4, 1, 7 };

		printArray(weights, "Weights");
		printArray(values, "Values");

		findOptimalItems(weights, values, 4, 7);
	}

	public static void findOptimalItems(int[] weights, int[] values, int N, int W) {
		int[][] opt = new int[N][W + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= W; j++) {
				if (weights[i] > j) {
					opt[i][j] = (i == 0) ? 0 : opt[i - 1][j];
				} else {
					if (i == 0)
						opt[i][j] = values[i];
					else {
						int earlierMax = (i - 1 >= 0) && (j - weights[i] >= 0) ? opt[i - 1][j - weights[i]] : 0;
						opt[i][j] = Math.max(opt[i - 1][j], (values[i] + earlierMax));
					}
				}
			}
		}

		print2DArray(opt, N, W + 1);
		printArray(weights, "Weights");
		int i = N - 1, j = W;

		int[] optimumCombination = new int[N];

		while (i >= 0 && j >= 0) {
			int priorRowValue = (i == 0) ? 0 : opt[i - 1][j];
			if (opt[i][j] == priorRowValue)
				i = i - 1;
			else {
				optimumCombination[i] = 1;
				j = j - weights[i];
				i = i - 1;
			}
		}
		System.out.println("\nMax Value - by DP >> " + opt[N - 1][W]);
		printArray(optimumCombination, "Best Combination - by DP");
	}

	public static void printArray(int[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	private static void print2DArray(int[][] multiArray, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(multiArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
