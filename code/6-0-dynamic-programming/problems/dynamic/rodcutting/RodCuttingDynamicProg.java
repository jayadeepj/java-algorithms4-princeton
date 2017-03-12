package dynamic.rodcutting;

/**
 * Given a rod of length n inches and a table of prices pi for i = 1,2, …. n,
 * determine the maximum revenue Rn obtain- able by cutting up the rod and
 * selling the pieces. Note that if the price Pn for a rod of length n is large
 * enough, an optimal solution may require no cutting at all.
 *
 */
public class RodCuttingDynamicProg {

	public static void main(String[] args) {

		int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		int rodLength = 9;

		printArray(price, "Price");

		int[] revenue1 = new int[rodLength + 1];
		int[] revenue2 = new int[rodLength + 1];
		int[] optFirstPieceLength = new int[rodLength + 1];
		for (int i = 0; i < revenue1.length; i++) {
			revenue1[i] = -1;
			revenue2[i] = -1;
			optFirstPieceLength[i] = -1;
		}

		System.out.println("Max Revenue by Recursion >> " + cutRodByRecursion(price, rodLength));
		System.out.println("Max Revenue by Recursion And Memoization >> " + cutRodByRecursionNMemo(revenue1, price, rodLength));

		System.out.println("Optimal Rod Slices Lengths Revenue >>");
		cutRodByRecursionNMemoWithSolution(optFirstPieceLength, revenue2, price, rodLength);
		getOptimalSliceLengths(optFirstPieceLength, rodLength);
	}

	/**
	 * Use the formula Rn = Max(Pn , R1+R(n-1) , R2+ R(n-2) , ......) The first
	 * argument, Pn, corresponds to making no cuts at all and selling the rod of
	 * length n as is. The other n 􏰐- 1 arguments to max correspond to the
	 * maximum revenue obtained by making an initial cut of the rod into two
	 * pieces of size i and n 􏰐 i , for i = 1,2, …. n - 1, and then optimally
	 * cutting up those pieces further, obtaining revenues Ri and Rn-i from
	 * those two pieces.
	 * 
	 * This method cuts the rod by recursion. However as there is no
	 * memoization, extremely inefficient. Complexity ~ O(2 ^ N)
	 * 
	 * @param price
	 * @param maxLength
	 * @return
	 */
	public static int cutRodByRecursion(int[] price, int maxLength) {
		if (maxLength == 0)
			return 0;

		int optRevenue = price[maxLength];
		for (int i = 1; i < maxLength; i++)
			optRevenue = Math.max(optRevenue, cutRodByRecursion(price, i) + cutRodByRecursion(price, maxLength - i));

		return optRevenue;
	}

	/**
	 * Works same as above but stores the results of the sub-problems in the
	 * memory Complexity ~ O(N)
	 * 
	 * @param revenue1
	 * @param price
	 * @param maxLength
	 * @return
	 */
	public static int cutRodByRecursionNMemo(int[] revenue1, int[] price, int maxLength) {
		if (maxLength == 0)
			return 0;

		if (revenue1[maxLength] != -1)
			return revenue1[maxLength];

		int optRevenue = price[maxLength];
		for (int i = 1; i < maxLength; i++)
			optRevenue = Math.max(optRevenue, cutRodByRecursionNMemo(revenue1, price, i)
					+ cutRodByRecursionNMemo(revenue1, price, maxLength - i));

		revenue1[maxLength] = optRevenue;
		return optRevenue;
	}

	/**
	 * Same as above but also stores the length of the first slice in an array to backtrack the optimal solution later
	 * @param optFirstPieceLength
	 * @param revenue2
	 * @param price
	 * @param maxLength
	 * @return
	 */
	public static int cutRodByRecursionNMemoWithSolution(int[] optFirstPieceLength, int[] revenue2, int[] price,
			int maxLength) {
		if (maxLength == 0)
			return 0;

		if (revenue2[maxLength] != -1)
			return revenue2[maxLength];

		int optRevenue = price[maxLength];
		int currentBestSlice = 0;
		for (int i = 1; i < maxLength; i++) {
			int firstSlice = cutRodByRecursionNMemoWithSolution(optFirstPieceLength, revenue2, price, i);
			int secondSlice = cutRodByRecursionNMemoWithSolution(optFirstPieceLength, revenue2, price, maxLength - i);

			if (firstSlice + secondSlice > optRevenue) {
				currentBestSlice = i;
				optRevenue = firstSlice + secondSlice;
			}
		}
		revenue2[maxLength] = optRevenue;
		optFirstPieceLength[maxLength] = currentBestSlice;
		return optRevenue;
	}

	/**
	 * Back tracks to find the optimal rod slice lengths
	 * 
	 * @param optFirstPieceLength
	 * @param n
	 */
	private static void getOptimalSliceLengths(int[] optFirstPieceLength, int n) {
		int sliceLength = optFirstPieceLength[n];
		if (sliceLength != -1) {
			if (sliceLength == 0) {
				System.out.print((n - sliceLength) + " ");
			} else {
				getOptimalSliceLengths(optFirstPieceLength, sliceLength);
				getOptimalSliceLengths(optFirstPieceLength, n - sliceLength);
			}
		}
	}

	public static void printArray(int[] array, String suffix) {
		System.out.println(suffix + "");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
