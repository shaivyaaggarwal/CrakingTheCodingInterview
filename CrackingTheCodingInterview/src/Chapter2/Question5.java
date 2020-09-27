package Chapter2;

public class Question5 {

	static class Node{
		int data;
		Node next;
	}
	
	public static Node push(Node headRef, int d) {
		Node newNode = new Node();
		newNode.data = d;
		newNode.next = headRef;
		headRef = newNode;
		return headRef;
	}

	public static void printLinkedList(Node headRef) {
		Node reverseHead = reverse(headRef);
		Node temp = reverseHead;
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}
	
	private static Node reverse(Node headRef) { 
		Node reverseHeadRef = headRef;
        Node prev = null; 
        Node next = null; 
        Node current = reverseHeadRef; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        reverseHeadRef = prev; 
        return reverseHeadRef; 
    } 

	public static Node pushToEnd(Node headRef, int d) {
		Node newNode = new Node();
		newNode.data = d;
		newNode.next = null;
		
		if(headRef == null) {
			headRef = newNode;
		}else {
			Node temp = headRef;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return headRef;
	}
	
	public static void addNumbers(Node headRef1, Node headRef2) {
		int carry = 0;
		Node temp1 = headRef1;
		Node temp2 = headRef2;
		Node sumRef = null;
		int sum = 0;
		
		while(temp1 != null || temp2 != null) {
			if(temp1 != null && temp2 != null ) {
				sum = temp1.data + temp2.data + carry;
				temp1 = temp1.next;
				temp2 = temp2.next;
			}else if(temp1 != null) {
				sum = temp1.data +carry;
				temp1 = temp1.next;
			}else if(temp2 != null){
				sum = temp2.data +carry;
				temp2 = temp2.next;
			}
			carry = (int) sum/10;
			sumRef = pushToEnd(sumRef, (sum % 10));
		} 
		
		System.out.print("The sum of the numbers ");
		printLinkedList(headRef1);
		System.out.print(" and ");
		printLinkedList(headRef2);
		System.out.print(" is:");
		printLinkedList(sumRef);
	}
	
	public static void main(String[] args) {
		Node headNumber1 = null;
		Node headNumber2 = null;
		
		//First number is 617
		headNumber1 = push(headNumber1, 6);
		headNumber1 = push(headNumber1, 1);
		headNumber1 = push(headNumber1, 7);
		
		//Second number is 295
		headNumber2 = push(headNumber2, 2);
		headNumber2 = push(headNumber2, 9);
		headNumber2 = push(headNumber2, 5);
		
		addNumbers(headNumber1, headNumber2);
	}
}
