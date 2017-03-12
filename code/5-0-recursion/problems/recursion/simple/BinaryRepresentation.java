package recursion.simple;

import java.util.Scanner;

/**
 * Write a program that takes a positive integer n (in
 * decimal) as a command-line argument and prints its binary representation.
 * Now, use the following simpler method: repeatedly divide 2 into n and read
 * the remainders backwards. A while loop to carry out this computation and
 * print the bits in the wrong order. Then, use recursion to print the bits in
 * the correct order.
 *
 */
public class BinaryRepresentation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to be represented in Binary >> ");
		int N = sc.nextInt();
		printBinary(N);
	}

	public static void printBinary(int N) {
		if (N == 0)
			return;
		else {
			printBinary(N / 2);
			System.out.print(N % 2);
		}

	}
}
