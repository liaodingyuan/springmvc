/**
 * 
 */
package basecc.DataStructure.binarytree;

/**
 * <p>
 * Title:Node
 * </p>
 * <p>
 * Description: 定义二叉树的节点
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年12月17日
 */
public class Node {

	/** 节点的值 */
	private int value;
	/** 节点的左孩子 */
	private Node leftChild;
	/** 节点的右孩子 */
	private Node RightChild;

	/**
	 * default constructor
	 * 
	 * @param value
	 */
	public Node(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the leftChild
	 */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild
	 *            the leftChild to set
	 */
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public Node getRightChild() {
		return RightChild;
	}

	/**
	 * @param rightChild
	 *            the rightChild to set
	 */
	public void setRightChild(Node rightChild) {
		RightChild = rightChild;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public void display() {
		System.out.print(this.value + "\t");
	}

}
