package dynamic.subsequence;

/**
 * Finds the Longest Common Subsequence. Unlike substrings, subsequences are not
 * required to occupy consecutive positions within the original sequences.
 * 
 * E.g DCDCADC is the LCS of in XAXDCDCADC and BDABCABDCADC. This class uses
 * Dynamic Programming & Memoization using a 2-D array .
 * 
 * Similarly LCS of GGCACCACG and ACGGCGGATACG is GGCAACG, a string of length 7
 *
 */
public class LongestCommonSubsequenceDynamicProg {

	public static void main(String[] args) {
		String seq2 = "ACGGCGGATACG";
		String seq1 = "GGCACCACG";
		lcs(seq1, seq2);
	}

	private static void lcs(String seq1, String seq2) {
		int m = seq1.length();
		int n = seq2.length();
		int[][] dynamo = new int[m + 1][n + 1];

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (isElementPosSame(seq1, seq2, i, j)) {
					dynamo[i][j] = dynamo[i - 1][j - 1] + 1;
				} else {
					dynamo[i][j] = Math.max(dynamo[i - 1][j], dynamo[i][j - 1]);
				}
			}
		}

		print2DArray(dynamo, m, n);

		int lcsLength = dynamo[m][n];
		char[] lcs = new char[lcsLength];
		int i = m, j = n;

		while (i > 0 && j > 0) {
			if (dynamo[i][j] == dynamo[i - 1][j])
				i--;
			else if (dynamo[i][j] == dynamo[i][j - 1])
				j--;
			else {
				lcs[--lcsLength] = seq1.charAt(i - 1);
				j--;
				i--;
			}
		}

		System.out.println(new String(lcs));
	}

	private static void print2DArray(int[][] dynamo, int m, int n) {
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(dynamo[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isElementPosSame(String seq1, String seq2, int x, int y) {
		return seq1.charAt(x - 1) == seq2.charAt(y - 1);
	}

}
