package recursion.simple;

/**
 * Efficient mechanism to generate fibonacci numbers
 * Method 1 uses simple recursion, 
 * but time taken to compute will exponentially increase over time
 * 
 * Method 2 uses memorization to avoid re-computations of the same N
 * 
 * Compare the time difference between the two
 *
 */
public class FibonacciGenerator {

	public static void main(String[] args) {
		
		System.out.println("Metthod 1");
		System.out.println("*********************");
		long startTime1 = System.currentTimeMillis();
		for (int i = 1; i < 47; i++)
			System.out.println(fibSimple(i));

		long endTime1 = System.currentTimeMillis();
		System.out.println("Time taken is >> " + (endTime1 - startTime1));

		long startTime2 = System.currentTimeMillis();
		
		System.out.println("Metthod 2");
		System.out.println("*********************");
		
		int[] mem = new int[48];
		mem[0] = 0;
		mem[1] = 1;
		
		for (int i = 1; i < 47; i++)
			System.out.println(fibWithMemorization(i,mem));

		long endTime2 = System.currentTimeMillis();
		System.out.println("Time taken is >> " + (endTime2 - startTime2));
	}

	/**
	 * simple recursion but not performant
	 * @param N
	 * @return
	 */
	private static int fibSimple(int N) {
		if (N == 1 || N == 2)
			return 1;
		return fibSimple(N - 1) + fibSimple(N - 2);
	}

	/**
	 * Uses memorization to avoid re-computations of the same N
	 * @param N
	 * @param mem
	 * @return
	 */
	private static int fibWithMemorization(int N, int[] mem) {
		if (N == 1 || N == 2)
			return 1;

		mem[N - 1] = fibWithMemorization((N - 1),mem);
		return mem[N - 2]+ mem[N - 1] ;
	}
}
