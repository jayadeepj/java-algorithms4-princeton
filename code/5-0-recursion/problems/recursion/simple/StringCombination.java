package recursion.simple;

import java.util.Scanner;

/**
 * Write a program that takes an integer command-line argument n and prints all
 * 2n combinations of any size. A combination is a subset of the n elements,
 * independent of order.
 * 
 * As an example, when n = 3, you should get the following output:
 * 
 * a ab abc ac b bc c
 *
 */
public class StringCombination {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number  >> ");
		int N = sc.nextInt();
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		printStringCombinations("", alphabets.substring(0, N));
	}

	private static void printStringCombinations(String prefix, String s) {
		for (int i = 0; i < s.length(); i++) {
			String newPrefix = prefix + s.charAt(i);
			System.out.println(newPrefix);
			printStringCombinations(newPrefix, s.substring(i + 1));
		}

	}
}
