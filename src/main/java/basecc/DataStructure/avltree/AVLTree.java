/**
 * 
 */
package basecc.DataStructure.avltree;

/**
 * <p>
 * Title:AVLTree
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年12月18日
 */
public class AVLTree<T extends Comparable<T>> {

	/** 定义AVL树的根节点 */
	private AVLTreeNode<T> mroot;

	/** 左右子树的组队打高度差 */
	private static int ALLOWED_IMBALANCE = 1;

	/**
	 * 获取节点的高度
	 * 
	 * @param node
	 *            需要获取高度的节点
	 * @return 节点的高度
	 */
	private int height(AVLTreeNode<T> node) {
		return node == null ? -1 : node.getHeight();
	}

	private AVLTreeNode<T> insert(T key, AVLTreeNode<T> node) {

		if (node == null) {
			return new AVLTreeNode<T>(key, null, null);
		}
		int compareResult = key.compareTo(node.getKey());
		// 比节点小，插入到节点的左子树
		if (compareResult < 0) {

			// 左子树为空，直接将节点放置在该位置
			node.setLeftChild(insert(key, node.getLeftChild()));
			// }

		} else if (compareResult > 0) {
			// 比节点小，插入到节点的右子树
			node.setRightChild(insert(key, node.getRightChild()));
		} else {
			// 已经有对应的节点，什么也不做。
		}

		// 重点操作，是AVL树平衡

		return balance(mroot);
	}
	// 右旋转
	// 插入

	/**
	 * 平衡AVL树操作
	 * 
	 * @param root
	 *            根节点
	 * @return
	 */
	private AVLTreeNode<T> balance(AVLTreeNode<T> root) {

		if (root == null) {
			return null;
		}
		/** 判断四种类型：左左、右右、左右、右左 */
		if (height(root.getLeftChild()) - height(root.getRightChild()) > ALLOWED_IMBALANCE) {// 左子树比右子树高度大于1
			if (height(root.getLeftChild().getLeftChild()) >= height(root.getLeftChild().getRightChild())) {
				// 进行单旋转
				root = singleRotationWithLeftChild(root);
			} else {
				root = doubleRotationWithLeftChild(root);
			}
		} else if (height(root.getRightChild()) - height(root.getLeftChild()) > ALLOWED_IMBALANCE) {// 右子树比左子树高度大于1
			if (height(root.getRightChild().getRightChild()) >= height(root.getRightChild().getLeftChild())) {
				root = singleRotateWithRightChild(root);
			} else {
				root = doubleRotateWithRightChild(root);
			}
		}

		return null;
	}

	/**
	 * 对节点进行左左旋转
	 * 
	 * @param rotatedNode
	 *            需要进行左左旋转的节点
	 * @return
	 */
	private AVLTreeNode<T> singleRotationWithLeftChild(AVLTreeNode<T> rotatedNode) {
		
		AVLTreeNode<T> rotatedNodeLeftChild = rotatedNode.getLeftChild();

		rotatedNode.setLeftChild(rotatedNodeLeftChild.getRightChild());
		rotatedNodeLeftChild.setRightChild(rotatedNode);
		
		rotatedNodeLeftChild.setHeight(Math.max(rotatedNodeLeftChild.getHeight(), rotatedNode.getHeight())+1);
		

		return null;
	}

	/**
	 * @param root
	 * @return
	 */
	private AVLTreeNode<T> doubleRotateWithRightChild(AVLTreeNode<T> root) {
		return null;
	}

	/**
	 * @param root
	 * @return
	 */
	private AVLTreeNode<T> singleRotateWithRightChild(AVLTreeNode<T> root) {
		return null;
	}

	/**
	 * @param root
	 * @return
	 */
	private AVLTreeNode<T> doubleRotationWithLeftChild(AVLTreeNode<T> root) {
		return null;
	}

}
