package dynamic.subsequence;

/**
 * Checks if a given sequence is a subsequence of another sequence. Unlike
 * substrings, subsequences are not required to occupy consecutive positions
 * within the original sequences.
 * 
 * E.g DCDCADC exists in BDABCABDCADC.
 * But DDCDCADC does not exist in BDABCABDCADC.
 *
 */
public class SubsequenceExists {

	private static boolean isSubSequence = false;

	public static void main(String[] args) {
		String master = "BDABCABDCADC";
		String sequence = "DCDCADC";
		System.out.println(doesSubSequenceExists(master, sequence));

		doesSubSequenceExistsWithGlobalVar(master, sequence);
		System.out.println(isSubSequence);
	}

	/**
	 * This method uses return
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

	/**
	 * This method uses a global variable instead
	 * @param master
	 * @param sequence
	 */
	private static void doesSubSequenceExistsWithGlobalVar(String master, String sequence) {

		if (sequence.length() == 0) {
			isSubSequence = true;
			return;
		}
		if (master.length() == 0)
			return;

		if (master.charAt(0) == sequence.charAt(0))
			doesSubSequenceExistsWithGlobalVar(master.substring(1), sequence.substring(1));
		else
			doesSubSequenceExistsWithGlobalVar(master.substring(1), sequence);

	}
}
