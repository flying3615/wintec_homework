package assignment3;

public class ItemList {

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

		public Item getNext(){
			return next;
		}

		public Item getPrev(){
			return prev;
		}

		public void setNext(Item next){
			this.next = next;
		}

		public void setPrev(Item prev){
			this.prev = prev;
		}

	}

	Item head;
	Item tail;
	long size;

	public long getSize(){
		return size;
	}

	public Item getTail(){
		return tail;
	}

	public Item getHead(){
		return head;
	}

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

	public void getPrimeNumbers() {
		int i = 0;
		if (head != null) {
			Item currentItem = head;
			while (currentItem != null) {
				if (checkPrimeNumber(currentItem.value)) {
					System.out.print(currentItem.value + "\t");
					//(five numbers each line)
					if(++i%5==0){
						System.out.println();
					}
				}
				currentItem = currentItem.next;
			}
			System.out.println();
		}
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

    private ItemList calInterception(ItemList itemList) {
        ItemList.Item thisCurrent = this.head;
        ItemList.Item thatCurrent = itemList.head;
        ItemList tmpItemList = new ItemList();
        while (thisCurrent != null) {
            while (thatCurrent != null) {
                if (thisCurrent.value == thatCurrent.value) {
                    tmpItemList.addItem(thatCurrent.value);
                }
                thatCurrent = thatCurrent.next;
            }
            thisCurrent = thisCurrent.next;
            thatCurrent = itemList.head;
        }

        return tmpItemList;
    }


    private static ItemList tmpList;

    public static ItemList getIntersection(ItemList... itemLists) {
        for (ItemList itemList : itemLists) {

            if (tmpList == null) {
                tmpList = itemList;
            } else {
                tmpList = tmpList.calInterception(itemList);
            }
        }
        return tmpList;
    }


}
