/**
 * 
 */
package basecc.DataStructure.binarytree;

import java.util.Stack;

/**
 * <p>
 * Title:BinaryTree
 * </p>
 * <p>
 * Description:Java֮�������Ļ���������ʵ�ʲ�����������ö�������ɾ������̫���ڷ����Ļ�������ʹ������ɾ��
 * </p>
 * <p>
 * Company:yuanhaha
 * </p>
 * 
 * @author liaody
 * @date 2017��12��17��
 */
public class BinaryTree {

	/** ���ø��ڵ� */
	private Node root = null;

	/**
	 * ���ö�����
	 * 
	 * @param value
	 */
	public BinaryTree(int value) {
		// ��ʼ�����������ڵ�
		root = new Node(value);
		// ����������Ϊ��
		root.setLeftChild(null);
		// ����������Ϊ��
		root.setRightChild(null);
	}

	/**
	 * ʹ�õݹ�ʵ�ֲ���
	 * 
	 * @param binaryTree
	 *            ���ҷ�Χ���
	 * @param keyNode
	 *            ���ҵĹؼ���
	 * @return ��ؼ���ֵ��ȵĵĽڵ�
	 */
	private Node findKeyRe(final Node binaryTree, final Node keyNode) {
		// �ش�bug��û�еݹ�ѭ������
		if (binaryTree == null) {
			System.out.println("����ʧ�ܣ�û�и���ֵ");
			return null;
		}
		// �ȸ��ڵ�С�����������в���
		if (keyNode.getValue() < binaryTree.getValue()) {
			return findKeyRe(binaryTree.getLeftChild(), keyNode);
		} else if (keyNode.getValue() > binaryTree.getValue()) {
			// �ȸ��ڵ�����������в���
			return findKeyRe(binaryTree.getRightChild(), keyNode);
		}
		// �����봫��Ľڵ��ֵ��ͬ�����ش���Ľڵ�
		System.out.println("���ҵ����" + binaryTree.getValue());
		return binaryTree;
		// }
	}

	/**
	 * ʹ��ѭ����д�ݹ顣
	 * 
	 * @param key
	 *            ���ҵĹؼ���
	 * @return ��ؼ���ֵ��ȵĵĽڵ�
	 */
	@SuppressWarnings("unused")
	private Node findkeyByWihle(final int key) {
		Node current = root;
		while (true) {
			// �봫��Ľڵ��ֵ��ͬ�����ش���Ľڵ�
			if (current.getValue() == key) {
				return current;
			}
			// �ȸ��ڵ�С�����������в���
			if (current.getValue() > key) {
				current = current.getLeftChild();
			}
			// �ȸ��ڵ�����������в���
			if (root.getValue() < key) {
				current = current.getLeftChild();
			}
			if (current == null) {
				return null;
			}
		}
	}

	/**
	 * ����������ؼ�����ȵĽڵ�
	 * 
	 * @param value
	 *            ���ҵĹؼ���
	 * @return ��ؼ���ֵ��ȵĵĽڵ�
	 */
	public Node findKey(final int value) {
		Node keyNode = new Node(value);
		keyNode.setLeftChild(null);
		keyNode.setRightChild(null);
		return findKeyRe(root, keyNode);
	}

	/**
	 * �ǵݹ����ڵ�
	 * 
	 * @param key
	 *            Ҫ�����Ԫ�ص�ֵ
	 * @return
	 */
	public String insertWihle(final int key) {

		// ������ʾ��Ϣ
		String error = "";

		// ����������ڵ�
		Node keyNode = new Node(key);
		root.setLeftChild(null);
		root.setRightChild(null);
		// �����һ��������ֱ�ӰѲ���ڵ㵱�����ڵ㡣��������
		if (root == null) {
			root = keyNode;
			return String.valueOf(root.getValue());
		}
		// �ǿ���
		Node current = root;
		while (true) {
			// ����Ӧ�Ľڵ��ֵ��ȣ�����ѭ��
			if (key == current.getValue()) {
				error = "�Ѿ�������Ԫ��";
				break;
			}
			// ����Ӧ�Ľڵ�С�����뵽��������������
			if (key < current.getValue()) {
				// ���������Ϊ�գ�ֱ�Ӳ��뵽��λ��
				if (current.getLeftChild() == null) {
					current.setLeftChild(keyNode);
					break;
				} else {
					// �����������Ϊ�գ���������������Ѱ��Ҫ�����λ��
					current = current.getLeftChild();
				}
			}
			// ����Ӧ�Ľڵ�󣬲��뵽��������������
			if (key > current.getValue()) {
				// ���������Ϊ�գ�ֱ�Ӳ��뵽��λ��
				if (current.getRightChild() == null) {
					current.setRightChild(keyNode);
					break;
				} else {
					// �����������Ϊ�գ���������������Ѱ��Ҫ�����λ��
					current = current.getRightChild();
				}
			}
		}
		return error;
	}

	/**
	 * ʹ�õݹ�ķ�ʽ����Ԫ��
	 * 
	 * @param current
	 * @param key
	 * @return
	 */
	public boolean insertRe(final Node current, final int key) {
		// �Ƚڵ��ֵС��������������λ�ò���Ԫ��
		if (key < current.getValue()) {
			if (current.getLeftChild() == null) {
				current.setLeftChild(new Node(key));
			}
			insertRe(current.getLeftChild(), key);
		} else if (key > current.getValue()) {// �Ƚڵ��ֵ��������������λ�ò���Ԫ��
			if (current.getRightChild() == null) {
				current.setRightChild(new Node(key));
			}
			insertRe(current.getRightChild(), key);
		} else {// ��ڵ��ֵ���
			System.out.println("����ʧ�ܣ����������Ѿ�������Ԫ��");
			return false;
		}
		return false;
	}

	/**
	 * @param key
	 */
	private void insert(final int key) {
		// ����������ڵ�
		Node keyNode = new Node(key);
		keyNode.setLeftChild(null);
		keyNode.setRightChild(null);
		// �����һ����������ֱ�ӰѲ���ڵ㵱�����ڵ㣬����true��ʾ����ɹ����������á�
		if (root == null) {
			root = keyNode;
			return;
		}
		Node current = root;
		// ���뵽����������
		if (key < current.getValue()) {

			// ����Ҫ����һ���жϣ�ȷ�����ᱨ��ָ���쳣
			if (current.getLeftChild() == null) {
				current.setLeftChild(keyNode);
				return;// �ݹ����
			} else {
				insertRe(current.getLeftChild(), keyNode);
			}
		}
		// ���뵽����������
		if (key > current.getValue()) {
			if (current.getRightChild() == null) {
				current.setRightChild(keyNode);
				return;
			} else {
				insertRe(current.getRightChild(), keyNode);
			}
		}

	}

	private void insertRe(Node binaryTree, final Node node) {
		// ���뵽����������
		if (node.getValue() < binaryTree.getValue()) {

			if (binaryTree.getLeftChild() == null) {
				binaryTree.setLeftChild(node);
				return;// �ݹ����
			} else {
				// ���������ߣ�ֱ���ҵ��յ�λ��
				insertRe(binaryTree.getLeftChild(), node);
			}
		}
		// ���뵽����������
		if (node.getValue() > binaryTree.getValue()) {

			// �Ѿ������ң�����ڵ�
			if (binaryTree.getRightChild() == null) {
				binaryTree.setRightChild(node);
				return;// �ݹ����
			} else {
				// ���������ߣ�ֱ���ҵ��յ�λ��
				insertRe(binaryTree.getRightChild(), node);
			}
		}
	}

	/** ��õ�һ�ֱ���������������� */
	// ��������ݹ����
	public void inOrderTraverse() {
		System.out.print("�������:");
		inOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 
	 * @param root
	 */
	private void inOrderTraverse(Node current) {

		if (current == null) {
			return;
		}
		// ����Ҫ������������Ϊ�յ��ж�
		// ��������ȴ�ӡ������
		// if (current.getLeftChild() != null) {
		inOrderTraverse(current.getLeftChild());
		// }
		// �ٴ�ӡ�ڵ�
		current.display();
		// ����ӡ������
		// if (current.getRightChild() != null) {
		inOrderTraverse(current.getRightChild());
		// }
	}

	// ��������ǵݹ����
	/**
	 * * ������ڵ�current������ýڵ㲻Ϊ���򽫽ڵ�ѹ��ջ�������������Ľڵ�����Ϊcurrent���ظ�������֪��currentΪ�ա�
	 * ��������Ϊ�գ�ջ��Ԫ�س�ջ�����ʽڵ�󽫽ڵ������������Ϊcurrent�� �ظ���������裬ֱ��currentΪ����վ�ڽڵ�Ϊ�ա�
	 */
	public void inOrderByStack() {

		System.out.print("����ǵݹ����:");
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.getLeftChild();
			}

			if (!stack.isEmpty()) {
				current = stack.pop();
				current.display();
				current = current.getRightChild();
			}
		}
		System.out.println();
	}

	/**
	 * ���õݹ��ǰ�����
	 */
	public void preOrderTraverse() {
		System.out.print("ǰ�����:");
		preOrderTraverse(root);
		System.out.println();
	}

	/**
	 * �ݹ�ǰ�����
	 * 
	 * @param node
	 */
	private void preOrderTraverse(Node node) {
		// �ݹ����
		if (node == null) {
			return;
		}
		node.display();
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
	}

	// ǰ������ǵݹ����
	public void preOrderByStack() {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		// ��������ڵ�current������ýڵ㲻Ϊ������ʽڵ�֮���ٽ��ڵ�ѹ��ջ���ظ��˲���֪��currentΪ��
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current.display();
				current = current.getLeftChild();
			}
			if (!stack.empty()) {
				current = stack.pop();
				current = current.getRightChild();
			}
		}
		System.out.println();
	}

	/**
	 * ʹ�õݹ�ĺ������
	 */
	public void postOrderTraverse() {
		System.out.print("�������:");
		postOrderTraverse(root);
		System.out.println();
	}

	/**
	 * ʹ�õݹ�ĺ������
	 * 
	 * @param node
	 */
	private void postOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		postOrderTraverse(node.getLeftChild());
		postOrderTraverse(node.getRightChild());
		node.display();
	}

	// ��������ǵݹ����
	public void postOrderByStack() {
	}

	/**
	 * ��ȡ����������Сֵ����������������
	 * 
	 * @return ��Сֵ
	 */
	public int getMinValue() {
		// һ·���󼴿ɵõ���Сֵ
		Node current = root;
		while (true) {
			if (current.getLeftChild() == null) {
				return current.getValue();
			}
			current = current.getLeftChild();
		}
	}

	/**
	 * ��ȡ������ �����ֵ�����������Һ���
	 * 
	 * @return ���ֵ
	 */
	public int getMaxValue() {
		Node current = root;
		while (true) {
			if (current.getRightChild() == null) {
				return current.getValue();
			}
			current = current.getRightChild();
		}
	}

	/**
	 * ɾ��������ֵ��Ӧ�Ľڵ�. ���1��ɾ��Ҷ�ӽڵ㡣�������ֱ��ɾ���� ���2��ֻ��һ�����ӣ�ֱ���ñ�ɾ����ĸ��ڵ����ӵ����ӽڵ㡣
	 * ���3����ɾ���Ľڵ����������ӣ���������Ƚϸ��ӣ���ҪѰ�Һ�̽ڵ㣬����Ҫɾ���Ľڵ�Ĺؼ�ֵ�θߵĽڵ������ĺ�̽ڵ㡣
	 * ˵�ü�һЩ����̽ڵ���Ǳ�Ҫɾ���Ľڵ�Ĺؼ�ֵҪ��Ľڵ㼯���е���Сֵ�������������
	 * 
	 * @param key
	 *            �ؼ���
	 * @return ɾ���ɹ�����true��ɾ��ʧ���򷵻�false
	 */
	public boolean delete(int value) {
		Node current = root; // ��Ҫɾ���Ľڵ�
		Node parent = null; // ��Ҫɾ���Ľڵ�ĸ��ڵ�
		boolean isLeftChild = true; // ��Ҫɾ���Ľڵ��Ƿ񸸽ڵ��������
		while (true) {
			if (value == current.getValue()) {
				break;
			} else if (value < current.getValue()) {
				isLeftChild = true;
				parent = current;
				current = current.getLeftChild();
			} else {
				isLeftChild = false;
				parent = current;
				current = current.getRightChild();
			}
			// �Ҳ�����Ҫɾ���Ľڵ㣬ֱ�ӷ���
			if (current == null) {
				return false;
			}
		}

		// ���������
		// 1����Ҫɾ���Ľڵ�ΪҶ�ӽڵ�
		if (current.getLeftChild() == null && current.getRightChild() == null) {
			// �����Ҷ�ڵ�Ϊ���ڵ㣬�����ڵ���Ϊnull
			if (current == root) {
				root = null;
			} else {
				// �����Ҷ�ڵ��Ǹ��ڵ�����ӽڵ㣬�����ڵ�����ӽڵ���Ϊnull
				if (isLeftChild) {
					parent.setLeftChild(null);
				} else { // �����Ҷ�ڵ��Ǹ��ڵ�����ӽڵ㣬�����ڵ�����ӽڵ���Ϊnull
					parent.setRightChild(null);
				}
			}
		}
		// 2����Ҫɾ���Ľڵ���һ���ӽڵ㣬�Ҹ��ӽڵ�Ϊ���ӽڵ�
		else if (current.getRightChild() == null) {
			// ����ýڵ�Ϊ���ڵ㣬�����ڵ�����ӽڵ��Ϊ���ڵ�
			if (current == root) {
				root = current.getLeftChild();
			} else {
				// ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�
				if (isLeftChild) {
					parent.setLeftChild(current.getLeftChild());
				} else { // ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�
					parent.setRightChild(current.getLeftChild());
				}
			}
		}
		// 2����Ҫɾ���Ľڵ���һ���ӽڵ㣬�Ҹ��ӽڵ�Ϊ���ӽڵ�
		else if (current.getLeftChild() == null) {
			// ����ýڵ�Ϊ���ڵ㣬�����ڵ�����ӽڵ��Ϊ���ڵ�
			if (current == root) {
				root = current.getRightChild();
			} else {
				// ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�
				if (isLeftChild) {
					parent.setLeftChild(current.getRightChild());
				} else { // ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�����ӽڵ��Ϊ���ڵ�����ӽڵ�
					parent.setRightChild(current.getRightChild());
				}
			}
		}
		// 3����Ҫɾ���Ľڵ��������ӽڵ㣬��ҪѰ�Ҹýڵ�ĺ����ڵ����ɾ���ڵ�
		else {
			Node successor = getSuccessor(current);
			// ����ýڵ�Ϊ���ڵ㣬����̽ڵ��Ϊ���ڵ㣬�������ڵ�����ӽڵ��Ϊ��̽ڵ�����ӽڵ�
			if (current == root) {
				root = successor;
			} else {
				// ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�ĺ�̽ڵ��Ϊ���ڵ�����ӽڵ�
				if (isLeftChild) {
					parent.setLeftChild(successor);
				} else { // ����ýڵ��Ǹ��ڵ�����ӽڵ㣬���ýڵ�ĺ�̽ڵ��Ϊ���ڵ�����ӽڵ�
					parent.setRightChild(successor);
				}
			}
		}
		current = null;
		return true;

	}

	/**
	 * 
	 * �õ���̽ڵ㣬��ɾ���ڵ������
	 */
	private Node getSuccessor(Node delNode) {
		Node successor = delNode;
		Node successorParent = null;
		Node current = delNode.getRightChild();

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}

		// �����̽ڵ㲻��ɾ���ڵ�����ӽڵ�ʱ��
		if (successor != delNode.getRightChild()) {
			// Ҫ����̽ڵ�����ӽڵ�ָ���̽�㸸�ڵ�����ӽڵ㣬
			successorParent.setLeftChild(successor.getRightChild());
			// ����ɾ���ڵ�����ӽڵ�ָ���̽������ӽڵ�
			successor.setRightChild(delNode.getRightChild());
		}
		// �κ�����£�����Ҫ��ɾ���ڵ�����ӽڵ�ָ���̽ڵ�����ӽڵ�
		successor.setLeftChild(delNode.getLeftChild());

		return successor;
	}

	/**
	 * 
	 * @param node
	 *            ��Ҫ��߶ȵĽڵ�
	 * @return �ڵ�����
	 */
	public int deep(final Node node) {

		return 0;
	}

	/**
	 * �����ĸ߶�
	 * 
	 * @return ���ĸ߶�
	 */
	public int treeHeight(final Node node) {

		if (node == null) {
			return 0;
		}
		int lHeight = treeHeight(node.getLeftChild());
		int rHeight = treeHeight(node.getRightChild());
		if (lHeight > rHeight) {
			return lHeight + 1;
		}
		return rHeight + 1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree(52);
		bt.insert(580);
		bt.insert(12);
		bt.insert(50);
		bt.insert(58);
		bt.insert(9);
		bt.insert(888);
		bt.insert(248);
		bt.insert(32);
		bt.insert(666);
		bt.insert(455);
		bt.insert(777);
		bt.insert(999);
		bt.inOrderTraverse();
		bt.preOrderTraverse();
		bt.postOrderTraverse();
		System.out.println(bt.findKey(777));
		System.out.println(bt.findKey(81));
		System.out.println("��Сֵ:" + bt.getMinValue());
		// bt.delete(32); //ɾ��Ҷ�ӽڵ�
		bt.delete(50); // ɾ��ֻ��һ�����ӽڵ�Ľڵ�
		// bt.delete(248); //ɾ��ֻ��һ�����ӽڵ�Ľڵ�
		// bt.delete(248); //ɾ��ֻ��һ�����ӽڵ�Ľڵ�
		bt.delete(580); // ɾ���������ӽڵ�Ľڵ㣬�Һ�̽ڵ�Ϊɾ���ڵ�����ӽڵ������
		// bt.delete(888); //ɾ���������ӽڵ�Ľڵ㣬�Һ�̽ڵ�Ϊɾ���ڵ�����ӽڵ�
		// bt.delete(52); // ɾ���������ӽڵ�Ľڵ㣬��ɾ���ڵ�Ϊ���ڵ�

		bt.inOrderTraverse();

	}

}
