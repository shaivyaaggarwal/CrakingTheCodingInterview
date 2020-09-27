package Chapter2;

public class Question4 {

	static class Node {
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
		Node temp = headRef;
		while (temp != null) {
			if (temp.next == null) {
				System.out.print(temp.data);
			} else {
				System.out.print(temp.data + "->");
			}
			temp = temp.next;
		}
		System.out.println();
	}

	/*
	 * Given the partition element, we have to bring all elements less than
	 * partitionElement before all elements which are greater than or equal to partitionElement
	 */
	public static void bringAllElementsSmallerThanPartitionToFrontOfLL(Node headRef, int partitionElement) {
		Node temp = headRef;
		Node prevOfTemp = headRef;
		Node partition = headRef;
		int count = 0;

		// First we will loop and find the first element in the linked list which is
		// greater than or equal to partitionElement
		while (temp != null) {
			if (temp.data < partitionElement) {
				count++;
				partition = temp;
				temp = temp.next;
			} else {
				break;
			}
		}

		// Given the LL is 3->8->5->4->5->10->1->2, temp is now on 8
		//That means we have reached the first value where LL element is greater than or equal to partitionElement
		//We did this to keep partition reference pointer to the element where we last encountered partitonElement
		System.out.println("Temp has reached node containing data: " + temp.data);
		
		while(temp != null) {
			if(temp.data >= partitionElement) {
				prevOfTemp = temp;
				temp = temp.next;
			}else{
				Node temp2 = new Node();
				temp2.data = temp.data;
				if(count == 0) {
					temp2.next = partition;
					partition = temp2;
					headRef = temp2;
				}else {
					temp2.next = partition.next;
					partition.next = temp2;
					partition = partition.next;
				}
				prevOfTemp.next = temp.next;
				temp = temp.next;
			}
		}
		
		System.out.println("The Linked List after moving all elements less than "+partitionElement+" before any of its occurence is :");
		printLinkedList(headRef);
	}

	public static void main(String[] args) {
		//First test case where first element in Linked List < partitionElement 
		Node head = null;
		head = push(head, 2);
		head = push(head, 1);
		head = push(head, 10);
		head = push(head, 5);
		head = push(head, 4);
		head = push(head, 5);
		head = push(head, 8);
		head = push(head, 3);

		System.out.println("-----First Test Case-----");
		System.out.println("The linked list is:");
		printLinkedList(head);

		bringAllElementsSmallerThanPartitionToFrontOfLL(head, 5);
		
		//Second test case where first element in Linked List >= paritionElement
		System.out.println("\n");
		Node head2 = null;
		head2 = push(head2, 5);
		head2 = push(head2, 2);
		head2 = push(head2, 1);
		head2 = push(head2, 10);
		head2 = push(head2, 5);
		head2 = push(head2, 4);
		head2 = push(head2, 5);
		head2 = push(head2, 8);

		System.out.println("-----Second Test Case-----");
		System.out.println("The linked list is:");
		printLinkedList(head2);
		
		bringAllElementsSmallerThanPartitionToFrontOfLL(head2, 5);
		
		//Third test case where no element in Linked List < partitionElement
		System.out.println("\n");
		Node head3 = null;
		head3 = push(head3, 5);
		head3 = push(head3, 10);
		head3 = push(head3, 5);
		head3 = push(head3, 17);
		head3 = push(head3, 5);
		head3 = push(head3, 8);

		System.out.println("-----Second Test Case-----");
		System.out.println("The linked list is:");
		printLinkedList(head3);
		
		bringAllElementsSmallerThanPartitionToFrontOfLL(head3, 5);
	}
}
