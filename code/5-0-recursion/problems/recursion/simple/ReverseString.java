package recursion.simple;

/**
 * Reverse A String recursively
 */
public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseStringRecursive("AbcDeF"));
		System.out.println(reverseStringNonRecursive("AbcDeF"));
	}

	private static String reverseStringRecursive(String val) {
		int len = val.length();
		if (len <= 1)
			return val;
		return reverseStringRecursive(val.substring(1, len)) + val.substring(0, 1);
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
