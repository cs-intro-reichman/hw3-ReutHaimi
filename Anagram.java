/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String firstString = preProcess(str1);
		String otherString = preProcess(str2);

		for(int i=0; i<firstString.length(); i++){
			int j=0;
			if(firstString.charAt(i) != ' ')
				{
			while (firstString.charAt(i) != otherString.charAt(j)) {
				j++;
				if (j == firstString.length()){
					return false;
			}
		}
		}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		if(str.isEmpty()) return str;
		String result ="";
		char currentChar = str.charAt(0);
		if (currentChar >= 'a' && currentChar <='z'){
			result = "" + currentChar;
		}
		else if(currentChar >= 'A' && currentChar <= 'Z') 
		{
			currentChar += 32;
			result = "" + currentChar;
		}

		for ( int i = 1 ; i < str.length() ; i ++) {
			currentChar = str.charAt(i);
			if (currentChar >= 'A' && currentChar <= 'Z'){
				currentChar += 32;
				result = result +currentChar;
			}
			else if (currentChar >= 'a' && currentChar <='z'){
				result = result + currentChar;
			}
		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String inputString = str;
		char [] StringChars = str.toCharArray();
		char currentChar; 
		String answer = "";
		
		for (int i =0 ; i <= StringChars.length - 1 ; i++){
			int num = (int)(inputString.length() * Math.random());
			currentChar = StringChars [i];
			StringChars [i] = StringChars [num];
			StringChars [num] = currentChar ; 
	}

	for (int i = 0; i <= StringChars.length - 1 ; i++) {
		answer = answer + StringChars [i];
		
	}
	return answer; 
}

}