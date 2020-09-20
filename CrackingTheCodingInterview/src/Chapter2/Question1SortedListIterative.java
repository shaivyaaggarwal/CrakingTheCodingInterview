package Chapter2;

public class Question1SortedListIterative {
	
	//Head of the linked list
	Node head;
	
	class Node{
		Integer data;
		Node next;
		Node(Integer d){
			data = d;
			next = null;
		}
	}

	//Remove duplicates from Sorted LinkedList
	//Assumption- The linked list is sorted
	//This is easy and we can do it in one loop. We will traverse from the start of the linked list and check for the next element. 
	//If the element is the same as first element, then we update the pointer of current node to point one step further
	//If the element is not same, then we move ahead in the loop
	//Complexity: O(n)
	private void removeDuplicatesFromSortedListIterative() {
		Node temp = head;
		while(temp.next != null) {
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
	}
	
	private void printLinkedList() {
		Node temp = head;
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
	
	//Utility function to add values into linked list
	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		Question1SortedListIterative sortedList = new Question1SortedListIterative();
		sortedList.push(80);
		sortedList.push(80);
		sortedList.push(30);
		sortedList.push(30);
		sortedList.push(30);
		sortedList.push(21);
		sortedList.push(20);
		sortedList.push(11);
		sortedList.push(11);
		
		System.out.println("The sorted list with duplicates is:");
		sortedList.printLinkedList();
		
		sortedList.removeDuplicatesFromSortedListIterative();
		System.out.println("The list after sorting using iterative method is:");
		sortedList.printLinkedList();
	}
}
