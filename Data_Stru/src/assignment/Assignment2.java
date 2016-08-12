package assignment;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
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

		// ItemList itemList1 = readInputFomeFile(new File("file1.txt"));
		// ItemList itemList2 = readInputFomeFile(new File("file1.txt"));
		// ItemList itemList3 = readInputFomeFile(new File("file1.txt"));

		LinkedList aLinkedList = new LinkedList<>();

		ItemList itemList = new ItemList();

		itemList.addItem(1);
		itemList.addItem(2);
		itemList.addItem(3);
		itemList.addItem(4);
		itemList.addItem(5);
		itemList.addItem(6);
		itemList.addItem(7);
		itemList.addItem(8);
		itemList.addItem(9);

		System.out.println(itemList.print());
		System.out.println(itemList.printReverse());
		System.out.println(itemList.size);
		System.out.println(itemList.getPrimeNumbers());

		ItemList itemList1 = new ItemList();
		ItemList itemList2 = new ItemList();
		ItemList itemList3 = new ItemList();

		itemList1.addItem(1);
		itemList1.addItem(3);
		itemList1.addItem(3);
		itemList1.addItem(4);
		itemList2.addItem(4);
		itemList2.addItem(5);
		itemList2.addItem(3);
		itemList3.addItem(7);
		itemList3.addItem(8);
		itemList3.addItem(3);
		itemList3.addItem(4);

		getIntersection(itemList1, itemList2, itemList3);

	}

	// how about four?
	// move to linklist body
	private static void getIntersection(ItemList itemLists1, ItemList itemLists2, ItemList itemLists3) {
		ItemList.Item current1 = itemLists1.head;
		ItemList.Item current2 = itemLists2.head;
		ItemList.Item current3 = itemLists3.head;
		ItemList tmpItemList = new ItemList();
		while (current1 != null) {
			while (current2 != null) {
				if (current1.value == current2.value) {
					tmpItemList.addItem(current2.value);
				}
				current2 = current2.next;
			}
			current1 = current1.next;
			current2 = itemLists2.head;
		}

		ItemList.Item tmpHeadItem = tmpItemList.head;
		while (tmpHeadItem != null) {
			while (current3 != null) {
				if (tmpHeadItem.value == current3.value) {
					System.out.println("Same item " + current3);
				}
				current3 = current3.next;
			}
			tmpHeadItem = tmpHeadItem.next;
			current3 = itemLists3.head;
		}
	}
}

class ItemList {

	public static class Item {
		Item next;
		Item prev;
		public Integer value;

		public Item(Integer value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Item [value=" + value + "]";
		}
	}

	Item head;
	Item tail;
	long size;

	public void addItem(int value) {
		Item item = new Item(value);
		if (head == null) {
			head = item;
			tail = item;
			size = 1L;
		} else {
			tail.next = item;
			item.prev = tail;
			tail = item;
			size++;
		}
	}

	private static boolean checkPrimeNumber(int num) {
		// 1 is not prime
		if (num == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public String getPrimeNumbers() {
		String result = "";
		if (head != null) {
			Item currentItem = head;
			while (currentItem != null) {
				if (checkPrimeNumber(currentItem.value)) {
					result += currentItem.value + ", ";
				}
				currentItem = currentItem.next;
			}
		}
		return result;
	}

	public String print() {
		StringBuffer sBuffer = new StringBuffer("ItemList ");
		if (head != null) {
			Item currentItem = head;
			while (currentItem != null) {
				if (currentItem == head) {
					sBuffer.append("[" + currentItem.value + "]");
				} else {
					sBuffer.append("->[" + currentItem.value + "]");
				}
				currentItem = currentItem.next;
			}
		} else {
			sBuffer.append("is empty");
		}
		return sBuffer.toString();
	}

	public String printReverse() {
		StringBuffer sBuffer = new StringBuffer("ItemList reverse ");
		if (tail != null) {
			Item currentItem = tail;
			while (currentItem != null) {
				if (currentItem == tail) {
					sBuffer.append("[" + currentItem.value + "]");
				} else {
					sBuffer.append("->[" + currentItem.value + "]");
				}
				currentItem = currentItem.prev;
			}
		} else {
			sBuffer.append("is empty");
		}
		return sBuffer.toString();
	}

	public static ItemList calInterception(ItemList itemList){
		return new ItemList();
	}

	public static void append(ItemList itemList){

	}

	public static ItemList getInter(ItemList... itemLists){
		ItemList tmpList = new ItemList();
		for(ItemList itemList:itemLists){
			tmpList.append(tmpList.calInterception(itemList));
		}


		return tmpList;
	}

}