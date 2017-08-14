package recursion.powersum;
import java.util.Scanner;

/**
 *
 */
public class PowerSum {

    private static int count =0;
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int X = Integer.parseInt(in.nextLine());
		int N = Integer.parseInt(in.nextLine());
		calcPowerSum(X, N);
	}

	public static void calcPowerSum(int X, int N) {
		int max = (int) Math.pow(X, ((double) 1 / N));
		int sum = 0;
		int[] right = new int[max];
		for (int i = 0; i < max; i++) {
			right[i] = ((int) Math.pow(i + 1, N));
		}
		permute(sum, right, X);
		System.out.println(count);
	}

	public static void permute(int sum, int[] right, int X) {
		 if (sum == X)
			 count++;

		if (right == null)
			return;

		for (int i = 0; i < right.length; i++) {
			int[] newRight = removeAllElementsTill(right, i);
			permute(sum + right[i], newRight, X);
		}

	}

	/**
	 * This method is an optimization over remove element at i
	 * @param array
	 * @param i
	 * @return
	 */
	public static int[] removeAllElementsTill(int[] array, int i) {
		int newLength = array.length - (i+1);
		if (newLength <= 0)
			return null;

		int[] newArray = new int[newLength];
		for (int j = 0; j < newArray.length; j++) {
				newArray[j] = array[i+1+j];
		}
		return newArray;
	}

}