/**
 * 
 */
package basecc.DataStructure.avltree;

/**
 * <p>
 * Title:AVLTreeNode
 * </p>
 * <p>
 * Description:AVL���Ľڵ�
 * </p>
 * <p>
 * Company:yuanhaha
 * </p>
 * 
 * @author liaody
 * @date 2017��12��18��
 */
public class AVLTreeNode<T extends Comparable<T>> {

	/** �ؼ��� */
	private T key;
	/** AVL���ĸ߶� */
	private int height;
	/** AVL���ڵ�������� */
	private AVLTreeNode<T> leftChild;
	/** AVL���������� */
	private AVLTreeNode<T> rightChild;

	/**
	 * ����AVL��
	 * 
	 * @param key
	 *            �ؼ���
	 */
	public AVLTreeNode(final T key) {
		this(key, null, null);
	}

	/**
	 * ����AVL��
	 * 
	 * @param key
	 *            �ؼ���
	 * @param leftChild
	 *            �ڵ������
	 * @param rightChild
	 *            �ڵ���Һ���
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
