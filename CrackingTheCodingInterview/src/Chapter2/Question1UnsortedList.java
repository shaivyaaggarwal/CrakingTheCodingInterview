package Chapter2;

import java.util.HashSet;

public class Question1UnsortedList {
	
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	//For each element in the linked list, we will traverse the rest of the elements and remove in case they match the outer loop element
	//Two loops hence complexity is O(n2)
	private void removeDuplicatesFromUnsortedListMethod1() {
		Node ptr1 = head;
		Node ptr2;
		while(ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;
			while(ptr2.next != null) {
				if(ptr2.next.data == ptr1.data) {
					ptr2.next = ptr2.next.next;
				}else {
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}
	
	//We will use a hash set to store new occurrence of an element, and if it is already found in the hash set, we will delete it from the linked list.
	//One loop hence complexity is O(n)
	private void removeDuplicatesFromUnsortedListMethod2(){
		HashSet<Integer> hs = new HashSet<>(); 
		Node temp = head;
		Node prev = null;
		while(temp != null) {
			if(hs.contains(Integer.valueOf(temp.data))) {
				prev.next = temp.next;
			}else {
				hs.add(Integer.valueOf(temp.data));
				prev = temp;
			}
			temp = temp.next;
		}
	}
	
	//Utility function to add values into linked list
	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
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

	public static void main(String[] args) {
		Question1UnsortedList unsortedList = new Question1UnsortedList();
		unsortedList.push(13);
		unsortedList.push(24);
		unsortedList.push(34);
		unsortedList.push(34);
		unsortedList.push(13);
		unsortedList.push(24);
		unsortedList.push(37);
		unsortedList.push(90);
		unsortedList.push(90);
		unsortedList.push(11);
		
		System.out.println("The un-sorted list with duplicates is:");
		unsortedList.printLinkedList();
		
		unsortedList.removeDuplicatesFromUnsortedListMethod1();
		System.out.println("The list after sorting using iterative method is:");
		unsortedList.printLinkedList();
		
		//Again adding data to the unsorted list so that it has duplicate elements
		unsortedList.push(13);
		unsortedList.push(24);
		unsortedList.push(34);
		unsortedList.push(34);
		unsortedList.push(13);
		unsortedList.push(24);
		unsortedList.push(37);
		unsortedList.push(90);
		unsortedList.push(90);
		unsortedList.push(11);
		System.out.println("The un-sorted list with duplicates is:");
		unsortedList.printLinkedList();
		
		unsortedList.removeDuplicatesFromUnsortedListMethod2();
		System.out.println("The list after sorting using iterative method is:");
		unsortedList.printLinkedList();
	}
}
