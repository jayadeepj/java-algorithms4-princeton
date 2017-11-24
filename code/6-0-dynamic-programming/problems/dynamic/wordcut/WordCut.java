package dynamic.wordcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * Uses a single boolean array for DP
 *
 */
public class WordCut {

	public static void main(String[] args) {
		WordCut wc = new WordCut();

		String text = "ABCDEFGHI";
		String[] dict = { "ABC", "DEF", "GHI" };

		Map<String, String> lookup = new HashMap<String, String>();
		for (int i = 0; i < dict.length; i++) {
			lookup.put(dict[i], "");
		}
		System.out.println("Can the text be segmmented ? " + wc.cut(text, lookup));
	}

	/**
	 * The above problem exhibits overlapping sub-problems. Use a boolean 1 D
	 * array as Dynamic Programming Store
	 * 
	 * @param text
	 * @param lookup
	 * @return
	 */
	public boolean cut(String text, Map<String, String> lookup) {
		boolean[] dpStore = new boolean[text.length() + 1];
		dpStore[0] = true;

		for (int i = 1; i < dpStore.length; i++) {
			boolean cutHere = false;
			for (int j = 0; j < i; j++) {
				if (dpStore[j]) {
					if (lookup.containsKey(text.substring(j, i)))
						cutHere = true;
				}

			}
			dpStore[i] = cutHere;
		}

		return dpStore[dpStore.length - 1];
	}

	/**
	 * Print 1D array
	 * 
	 * @param array
	 */
	public static void print1DArray(boolean[] array, String suffix) {
		System.out.println(suffix + " >>");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
