package dynamic.arraysumoptimization;

import java.util.Scanner;

/**
 * 
 * Array A contains the elements, A1,A2...AN. And array B contains the elements,
 * B1,B2...BN. There is a relationship between Ai and Bi, ∀ 1 ≤ i ≤ N, i.e., any
 * element Ai lies between 1 and Bi. Let cost S of an array A is defined as: Sum
 * of the difference of all subsequent elements of A You have to print the
 * largest possible value of S.
 * 
 */
public class SherlockAndCost
{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int j = 0; j < T; j++) {
			int N = in.nextInt();
			int[] original = new int[N];
			for (int i = 0; i < N; i++) {
				original[i] = in.nextInt();
			}
			optimizeByDP(original);
		}
	}

	/**
	 * Solution by Dynamic programming
	 * opt[i][0] => the maximum cost assuming 1 is chosen in the ith operation
	 * opt[i][1] => the maximum cost assuming Bi is chosen in the ith operation
	 * @param original
	 */
	private static void optimizeByDP(int[] original) {

		int N = original.length;
		int[][] opt = new int[N][2];

		for (int i = 1; i < N; i++) {
			opt[i][0] = Math.max(opt[i-1][0] + Math.abs(1-1) , opt[i-1][1]+Math.abs(1-original[i-1]));
			opt[i][1] = Math.max(opt[i-1][0] + Math.abs(original[i]-1), opt[i-1][1]+Math.abs(original[i]-original[i-1]));
		}
		System.out.println(Math.max(opt[N-1][0],opt[N-1][1]));
	}
}