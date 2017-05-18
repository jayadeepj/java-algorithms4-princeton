package regex.simple;

public class BasicExpressions {
	public static void main(String[] args) {

		System.out.println();
		anyOrNoCharacterMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		anyCharacterMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		anySingleCharacterMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		someCharacterMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		anySingleDigitMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		charecterGroupingMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		charecterStartEndGroupingMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		
		System.out.println("\n----------------------------------------------------------------\n");
	}
	
	/**
	 * Any character or No Character (except \n newline)
	 * ^ B
	 */
	public static void anyOrNoCharacterMatch() {

		String anyCharRegex = ".*";
		String word1 = "Test Word";
		String word2 = "";
		String word3 = "184";
		
		System.out.println(" * >>  0 or more of previous expression. \n");
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word3 +"' >> "+word3.matches(anyCharRegex));
		
	}
	
	/**
	 * Some character or No Character (except \n newline)
	 * ^ B
	 */
	public static void someCharacterMatch() {

		String anyCharRegex = "A*B";
		String word1 = "AAAB";
		String word2 = "AAABCCC";
		String word3 = "AXCAB";
		
		System.out.println(" A B * >> match strings with an A followed by 0 or more Bs & not A-XYZ-B");
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word3 +"' >> "+word3.matches(anyCharRegex));
		
	}
	/**
	 * Any character (except \n newline)
	 * ^ B
	 */
	public static void anyCharacterMatch() {

		String anyCharRegex = ".+";
		String word1 = "Test Word";
		String word2 = "";
		String word3 = "184";
		
		System.out.println(" + >>  1 or more of previous expression. \n");
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word3 +"' >> "+word3.matches(anyCharRegex));
	}
	
	/**
	 * Any single character (except \n newline)
	 * ^ B
	 */
	public static void anySingleCharacterMatch() {

		String anyCharRegex = "Blue.?ell";
		String word1 = "BlueBell";
		String word2 = "Blueell";
		String word3 = "Blue ell";
		String word4 = "BlueBBell";
		
		System.out.println(" ? >>  0 or 1 of previous expression. \n");
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word3 +"' >> "+word3.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word4 +"' >> "+word4.matches(anyCharRegex));
	}
	
	/**
	 * Any single Digit (except \n newline)
	 * ^ B
	 */
	public static void anySingleDigitMatch() {

		String anyDigitRegex = "1000\\d?";
		String word1 = "10005";
		String word2 = "100055";
		String word3 = "10000";
		String word4 = "1000 5";
		
		System.out.println(" ? >>  0 or 1 of previous expression. \n");
		System.out.println(" Regex '"+anyDigitRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyDigitRegex));
		System.out.println(" Regex '"+anyDigitRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyDigitRegex));
		System.out.println(" Regex '"+anyDigitRegex +"' on word  '"+word3 +"' >> "+word3.matches(anyDigitRegex));
		System.out.println(" Regex '"+anyDigitRegex +"' on word  '"+word4 +"' >> "+word4.matches(anyDigitRegex));
	}
	
	/**
	 * Character Grouping Match
	 * ^ B
	 */
	public static void charecterGroupingMatch() {

		String anyCharRegex = "(red|green|blue)";
		String word1 = "red";
		String word2 = "black";
		
		System.out.println(" (...) >> Logical grouping of part of an expression.. \n");
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex));
		System.out.println(" Regex '"+anyCharRegex +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex));
	}
	
	/**
	 * Character Start & End Grouping Match
	 * ^ B
	 */
	public static void charecterStartEndGroupingMatch() {

		String anyCharRegex1 = "^(red|green|blue)-1000.*";
		String anyCharRegex2 = "((red|green|blue)-1000.*)$";
		String word1 = "red-1000-xx";
		String word2 = "xx-red-1000";
		
		System.out.println(" ^ >>  Start of a string.. ");
		System.out.println(" $ >>  End of a string.. \n");
		System.out.println(" Regex '"+anyCharRegex1 +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex1));
		System.out.println(" Regex '"+anyCharRegex1 +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex1));
		
		System.out.println(" Regex '"+anyCharRegex2 +"' on word  '"+word1 +"' >> "+word1.matches(anyCharRegex2));
		System.out.println(" Regex '"+anyCharRegex2 +"' on word  '"+word2 +"' >> "+word2.matches(anyCharRegex2));
	}
	

}
