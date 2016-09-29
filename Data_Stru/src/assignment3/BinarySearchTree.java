package assignment3;

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
        if (current == null) return false;
        if (current.element > element) {
            return search_rec(current.left, element);
        } else if (current.element < element) {
            return search_rec(current.right, element);
        } else {
            //found element
            return true;
        }
    }

    public boolean search_loop(TreeNode<Integer> node) {
        TreeNode<Integer> current = root;
        Integer element = node.element;
        while (current != null) {
            if (current.element.equals(element)) return true;
            if (current.element > element) current = current.left;
            if (current.element < element) current = current.right;
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

    public int findHighHeight(TreeNode current) {
        //recursive
        if (current != null) {
            int right = 1 + findHighHeight(current.right);
            int left = 1 + findHighHeight(current.left);
            //get the bigger
            if (left > right) {
                return left;
            } else {
                return right;
            }
        } else {
            return -1;
        }
    }

    public int findLowHeight(TreeNode current) {
        //recursive
        if (current != null) {
            int right = 1 + findLowHeight(current.right);
            int left = 1 + findLowHeight(current.left);
            //get the smaller
            if (left < right) {
                return left;
            } else {
                return right;
            }
        } else {
            //The height of a binary search tree is equal to number of layers - 1
            //cancel 0+1 if only root
            return -1;
        }
    }


    //Uncompleted
    public void printLevelByLevel(TreeNode current) {
        if (current == null || this.root == null) {
            return;
        } else if (current.equals(root)) {
            System.out.println("root=" + current.element);
            this.printSubTree(current, 0);
        } else {
            //print from an arbitrary node
        }
    }


    private void printSubTree(TreeNode current, int level) {
        if (current == null) return;
        if (current.left == null && current.right == null) {
            System.out.println("leaf =" + current.element);
            return;
        }
        System.out.println("----level " + (level++) + "-----");
        if (current.left != null) {
            System.out.print("left=" + current.left.element + " ");
        }
        if (current.right != null) {
            System.out.println("right=" + current.right.element);
        } else {
            System.out.println();
        }

        printSubTree(current.left, level);
        printSubTree(current.right, level);
    }

    public boolean deleteNode(TreeNode<Integer> node) {

        //step 1, check if node exists in the given tree
        if (root == null) return false;

        boolean isFound = this.search_loop(node);
        if (!isFound) return false;


        //step2 found its parent
        TreeNode<Integer> current = root;
        TreeNode<Integer> parent = null;
        SIDE side = UNCERTAIN;
        while (current != null) {

            if (current.element < node.element) {
                parent = current;
                current = current.right;
                side = RIGHT;
            }

            if (current.element > node.element) {
                parent = current;
                current = current.left;
                side = LEFT;
            }

            if (current.equals(node)) break;
        }


        //found itself

        //case 1, node has no child, found on which side of its parent and delete.
        if (current.left == null && current.right == null) {
            switch (side) {
                case LEFT:
                    current = null;
                    parent.left = null;
                    break;
                case RIGHT:
                    current = null;
                    parent.right = null;
                    break;
                //no parent,single root without child
                case UNCERTAIN:
                    root = null;
                    break;
            }
            return true;
        }

        //case 2, node has only one child, connect the side of it in parent to it sub child
        if (current.left == null || current.right == null) {
            switch (side) {
                case LEFT:
                    parent.left = current.left == null ? current.right : current.left;
                    current = null;
                    break;
                case RIGHT:
                    parent.right = current.left == null ? current.right : current.left;
                    current = null;
                    break;
                //no parent,single root without child
                case UNCERTAIN:
                    root = current.left == null ? current.right : current.left;
                    break;
            }
            return true;
        }

        //case 3, node has two children, replace its place with the smallest node in its right subtree, and delete the smallest in the right subtree
        if (current.left != null && current.right != null) {
            TreeNode<Integer> smallestInRight = findSmallestNode(current.right);
            smallestInRight.left = current.left;
            smallestInRight.right = current.right;
            switch (side) {
                case LEFT:
                    parent.left = smallestInRight;
                    break;
                case RIGHT:
                    parent.left = smallestInRight;
                    break;
                //no parent,single root without child
                case UNCERTAIN:
                    root = smallestInRight;
                    break;
            }
            //delete the smallest in the right subtree;
            deleteNode(smallestInRight);
            return true;
        }

        return false;

    }

    private TreeNode<Integer> findSmallestNode(TreeNode from) {
        TreeNode current = from;
        while (current != null) {
            current = current.left;
        }
        return current;
    }


    //printSubTree increasing order
    public void prIncOrder(TreeNode current) {
        if (current == null) return;
        prIncOrder(current.left);
        System.out.print(current.element + " ");
        prIncOrder(current.right);

    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("------insert---------");
        System.out.println(bst.insert(new TreeNode<>(31)));
        System.out.println(bst.insert(new TreeNode<>(22)));
        System.out.println(bst.insert(new TreeNode<>(3)));
        System.out.println(bst.insert(new TreeNode<>(14)));
        System.out.println(bst.insert(new TreeNode<>(7)));
        System.out.println(bst.insert(new TreeNode<>(66)));
        System.out.println(bst.insert(new TreeNode<>(5)));

        System.out.println();
        System.out.println("------search_rec---------");
        System.out.println(bst.search_rec(bst.root, 31));
        System.out.println(bst.search_rec(bst.root, 22));
        System.out.println(bst.search_rec(bst.root, 10));

        System.out.println();
        System.out.println("------search_loop---------");
        System.out.println(bst.search_loop(new TreeNode<>(14)));
        System.out.println(bst.search_loop(new TreeNode<>(66)));
        System.out.println(bst.search_loop(new TreeNode<>(10)));

        System.out.println();
        System.out.println("------find height---------");
        System.out.println("highest level =" + bst.findHighHeight(bst.root));
        System.out.println("lowest level=" + bst.findLowHeight(bst.root));

        System.out.println();
        System.out.println("------print level by level---------");
        bst.printLevelByLevel(bst.root);

        System.out.println();
        System.out.println("------print incre order---------");
        bst.prIncOrder(bst.root);
    }

}
