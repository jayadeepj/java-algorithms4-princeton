package regex.simple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * If you are reusing the Pattern object then there will be some performance
 * benefit. Also when using Pattern/Matcher you can group your regular
 * expressions and get the matching parts.
 * 
 * The bottom-line is if you have a regex that you will use only once and you
 * don't need to parse your string to get matching parts then use either. But if
 * you are going to use the same regex against multiple strings or you need
 * parts of the String based on regex create a Pattern and get Matcher using it.
 *
 */
public class JavaPatternMatcher {

	public static void main(String[] args) {
		System.out.println();
		simplePatternMatchAndFind();
		System.out.println("\n----------------------------------------------------------------\n");
		wordBoundaryPatterns();
	}

	private static void simplePatternMatchAndFind() {
		String sentence1 = "The old url is http://google.com & the new url is http://google.co.in ";
		String pattern1 = ".*http://.*";
		String pattern2 = "http://.*";
		
		Pattern compiledPattern1 = Pattern.compile(pattern1);
		Matcher matcher1 = compiledPattern1.matcher(sentence1);
		
		Pattern compiledPattern2 = Pattern.compile(pattern2);
		Matcher matcher2 = compiledPattern2.matcher(sentence1);
		

		System.out.println("Match >> The pattern ' "+compiledPattern1.pattern()+" ' Match for string ' "+sentence1+" ' is >> "+matcher1.matches());
		System.out.println("Match >> The pattern ' "+compiledPattern2.pattern()+" ' Match for string ' "+sentence1+" ' is >> "+matcher2.matches());
		System.out.println("Find >> The pattern ' "+compiledPattern2.pattern()+" ' Find for string ' "+sentence1+" ' is >> "+matcher2.find());
		matcher2.reset();
		
		while(matcher2.find()){
			System.out.println("The pattern start index ' "+compiledPattern2.pattern()+" ' find for string ' "+sentence1+" ' is >> "+matcher2.start() +" end index is >> "+matcher2.end());
		}
	}

	/**
	 * Your task is to write a regex which will match word starting with vowel
	 * (a,e,i,o, u, A, E, I , O or U). The matched word can be of any length.
	 * The matched word should consist of letters (lowercase and uppercase both)
	 * only. The matched word must start and end with a word boundary.
	 */
	public static void wordBoundaryPatterns() {

		Pattern junkPattern1 = Pattern.compile("\\b[aeiouAEIOU][a-zA-Z]*\\b");

		String word1 = "Found any match?";
		String word2 = "Found No words?";
		
		Matcher matcher1 = junkPattern1.matcher(word1);
		Matcher matcher2 = junkPattern1.matcher(word2);

		System.out.println("\b assert position at a word boundary.>> hence can be used to search for words in a string");
		System.out.println("\b >> Three different positions qualify for word boundaries :"
				+ " Before the first character in the string, if the first character is a word character. "
				+ "Between two characters in the string, where one is a word character and the other is not a word character."
				+ "After the last character in the string, if the last character is a word character.");
		System.out.println(" Regex '" + junkPattern1.pattern() + "' on word  '" + word1 + "' >> " + matcher1.find());
		System.out.println(" Regex '" + junkPattern1.pattern() + "' on word  '" + word2 + "' >> " + matcher2.find());

	}
}
