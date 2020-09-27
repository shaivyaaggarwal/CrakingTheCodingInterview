package Chapter2;

import java.util.Stack;

public class Question6 {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method 1
	// To check if a linked list is a palindrome, we can traverse the linked list and push each element on to a stack.
	// The stack will basically pop the linked list in reverse, so we can traverse the linked list again and compare element with stack.popped element.
	public boolean checkLinkedListIsPalindromeMethod1() {
		Node temp = head;
		boolean isPalindrome = true;
		Stack<Integer> stack = new Stack<>();
		while(temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		
		temp = head;
		while(temp != null) {
			if(temp.data != stack.pop()) {
				isPalindrome = false;
				break;
			}
			temp = temp.next;
		}
		
		return isPalindrome;
	}
	
	//Method 2
	//Using 2 pointers fast and slow, we first reach the half of the linked list
	//We can reverse the second half of the linked list and compare both the halves.
	//If they are equal, then the linked list is a palindrome.
	//Else, it is not
	public boolean checkLinkedListIsPalindromeMethod2(){
		Node slow = head;
		Node fast = head;
		Node firstHalf = head;
		Node middle = null;
		boolean isPalindrome = true;
		
		while(fast != null && fast.next != null) {
			firstHalf = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println("Slow pointer is at the middle of the linked list: "+slow.data);
		
		//Fast pointer will be null in case of even number of elements in LL. And not-null in case of odd number of elements in LL.
		//In case of odd numbers, we will store middle element someplace so that we can reconstruct it back
		if(fast != null) {
			middle = slow;
			slow = slow.next;
		}
		
		//Now, we will reverse the second half which starts from slow pointer position
		Node secondHalf = slow;
		firstHalf.next = null;
		secondHalf = reverse(secondHalf);
		
		//Compare the data of first and second half. Keep in mind, if the length of linked list is odd, then the middle element is not considered.
		isPalindrome = compareDataOfLinkedLists(head, secondHalf); 
		
		//We have got the result in upper statement. We just need to reconstruct the linked list back
		secondHalf = reverse(secondHalf);
		if(middle != null) {
			firstHalf.next = middle;
			middle.next = secondHalf;
		}else {
			firstHalf.next = secondHalf;
		}
		
		return isPalindrome;
	}
	
	public static boolean compareDataOfLinkedLists(Node firstHalf, Node secondHalf) {
		Node temp1 = firstHalf; 
        Node temp2 = secondHalf; 
        
        while (temp1 != null && temp2 != null) { 
            if (temp1.data == temp2.data) { 
                temp1 = temp1.next; 
                temp2 = temp2.next; 
            } 
            else {
            	return false; 
            }      
        } 
  
        // If both are empty, return true
        if (temp1 == null && temp2 == null) 
            return true; 
  
        //If either of the halves is not empty, return false
        return false; 
    }
	
	public static Node reverse(Node secondHalf) {
		Node prev = null;
		Node current = secondHalf;
		Node next;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		secondHalf = prev;
		return secondHalf;
	}

	private void printLinkedList() {
		Node temp = head;
		while (temp != null) {
			if (temp.next != null) {
				System.out.print(temp.data + "->");
			} else {
				System.out.print(temp.data);
			}
			temp = temp.next;
		}
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		Question6 linkedList = new Question6();
		linkedList.push(1);
		linkedList.push(0);
		linkedList.push(1);
		linkedList.push(0);
		linkedList.push(1);

		Question6 linkedList2 = new Question6();
		linkedList2.push(1);
		linkedList2.push(0);
		linkedList2.push(5);
		linkedList2.push(4);
		linkedList2.push(1);
		
		Question6 linkedList3 = new Question6();
		linkedList3.push(1);
		linkedList3.push(0);
		linkedList3.push(1);
		linkedList3.push(1);
		linkedList3.push(0);
		linkedList3.push(1);
		
		Question6 linkedList4 = new Question6();
		linkedList4.push(1);
		linkedList4.push(0);
		linkedList4.push(6);
		linkedList4.push(5);
		linkedList4.push(0);
		linkedList4.push(1);
		
		System.out.println("---- Using Method 1- Stacks -----");

		if(linkedList.checkLinkedListIsPalindromeMethod1()) {
			System.out.print("The linked list ");
			linkedList.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		if(linkedList2.checkLinkedListIsPalindromeMethod1()) {
			System.out.print("The linked list ");
			linkedList2.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList2.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		if(linkedList3.checkLinkedListIsPalindromeMethod1()) {
			System.out.print("The linked list ");
			linkedList3.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList3.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		if(linkedList4.checkLinkedListIsPalindromeMethod1()) {
			System.out.print("The linked list ");
			linkedList4.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList4.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		System.out.println("\n\n---- Using Method 2- Reversing Half of Linked List -----");
		System.out.println("\n\n***Use Case 1***");
		if(linkedList.checkLinkedListIsPalindromeMethod2()) {
			System.out.print("The linked list ");
			linkedList.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		System.out.println("\n\n***Use Case 2***");
		if(linkedList2.checkLinkedListIsPalindromeMethod2()) {
			System.out.print("The linked list ");
			linkedList2.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList2.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		System.out.println("\n\n***Use Case 3***");
		if(linkedList3.checkLinkedListIsPalindromeMethod2()) {
			System.out.print("The linked list ");
			linkedList3.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList3.printLinkedList();
			System.out.println(" is not a palindrome");
		}
		
		System.out.println("\n\n***Use Case 4***");
		if(linkedList4.checkLinkedListIsPalindromeMethod2()) {
			System.out.print("The linked list ");
			linkedList4.printLinkedList();
			System.out.println(" is a palindrome");
		}else {
			System.out.print("The linked list ");
			linkedList4.printLinkedList();
			System.out.println(" is not a palindrome");
		}
	}

}
