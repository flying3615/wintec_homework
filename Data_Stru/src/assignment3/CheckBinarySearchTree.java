package assignment3;

/**
 * Created by liuyufei on 14/10/16.
 */
public class CheckBinarySearchTree {

    //WRONG!!!
    public static boolean checkBinSerTree(TreeNode<Integer> root){

        if(root.left!=null){
            if(root.left.element>root.element){
                return false;
            }else if(root.left.right!=null&&root.left.right.element>root.element){
                return false;
            }else {
                return checkBinSerTree(root.left);
            }
        }else if(root.right!=null){
            if(root.right.element<root.element){
                return false;
            }else if(root.right.left!=null&&root.right.left.element<root.element){
                return false;
            }else{
                return checkBinSerTree(root.right);
            }
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root_false = new TreeNode<>(6);
        TreeNode<Integer> left1_false = new TreeNode<>(4);
        TreeNode<Integer> left2_false = new TreeNode<>(1);
        TreeNode<Integer> right1_false = new TreeNode<>(8);
        TreeNode<Integer> right2_false = new TreeNode<>(5);
        TreeNode<Integer> right3_false = new TreeNode<>(7);
        root_false.left = left1_false;
        root_false.right = right1_false;
        left1_false.right = right2_false;
        right2_false.right = right3_false;

        System.out.println(checkBinSerTree(root_false));

        TreeNode<Integer> root_true = new TreeNode<>(3);
        TreeNode<Integer> left1_true = new TreeNode<>(2);
        TreeNode<Integer> left2_true = new TreeNode<>(1);
        TreeNode<Integer> right1_true = new TreeNode<>(5);
        TreeNode<Integer> right2_true = new TreeNode<>(4);
        root_true.left = left1_true;
        root_true.right = right1_true;
        left1_true.left = left2_true;
        right1_true.left = right2_true;

        System.out.println(checkBinSerTree(root_true));

        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> right1 = new TreeNode<>(2);
        TreeNode<Integer> right2 = new TreeNode<>(3);
        TreeNode<Integer> right3 = new TreeNode<>(4);
        TreeNode<Integer> right4 = new TreeNode<>(5);
        root.right = right1;
        right1.right = right2;
        right2.right = right3;
        right3.right = right4;

        System.out.println(checkBinSerTree(root));

        TreeNode<Integer> root_link_false = new TreeNode<>(1);
        TreeNode<Integer> right1_link_false = new TreeNode<>(2);
        TreeNode<Integer> right2_link_false = new TreeNode<>(5);
        TreeNode<Integer> right3_link_false = new TreeNode<>(4);
        TreeNode<Integer> right4_link_false = new TreeNode<>(3);

        root_link_false.right = right1_link_false;
        right1_link_false.right = right2_link_false;
        right2_link_false.right = right3_link_false;
        right3_link_false.right = right4_link_false;

        System.out.println(checkBinSerTree(root_link_false));


    }
}
