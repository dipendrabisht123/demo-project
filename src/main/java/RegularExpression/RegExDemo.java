package RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	public static void main(String[] args) {
		regularExpression();

	}

	
	public static void regularExpression(){
		
		String sAlphaNumaric = "abcddEEEf1234abcgggghijkabc";
		// Find any character between the brackets
		String sRegEx = "[adf]";
		System.out.println(sAlphaNumaric.replaceAll(sRegEx, "X"));
		
		Pattern pattern = Pattern.compile(sRegEx);
		Matcher matcher = pattern.matcher(sAlphaNumaric);
		System.out.println(matcher.find());
		
		// Validates input string should only have lower or upper case albphabats and numbers form 0 to 9 
		sRegEx = "[A-Za-z0-9]+";
		pattern = Pattern.compile(sRegEx);
		matcher = pattern.matcher(sAlphaNumaric);
		System.out.println("Pattern matches whole string: " + matcher.matches());
		
		// Ignore case sensitivity: Validates input string should only have lower or upper case albphabats and numbers form 0 to 9
		sRegEx = "(?i)[a-z0-9]+";
		pattern = Pattern.compile(sRegEx);
		matcher = pattern.matcher(sAlphaNumaric);
		System.out.println("Pattern matches whole string (Inactive cases sensitivity): " + matcher.matches());
		
		sRegEx = "[\\w\\d]+";
		pattern = Pattern.compile(sRegEx);
		matcher = pattern.matcher(sAlphaNumaric);
		System.out.println("Pattern matches whole string (with character classess ): " + matcher.matches());
		
		/*// Find any character NOT between the brackets
		sRegEx = "[^abc]";
		System.out.println(sAlphaNumaric.replaceAll(sRegEx, "X"));
		pattern = Pattern.compile(sRegEx);
		matcher = pattern.matcher(sAlphaNumaric);
		System.out.println(matcher.find());
		
		// Find any character between the brackets (numaric)
		System.out.println(sAlphaNumaric.replaceAll("[123]", "X"));
		
		// Find any character NOT between the brackets (numaric)
		System.out.println(sAlphaNumaric.replaceAll("[^123]", "X"));
		
		System.out.println(sAlphaNumaric.replaceAll("(a|d)", "X"));
		
		// Find a single character, except newline or line terminator
		System.out.println(sAlphaNumaric.replaceAll(".", "X"));
		
		
		// Find a word character
		System.out.println(sAlphaNumaric.replaceAll("\\w", "X"));
		
		String sAlphaNumaricSpecialChar = "abcddEEEf1234@#gggghijkabc";
		
		// Find a non-word character
		System.out.println(sAlphaNumaricSpecialChar.replaceAll("\\W", "X"));
		
		// Find a digit character
		System.out.println(sAlphaNumaric.replaceAll("\\d", "X"));
		
		// Find a non-digit character
		System.out.println(sAlphaNumaric.replaceAll("\\D", "X"));
		
		String sStringWithTabSpace = "Hi there,	my name is Dipendra";
		
		// Find a whitespace character
		System.out.println(sStringWithTabSpace.replaceAll("\\s", "-"));
		
		// Find a non-whitespace character
		System.out.println(sStringWithTabSpace.replaceAll("\\S", "-"));
		
		// Find a match at the beginning/end of a word, beginning like this: \bHI, end like this: HI\b
		System.out.println(sStringWithTabSpace.replaceAll("\\bHi", "-"));
		System.out.println(sStringWithTabSpace.replaceAll("Dipendra\\b", "-"));

		

		//Find a match but not at the beginning/end
		System.out.println(sAlphaNumaric.replaceAll("\\Babc", "-"));
		
		String sAlphaNumaric_1 = "aabcddEEEf1234aabcgggghijkaabc";
		
		// n*  :  Matches any string that contains zero or more occurrences of n
		System.out.println(sAlphaNumaric_1.replaceAll("a*", "X"));
		System.out.println(sAlphaNumaric_1.replaceAll("\\s*", "_"));
		
		// n*  :  Matches any string that contains zero or one occurrences of n
		System.out.println(sAlphaNumaric_1.replaceAll("a?", "X"));
		
		// n+  :  Matches any string that contains at least one n (one or more)
		System.out.println(sAlphaNumaric_1.replaceAll("a+", "X"));
				
		// n{X}  :  Matches any string that contains a sequence of X n's
		System.out.println(sAlphaNumaric.replaceAll("E{2}", "X"));
		
		// ^n  :  Matches any string with n at the beginning of it
		System.out.println(sAlphaNumaric.replaceAll("^[abc]", "X"));
		
		// n$  :  Matches any string with n at the beginning of it
		System.out.println(sAlphaNumaric.replaceAll("abc$", "X"));
		
		// ?=n  : Matches any string that is followed by a specific string n
		System.out.println(sAlphaNumaric.replaceAll("(?=f)", "X"));
		
		sStringWithTabSpace = "Hi  there,	my name is Dipendra";
		System.out.println(sStringWithTabSpace.replaceAll("Hi(\\s+)there", "X"));
		System.out.println(sStringWithTabSpace.replaceAll(".", "X"));
		System.out.println(sStringWithTabSpace.replaceAll(".*", "X")); // 1 X for 0 occurance and 1 for everything else
		System.out.println(sStringWithTabSpace.replaceAll(".+", "X")); // 1 X for 0 occurance and 1 for everything else
		
		String sAlphaNumaric_2 = "aabcddEEEf1234aabcgggghijkaabc";
		
		// Matches if character is followed by another character
		System.out.println(sAlphaNumaric_2.replaceAll("[aEi][fj]", "-"));*/
		
		
		// Matching an email pattern
		
		String sEmail = "abced_daf@gmail.com";
		pattern = Pattern.compile("(.*)@(.*)");
		matcher = pattern.matcher(sEmail);
		System.out.println(matcher.matches());
		
		sEmail = "@gmail.com";
		pattern = Pattern.compile("(.+)@(.*)");
		matcher = pattern.matcher(sEmail);
		System.out.println(matcher.matches());
		
		sEmail = "Aa4445saf_sa@gmail.com";
		// Both are fine
//		pattern = Pattern.compile("^[A-Za-z0-9_]+@[a-z]+(.)com$");
		pattern = Pattern.compile("^[A-Za-z0-9]+([\\w\\W\\d])+@[a-z]+(.)com$");
		matcher = pattern.matcher(sEmail);
		System.out.println(matcher.matches());
		
		// Find a word character
				System.out.println(sAlphaNumaric.replaceAll("\\w", "X"));
		
		
	}
}
