package dynamic.subsequence;

/**
 * Finds the Longest Common Subsequence. Unlike substrings, subsequences are not
 * required to occupy consecutive positions within the original sequences.
 * 
 * E.g DCDCADC is the LCS of in XAXDCDCADC and BDABCABDCADC. 
 *
 */
public class LongestCommonSubsequenceBruteForce {

	private static String longestSubsequence = "";
	public static void main(String[] args) {
		String seq1 = "BDABCABDCADC";
		String seq2 = "XAXDCDCADC";
		findAllSubsequence("", seq1, seq2);
		System.out.println(longestSubsequence);
	}

	/**
	 * Iteratively finds all subsequences in a sequence by using recursion in a loop
	 * The subsequence tree is formed as {w} => {wx => {wxy, wxz},wy => {wyz},wz} e.t.c
	 * @param prefixSeq1
	 * @param remainingSeq1
	 * @param seq2
	 */
	private static void findAllSubsequence(String prefixSeq1, String remainingSeq1, String seq2)
	{
		if(doesSubSequenceExists(seq2, prefixSeq1))
			longestSubsequence = ((prefixSeq1.length()>longestSubsequence.length()) ? prefixSeq1:longestSubsequence);
		
		for (int i = 0; i < remainingSeq1.length(); i++) {
			findAllSubsequence(prefixSeq1+remainingSeq1.charAt(i), remainingSeq1.substring(i+1), seq2);
		}
	}

	/**
	 * Checks if sequence exists in master
	 * @param master
	 * @param sequence
	 * @return
	 */
	private static boolean doesSubSequenceExists(String master, String sequence) {

		if (sequence.length() == 0)
			return true;
		if (master.length() == 0)
			return false;

		if (master.charAt(0) == sequence.charAt(0))
			return doesSubSequenceExists(master.substring(1), sequence.substring(1));
		else
			return doesSubSequenceExists(master.substring(1), sequence);
	}	


}
