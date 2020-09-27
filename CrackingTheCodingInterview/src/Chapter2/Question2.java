package Chapter2;

public class Question2 {
		
	static class Node{
		int data;
		Node next;
	}
	
	//Print element at kth to last position in the linked list.
	//First we will calculate the linked list by traversing it
	//If k>length of linked list, print that element is not found
	//Else, print element at (ll.length-k+1) position
	//Complexity: O(n)
	static void printElementAtKthToLastElementInLinkedList(Node headRef, int k) {
		Node temp = headRef;
		int length = 0;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		
		if(k > length) {
			System.out.println("The position k="+k+" is greater than the length of linked list. No element found.");
		}
		
		temp = headRef;
		int count = 0;
		while(temp != null) {
			count++;
			if(count == (length-k+1)) {
				System.out.println("Element at "+k+"th position to last index is :"+temp.data);
				break;
			}
			temp = temp.next;
		}
	}
	
	static Node push(Node headRef, int d) {
		Node temp = new Node();
		temp.data = d;
		temp.next = headRef;
		headRef = temp;
		return headRef;
	}
	
	static void printLinkedList(Node headRef) {
		Node temp = headRef;
		while(temp!=null) {
			if(temp.next == null) {
				System.out.print(temp.data);
			}else {
				System.out.print(temp.data + "->");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Node head = null;
		head = push(head, 13);
		head = push(head, 14);
		head = push(head, 34);
		head = push(head, 78);
		head = push(head, 90);
		head = push(head, 23);
		head = push(head, 45);
		
		System.out.println("The linked list is:");
		printLinkedList(head);
		
		printElementAtKthToLastElementInLinkedList(head, 5);
		printElementAtKthToLastElementInLinkedList(head, 9);
	}
}
