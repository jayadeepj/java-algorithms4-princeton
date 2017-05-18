package regex.simple;

public class AdvancedExpressions {
	public static void main(String[] args) {

		System.out.println();
		setOfCharectersAndComplement();
		System.out.println("\n----------------------------------------------------------------\n");
		rangeAndAlphaNumeric();
		System.out.println("\n----------------------------------------------------------------\n");
		complexDigitMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		decimalReplaceMatch();
		System.out.println("\n----------------------------------------------------------------\n");
		titleCapsifyIfExists();
		System.out.println("\n----------------------------------------------------------------\n");
		usefulPatterns();
		System.out.println("\n----------------------------------------------------------------\n");
		digitAndSpacePatterns();
		System.out.println("\n----------------------------------------------------------------\n");
		countPatterns();
		System.out.println("\n----------------------------------------------------------------\n");
		backReference1();
		System.out.println("\n----------------------------------------------------------------\n");
		backReference2();
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\n----------------------------------------------------------------\n");
	}

	/**
	 * Set Of Characters And Complement. Specified Set >> enclosed in [] &&
	 * Complement >> enclosed in [] preceded by ^
	 */
	public static void setOfCharectersAndComplement() {

		String onlyVowels = "[AEIOU]*";
		String noVowels = "[^AEIOU]*";
		String word1 = "XYZPQ";
		String word2 = "UAI";
		String word3 = "ABCDEF";

		System.out.println(" Specified Set >> enclosed in [] && Complement >> enclosed in [] preceded by ^");
		System.out .println(" Regex ' " + onlyVowels + " ' on string  ' " + word1 + " ' >> " + word1.matches(onlyVowels));
		System.out .println(" Regex ' " + onlyVowels + " ' on string  ' " + word2 + " ' >> " + word2.matches(onlyVowels));
		System.out .println(" Regex ' " + onlyVowels + " ' on string  ' " + word3 + " ' >> " + word3.matches(onlyVowels));

		System.out.println(" Regex ' " + noVowels + " ' on string  ' " + word1 + " ' >> " + word1.matches(noVowels));
		System.out.println(" Regex ' " + noVowels + " ' on string  ' " + word2 + " ' >> " + word2.matches(noVowels));
		System.out.println(" Regex ' " + noVowels + " ' on string  ' " + word3 + " ' >> " + word3.matches(noVowels));
	}

	/**
	 * Using Range
	 */
	public static void rangeAndAlphaNumeric() {

		String alphaNumeric = "[(A-Z)|(1-9)|(a-z)]*";
		String alphaNumericWithCapsPnly = "[(A-Z)|(1-9)]*";
		String word1 = "ABCD1234AV";
		String word2 = "AB CD1234 & AV";
		String word3 = "abcAB12";

		System.out.println(" [] with - >> Range");
		System.out.println( " Regex ' " + alphaNumeric + " ' on string  ' " + word1 + " ' >> " + word1.matches(alphaNumeric));
		System.out.println( " Regex ' " + alphaNumeric + " ' on string  ' " + word2 + " ' >> " + word2.matches(alphaNumeric));
		System.out.println( " Regex ' " + alphaNumeric + " ' on string  ' " + word3 + " ' >> " + word3.matches(alphaNumeric));

		System.out.println(" Regex ' " + alphaNumericWithCapsPnly + " ' on string  ' " + word1 + " ' >> " + word1.matches(alphaNumericWithCapsPnly));
		System.out.println(" Regex ' " + alphaNumericWithCapsPnly + " ' on string  ' " + word2 + " ' >> " + word2.matches(alphaNumericWithCapsPnly));
		System.out.println(" Regex ' " + alphaNumericWithCapsPnly + " ' on string  ' " + word3 + " ' >> " + word3.matches(alphaNumericWithCapsPnly));
	}


	/**
	 * Using Digits
	 */
	public static void complexDigitMatch() {

		String integersAndDouble = "^\\d{2,4}(\\.\\d+)?[a-z|A-Z|\\s]*";
		String word1 = "1234.1234";
		String word2 = "12345666.1234";
		String word3 = "1234";
		String word4 = "12$23";
		String word5 = "My salary is 1234.1234";
		String word6 = "1234.1234 is my Salary";

		System.out.println(" {X}  >> Occurs X number of times && {X,Y} Occurs between X and Y times.");
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word1 + " ' >> " + word1.matches(integersAndDouble));
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word2 + " ' >> " + word2.matches(integersAndDouble));
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word3 + " ' >> " + word3.matches(integersAndDouble));
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word4 + " ' >> " + word4.matches(integersAndDouble));
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word5 + " ' >> " + word5.matches(integersAndDouble));
		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word6 + " ' >> " + word6.matches(integersAndDouble));
	}

	/**
	 * Using Digits
	 */
	public static void decimalReplaceMatch() {

		String integersAndDouble = "(^\\d{2,4})(\\.\\d+)?([a-z|A-Z|\\s]*)";
		String word1 = "1234.1234 is my Salary";

		System.out.println(" Regex ' " + integersAndDouble + " ' on string  ' " + word1 + " ' >> " + word1.matches(integersAndDouble));
		System.out.println(" $1$3 Replace Regex ' " + integersAndDouble + " ' on string  ' " + word1 + " ' >> " + word1.replaceAll(integersAndDouble, "$1$3"));
	}

	/**
	 * Using Digits
	 */
	public static void titleCapsifyIfExists() {

		String titleMatch = "([a-z|A-Z]*\\.){1}([a-z|A-Z|\\s]*)";
		String word1 = "mr. Binzi Cao";
		String word2 = "Binzi Cao";

		System.out .println(" Regex ' " + titleMatch + " ' on string  ' " + word1 + " ' >> " + word1.matches(titleMatch));
		System.out.println(" Regex ' " + titleMatch + " ' on string  ' " + word2 + " ' >> " + word2.matches(titleMatch));
	}

	/**
	 * Other Useful Patterns
	 */
	public static void usefulPatterns() {

		String isNoNumberAtBeginning = "^[^\\d].*";
		String intersectionExcept = "([[a-z|1-9]&&[^bcd]])*";

		String word1 = "12abcd";
		String word2 = "xyz12";

		System.out.println(" ^ >>  Start of a string.. ");
		System.out.println(" [^X] >>  Complement of expression.. \n");
		System.out.println(" Regex '" + isNoNumberAtBeginning + "' on word  '" + word1 + "' >> "+ word1.matches(isNoNumberAtBeginning));
		System.out.println(" Regex '" + isNoNumberAtBeginning + "' on word  '" + word2 + "' >> " + word2.matches(isNoNumberAtBeginning));

		System.out.println(" Regex '" + intersectionExcept + "' on word  '" + word1 + "' >> " + word1.matches(intersectionExcept));
		System.out.println( " Regex '" + intersectionExcept + "' on word  '" + word2 + "' >> " + word2.matches(intersectionExcept));
	}

	/**
	 * must be of length 6. First character should not be a digit ( or ).
	 * 
	 * Second character should not be a lowercase vowel ( or ).
	 * 
	 * Third character should not be b, c, D or F.
	 * 
	 * Fourth character should not be a whitespace character ( \r, \n, \t, \f or
	 * <space> ).
	 * 
	 * Fifth character should not be a uppercase vowel ( or ).
	 * 
	 * Sixth character should not be a . or , symbol.
	 */
	public static void digitAndSpacePatterns() {

		String junkPattern1 = "\\D[^aeiou][^bcDF][^\\s][^AEIOU][^\\.,]";

		String junkPattern2 = "^\\D[^aeiou][^bcDF]\\S[^AEIOU][^\\.,]$";

		String word1 = "w12eE'";
		String word2 = "athink?";

		System.out.println(" Regex '" + junkPattern1 + "' on word  '" + word1 + "' >> " + word1.matches(junkPattern1));
		System.out.println(" Regex '" + junkPattern1 + "' on word  '" + word2 + "' >> " + word2.matches(junkPattern1));

		System.out.println(" Regex '" + junkPattern2 + "' on word  '" + word1 + "' >> " + word1.matches(junkPattern2));
		System.out.println(" Regex '" + junkPattern2 + "' on word  '" + word2 + "' >> " + word2.matches(junkPattern2));

	}

	/**
	 * write a regex that will match using the following conditions:
	 * 
	 * S should begin with or digits.
	 * 
	 * After that, should have or more letters (both lowercase and uppercase).
	 * 
	 * Then should end with up to . symbol(s). You can end with to . symbol(s),
	 * inclusively.
	 * 
	 */
	public static void countPatterns() {

		String junkPattern1 = "^\\d{1,2}[a-zA-Z]{3,}\\.{0,3}$";

		String word1 = "3threeormorealphabets....";
		String word2 = "3threeormorealphabets...";

		System.out.println("[xyz]{5,} >>   will match the character x, y or z 5 or more times. ");
		System.out.println(" Regex '" + junkPattern1 + "' on word  '" + word1 + "' >> " + word1.matches(junkPattern1));
		System.out.println(" Regex '" + junkPattern1 + "' on word  '" + word2 + "' >> " + word2.matches(junkPattern1));

	}
	
	public static void backReference1() {

		String palindrome = "(\\w)(\\w)(\\w)(\\w)y\\4\\3\\2\\1";

		String word1 = "malayalam";
		String word2 = "english";

		System.out.println("\\groupnumber >> This tool (\1 references the first capturing group) matches the same text as previously matched by the capturing group.");
		System.out.println(" Regex '" + palindrome + "' on word  '" + word1 + "' >> " + word1.matches(palindrome));
		System.out.println(" Regex '" + palindrome + "' on word  '" + word2 + "' >> " + word2.matches(palindrome));
	}
	
	/**
	 * String consists of 8 digits.String may have "" separator such that string gets divided
	 * in parts, with each part having exactly two digits. (Eg. 12-34-56-78)
	 * 
	 * Valid
	 * * * * * * * * * * 
	 * 12345678
	 * 
     * 12-34-56-87
	 * 
	 * 
	 * Invalid
	 * * * * * * * * * * 
	 * 1-234-56-78
	 * 
     * 12-45-7810
	 * 
	 */
	public static void backReference2() {

		String groupMatchPattern1 = "(\\d{2})(-?)(\\d{2})(-?)(\\d{2})(-?)(\\d{2})";
		String groupMatchPattern2 = "^(\\d{2})(-?)(\\d{2})(\\2)(\\d{2})(\\2)(\\d{2})$";

		String word1 = "12-34-56-78";
		String word2 = "12-45-7810";

		System.out.println("\\groupnumber >> This tool (\1 references the first capturing group) matches the same text as previously matched by the capturing group.");
		System.out.println(" Regex '" + groupMatchPattern1 + "' on word  '" + word1 + "' >> " + word1.matches(groupMatchPattern1));
		System.out.println(" Regex '" + groupMatchPattern1 + "' on word  '" + word2 + "' >> " + word2.matches(groupMatchPattern1));
		
		System.out.println(" Regex '" + groupMatchPattern2 + "' on word  '" + word1 + "' >> " + word1.matches(groupMatchPattern2));
		System.out.println(" Regex '" + groupMatchPattern2 + "' on word  '" + word2 + "' >> " + word2.matches(groupMatchPattern2));
	}
	
}
