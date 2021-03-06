package assignment3;

import java.util.LinkedList;
import java.util.Queue;

import static assignment3.BinarySearchTree.SIDE.*;

/**
 * Created by liuyufei on 28/09/16.
 */
public class BinarySearchTree {

	TreeNode<Integer> root;

	enum SIDE {
		LEFT, RIGHT, UNCERTAIN
	}

	public boolean search_rec(TreeNode<Integer> current, Integer element) {
		if (current == null)
			return false;
		if (current.element > element) {
			return search_rec(current.left, element);
		} else if (current.element < element) {
			return search_rec(current.right, element);
		} else {
			// found element
			return true;
		}
	}

	public boolean search_loop(TreeNode<Integer> node) {
		TreeNode<Integer> current = root;
		Integer element = node.element;
		while (current != null) {
			if (current.element.equals(element))
				return true;
			if (current.element > element)
				current = current.left;
			if (current.element < element)
				current = current.right;
		}
		return false;
	}

	public boolean insert(TreeNode<Integer> node) {
		TreeNode<Integer> parent = null;
		TreeNode<Integer> current;
		Integer element = node.element;

		if (root == null) {
			root = new TreeNode<>(element);
			return true;
		} else {
			current = root;
			while (current != null) {
				if (element < current.element) {
					parent = current;
					current = current.left;
				} else if (element > current.element) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}
			}

			if (element < parent.element) {
				parent.left = new TreeNode<>(element);
			} else {
				parent.right = new TreeNode<>(element);
			}
			return true;
		}
	}

	public int findHighHeight(TreeNode<Integer> current) {
		// recursive
		if (current != null) {
			int right = 1 + findHighHeight(current.right);
			int left = 1 + findHighHeight(current.left);
			// get the bigger
			if (left > right) {
				return left;
			} else {
				return right;
			}
		} else {
			return -1;
		}
	}

	public int findLowHeight(TreeNode<Integer> current) {
		// recursive
		if (current != null) {
			int right = 1 + findLowHeight(current.right);
			int left = 1 + findLowHeight(current.left);
			// get the smaller
			if (left < right) {
				return left;
			} else {
				return right;
			}
		} else {
			// The height of a binary search tree is equal to number of layers -
			// 1
			// cancel 0+1 if only root
			return -1;
		}
	}

	public void printLevelByLevel(TreeNode<Integer> current) {
		int height = this.findHighHeight(current);
		for (int i = 0; i < height; i++) {
			if (i == 0) {
				System.out.println("-------level 0----------");
				System.out.println();
				System.out.println("root=" + current.element);
			}
			System.out.println();
			System.out.println("-------level " + (i + 1) + "----------");
			this.printSubTree(current, i, 0);
		}
	}

	private void printSubTree(TreeNode<Integer> current, int level, int acc) {
		if (current == null)
			return;
		if (acc == level) {
			// level=0 & acc=0, it's actually level 1, printing its child node
			if (current.left != null)
				System.out.print("left=" + current.left.element + " ");
			if (current.right != null)
				System.out.print("right=" + current.right.element + " ");
		} else {
			acc += 1;
			printSubTree(current.left, level, acc);
			printSubTree(current.right, level, acc);
		}
	}

	public int numOfNodes(TreeNode<Integer> node) {
		if (node != null) {
			return 1 + numOfNodes(node.left) + numOfNodes(node.right);
		} else {
			return 0;
		}
	}

	public int maxID(TreeNode<Integer> node) {
		if (node == null)
			return -1;
		if (node.right != null) {
			return maxID(node.right);
		} else {
			return node.element;
		}
	}

	// how to print with level info? construct the node with level info
	int current_level = -1;

	public void printLevelByLevelQ(TreeNode<Integer> node) {
		int level = 0;
		Queue<TreeNode<Integer>> tmp = new LinkedList<>();
		// Add level zero to node
		node.setLevel(level);
		tmp.add(node);
		while (!tmp.isEmpty()) {
			TreeNode<Integer> inner = tmp.poll();
			// l = read the level from the node you polled;
			if (inner.getLevel() > current_level) {
				System.out.println("-----level " + inner.getLevel() + "------");
				current_level = inner.getLevel();
			}

			System.out.println(inner.element + " ");

			if (inner.left != null) {
				// Set the level of inner.left to l +1;
				inner.left.setLevel(inner.getLevel() + 1);
				tmp.add(inner.left);
			}

			if (inner.right != null) {
				// Set the level of inner.right to l +1;
				inner.right.setLevel(inner.getLevel() + 1);
				tmp.add(inner.right);
			}
		}
	}

	public void deleteNode(TreeNode<Integer> node) {
		// Delete node
	}

	private TreeNode<Integer> findSmallestNode(TreeNode<Integer> from) {
		TreeNode<Integer> current = from;
		TreeNode<Integer> last_node = null;

		while (current != null) {
			last_node = current;
			current = current.left;
		}
		System.out.println("smallest=" + last_node.element);
		return last_node;
	}

	// printSubTree increasing order
	public void prIncOrder(TreeNode<Integer> current) {
		if (current == null)
			return;
		prIncOrder(current.left);
		System.out.print(current.element + " ");
		prIncOrder(current.right);

	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		// 37
		// / \
		// / \
		// / \
		// 24 42
		// / \ / \
		// 7 32 40 120
		// / \ / \ / \ / \
		// 2 8 25 34 38 41 100 130

		System.out.println("------insert---------");
		bst.insert(new TreeNode<>(37));
		bst.insert(new TreeNode<>(24));
		bst.insert(new TreeNode<>(42));
		bst.insert(new TreeNode<>(7));
		bst.insert(new TreeNode<>(32));
		bst.insert(new TreeNode<>(40));
		bst.insert(new TreeNode<>(120));
		bst.insert(new TreeNode<>(2));
		bst.insert(new TreeNode<>(8));
		bst.insert(new TreeNode<>(25));
		bst.insert(new TreeNode<>(34));
		bst.insert(new TreeNode<>(38));
		bst.insert(new TreeNode<>(41));
		bst.insert(new TreeNode<>(100));
		bst.insert(new TreeNode<>(130));

		System.out.println();
		System.out.println("------search_rec---------");
		System.out.println(bst.search_rec(bst.root, 25));
		System.out.println(bst.search_rec(bst.root, 38));
		System.out.println(bst.search_rec(bst.root, 10));

		// System.out.println();
		// System.out.println("------search_loop---------");
		// System.out.println(bst.search_loop(new TreeNode<>(14)));
		// System.out.println(bst.search_loop(new TreeNode<>(66))); ??
		// System.out.println(bst.search_loop(new TreeNode<>(10)));

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
		System.out.println("------number of nodes---------");
		System.out.println(bst.numOfNodes(bst.root));

		System.out.println();
		System.out.println("------biggest number of nodes---------");
		System.out.println(bst.maxID(bst.root));

		// bst.deleteNode(new TreeNode<>(42));
		// System.out.println();
		// System.out.println("------print level by level---------");
		// bst.printLevelByLevel(bst.root);
	}

}
