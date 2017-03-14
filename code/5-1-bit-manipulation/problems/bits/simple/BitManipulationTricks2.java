package bits.simple;

/**
 * Simple Bit Manipulation problems & Tricks.
 * 
 */
public class BitManipulationTricks2 {
	public static void main(String[] args) {

		/*** convert Integer into Binary (String representation) *****/

		int N1 = 25;
		int N2 = 26;
		System.out.println("Check if the integer is even or odd.");
		System.out.println("is " + N1 + " odd ? " + isOdd(N1));
		System.out.println("is " + N2 + " odd ? " + isOdd(N2));
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Unset the i-th bit");
		clearIthBit(239, 5);
		System.out.println("\n----------------------------------------------------------------\n");

		System.out.println("Turn off the rightmost 1-bit");
		clearRightMost1Bit(239);
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Turn off the leftmost 1-bit");
		clearLeftMost1Bit(239);
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Isolate the rightmost 1-bit");
		isolateRightMost1Bit(156);
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Right propagate the rightmost 1-bit.");
		rightPropagateRightMost1Bit(156);
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Isolate the rightmost 0-bit");
		isolateRightMost0Bit(47);
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("Turn on the rightmost 0-bit");
		turnOnRightMost0Bit(33);
		System.out.println("\n----------------------------------------------------------------\n");
	}
	
	/**
	 * Isolate the rightmost 0-bit.
	 * 
	 * @param N
	 */
	public static void turnOnRightMost0Bit(int N) {
		System.out.println("Before turning ON Right Most 0 Bit in  N >> " + Integer.toBinaryString(N));
		System.out.println("After turning ON Right Most 0 Bit in  N >> " + Integer.toBinaryString(N | (N+1)));
	}

	/**
	 * Isolate the rightmost 0-bit.
	 * 
	 * @param N
	 */
	public static void isolateRightMost0Bit(int N) {
		System.out.println("Before isolating Right Most 0 Bit in  N >> " + Integer.toBinaryString(N));
		System.out.println("After isolating Right Most 0 Bit in  N >> " + Integer.toBinaryString(N & ~(N+1)));
	}
	
	/**
	 * Right propagate the rightmost 1-bit.
	 * 
	 * @param N
	 */
	public static void rightPropagateRightMost1Bit(int N) {
		System.out.println("Before Right Propagating Right Most 1Bit in  N >> " + Integer.toBinaryString(N));
		System.out.println("After Right Propagating Right Most 1Bit in  N >> " + Integer.toBinaryString(N | (N-1)));
	}
	
	/**
	 * Isolate the rightmost 1-bit.
	 * 
	 * @param N
	 */
	public static void isolateRightMost1Bit(int N) {
		System.out.println("Before isolating Right Most 1Bit in  N >> " + Integer.toBinaryString(N));
		System.out.println("After isolating Right Most 1Bit in  N >> " + Integer.toBinaryString(N & (-N)));
	}
	
	/**
	 * Turn off the rightmost 1-bit.
	 * 
	 * @param N
	 */
	public static void clearRightMost1Bit(int N) {
		System.out.println("Before Clearing bit N >> " + Integer.toBinaryString(N));
		System.out.println("After Clearing bit N >> " + Integer.toBinaryString(N & (N-1)));
	}

	/**
	 * Turn off the leftmost 1-bit.
	 * 
	 * @param N
	 */
	public static void clearLeftMost1Bit(int N) {
		System.out.println("Before Clearing bit N >> " + Integer.toBinaryString(N));
		int bitLength =  Integer.toBinaryString(N).length();
		int X = N & ~(1<< (bitLength -1));
		System.out.println("After Clearing bit N >> " + Integer.toBinaryString(X));
	}
	
	/**
	 * Unset the i-th bit.
	 * 
	 * @param N
	 * @param i
	 */
	public static void clearIthBit(int N, int i) {
		System.out.println("Before Clearing bit >> " + i + " the N >> " + Integer.toBinaryString(N));
		System.out.println("After Clearing bit >> " + i + " the N >> " + Integer.toBinaryString(N & (~(1 << i))));
	}

	/**
	 * Check if the integer is even or odd.
	 * 
	 * @param N
	 */
	public static boolean isOdd(int N) {
		return (N & 1) != 0;
	}

}
