package Chapter1;

public class Question3 {
	
	//First, we will calculate the actual length required for a URLified string
	//Then we will start from the end of the string and start populating the characters %,2,0 in place of space.
	//We can then return the string by converting characters array to String
	//Time Complexity: O(n)
	private String urlifyStringMethod1(String str) {
		char[] charArray = str.toCharArray();
		int numOfSpaces = 0;
		for(int i=0; i<charArray.length; i++) {
			if(charArray[i] == ' ') {
				numOfSpaces++;
			}
		}
		
		int newLength = str.length()+numOfSpaces*3;
		char[] newCharArray = new char[newLength];
		
		for(int i=0,j=0;i<charArray.length;i++) {
			if(charArray[i] == ' ') {
				newCharArray[j] = '%';
				newCharArray[j+1] = '2';
				newCharArray[j+2] = '0';
				j+=3;
			} else {
				newCharArray[j] = charArray[i];
				j++;
			}
		}
		return String.valueOf(newCharArray);
	}
	
	//We will use String class's replace method. Keep in mind that simple replacing of " " would not work.
	private String urlifyStringMethod2(String str) {
		str = str.trim();
		str = str.replaceAll("\\s", "%20");
		return str;
	}
	
	public static void main(String[] args) {
		String urlifyMe = "Hi there,I am going to be URLified";
		Question3 object = new Question3();
		System.out.println("The URLified string is :"+object.urlifyStringMethod1(urlifyMe));
		System.out.println("The URLified string is :"+object.urlifyStringMethod2(urlifyMe));
	}
}
