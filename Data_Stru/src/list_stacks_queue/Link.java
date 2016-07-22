package list_stacks_queue;

public class Link {
	public String bookName;
	public int millionSold;

	public Link next;

	public Link(String bookName,int millionSold){
		this.bookName = bookName;
		this.millionSold = millionSold;
	}

	public void display(){
		System.out.println(bookName+" : "+millionSold+",000,000");
	}

	@Override
	public String toString() {
		return "Link [bookName=" + bookName + ", millionSold=" + millionSold;
	}

	public static void main(String[] args) {
		LinkedList theLinkedList = new LinkedList();
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Harry Potter and Sorcerer's Stone", 600);
		theLinkedList.display();

	}

}

class LinkedList{

	public Link firstLink;

	public LinkedList() {
		firstLink = null;
	}


	public boolean isEmpty() {
		return firstLink==null;
	}

	public void insertFirstLink(String bookName,int millionSold) {
		Link newLink = new Link(bookName, millionSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}

	public Link removeFirst(){
		Link linkReference = firstLink;
		if(!isEmpty()){
			firstLink = firstLink.next;
		}else{
			System.out.println("Empty LinkedList");
		}
		return linkReference;
	}

	public void display(){
		Link theLink = firstLink;
		while(theLink!=null){
			theLink.display();
			System.out.println("Next Link: "+theLink.next);
			theLink = theLink.next;
		}
	}

	public Link find(String bookName){
		Link theLink = firstLink;
		if(!isEmpty()){
			while (theLink.bookName!=bookName) {
				if(theLink.next==null){
					return null;
				}else{
					theLink = theLink.next;
				}
			}
		}else{
			System.out.println("LinkList is empty");
		}
		return theLink;
	}

	public Link removeLink(String bookName){
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		while(currentLink.bookName!=bookName){
			if(currentLink.next==null){
				return null;
			}else{
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		//now the currentLink's bookName is the bookName

		if(currentLink==firstLink){
			firstLink = firstLink.next;
		}else{
			previousLink.next = currentLink.next;
		}

		return currentLink;
	}


}
