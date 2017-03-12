package recursion.queen;

import java.util.Scanner;

/**
 * Place 8 queens on an 8-by-8 chess board so that no two queens are in the same
 * row, column, or diagonal. There are 8! = 40,320 ways in which no two queens
 * are placed in the same row or column. Any permutation p[] of the integers 0
 * to 7 gives such a placement: put queen i in row i, column p[i]. Your program
 * Queens.java should take an integer command-line argument n and enumerate all
 * solutions to the n-queens problem by drawing the location of the queens in
 * ASCII like the solution below.
 *
 */
public class NQueensProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the board length/height  >> ");
		int N = sc.nextInt();
		int[] fullSet = new int[N];
		for (int i = 0; i < fullSet.length; i++) {
			fullSet[i] = i;
		}
		permutateArray(null, fullSet, 0);
	}

	/**
	 * Finds all permutations of array p[i]
	 * 
	 * @param prefixSet
	 * @param fullSet
	 * @param lengthOfPrefix
	 */
	public static void permutateArray(int[] prefixSet, int[] fullSet, int lengthOfPrefix) {
		if (lengthOfPrefix == fullSet.length) {
			if (isValidQueenPosition(prefixSet)) {
				printArrayOnBoard(prefixSet);
			}
		}
		int[] newPrefixSet = new int[lengthOfPrefix + 1];
		copyTo(prefixSet, newPrefixSet);

		for (int i = 0; i < fullSet.length; i++) {
			if (!contains(prefixSet, fullSet[i])) {
				newPrefixSet[lengthOfPrefix] = fullSet[i];
				permutateArray(newPrefixSet, fullSet, lengthOfPrefix + 1);
			}
		}
	}

	public static boolean contains(int[] prefixSet, int element) {
		if (prefixSet == null)
			return false;
		for (int i = 0; i < prefixSet.length; i++) {
			if (prefixSet[i] == element)
				return true;
		}
		return false;
	}

	/**
	 * If p[i+x] == p[i]+x or If p[i+x] == p[i]-x then it means that the 2
	 * elements are diagonally related & hence not a valid queen position
	 * 
	 * @param permutedSet
	 * @return
	 */
	public static boolean isValidQueenPosition(int[] permutedSet) {
		for (int i = 0; i < permutedSet.length; i++) {
			int elementToAppend = permutedSet[i];
			for (int j = 0; j < i; j++) {
				if (permutedSet[j] + (i - j) == elementToAppend)
					return false;
				if (permutedSet[j] - (i - j) == elementToAppend)
					return false;
			}
		}
		return true;
	}

	public static void printArray(int[] prefixSet) {
		for (int i = 0; i < prefixSet.length; i++) {
			System.out.print(prefixSet[i] + " ");
		}
		System.out.println();
	}

	public static void printArrayOnBoard(int[] prefixSet) {
		int boardHeigtht = prefixSet.length;
		for (int i = 0; i < boardHeigtht; i++) {
			for (int j = 0; j < boardHeigtht; j++) {
				if (j == prefixSet[i])
					System.out.print("Q" + " ");
				else
					System.out.print("*" + " ");
			}
			System.out.println();
		}
		System.out.println("****************");
	}

	public static void copyTo(int[] prefixSet, int[] newPrefixSet) {
		if (prefixSet == null)
			return;
		for (int i = 0; i < prefixSet.length; i++) {
			newPrefixSet[i] = prefixSet[i];
		}
	}
}
