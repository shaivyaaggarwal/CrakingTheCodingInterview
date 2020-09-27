package Chapter2;

public class Question1SortedListRecursive {

	static class Node{
		Integer data;
		Node next;
	}
	
	//Recursive method to remove duplicate nodes
	private static Node removeDuplicatesFromSortedListRecursive(Node head) {
		//In case the list is empty, return null
		if(head == null) {
			return null;
		}
		
		if(head.next != null) {
			if(head.data == head.next.data) {
				head.next = head.next.next;
				removeDuplicatesFromSortedListRecursive(head);
			}else{
				removeDuplicatesFromSortedListRecursive(head.next);
			}
		}
		
		return head;
	}
	
	//Utility function to add values into linked list
	private static Node push(Node headRef, int i) {
		Node newNode = new Node();
		newNode.data = i;
		newNode.next = headRef;
		headRef = newNode;
		return headRef;
	}
	
	//Utility function to print the linked list
	private static void printLinkedList(Node headRef) {
		Node temp = headRef;
		while(temp != null) {
			if(temp.next != null) {
				System.out.print(temp.data+"->");
			}else{
				System.out.print(temp.data);
			}
			temp = temp.next; 
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//Start with an empty list
		Node head = null;
		
		//Creating a sorted linked list
		head = push(head, 80);
		head = push(head, 80);
		head = push(head, 30);
		head = push(head, 30);
		head = push(head, 30);
		head = push(head, 21);
		head = push(head, 20);
		head = push(head, 11);
		head = push(head, 11);
		
		System.out.println("The sorted list with duplicates is:");
		printLinkedList(head);
		
		head = removeDuplicatesFromSortedListRecursive(head);
		System.out.println("The list after sorting using recursive method is:");
		printLinkedList(head);
	}
}
