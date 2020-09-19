package Chapter1;

public class Question5 {
	
	//https://www.geeksforgeeks.org/edit-distance-dp-5/
	
	//We will traverse both the strings simultaneously
	//If the characters at given position match, move to the next characters
	//If the characters don't match, then consider the cases:
	//1. If the strings have already observed one difference and this is the other difference, then return false straight away
	//2. If this is the first difference being encountered, then consider the lengths of the strings. If one string is greater in length than other, there is a possibility of edit.
	//Repeat until coundOfEdits becomes more than 1
	//Complexity: O(n)
	private boolean checkIfStringWasOperatedOnlyOnceMethod1(String string1, String string2) {
		int len1 = string1.length();
		int len2 = string2.length();
		
		if(Math.abs(len1 - len2) > 1) {
			return false;
		}
		
		int countOfEdits = 0;
		for(int i=0, j=0; (i<len1 && j<len2);) {
			if(string1.charAt(i) != string2.charAt(j)){
				if(countOfEdits == 1) {
					return false;
				}else {
					countOfEdits++;
					if(len1 > len2) {
						i++;
					}else if(len2 > len1) {
						j++;
					}else {
						i++;
						j++;
					}
				}
			}else {
				i++;
				j++;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String str1 = "peaks";
		String str2 = "eaksp";
		Question5 obj = new Question5();
		
		if(obj.checkIfStringWasOperatedOnlyOnceMethod1(str1, str2)) {
			System.out.println("Only one operation was performed on the string");
		}else {
			System.out.println("More than one operation was performed on the string");
		}
	}
}
