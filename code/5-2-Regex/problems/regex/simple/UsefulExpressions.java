package regex.simple;

public class UsefulExpressions {
	public static void main(String[] args) {

		System.out.println();
		emailIDMatcher();
		System.out.println("\n----------------------------------------------------------------\n");
		ipV4Matcher();
		System.out.println("\n----------------------------------------------------------------\n");
		ipV6Matcher();
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\n----------------------------------------------------------------\n");
		System.out.println("\n----------------------------------------------------------------\n");
	}


	/**
	 */
	public static void emailIDMatcher() {

		String alphaNumericIncludingSpace = "[(A-Z)|(1-9)|(a-z)|(\\s)]*";
		String emailIDRegex = "[(A-Z)|(1-9)|(a-z)]+@[(A-Z)|(1-9)|(a-z)]+\\.(com|org|net)";
		String betterEmailIDRegex = "[0-­9a-­zA-Z]+@[0-­9a-­zA-Z]+\\.(com|org|net)";
		String evenBetterEmailIDRegex = "[\\w]+@[\\w]+\\.(com|org|net)";

		String word1 = "ABCD1234AV";
		String word2 = "AB CD1  234  AV";
		String word3 = "abcAB12";

		String mail1 = "abc@yahoo.com";
		String mail2 = "abc@yahoo com";
		String mail3 = "abc@yahoo.in";
		String mail4 = "@yahoo.in";

		System.out.println(" [] with - >> Range && \\s >> Matches any white­space character.");
		System.out.println(" Regex ' " + alphaNumericIncludingSpace + " ' on string  ' " + word1 + " ' >> " + word1.matches(alphaNumericIncludingSpace));
		System.out.println(" Regex ' " + alphaNumericIncludingSpace + " ' on string  ' " + word2 + " ' >> " + word2.matches(alphaNumericIncludingSpace));
		System.out.println(" Regex ' " + alphaNumericIncludingSpace + " ' on string  ' " + word3 + " ' >> " + word3.matches(alphaNumericIncludingSpace));

		System.out.println( " Regex ' " + emailIDRegex + " ' on string  ' " + mail1 + " ' >> " + mail1.matches(emailIDRegex));
		System.out.println( " Regex ' " + emailIDRegex + " ' on string  ' " + mail2 + " ' >> " + mail2.matches(emailIDRegex));
		System.out.println( " Regex ' " + emailIDRegex + " ' on string  ' " + mail3 + " ' >> " + mail3.matches(emailIDRegex));
		System.out.println( " Regex ' " + emailIDRegex + " ' on string  ' " + mail4 + " ' >> " + mail4.matches(emailIDRegex));

		System.out.println(" Regex ' " + betterEmailIDRegex + " ' on string  ' " + mail1 + " ' >> " + mail1.matches(betterEmailIDRegex));
		System.out.println(" Regex ' " + betterEmailIDRegex + " ' on string  ' " + mail2 + " ' >> " + mail2.matches(betterEmailIDRegex));
		System.out.println(" Regex ' " + betterEmailIDRegex + " ' on string  ' " + mail3 + " ' >> " + mail3.matches(betterEmailIDRegex));
		System.out.println(" Regex ' " + betterEmailIDRegex + " ' on string  ' " + mail4 + " ' >> " + mail4.matches(betterEmailIDRegex));

		System.out.println(" \\w  >> Matches any word character If ECMAScript­compliant behavior is specified with the ECMAScript option, \\w is equivalent to [a­zA­Z_0­9].");
		System.out.println(" Regex ' " + evenBetterEmailIDRegex + " ' on string  ' " + mail1 + " ' >> " + mail1.matches(evenBetterEmailIDRegex));
		System.out.println(" Regex ' " + evenBetterEmailIDRegex + " ' on string  ' " + mail2 + " ' >> " + mail2.matches(evenBetterEmailIDRegex));
		System.out.println(" Regex ' " + evenBetterEmailIDRegex + " ' on string  ' " + mail3 + " ' >> " + mail3.matches(evenBetterEmailIDRegex));
		System.out.println(" Regex ' " + evenBetterEmailIDRegex + " ' on string  ' " + mail4 + " ' >> " + mail4.matches(betterEmailIDRegex));
	}

	public static boolean ipV4Matcher1() {

		String ipv4Pattern = "(\\d{1,3})(\\.)(\\d{1,3})(\\.)(\\d{1,3})(\\.)(\\d{1,3})";
		String ipv4Pattern2 = "((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))(\\.)((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))(\\.)((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))(\\.)((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))";

		String add1 = "0";
		String address = "255.8.123.56";

		boolean isIpV4 = true;
		if(address.matches(ipv4Pattern)){
			String[] arr = address.split("\\.");
			for (String element:arr) {
				if(Integer.parseInt(element) > 255)
					isIpV4 = false;
			}
		}
		else
			isIpV4 = false;
		
		System.out.println(" Regex '" + ipv4Pattern + "' on word  '" + address + "' >> " +isIpV4);
		
		System.out.println(" Regex ' " + ipv4Pattern2 + " ' on string  ' " + address + " ' >> " + address.matches(ipv4Pattern2));
		
		return isIpV4;
		
	}
	
	public static boolean ipV4Matcher() {

		String ipv4Pattern = "(((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))(\\.)){3}((00)?[0-9]|0?[0-9][0-9]|(([0-1][0-9][0-9])|(2[0-5][0-5])))";
		String address = "255.8.123.56";
		String address1 = "121.18.19.20";
		System.out.println(" Regex ' " + ipv4Pattern + " ' on string  ' " + address + " ' >> " + address.matches(ipv4Pattern));
		System.out.println(" Regex ' " + ipv4Pattern + " ' on string  ' " + address1 + " ' >> " + address1.matches(ipv4Pattern));
		return address.matches(ipv4Pattern);
		
	}
	
	public static boolean ipV6Matcher() {
		String ipv6Pattern = "([0-9a-fA-F]{0,4}\\:){7}([0-9a-fA-F]{0,4})";
		String address = "2001:0db8:0000:0000:0000:ff00:0042:8329";
		String address1= "2001:0db8:0:0:0:ff00:0042:8329";
		System.out.println(" Regex ' " + ipv6Pattern + " ' on string  ' " + address + " ' >> " + address.matches(ipv6Pattern));
		System.out.println(" Regex ' " + ipv6Pattern + " ' on string  ' " + address1 + " ' >> " + address1.matches(ipv6Pattern));
		return address.matches(ipv6Pattern);
	}
	
}
