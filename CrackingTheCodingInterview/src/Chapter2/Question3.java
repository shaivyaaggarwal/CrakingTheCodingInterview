package Chapter2;

public class Question3 {
	
	static class Node{
		int data;
		Node next;
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
	
	//The element provided will always be the one in the middle(Not exact middle but not one of the first or the last element)
	static void deleteElement(Node headRef, int element){
		Node temp = headRef;
		Node prev = headRef;
		while(temp != null) {
			if(temp.data == element) {
				prev.next = temp.next;
			} else {
				prev = temp;
			}
			temp = temp.next;
		}
		System.out.println("The linked list after deleting "+element+" is:");
		printLinkedList(headRef);
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
		
		deleteElement(head, 78);
		deleteElement(head, 14);
	}
}
