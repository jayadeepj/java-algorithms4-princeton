package bits.simple;

/**
 * Simple Bit Manipulation problems & Tricks.
 * 
 */
public class BitManipulationTricks3 {
	public static void main(String[] args) {
		System.out.println(" A ^ A = 0  , A ^ A ^ A = A, A ^ B ^ A = B  , A ^ B ^ A ^ A = A ^ B ");
		xorProperties1();
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("if A^B = C then A^C = B; ");
		xorProperties2();
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("XOR of all numbers from 1.. N follows a pattern . 1^2^3^4^5^6^..^N Can be done in O(1)");
		System.out.println("The pattern is 0,N+1,1,N,0,N+1,1,N ...");
		System.out.println("xor from 1 to 9 is >> "+xorSoFarFrom1toN(9));
		System.out.println("xor from 1 to 9 is >> "+(1^2^3^4^5^6^7^8^9));
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("In Java 1<<x  is different from 1L<<x");
		bigShiftInJava();
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Find index of left most 1 ");
		findIndexOfLeftMost1(8000000000L);
		System.out.println("\n----------------------------------------------------------------\n");
		
		long N5 = 257L;
		System.out.println("Find the largest power of 2 (most significant bit in binary form), which is less than or equal to the given number N.");
		System.out.println("Largest power of 2 less than >> " + N5 + " is >> " + largestPowerBestTrick(N5));
		System.out.println("\n----------------------------------------------------------------\n");
	}

	/**
	 * Tricks with XOR. Specially important is A ^ B ^ A = B & A ^ B ^ A ^ A = A
	 * ^ B
	 */
	public static void xorProperties1() {
		System.out.println(" 5 ^ 5 =" + (5 ^ 5));
		System.out.println(" 5 ^ 5 ^ 5 = " + (5 ^ 5 ^ 5));
		System.out.println(" 5 ^ 8 ^ 5 = " + (5 ^ 8 ^ 5));
		System.out.println(" 5 ^ 8 ^ 5 ^ 5 = " + (5 ^ 8 ^ 5 ^ 5));
	}

	/**
	 * Tricks with XOR. if A^B = C then A^C = B
	 */
	public static void xorProperties2() {
		System.out.println(" 5 ^ 8 = " + (5 ^ 8));
		System.out.println(" 13 ^ 8 = " + (13 ^ 8));
	}
	
	/**
	 * Gives XOR of all numbers from 1 .. N
	 */
	public static long xorSoFarFrom1toN(long N) {
		if ((N + 1) % 4 == 0L)
			return 0L;
		else if ((N + 2) % 4 == 0L)
			return N+1;
		else if ((N + 3) % 4 == 0L)
			return 1L;
		else
			return N;
	}
	
	/**
	 * In Java 1<<x  is different from 1L<<x
	 */
	public static void bigShiftInJava() {
		System.out.println(" 1 << 30 = " + Long.toBinaryString( 1 << 30 ));
		System.out.println(" 1 << 31 = " + Long.toBinaryString( 1 << 31 ));
		System.out.println("The above value is not shifted properly if greater thn 30. You have to use 1L");
		System.out.println(" 1L << 31 = " + Long.toBinaryString( 1L << 31 ));
		System.out.println(" 1L << 32 = " + Long.toBinaryString( 1L << 32 ));
	}
	
	/**
	 * Find index of left most 1
	 * @param N
	 * @return
	 */
	public static void findIndexOfLeftMost1(long N){
		long leftMost1Index = (long) (Math.log(N) / Math.log(2));
		System.out.println("Left  most bit in "+N+" ("+Long.toBinaryString(N)+") is at"+leftMost1Index);
	}
	
	public static long largestPowerBestTrick(long N) {
		long leftMost1Index = (long) (Math.log(N) / Math.log(2));
		return (1L<<leftMost1Index);
	}
}
