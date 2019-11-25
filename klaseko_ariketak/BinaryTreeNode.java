public class BinaryTreeNode<T> {
	protected T content;
	protected BinaryTreeNode<T> left;
	protected BinaryTreeNode<T> right;

	public BinaryTreeNode(T elem) {
		content = elem;
		left = null;
		right = null;
	}
}
