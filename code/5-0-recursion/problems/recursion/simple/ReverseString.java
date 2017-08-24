package recursion.simple;

/**
 * Reverse A String recursively
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseStringRecursive("AbcDeF"));
		System.out.println(reverseStringNonRecursive("AbcDeF"));
		System.out.println(anotherReverseStringRecursive("AbcDeF", "AbcDeF".length() - 1, ""));
	}

	/**
	 * ABCDE -> E+reverse(ABCD) -> ED+reverse(ABC)
	 *
	 * @param val
	 * @return
	 */
	private static String reverseStringRecursive(String val) {
		int len = val.length();
		if (len <= 1)
			return val;
		return reverseStringRecursive(val.substring(1, len)) + val.substring(0, 1);
	}

	public static String anotherReverseStringRecursive(String text, int index, String reversedString) {
		if (index == -1)
			return reversedString;

		return anotherReverseStringRecursive(text, index - 1, reversedString + text.charAt(index));
	}

	private static String reverseStringNonRecursive(String val) {
		char[] orig = val.toCharArray();
		char[] newVal = new char[orig.length];
		for (int i = orig.length - 1; i >= 0; i--) {
			newVal[orig.length - 1 - i] = orig[i];
		}
		return String.valueOf(newVal);
	}
}
