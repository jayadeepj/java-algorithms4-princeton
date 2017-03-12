package dynamic.subsequence;

/**
 * Write a program Subsequence.java that takes a string command-line argument s
 * and an integer command-line argument k and prints out all subsequences of s
 * of length k.
 * 
 * abc abd acd bcd
 *
 */
public class StringSubsequence {

    /**
     * Solution 1
     * @param prefix
     * @param remaining
     * @param k
     */
    public static void print1(String prefix, String remaining, int k) {
        if (k == 0) {
            System.out.println(prefix);
            return;
        }
        if (remaining.length() == 0) return;
        print1(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        print1(prefix, remaining.substring(1), k);
    }

	/**
	 * Solution 2
	 * @param prefix
	 * @param remaining
	 * @param k
	 */
	private static void print2(String prefix, String remaining, int k)
	{
		if(prefix.length()==k)
			System.out.println(prefix);
		for (int i = 0; i < remaining.length(); i++) {
			print2(prefix+remaining.charAt(i), remaining.substring(i+1), k);
		}
	}
	
    public static void main(String[] args) { 
        String s = "abcde";
        int k = 3;
        System.out.println("********** Solution 1 **********");
        print1("", s, k);
        System.out.println("********** Solution 2 **********");
        print2("", s, k);
    }
}
