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
 * @date 2017��12��18��
 */
public class AVLTree<T extends Comparable<T>> {

	/** ����AVL���ĸ��ڵ� */
	private AVLTreeNode<T> mroot;

	/** ������������Ӵ�߶Ȳ� */
	private static int ALLOWED_IMBALANCE = 1;

	/**
	 * ��ȡ�ڵ�ĸ߶�
	 * 
	 * @param node
	 *            ��Ҫ��ȡ�߶ȵĽڵ�
	 * @return �ڵ�ĸ߶�
	 */
	private int height(AVLTreeNode<T> node) {
		return node == null ? -1 : node.getHeight();
	}

	private AVLTreeNode<T> insert(T key, AVLTreeNode<T> node) {

		if (node == null) {
			return new AVLTreeNode<T>(key, null, null);
		}
		int compareResult = key.compareTo(node.getKey());
		// �Ƚڵ�С�����뵽�ڵ��������
		if (compareResult < 0) {

			// ������Ϊ�գ�ֱ�ӽ��ڵ�����ڸ�λ��
			node.setLeftChild(insert(key, node.getLeftChild()));
			// }

		} else if (compareResult > 0) {
			// �Ƚڵ�С�����뵽�ڵ��������
			node.setRightChild(insert(key, node.getRightChild()));
		} else {
			// �Ѿ��ж�Ӧ�Ľڵ㣬ʲôҲ������
		}

		// �ص��������AVL��ƽ��

		return balance(mroot);
	}
	// ����ת
	// ����

	/**
	 * ƽ��AVL������
	 * 
	 * @param root
	 *            ���ڵ�
	 * @return
	 */
	private AVLTreeNode<T> balance(AVLTreeNode<T> root) {

		if (root == null) {
			return null;
		}
		/** �ж��������ͣ��������ҡ����ҡ����� */
		if (height(root.getLeftChild()) - height(root.getRightChild()) > ALLOWED_IMBALANCE) {// ���������������߶ȴ���1
			if (height(root.getLeftChild().getLeftChild()) >= height(root.getLeftChild().getRightChild())) {
				// ���е���ת
				root = singleRotationWithLeftChild(root);
			} else {
				root = doubleRotationWithLeftChild(root);
			}
		} else if (height(root.getRightChild()) - height(root.getLeftChild()) > ALLOWED_IMBALANCE) {// ���������������߶ȴ���1
			if (height(root.getRightChild().getRightChild()) >= height(root.getRightChild().getLeftChild())) {
				root = singleRotateWithRightChild(root);
			} else {
				root = doubleRotateWithRightChild(root);
			}
		}

		return null;
	}

	/**
	 * �Խڵ����������ת
	 * 
	 * @param rotatedNode
	 *            ��Ҫ����������ת�Ľڵ�
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
