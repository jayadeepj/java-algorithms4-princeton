package bits.simple;

/**
 * Simple Bit Manipulation problems & Tricks.
 * 
 */
public class BitManipulationTricks1 {
	public static void main(String[] args) {

		/*** convert Integer into Binary (String representation) *****/
		int N = 350818645;
		System.out.println("Binary representation of " + N + " = " + convertToBinary(N));
		System.out.println("\n----------------------------------------------------------------\n");
		/*** Check if N is a power of 2 (2^N) ***/
		int N1 = 256;
		int N2 = 132;

		System.out.println(N1 + " is power of 2 ? " + isPowerOf2(N1));
		System.out.println(21 + " is power of 2 ? " + isPowerOf2(N2));

		System.out.println(N1 + " is power of 2 ? " + isPowerOf2Trick(N1));
		System.out.println(21 + " is power of 2 ? " + isPowerOf2Trick(N2));
		System.out.println("\n----------------------------------------------------------------\n");
		/***
		 * Count the number of ones in the binary representation of the given
		 ***/

		int N3 = 23;
		System.out.println("The number of 1s in " + N3 + "  is " + countNoOfOnes(N3));
		System.out.println("The number of 1s in " + N3 + "  is " + countNoOfOnesTrick(N3));
		System.out.println("\n----------------------------------------------------------------\n");
		/***
		 * Iterate over all the subsets of an N-element set using bit
		 * manipulation
		 ***/

		char[] masterSet = { 'a', 'b', 'c', 'd' };
		System.out.println("generate all the possible subsets of a set >>  { 'a', 'b', 'c', 'd' } ");
		generateAllPossibleSubset(masterSet);
		System.out.println("\n----------------------------------------------------------------\n");

		int N5 = (int) Math.pow(2.0, 5) + 10;
		System.out.println(
				"Trick 1: Find the largest power of 2 (most significant bit in binary form), which is less than or equal to the given number N.");
		System.out.println("Largest power of 2 less than >> " + N5 + " is >> " + largestPowerTrick1(N5));
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println(
				"Trick 2: Find the largest power of 2 (most significant bit in binary form), which is less than or equal to the given number N.");
		System.out.println("Largest power of 2 less than >> " + N5 + " is >> " + largestPowerTrick2(N5));
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Given two numbers A and B. Swap A and B without using arithmetic operator");
		swap(20, 30);
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Flip the ith bit in the binary representation of a given number N.");
		flipIthBit(25, 3);
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Flip the all bits in the binary representation of a given number N.");
		flipAll(25);
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println(" A ^ A = 0  , A ^ A ^ A = A, A ^ B ^ A = B  , A ^ B ^ A ^ A = A ^ B ");
		xor2NTricks();
		System.out.println("\n----------------------------------------------------------------\n");
	}

	/**
	 * Tricks with XOR. Specially important is A ^ B ^ A = B & A ^ B ^ A ^ A = A
	 * ^ B
	 */
	public static void xor2NTricks() {
		System.out.println(" 5 ^ 5 =" + (5 ^ 5));
		System.out.println(" 5 ^ 5 ^ 5 = " + (5 ^ 5 ^ 5));
		System.out.println(" 5 ^ 8 ^ 5 = " + (5 ^ 8 ^ 5));
		System.out.println(" 5 ^ 8 ^ 5 ^ 5 = " + (5 ^ 8 ^ 5 ^ 5));
	}

	/**
	 * Toggle the ith bit in the binary representation of a given number N.
	 * 
	 * @param N
	 * @param i
	 */
	public static void flipIthBit(int N, int i) {
		System.out.println(Integer.toBinaryString(N));
		System.out.println(Integer.toBinaryString(N ^ (1 << i)));

	}

	/**
	 * Flip the all bits in the binary representation of a given number N.
	 * 
	 * @param N
	 * @param i
	 */
	public static void flipAll(int N) {
		System.out.println("Original >> " + Integer.toBinaryString(N));
		System.out.println("Flipped by NOT >> " + Integer.toBinaryString(~N));
	}

	/**
	 * Given two numbers A and B. Swap A and B without using arithmetic operator
	 * and without using third variable.
	 * 
	 * @param A
	 * @param B
	 */
	public static void swap(int A, int B) {
		System.out.println("Before swap >> A >> " + A + " &  B >> " + B);

		B = A ^ B;
		A = A ^ B;
		B = A ^ B;

		System.out.println("After swap >> A >> " + A + " & B >> " + B);

	}

	/**
	 * Find the largest power of 2 (most significant bit in binary form), which
	 * is less than or equal to the given number N.
	 * 
	 * @param N
	 * @return
	 */
	public static int largestPowerTrick1(int N) {
		N = N | N >> 1;
		N = N | N >> 2;
		N = N | N >> 4;
		N = N | N >> 8;
		N = N | N >> 16;
		N = N | N >> 32;
		return (N + 1) >> 1;

	}

	/**
	 * Find the largest power of 2 (most significant bit in binary form), which
	 * is less than or equal to the given number N.
	 * 
	 * However this trick will work only of the number starts with 1. (E.g 8D is
	 * passed as 1000 and not 00001000)
	 * 
	 * @param N
	 * @return
	 */
	public static int largestPowerTrick2(int N) {
		int bitLength =  Integer.toBinaryString(N).length();
		return (1 << (bitLength -1));
	}

	/**
	 * How to generate all the possible subsets of a set ? Iterate over all the
	 * subsets of an N-element set using bit manipulation
	 * 
	 * @param masterSet
	 */
	public static void generateAllPossibleSubset(char[] masterSet) {
		int N = masterSet.length;

		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(masterSet[j] + " ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * To check if the ith bit is set or not (1 or not), we can use AND
	 * operator.
	 * 
	 * @param N
	 * @param i
	 * @return
	 */
	public boolean isIthBitSet(int N, int i) {

		if ((N & 1 << i) == 0)
			return false;
		else
			return true;

	}

	/**
	 * Count the number of ones in the binary representation of the given
	 * number. The time complexity of the below is O(K) where K is the number of
	 * 1s in the binary representation
	 * 
	 * @param N
	 * @return
	 */
	public static int countNoOfOnesTrick(int N) {
		int count = 0;
		while (N != 0) {
			count++;
			N = N & (N - 1);
		}
		return count;
	}

	/**
	 * Count the number of ones in the binary representation of the given
	 * number. The time complexity of the below is log2N
	 * 
	 * @param N
	 * @return
	 */
	public static int countNoOfOnes(int N) {
		int count = 0;
		while (N != 0) {
			if (N % 2 != 0)
				count++;
			N = N / 2;
		}
		return count;
	}

	/**
	 * Check if N is a power of 2 (2^N) The time complexity of the below is O(1)
	 * 
	 * @param N
	 */
	public static boolean isPowerOf2Trick(int N) {
		if (N == 0)
			return false;
		return ((N & (N - 1)) == 0) ? true : false;
	}

	/**
	 * Check if N is a power of 2 (2^N) Thie time complexity of the below is
	 * log2N
	 * 
	 * @param N
	 */
	public static boolean isPowerOf2(int N) {
		while (N % 2 == 0)
			N = N / 2;
		return (N == 1) ? true : false;
	}

	/**
	 * Recursive method to convert Integer into Binary (String representation)
	 * 
	 * @param N
	 * @return
	 */
	public static String convertToBinary(int N) {
		if (N == 1)
			return "1";
		String val = convertToBinary(N / 2);
		return (val + String.valueOf(N % 2));
	}
}
