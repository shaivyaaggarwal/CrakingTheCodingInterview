package Chapter1;

public class Question9 {

	//Check if one word is a rotation of another 
	//If we append the rotated string with itself and search for original string to be a substring, if found, the rotated string is a rotation of original string
	private boolean isRotationOfOriginalString(String originalStr, String rotatedStr) {
		String rotatedString = rotatedStr+rotatedStr;
		
		//Method 1
//		if(rotatedString.contains(originalStr)) {
//			return true;
//		}
		
		//Method2
		if(rotatedString.indexOf(originalStr) != -1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String originalString = "waterbottle";
		String rotatedString1 = "terbottlewa";
		String rotatedString2 = "trebottlewa";
		Question9 object = new Question9();
		
		if(object.isRotationOfOriginalString(originalString, rotatedString1)) {
			System.out.println(rotatedString1+" is a rotation of "+originalString);
		}else {
			System.out.println(rotatedString1+" is not a rotation of "+originalString);
		}
		
		if(object.isRotationOfOriginalString(originalString, rotatedString2)) {
			System.out.println(rotatedString2+" is a rotation of "+originalString);
		}else {
			System.out.println(rotatedString2+" is not a rotation of "+originalString);
		}
	}
}
