package recursion.simple;

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
public class StringPermutation2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number  >> ");
		int N = sc.nextInt();
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		printStringPermutations("", alphabets.substring(0, N));
	}

	private static void printStringPermutations(String prefix, String original) {
		if (prefix.length() == original.length()) {
			System.out.println(prefix);
			return;
		}
		String newPrefix = prefix;
		for (int i = 0; i < original.length(); i++) {
			if (newPrefix.indexOf(original.charAt(i)) == -1) {
				newPrefix = prefix + original.charAt(i);
				printStringPermutations(newPrefix, original);
			}
		}
	}
}
