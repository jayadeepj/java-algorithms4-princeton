package recursion.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a recursive program that take an integer command-line argument n and
 * prints all n! permutations of the n letters starting at a (assume that n is
 * no greater than 26). A permutation of n elements is one of the n! possible
 * orderings of the elements. As an example, when n = 3 you should get the
 * following output (but do not worry about the order in which you enumerate
 * them):
 * 
 * bca cba cab acb bac abc
 *
 */
public class StringPermutation {

	static char[] alphabetArray = new char[] { 'X', 'a', 'b', 'c', 'd', 'e' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number  >> ");
		int N = sc.nextInt();
		List<char[]> prevPermutationList = printStringPermutations(N);
		for (char[] stringArr : prevPermutationList) {
			System.out.println(String.valueOf(stringArr));
		}
	}

	public static List<char[]> printStringPermutations(int N) {
		if (N == 1) {
			List<char[]> permutationList = new ArrayList<char[]>();
			char[] permutationArray = new char[N];
			permutationArray[0] = alphabetArray[N];
			permutationList.add(permutationArray);
			return permutationList;
		} else {
			List<char[]> prevPermutationList = printStringPermutations(N - 1);
			List<char[]> permutationList = new ArrayList<char[]>();
			for (char[] stringArr : prevPermutationList) {
				for (int i = 0; i <= stringArr.length; i++) {
					char[] newString = insertElementAtX(stringArr, i, alphabetArray[N]);
					permutationList.add(newString);
				}
			}
			return permutationList;
		}
	}

	private static char[] insertElementAtX(char[] original, int x, char element) {

		if (x > original.length)
			throw new RuntimeException("X is more than array length");
		if (x < 0)
			throw new RuntimeException("X is invalid");
		char[] newArr = new char[original.length + 1];
		for (int i = 0; i < newArr.length; i++) {
			if (i == x)
				newArr[i] = element;
			else if (i > x)
				newArr[i] = original[i - 1];
			else
				newArr[i] = original[i];
		}
		return newArr;
	}
}
