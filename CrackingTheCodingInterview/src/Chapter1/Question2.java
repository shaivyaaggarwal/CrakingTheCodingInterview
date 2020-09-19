package Chapter1;

import java.util.Arrays;

public class Question2 {
	
	//We will convert both strings to character arrays and sort them.
	//Then we will compare the sorted arrays and if at any point, the characters are not same, we return false 
	//Arrays.sort() takes O(nlogn) time and one loop takes O(n) time. So final complexity: O(nlogn)
	private boolean checkIfStringsArePermutationsMethod1(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		char[] str1Chars = str1.toCharArray();
		char[] str2Chars = str2.toCharArray();
		
		Arrays.sort(str1Chars);
		Arrays.sort(str2Chars);
		
		for(int i=0;i<str1Chars.length;i++) {
			if(str1Chars[i] != str2Chars[i]) {
				return false;
			}
		}
		return true;
	}
	
	//We will create a 256 chars array considering any character can be in the string.
	//Loop over the first string, increment the count in the character array for position of each character
	//Loop over the second string, decrement the count in the character array for the position of each character
	//Loop over the character array and if any element has count!=0, return false
	//Complexity: O(n)
	private boolean checkIfStringsArePermutationsMethod2(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		int[] charArray = new int[256];
		Arrays.fill(charArray, 0);
		
		for(int i=0;i<str1.length();i++) {
			charArray[str1.charAt(i)]++;
			charArray[str2.charAt(i)]--;
		}
		
		for(int i=0;i<charArray.length; i++) {
			if(charArray[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String testStr1 = "shaivyaaggarwal";
		String testStr2 = "walaggarvyashai";
		Question2 object = new Question2();
		
		//Method 1
		if(object.checkIfStringsArePermutationsMethod1(testStr1, testStr2)) {
			System.out.println("Both strings are permutations of each other");
		}else {
			System.out.println("Both strings are not permutations of each other");
		}
		
		//Method 2
		if(object.checkIfStringsArePermutationsMethod2(testStr1, testStr2)) {
			System.out.println("Both strings are permutations of each other");
		}else {
			System.out.println("Both strings are not permutations of each other");
		}
	}
}
