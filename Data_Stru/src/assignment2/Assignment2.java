package assignment2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Assignment2 {

	// auxiliary method to init array from file
	private static ItemList readInputFomeFile(File file) {
		ItemList ItemList = new ItemList();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				ItemList.addItem(scanner.nextInt());
			}
		} catch (IOException e) {
			System.out.println("Unable to create: " + e.getMessage());
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return ItemList;
	}// end of readInputFomeFile

	public static void main(String[] args) {

		 ItemList itemList1 = readInputFomeFile(new File("file1.txt"));
		 ItemList itemList2 = readInputFomeFile(new File("file2.txt"));
		 ItemList itemList3 = readInputFomeFile(new File("file3.txt"));

		System.out.println(itemList1.print());
		System.out.println(itemList1.printReverse());
		System.out.println(itemList1.getSize());
		itemList1.getPrimeNumbers();

		System.out.println("intersection items = "+ItemList.getIntersection(itemList1, itemList2, itemList3).print());

	}

	private static boolean checkCircle(ItemList itemList){
		ItemList.Item slow = itemList.getHead();
		ItemList.Item fast = itemList.getHead();
		//if fast getting to the tail which is null means no circle;
		while(slow!=null&&fast!=null){

			slow = slow.getNext();
			fast = fast.getNext();

			//in case of double forward node is null @ the tail
			if(fast!=null){
				fast = fast.getNext();
			}

			if(fast==slow){
				//fix code
				fast.getPrev().setNext(null);
				return true;
			}
		}

		return false;
	}

	private static boolean jumpNode(ItemList itemList){
		ItemList.Item slow = itemList.getHead();
		ItemList.Item fast = itemList.getHead();
		while(fast!=null){
			slow = slow.getNext();
			fast = fast.getNext();
			//in case of double forward node is null @ the tail
			if(fast!=null){
				fast = fast.getNext();
				if(fast.getPrev()!=slow.getNext()){

					return false;
				}
			}
		}

		return true;
	}


}



