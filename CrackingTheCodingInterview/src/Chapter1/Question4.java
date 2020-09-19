package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question4 {
	
	//Initialize a character array of size 256 to check for all ASCII characters.
	//Loop over the string and increment the count for the ASCII character
	//Loop over the array and if more than one count found to be odd, then the string is not a palindrome.
	//Complexity: O(n)
	private boolean checkPalindromePermutationMethod1(String str) {
		int[] countOfCharacters = new int[256];
		Arrays.fill(countOfCharacters, 0);
		for(int i=0; i<str.length(); i++) {
			countOfCharacters[(int)(str.charAt(i))]++; 
		}
		
		int noOfOdds = 0;
		for(int i=0; i<256; i++) {
			if((countOfCharacters[i] % 2) > 0) {
				noOfOdds++;
			}
			if(noOfOdds > 1) {
				return false;
			}
		}
		return true;
	}
	
	//Create a character list. Traverse the string. For every character in the string, remove the character if the list already contains it else add it to the list.
	//If the string length is even, the list should be empty
	//If the string length is odd, the list should have one element
	//Complexity of list.remove() is O(n) and list.add() is O(1)
	//One loop and inside that list.remove is there. So, final complexity: O(nm)
	private boolean checkPalindromePermutationMethod2(String str) {
		List<Character> list = new ArrayList<Character>();
		int len = str.length();
		
		for(int i=0; i<len; i++){
			if(list.contains(str.charAt(i))) {
				list.remove((Character)str.charAt(i));
			}else {
				list.add(str.charAt(i));
			}
		}
		
		if(len % 2 == 0 && list.isEmpty()) {
			return true;
		}else if(len % 2 == 1 && list.size() == 1) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		String testPalindromeString1 = "tacocat";
		String testPalindromeString2 = "notataco";
	
		Question4 obj = new Question4();
		
		if(obj.checkPalindromePermutationMethod1(testPalindromeString1)) {
			System.out.println("The String: '" + testPalindromeString1 + "' is a palindrome");
		}else {
			System.out.println("The String: '" + testPalindromeString1 + "' is not a palindrome");
		}
		
		if(obj.checkPalindromePermutationMethod1(testPalindromeString2)) {
			System.out.println("The String: '" + testPalindromeString2 + "' is a palindrome");
		}else {
			System.out.println("The String: '" + testPalindromeString2 + "' is not a palindrome");
		}
		
		if(obj.checkPalindromePermutationMethod2(testPalindromeString1)) {
			System.out.println("The String: '" + testPalindromeString1 + "' is a palindrome");
		}else {
			System.out.println("The String: '" + testPalindromeString1 + "' is not a palindrome");
		}
		
		if(obj.checkPalindromePermutationMethod2(testPalindromeString2)) {
			System.out.println("The String: '" + testPalindromeString2 + "' is a palindrome");
		}else {
			System.out.println("The String: '" + testPalindromeString2 + "' is not a palindrome");
		}
	}
}
