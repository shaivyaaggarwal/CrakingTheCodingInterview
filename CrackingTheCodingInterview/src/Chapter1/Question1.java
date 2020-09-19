package Chapter1;

import java.util.Arrays;

public class Question1 {
	
	//Here, we are not going to use any extra space. We are going to loop over the array of characters(string) and check if ith element matches any other element in the string.
	//If at any point, any two characters are same, we break the loop and return false.
	//Looping one inside the other. Complexity: O(n-square) or O(n2)
	private boolean checkIfAllCharactersAreUniqueMethod1(String str) {
		int len = str.length();
		if(len > 26)
			return false;
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//We can simply sort the string in ascending order and check if ith element matches (i+1)th element in the string.
	//If at any point, any two characters are same, we break the loop and return false.
	//Arrays.sort() complexity: O(nlogn) and simple loop: O(n). Hence, total complexity: O(nlogn)
	private boolean checkIfAllCharactersAreUniqueMethod2(String str) {
		char[] strChars = str.toCharArray();
		if(strChars.length > 26)
			return false;
		Arrays.sort(strChars);
		for(int i=0; i<strChars.length-1; i++) {
			if(strChars[i] == strChars[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	//This method is WHEN SOMEONE ASKS YOU "WITHOUT ANY DATA STRUCTURE". Please note that this solution is case sensitive.
	//We will use an int variable's bits(int has 32 bits). Please note that this is valid for strings having characters from a-z only.
	//When we iterate over a string, we find the int value of the character as: int bitAtIndex = str.charAt(i) - 'a';
	//Then the bit at that int value is set to 1 with the statement 1<<bitAtIndex. 
	//Now, if this bit is already set in the checker (checker & (1<<bitAtIndex)), the &(AND) operation would make checker>0. Return false in this case.
	//Else, make checker=1 at that bit using checker = checker | (1<<bitAtIndex)
	//Time complexity: O(n). Each bitwise operation is O(1)
	private boolean checkIfAllCharactersAreUniqueMethod3(String str) {
		if(str.length() > 26)
			return false;
		int checker = 0;
		for(int i=0; i<str.length(); i++) {
			int bitAtIndex = str.charAt(i) - 'a';
			if((checker & (1<<bitAtIndex)) > 0) {
				//This means that the bit in checker at poisition bitAtIndex is already 1. The character in the string already exists.
				return false;
			}
			checker = checker | (1<<bitAtIndex);
		}
		return true;
	}
	
	//Using Java8 streams
	//chars() converts string to an intStream of characters
	//distinct() method on the previous stream creates a new stream that contains onoy distinct characters from previous stream
	private boolean checkIfAllCharactersAreUniqueMethod4(String str) {
		return (str.chars().distinct().count() == str.length());
	}
	
	public static void main(String[] args) {
		String inputString = "StringToTestIfItHasAllTheCharactersAsUnique";
		Question1 object = new Question1();
		
		//Method 1
		if(object.checkIfAllCharactersAreUniqueMethod1(inputString)) {
			System.out.println("The String has all the unique characters");
		}else {
			System.out.println("The String has non-unique characters");
		}
		
		//Method2
		if(object.checkIfAllCharactersAreUniqueMethod2(inputString)) {
			System.out.println("The String has all the unique characters");
		}else {
			System.out.println("The String has non-unique characters");
		}
		
		//Method3
		if(object.checkIfAllCharactersAreUniqueMethod3(inputString)) {
			System.out.println("The String has all the unique characters");
		}else {
			System.out.println("The String has non-unique characters");
		}
		
		//Method3
		if(object.checkIfAllCharactersAreUniqueMethod4(inputString)) {
			System.out.println("The String has all the unique characters");
		}else {
			System.out.println("The String has non-unique characters");
		}
		
	}
}
