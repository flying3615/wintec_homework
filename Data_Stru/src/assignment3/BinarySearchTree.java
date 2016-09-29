package assignment3;

/**
 * Created by liuyufei on 28/09/16.
 */
public class BinarySearchTree {


    TreeNode<Integer> root;

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

    public boolean search_loop(Integer element) {
        TreeNode<Integer> current = root;
        while (current != null) {
            if (current.element.equals(element)) return true;
            if (current.element > element) current = current.left;
            if (current.element < element) current = current.right;
        }
        return false;
    }

    public boolean insert(Integer element) {
        TreeNode<Integer> parent = null;
        TreeNode<Integer> current;
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


    //!!!!
    public void printLevelByLevel(TreeNode current) {
        System.out.println("root="+current.element);
        this.printSubTree(current,0);
    }


    private void printSubTree(TreeNode current, int level){
        if (current == null) return;
        if (current.left == null && current.right == null) {
            System.out.println("leaf =" + current.element);
            return;
        }
        System.out.println("----level "+(level++)+"-----");
        if (current.left != null) {
            System.out.print("left=" + current.left.element+" ");
        }
        if (current.right != null){
            System.out.println("right=" + current.right.element);
        }else{
            System.out.println();
        }

        printSubTree(current.left,level);
        printSubTree(current.right,level);
    }


    //printSubTree increasing order
    public void prIncOrder(TreeNode current) {
        if(current==null) return;
        prIncOrder(current.left);
        System.out.print(current.element+" ");
        prIncOrder(current.right);

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("------insert---------");
        System.out.println(bst.insert(31));
        System.out.println(bst.insert(22));
        System.out.println(bst.insert(3));
        System.out.println(bst.insert(14));
        System.out.println(bst.insert(7));
        System.out.println(bst.insert(66));
        System.out.println(bst.insert(5));

        System.out.println();
        System.out.println("------search_rec---------");
        System.out.println(bst.search_rec(bst.root, 9));
        System.out.println(bst.search_rec(bst.root, 6));
        System.out.println(bst.search_rec(bst.root, 10));

        System.out.println();
        System.out.println("------search_loop---------");
        System.out.println(bst.search_loop(9));
        System.out.println(bst.search_loop(6));
        System.out.println(bst.search_loop(10));

        System.out.println();
        System.out.println("------find height---------");
        System.out.println("highest level ="+bst.findHighHeight(bst.root));
        System.out.println("lowest level="+bst.findLowHeight(bst.root));

        System.out.println();
        System.out.println("------print level by level---------");
        bst.printLevelByLevel(bst.root);

        System.out.println();
        System.out.println("------print incre order---------");
        bst.prIncOrder(bst.root);
    }

}
