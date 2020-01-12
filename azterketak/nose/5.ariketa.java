public class LinkedList<T> {
	LinkedNode<T> first;
	LinkedNode<T> last;
}

public class LinkedNode<T> {
	T data;
	LinkedNode<T> next;
}

public class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left, right;
}

public class Zuhaitza<T> {
	BinaryTreeNode<T> root;

	public LinkedList<T> listaOrdenatua() {
		LinkedList<T> emaitza = new LinkedList<T>();
		return listaOrdenatua(this.root,emaitza);
	}

	private LinkedList<T> listaOrdenatua(BinaryTreeNode<T> hostoa,
			LinkedList<T> emaitza) {
		if(hostoa == null) {}
		else {
			emaitza = listaOrdenatua(hostoa.left, emaitza);
			emaitza.addLast(hostoa.data);
			return listaOrdenatua(hostoa.right, emaitza);
		}
	}
}
