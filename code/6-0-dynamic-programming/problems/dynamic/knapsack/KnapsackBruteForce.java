package dynamic.knapsack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Brute force algorithm for knapsack. Complexity is 2 ^ N . Creates a binary
 * array for each xi and uses it to compute max value constraint to the weight
 *
 */
public class KnapsackBruteForce {

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

		printArray(weights, "Weights");
		printArray(values, "Values");

		findOptimalItems(weights, values, N, W);
	}

	public static void findOptimalItems(int[] weights, int[] values, int N, int W) {
		int maxCombinations = (int) (Math.pow(2, N));
		int maxValue = -1;
		int[] bestCombination = null;

		for (int i = 0; i < maxCombinations; i++) {
			int[] binaryCombination = new int[N];
			convertToBinary(i, N, binaryCombination);
			int totalWeight = 0, totalValue = 0;
			for (int j = 0; j < N; j++) {
				totalWeight += weights[j] * binaryCombination[j];
				totalValue += values[j] * binaryCombination[j];
			}
			if (totalWeight <= W && totalValue > maxValue) {
				maxValue = totalValue;
				bestCombination = Arrays.copyOf(binaryCombination, N);
			}
		}
		System.out.println("\nMax Value >> " + maxValue);
		printArray(bestCombination, "Best Combination");
	}

	private static void convertToBinary(int decimal, int index, int[] binaryCombination) {
		if (decimal == 0)
			return;
		int reminder = decimal % 2;
		convertToBinary(decimal / 2, --index, binaryCombination);
		binaryCombination[index] = reminder;
	}

	public static void printArray(int[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
