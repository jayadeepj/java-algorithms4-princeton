package substringsearch;

/**
 * Simple brute force substring search
 * Time Complexity O(MN)
 *
 */
public class BruteForceSubstring {

	public static void main(String[] args) {
		String text = "INHAYSTACKNE1EDLEINHAYSTACKNEED1LEN";
		String pattern = "NEEDLE";
		BruteForceSubstring bruteForceSubstring = new BruteForceSubstring();
		System.out.println(bruteForceSubstring.substringSearch(text.toCharArray(),pattern.toCharArray()));
	}

	private boolean substringSearch(char[] text, char[] pattern) {
		for (int i = 0; i < text.length; i++) {
			if (text[i] == pattern[0]) {
				boolean isMatchAtX = substringSearchAtX(text,pattern, i);
				if (isMatchAtX)
					return true;
			}
		}
		return false;
	}

	private boolean substringSearchAtX(char[] text, char[] pattern, int start) {
		for (int i = 0; i < pattern.length; i++) {
			if ((i + start < text.length) || text[i + start] != pattern[i])
				return false;
		}
		return true;
	}
}
