/**
 * 
 */
package basecc.DataStructure.binarytree;

/**
 * <p>
 * Title:Node
 * </p>
 * <p>
 * Description: ����������Ľڵ�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��12��17��
 */
public class Node {

	/** �ڵ��ֵ */
	private int value;
	/** �ڵ������ */
	private Node leftChild;
	/** �ڵ���Һ��� */
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
