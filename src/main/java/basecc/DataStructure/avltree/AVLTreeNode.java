/**
 * 
 */
package basecc.DataStructure.avltree;

/**
 * <p>
 * Title:AVLTreeNode
 * </p>
 * <p>
 * Description:AVL树的节点
 * </p>
 * <p>
 * Company:yuanhaha
 * </p>
 * 
 * @author liaody
 * @date 2017年12月18日
 */
public class AVLTreeNode<T extends Comparable<T>> {

	/** 关键字 */
	private T key;
	/** AVL树的高度 */
	private int height;
	/** AVL树节点的左子树 */
	private AVLTreeNode<T> leftChild;
	/** AVL树的右子树 */
	private AVLTreeNode<T> rightChild;

	/**
	 * 构建AVL树
	 * 
	 * @param key
	 *            关键字
	 */
	public AVLTreeNode(final T key) {
		this(key, null, null);
	}

	/**
	 * 构建AVL树
	 * 
	 * @param key
	 *            关键字
	 * @param leftChild
	 *            节点的左孩子
	 * @param rightChild
	 *            节点的右孩子
	 */
	public AVLTreeNode(final T key, AVLTreeNode<T> leftChild, AVLTreeNode<T> rightChild) {
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.height = 0;
	}

	/**
	 * @return the key
	 */
	public T getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(T key) {
		this.key = key;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the leftChild
	 */
	public AVLTreeNode<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild
	 *            the leftChild to set
	 */
	public void setLeftChild(AVLTreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public AVLTreeNode<T> getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild
	 *            the rightChild to set
	 */
	public void setRightChild(AVLTreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return key.toString();
	}

}
