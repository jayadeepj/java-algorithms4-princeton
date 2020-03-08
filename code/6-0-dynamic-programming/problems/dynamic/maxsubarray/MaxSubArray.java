package dynamic.maxsubarray;

/**
 * ind the contiguous subarray within an array (containing at least one number)
 * which has the largest sum
 * 
 * @author jayadeep
 *
 */
public class MaxSubArray {

	public static void main(String[] args) {
     int[] input = new int[] {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(maxSubArray(input));
     
	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private static int maxSubArray(int[] input) {
		int[] maxLengthSoFar = new int[input.length];
		maxLengthSoFar[0] = input[0];
		for (int i = 1; i < input.length; i++) {
			maxLengthSoFar[i] = Math.max(input[i], maxLengthSoFar[i - 1] + input[i]);
		}
		int maxSum = maxLengthSoFar[findMaxIndex(maxLengthSoFar)];
		return maxSum;
	}

	private static int findMaxIndex(int[] maxLengthSoFar) {
		int maxIndex = 0;
		for (int i = 1; i < maxLengthSoFar.length; i++) {
			if (maxLengthSoFar[i] > maxLengthSoFar[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
	}
}
