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
 * Description:Java之二叉树的基本操作。实际操作中如果觉得二叉树的删除操作太过于繁琐的话，可以使用懒惰删除
 * </p>
 * <p>
 * Company:yuanhaha
 * </p>
 * 
 * @author liaody
 * @date 2017年12月17日
 */
public class BinaryTree {

	/** 设置根节点 */
	private Node root = null;

	/**
	 * 设置二叉树
	 * 
	 * @param value
	 */
	public BinaryTree(int value) {
		// 初始化二叉树根节点
		root = new Node(value);
		// 设置左子树为空
		root.setLeftChild(null);
		// 设置右子树为空
		root.setRightChild(null);
	}

	/**
	 * 使用递归实现查找
	 * 
	 * @param binaryTree
	 *            查找范围起点
	 * @param keyNode
	 *            查找的关键字
	 * @return 与关键字值相等的的节点
	 */
	private Node findKeyRe(final Node binaryTree, final Node keyNode) {
		// 重大bug，没有递归循环出口
		if (binaryTree == null) {
			System.out.println("查找失败，没有该项值");
			return null;
		}
		// 比根节点小，在左子树中查找
		if (keyNode.getValue() < binaryTree.getValue()) {
			return findKeyRe(binaryTree.getLeftChild(), keyNode);
		} else if (keyNode.getValue() > binaryTree.getValue()) {
			// 比根节点大，在右子树中查找
			return findKeyRe(binaryTree.getRightChild(), keyNode);
		}
		// 否则，与传入的节点的值相同，返回传入的节点
		System.out.println("查找到该项：" + binaryTree.getValue());
		return binaryTree;
		// }
	}

	/**
	 * 使用循环改写递归。
	 * 
	 * @param key
	 *            查找的关键字
	 * @return 与关键字值相等的的节点
	 */
	@SuppressWarnings("unused")
	private Node findkeyByWihle(final int key) {
		Node current = root;
		while (true) {
			// 与传入的节点的值相同，返回传入的节点
			if (current.getValue() == key) {
				return current;
			}
			// 比根节点小，在左子树中查找
			if (current.getValue() > key) {
				current = current.getLeftChild();
			}
			// 比根节点大，在右子树中查找
			if (root.getValue() < key) {
				current = current.getLeftChild();
			}
			if (current == null) {
				return null;
			}
		}
	}

	/**
	 * 查找与给定关键字相等的节点
	 * 
	 * @param value
	 *            查找的关键字
	 * @return 与关键字值相等的的节点
	 */
	public Node findKey(final int value) {
		Node keyNode = new Node(value);
		keyNode.setLeftChild(null);
		keyNode.setRightChild(null);
		return findKeyRe(root, keyNode);
	}

	/**
	 * 非递归插入节点
	 * 
	 * @param key
	 *            要插入的元素的值
	 * @return
	 */
	public String insertWihle(final int key) {

		// 错误提示消息
		String error = "";

		// 创建待插入节点
		Node keyNode = new Node(key);
		root.setLeftChild(null);
		root.setRightChild(null);
		// 如果是一个空树，直接把插入节点当做根节点。结束调用
		if (root == null) {
			root = keyNode;
			return String.valueOf(root.getValue());
		}
		// 非空树
		Node current = root;
		while (true) {
			// 和相应的节点的值相等，跳出循环
			if (key == current.getValue()) {
				error = "已经包含该元素";
				break;
			}
			// 比相应的节点小，插入到它的左子树当中
			if (key < current.getValue()) {
				// 如果左子树为空，直接插入到该位置
				if (current.getLeftChild() == null) {
					current.setLeftChild(keyNode);
					break;
				} else {
					// 如果左子树不为空，继续在左子树中寻找要插入的位置
					current = current.getLeftChild();
				}
			}
			// 比相应的节点大，插入到它的右子树当中
			if (key > current.getValue()) {
				// 如果右子树为空，直接插入到该位置
				if (current.getRightChild() == null) {
					current.setRightChild(keyNode);
					break;
				} else {
					// 如果右子树不为空，继续在右子树中寻找要插入的位置
					current = current.getRightChild();
				}
			}
		}
		return error;
	}

	/**
	 * 使用递归的方式插入元素
	 * 
	 * @param current
	 * @param key
	 * @return
	 */
	public boolean insertRe(final Node current, final int key) {
		// 比节点的值小，在左子树中找位置插入元素
		if (key < current.getValue()) {
			if (current.getLeftChild() == null) {
				current.setLeftChild(new Node(key));
			}
			insertRe(current.getLeftChild(), key);
		} else if (key > current.getValue()) {// 比节点的值大，在右子树中找位置插入元素
			if (current.getRightChild() == null) {
				current.setRightChild(new Node(key));
			}
			insertRe(current.getRightChild(), key);
		} else {// 与节点的值相等
			System.out.println("插入失败，二叉树中已经包含该元素");
			return false;
		}
		return false;
	}

	/**
	 * @param key
	 */
	private void insert(final int key) {
		// 创建待插入节点
		Node keyNode = new Node(key);
		keyNode.setLeftChild(null);
		keyNode.setRightChild(null);
		// 如果是一个空树，，直接把插入节点当做根节点，返回true表示插入成功，结束调用。
		if (root == null) {
			root = keyNode;
			return;
		}
		Node current = root;
		// 插入到左子树当中
		if (key < current.getValue()) {

			// 这里要进行一次判断，确保不会报空指针异常
			if (current.getLeftChild() == null) {
				current.setLeftChild(keyNode);
				return;// 递归出口
			} else {
				insertRe(current.getLeftChild(), keyNode);
			}
		}
		// 插入到右子树当中
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
		// 插入到左子树当中
		if (node.getValue() < binaryTree.getValue()) {

			if (binaryTree.getLeftChild() == null) {
				binaryTree.setLeftChild(node);
				return;// 递归出口
			} else {
				// 继续向左走，直到找到空的位置
				insertRe(binaryTree.getLeftChild(), node);
			}
		}
		// 插入到右子树当中
		if (node.getValue() > binaryTree.getValue()) {

			// 已经到最右，插入节点
			if (binaryTree.getRightChild() == null) {
				binaryTree.setRightChild(node);
				return;// 递归出口
			} else {
				// 继续向右走，直到找到空的位置
				insertRe(binaryTree.getRightChild(), node);
			}
		}
	}

	/** 最常用的一种遍历方法是中序遍历 */
	// 中序遍历递归操作
	public void inOrderTraverse() {
		System.out.print("中序遍历:");
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
		// 不需要进行左右子树为空的判断
		// 中序遍历先打印左子树
		// if (current.getLeftChild() != null) {
		inOrderTraverse(current.getLeftChild());
		// }
		// 再打印节点
		current.display();
		// 最后打印右子树
		// if (current.getRightChild() != null) {
		inOrderTraverse(current.getRightChild());
		// }
	}

	// 中序遍历非递归操作
	/**
	 * * 对任意节点current，如果该节点不为空则将节点压入栈，并将左子树的节点设置为current，重复操作，知道current为空。
	 * 若左子树为空，栈顶元素出栈。访问节点后将节点的右子树设置为current。 重复上输入后步骤，直到current为空且站内节点为空。
	 */
	public void inOrderByStack() {

		System.out.print("中序非递归遍历:");
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
	 * 采用递归的前序遍历
	 */
	public void preOrderTraverse() {
		System.out.print("前序遍历:");
		preOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 递归前序遍历
	 * 
	 * @param node
	 */
	private void preOrderTraverse(Node node) {
		// 递归出口
		if (node == null) {
			return;
		}
		node.display();
		preOrderTraverse(node.getLeftChild());
		preOrderTraverse(node.getRightChild());
	}

	// 前序遍历非递归操作
	public void preOrderByStack() {
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		// 对于任意节点current，如果该节点不为空则访问节点之后再将节点压入栈，重复此操作知道current为空
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
	 * 使用递归的后序遍历
	 */
	public void postOrderTraverse() {
		System.out.print("后序遍历:");
		postOrderTraverse(root);
		System.out.println();
	}

	/**
	 * 使用递归的后序遍历
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

	// 后序遍历非递归操作
	public void postOrderByStack() {
	}

	/**
	 * 获取二叉树的最小值。左子树的最左孩子
	 * 
	 * @return 最小值
	 */
	public int getMinValue() {
		// 一路向左即可得到最小值
		Node current = root;
		while (true) {
			if (current.getLeftChild() == null) {
				return current.getValue();
			}
			current = current.getLeftChild();
		}
	}

	/**
	 * 获取二叉树 的最大值。右子树的右孩子
	 * 
	 * @return 最大值
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
	 * 删除给定的值对应的节点. 情况1：删除叶子节点。这种情况直接删除。 情况2：只有一个孩子，直接让被删除点的父节点链接到孩子节点。
	 * 情况3：被删除的节点有两个孩子，这种情况比较复杂，需要寻找后继节点，即比要删除的节点的关键值次高的节点是它的后继节点。
	 * 说得简单一些，后继节点就是比要删除的节点的关键值要大的节点集合中的最小值。（右子树中最）
	 * 
	 * @param key
	 *            关键字
	 * @return 删除成功返回true，删除失败则返回false
	 */
	public boolean delete(int value) {
		Node current = root; // 需要删除的节点
		Node parent = null; // 需要删除的节点的父节点
		boolean isLeftChild = true; // 需要删除的节点是否父节点的左子树
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
			// 找不到需要删除的节点，直接返回
			if (current == null) {
				return false;
			}
		}

		// 分情况考虑
		// 1、需要删除的节点为叶子节点
		if (current.getLeftChild() == null && current.getRightChild() == null) {
			// 如果该叶节点为根节点，将根节点置为null
			if (current == root) {
				root = null;
			} else {
				// 如果该叶节点是父节点的左子节点，将父节点的左子节点置为null
				if (isLeftChild) {
					parent.setLeftChild(null);
				} else { // 如果该叶节点是父节点的右子节点，将父节点的右子节点置为null
					parent.setRightChild(null);
				}
			}
		}
		// 2、需要删除的节点有一个子节点，且该子节点为左子节点
		else if (current.getRightChild() == null) {
			// 如果该节点为根节点，将根节点的左子节点变为根节点
			if (current == root) {
				root = current.getLeftChild();
			} else {
				// 如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
				if (isLeftChild) {
					parent.setLeftChild(current.getLeftChild());
				} else { // 如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点
					parent.setRightChild(current.getLeftChild());
				}
			}
		}
		// 2、需要删除的节点有一个子节点，且该子节点为右子节点
		else if (current.getLeftChild() == null) {
			// 如果该节点为根节点，将根节点的右子节点变为根节点
			if (current == root) {
				root = current.getRightChild();
			} else {
				// 如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
				if (isLeftChild) {
					parent.setLeftChild(current.getRightChild());
				} else { // 如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点
					parent.setRightChild(current.getRightChild());
				}
			}
		}
		// 3、需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
		else {
			Node successor = getSuccessor(current);
			// 如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
			if (current == root) {
				root = successor;
			} else {
				// 如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
				if (isLeftChild) {
					parent.setLeftChild(successor);
				} else { // 如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
					parent.setRightChild(successor);
				}
			}
		}
		current = null;
		return true;

	}

	/**
	 * 
	 * 得到后继节点，即删除节点的左后代
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

		// 如果后继节点不是删除节点的右子节点时，
		if (successor != delNode.getRightChild()) {
			// 要将后继节点的右子节点指向后继结点父节点的左子节点，
			successorParent.setLeftChild(successor.getRightChild());
			// 并将删除节点的右子节点指向后继结点的右子节点
			successor.setRightChild(delNode.getRightChild());
		}
		// 任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
		successor.setLeftChild(delNode.getLeftChild());

		return successor;
	}

	/**
	 * 
	 * @param node
	 *            需要求高度的节点
	 * @return 节点的深度
	 */
	public int deep(final Node node) {

		return 0;
	}

	/**
	 * 求树的高度
	 * 
	 * @return 树的高度
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
		System.out.println("最小值:" + bt.getMinValue());
		// bt.delete(32); //删除叶子节点
		bt.delete(50); // 删除只有一个左子节点的节点
		// bt.delete(248); //删除只有一个右子节点的节点
		// bt.delete(248); //删除只有一个右子节点的节点
		bt.delete(580); // 删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
		// bt.delete(888); //删除有两个子节点的节点，且后继节点为删除节点的右子节点
		// bt.delete(52); // 删除有两个子节点的节点，且删除节点为根节点

		bt.inOrderTraverse();

	}

}
