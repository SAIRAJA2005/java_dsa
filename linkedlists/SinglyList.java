package linkedlists;

import java.util.Scanner;

public class SinglyList {
	private Node head;
	static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public SinglyList() {
		head = null;
		System.out.println("An empty list is created");
	}
	
	public Node createNode() {
		System.out.println("Enter Id and Name of the Person:");
		int id = scanner.nextInt();
		String name = scanner.next();
		Person person = new Person(id, name);
		Node node = new Node(person, null);
		return node;
	}
		
	public void insertAtFront() {
		Node newNode = createNode();
		if(head == null) { // Check if list is empty
			head = newNode; // make the new node as 1st node
			return;
		}
		newNode.setLink(head); // make the new node point to existing 1st node
		head = newNode; // make the new node as 1st node of the list
	}

	public void insertAtRear() {
		Node newNode = createNode();
		if(head == null) { // Check if list is empty
			head = newNode; // make the new node as 1st node
			return;
		}
		Node temp = head;
		while(temp.getLink() != null) { // Check if last node is not reached
			temp = temp.getLink(); // traverse to next node
		}
		temp.setLink(newNode); // set the link part of temp node to newNode
	}

	public void deleteFromFront() {
		if(head == null) { // Check if list is empty
			System.out.println("List is empty");
			return;
		}
		System.out.println("Node with data: " + head.getData() + " is deleted");
		head = head.getLink();
	}

	public void deleteFromRear() {
		if(head == null) { // Check if list is empty
			System.out.println("List is empty");
			return;
		}
		if(head.getLink() == null) { // list has one node
			System.out.println("Node with data: " + head.getData() + " is deleted");
			head.setLink(null);
		}
		Node temp = head;
		while(temp.getLink().getLink() != null) // check if link of next node is null
			temp = temp.getLink();
		System.out.println("Node with data: " + temp.getLink().getData() + " is deleted");
		temp.setLink(null); // make the last but node as last node
	}

	// Assignment Invalid position or insert at rear
	public void insertAtPosition() {
		Node newNode = createNode();
		System.out.print("Enter postion of the new node: ");
		int position = scanner.nextInt();
		if(head == null) {
			head = newNode;
			return;
		}
		if(position == 1) {
			newNode.setLink(head);
			head.setLink(newNode);
			return;
		}
		Node temp = head;
		int count = 1;
		while(temp.getLink() != null && count < position-1) {
			temp = temp.getLink();
			count++;
		}
		if(temp.getLink() != null) { // insert new-node in between
			newNode.setLink(temp.getLink());
			temp.setLink(newNode); 
			return;
		}
		temp.setLink(newNode); // insert new-node at rear
	}

	public void deleteFromPosition() {
		if(head == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.print("Enter postion of the node to be deleted: ");
		int position = scanner.nextInt();
		if(position == 1) {
			System.out.println("Node with data " + head.getData() + " is deleted");
			head = null;
			return;
		}
		Node temp = head;
		int count = 1;
		while(temp.getLink() != null && count < position-1) {
			temp = temp.getLink();
			count++;
		}
		if(temp.getLink() == null && count < position) {
			System.out.println("Invalid position");
			return;
		}
		if(position == count+1 && temp.getLink() != null) {
			System.out.println("Deleted node is " + temp.getLink().getData());
			temp.setLink(temp.getLink().getLink());
			return;
		}
		System.out.println("Deleted node is " + temp.getLink().getData());
		temp.setLink(null);
	}

	public void displayFromFront() {
		if(head == null) { // Check if list is empty
			System.out.println("List is empty");
			return;
		}
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.getData());
			temp = temp.getLink();
		}
	}
	
	public void printRecursively(Node head) {
		if(head == null)
			return;
		printRecursively(head.getLink());
		System.out.print(head.getData());
	}
	
	public void displayFromRear() {
		if(head == null) { // Check if list is empty
			System.out.println("List is empty");
			return;
		}
		printRecursively(head);
	}	
}
