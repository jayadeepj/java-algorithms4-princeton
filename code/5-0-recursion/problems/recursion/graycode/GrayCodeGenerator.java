package recursion.graycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An n-bit Gray code is a list of the 2n different n-bit binary numbers such
 * that each entry in the list differs in precisely one bit from its
 * predecessor. The n bit binary reflected Gray code is defined recursively as
 * follows:
 * 
 * the n−1 bit code, with 0 prepended to each word,
 * 
 * followed by the n−1 bit code in reverse order, with 1 prepended to each word.
 *
 */
public class GrayCodeGenerator {
	public static void main(String[] args) {
		List<String> grayCodeSetNew = grayCodeRecursively(4);
		for (String string : grayCodeSetNew) {
			System.out.println(string);
		}
	}

	private static List<String> grayCodeRecursively(int N) {
		if (N == 1) {
			List<String> graySet = new ArrayList<>();
			graySet.add("0");
			graySet.add("1");
			return graySet;
		}

		List<String> previousGraySet = grayCodeRecursively(N - 1);
		List<String> graySet = new ArrayList<>();
		for (String bits : previousGraySet) {
			graySet.add("0" + bits);
		}
		Collections.reverse(previousGraySet);
		for (String bits : previousGraySet) {
			graySet.add("1" + bits);
		}
		return graySet;
	}
}
