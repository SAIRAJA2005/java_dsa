package linkedlists;

import java.util.LinkedList;

public class ListDemo {

	public static void runMenu() {
		int choice = 0;
		int numberOfOperations = 20;
		SinglyList list = new SinglyList();
		do {
			System.out.print("\n1:InsertFront 2:InsertRear 3:InsertAtPos 4:DeleteFront 5:DeleteRear \n6:DeleteFromPos 7:DisplayFromFront 8:DisplayFromRear 9:Exit.  Your Choice: ");
			choice = SinglyList.scanner.nextInt();
			switch(choice) {
			case 1 : list.insertAtFront(); break;
			case 2 : list.insertAtRear(); break;
			case 3 : list.insertAtPosition(); break;
			case 4 : list.deleteFromFront(); break;
			case 5 : list.deleteFromRear(); break;
			case 6 : list.deleteFromPosition(); break;
			case 7 : list.displayFromFront(); break;
			case 8 : list.displayFromRear(); break;
			case 9 : numberOfOperations = 0; break;
			default: System.out.println("Invalid Choice");
			}
			numberOfOperations--;
		}while(numberOfOperations >= 1);
	}
	
	public static void main(String[] args) {
		runMenu();
		System.out.println("End of Program");
	}
}
