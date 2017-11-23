package substringsearch;

import java.util.Arrays;

/**
 * Reads in two strings, the pattern and the input text, and searches for the
 * pattern in the input text using the of the Rabin-Karp algorithm.
 *
 * For text of length n and p patterns of combined length m, its average and
 * best case running time is O(n+m) in space O(p), but its worst-case time is
 * O(nm)
 *
 * @author jayadeep
 *
 */
public class RobinKarpSubstringSearch {
	public static void main(String[] args) {
		String text = "INHAYSTACKNEEDLEINHAYSTACKNEEDLE";
		String pattern = "NEEDLE";
		RobinKarpSubstringSearch robinKarpSubstringSearch = new RobinKarpSubstringSearch();
		System.out.println(robinKarpSubstringSearch.search(text.toCharArray(), pattern.toCharArray()));
	}

	private boolean search(char[] text, char[] pattern) {
		int prime = 3;
		int length = pattern.length;

		double hashOfPattern = hash(pattern, prime);
		char[] firstSlice = Arrays.copyOfRange(text, 0, length);
		double hashOfFirstSlice = hash(firstSlice, prime);
		if (hashOfFirstSlice == hashOfPattern && isEqual(firstSlice, pattern))
			return true;

		double hashOfSlice = hashOfFirstSlice;
		for (int i = length; i < text.length; i++) {
			double rolledHash = rollingHash(text, i, prime, length, hashOfSlice);
			if (rolledHash == hashOfPattern) {
				char[] slice = Arrays.copyOfRange(text, (i - length + 1), i + 1);
				if (isEqual(slice, pattern))
					return true;
			}
			hashOfSlice = rolledHash;
		}
		return false;
	}

	/**
	 * Example : String = abcd
	 *
	 * oldhash(abc) => (a X 1) + (b X 3^1) + (c X 3^2)
	 *
	 * newhash(bcd) = (oldhash - a) / 3 + (d X 3^2)
	 *
	 * @param text
	 * @param pos
	 * @param prime
	 * @param length
	 * @param oldhash
	 * @return
	 */
	private double rollingHash(char[] text, int pos, int prime, int length, double oldhash) {
		System.out.println(oldhash + " " + text[pos - length] + " " + text[pos]);
		double hash = oldhash;
		hash = hash - text[pos - length];
		hash = hash / prime;
		hash = hash + text[pos] * (Math.pow(prime, length - 1));
		return hash;
	}

	/**
	 * Example : hash(abc) => (a X 1) + (b X 3^1) + (c X 3^2)
	 *
	 * @param value
	 * @param prime
	 * @return
	 */
	private double hash(char[] value, int prime) {
		double hash = 0;
		for (int i = 0; i < value.length; i++) {
			hash = hash + (value[i] * (Math.pow(prime, i)));
		}
		return hash;
	}

	/**
	 * To resolve hash collision, recheck the strings for equality
	 *
	 * @param value1
	 * @param value2
	 * @return
	 */
	private boolean isEqual(char[] value1, char[] value2) {
		for (int i = 0; i < value1.length; i++) {
			if (value1[i] != value2[i])
				return false;
		}
		return true;

	}
}
