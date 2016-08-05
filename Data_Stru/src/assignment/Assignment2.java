package assignment;

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
				Item item = new Item(scanner.nextInt());
				ItemList.addItem(item);
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

		ItemList itemList = new ItemList();
		System.out.println(itemList.size);

		Item item1 = new Item(1);
		Item item2 = new Item(2);
		Item item3 = new Item(3);
		Item item4 = new Item(4);
		Item item5 = new Item(5);
		Item item6 = new Item(6);
		Item item7 = new Item(7);
		Item item8 = new Item(8);
		Item item9 = new Item(9);

		itemList.addItem(item1);
		itemList.addItem(item2);
		itemList.addItem(item3);
		itemList.addItem(item4);
		itemList.addItem(item5);
		itemList.addItem(item6);
		itemList.addItem(item7);
		itemList.addItem(item8);
		itemList.addItem(item9);

		System.out.println(itemList.print());
		System.out.println(itemList.printReverse());
		System.out.println(itemList.size);
		System.out.println(itemList.getPrimeNumbers());

	}

	private static void getIntersection(ItemList itemLists1,ItemList itemLists2,ItemList itemLists3 ){
		Item current1 = itemLists1.head;
		Item current2 = itemLists1.head;
		Item current3 = itemLists1.head;

		while(current1.next!=null){
			while(current2.next!=null){
				while (current3.next!=null) {
					if(current1.equals(current2)&&current2.equals(current3)){
						System.out.println(current1);
					}
					current3 = current3.next;
				}
				current2 = current2.next;
			}
			current1 = current1.next;
		}

	}

}

class Item {

	Item next;
	Item prev;
	Integer value;

	public Item(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item [value=" + value + "]";
	}

}

class ItemList {

	Item head;
	Item tail;
	long size;

	public void addItem(Item item) {
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
			while (currentItem.next != null) {
				if (checkPrimeNumber(currentItem.value)) {
					result += currentItem.value + ", ";
				}
				currentItem = currentItem.next;
			}
			if (checkPrimeNumber(tail.value))
				result += tail.value;
		}
		return result;
	}

	public String print() {
		StringBuffer sBuffer = new StringBuffer("ItemList ");
		if (head != null) {
			Item currentItem = head;
			while (currentItem.next != null) {
				sBuffer.append("->[" + currentItem.value + "]");
				currentItem = currentItem.next;
			}
			sBuffer.append("->[" + tail.value + "]");
		} else {
			sBuffer.append("is empty");
		}
		return sBuffer.toString();
	}

	public String printReverse() {
		StringBuffer sBuffer = new StringBuffer("ItemList reverse ");
		if (tail != null) {
			Item currentItem = tail;
			while (currentItem.prev != null) {
				sBuffer.append("->[" + currentItem.value + "]");
				currentItem = currentItem.prev;
			}
			sBuffer.append("->[" + head.value + "]");
		} else {
			sBuffer.append("is empty");
		}
		return sBuffer.toString();
	}

}