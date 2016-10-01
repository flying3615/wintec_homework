package assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Assignment3 {

	// auxiliary method to init array from file


	public static void main(String[] args) {

		 ItemList itemList1 = Helper.readInputFomeFile("file1.txt");
		 ItemList itemList2 = Helper.readInputFomeFile("file2.txt");
		 ItemList itemList3 = Helper.readInputFomeFile("file3.txt");

		BinarySearchTree bst = new BinarySearchTree();

		ItemList common= ItemList.getIntersection(itemList1, itemList2, itemList3);

		System.out.println("---------ready to insert-----------");
		System.out.println(common.print());

		ItemList.Item head = common.getHead();
		while(head!=null){
			int value = head.value;
			bst.insert(new TreeNode<>(value));
			head = head.next;
		}

		System.out.println();
		System.out.println("------find height---------");
		System.out.println("highest level =" + bst.findHighHeight(bst.root));
		System.out.println("lowest level=" + bst.findLowHeight(bst.root));

		System.out.println();
		System.out.println("------print incre order---------");
		bst.prIncOrder(bst.root);

		System.out.println();
		System.out.println("------print level by level---------");
		bst.printLevelByLevel(bst.root);
		System.out.println();
		System.out.println("------print level by level in Q---------");
		bst.printLevelByLevelQ(bst.root);

		System.out.println();
		System.out.println("------number of nodes---------");
		System.out.println(bst.numOfNodes(bst.root));

		System.out.println();
		System.out.println("------biggest number of nodes---------");
		System.out.println(bst.maxID(bst.root));
	}

}



