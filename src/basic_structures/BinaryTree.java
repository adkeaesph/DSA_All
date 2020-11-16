package basic_structures;

public class BinaryTree<T> {
	private T root;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree() {
		root = null;
		left = null;
		right = null;
	}
	
	public BinaryTree(T root) {
		this();
		this.root = root;
	}

	public T getRoot() {
		return root;
	}

	public void setRoot(T root) {
		this.root = root;
	}
	
	public BinaryTree<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTree<T> left) {
		this.left = left;
	}

	public BinaryTree<T> getRight() {
		return right;
	}

	public void setRight(BinaryTree<T> right) {
		this.right = right;
	}

	public void inOrderTraversal() {
		if(left!=null)
			left.inOrderTraversal();
		System.out.print(root+" ");
		if(right!=null)
			right.inOrderTraversal();
	}
	
	public void preOrderTraversal() {
		System.out.print(root+" ");
		if(left!=null)
			left.preOrderTraversal();
		if(right!=null)
			right.preOrderTraversal();
	}
	
	public void postOrderTraversal() {
		if(left!=null)
			left.postOrderTraversal();
		if(right!=null)
			right.postOrderTraversal();
		System.out.print(root+" ");
	}
	
	public void levelOrderTraversal() {
		
	}
	
	public int getHeight() {
		int leftHeight = 0, rightHeight = 0;
		if(left!=null)
			leftHeight = left.getHeight() + 1;
		if(right!=null)
			rightHeight = right.getHeight() + 1;
		if(leftHeight>rightHeight)
			return leftHeight;
		return rightHeight;
	}
}
