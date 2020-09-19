package Chapter1;

public class Question6 {
	
	//We start from the start of the string and create a StringBuilder object and counter=1
	//Keep iterating until same character is found. Keep incrementing the counter.
	//As soon as you encounter a different character at i+1th position, add the character and count to StringBuilder and reset counter to 1
	//Once out of the loop, append everything left at the end of StringBuilder object
	//Convert the stringBuilder object to String object and return the compressed string
	//Complexity: O(n)
	private String compressString(String str) {
		StringBuilder compressedString = new StringBuilder();
		int count = 1;
		int i=0;
		for(;i<str.length()-1;i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				count++;
			}else {
				compressedString.append(str.charAt(i));
				compressedString.append(String.valueOf(count));
				count = 1;
			}
		}
		compressedString.append(str.charAt(i));
		compressedString.append(String.valueOf(count));
		if(checkIfStringHasOnly1Indigits(compressedString.toString())) {
			return str;
		}
		return compressedString.toString();
	}
	
	private boolean checkIfStringHasOnly1Indigits(String compressedString) {
		char[] characterArray = compressedString.toCharArray();
		for(int i=0; i<characterArray.length;i++) {
			if(!(characterArray[i] >= 'a' && characterArray[i] <= 'z') && !(characterArray[i] >= 'A' && characterArray[i] <= 'Z')) {
				if(characterArray[i] != '1') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String testString1 = "aaaaffffgggghhhhuooaa";
		String testString2 = "abcdefgh";
		Question6 obj = new Question6();
		
		System.out.println("The String compression for "+testString1+" is:"+obj.compressString(testString1));
		System.out.println("The String compression for "+testString2+" is:"+obj.compressString(testString2));
	}
}
