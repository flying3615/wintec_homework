package assignment3;


/**
 * Created by liuyufei on 28/09/16.
 */
public class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    int level;

    public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}


	public TreeNode(E element){
        this.element = element;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return element.equals(treeNode.element);

    }

    @Override
    public int hashCode() {
        return element.hashCode();
    }



}
