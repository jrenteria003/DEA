import java.util.ArrayList;

public class BinTree<T> implements TADBinaryTree<T> {
	protected BinTreeNode<T> root;
	protected int count;

	public BinTree() {
		root = null; count = 0;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public T find(T elem) {
	//--------------------------------
	//aurre:
	//post : elementua aurkitzen badu
	//elementua bueltatu, bestela null
	//--------------------------------
		return find(elem, this.root);
	}

	//soluzio errekurtsiboa
	private T find(T elem, BinaryTreeNode<T> z) {
		if(z == null) return null;
		//KUARENTENA xdxdxd
		//else if(z.left == null && z.right == null) {
		//	if(z.content.equals(elem))
		//		return z;
		//	else return null;
		//}
		else if(z.content.equals(elem)) return z.content;
		else {
			T emEzk = find(elem, z.left);
			if(emEzk != null) return emEzk;
			else return find(elem, z.right);
		}
	}

	public void removeLeftSubtree() {
		//--------------------------------
		//aurre: zuhaitza ez da hutsa
		//post : ezabatu da ezkerreko
		//azpizuahitza
		//--------------------------------
		this.count = this.count - adabegiKop(root.left);
		this.root.left = null;
	}

	private int adabegiKop(BinaryTreeNode<T> z) {
		if(z == null) return 0;
		else return 1 + adabegiKop(z.left) + adabegiKop(z.right);
	}

	public Iterator<T> inOrdena() {
		ArrayList<T> emaitza = new ArrayList<T>();
		lortuZerrenda(emaitza, this.root);
		return emaitza.iterator();
	}

	private void lortuZerrenda(ArrayList<T> l, BinaryTreeNode<T> z) {
		if(z == null) {}
		else { 	lortuZerrenda(l, z.left);
				l.add(z.content);
				lortuZerrenda(l, z.right);
		}
	}

	public Iterator<T> itMailaka() {
		Queue<BinaryTreeNode<T>> aztGabeak = new Queue<BinaryTreeNode<T>>();
		ArrayList<T> emaitza = new ArrayList<T>();
		if(this.root != null) {
			aztGabeak.insert(this.root);
			while(!aztGabeak.isEmpty()) {
				BinaryTreeNode<T> unekoa = aztGabeak.remove();
				emaitza.add(unekoa.content);
				if(unekoa.left != null) {
					aztGabeak.insert(unekoa.left);
				}
				if(unekoa.right != null) {
					aztGabeak.insert(unekoa.right);
				}
			}
		}
		return emaitza.iterator();
	}

	public T findMin() {
		//aurre	: zuhaitz ez hutsa
		return findMin(this.root);
	}

	//	------------------------------------
	//	a			           | emaitza
	//	------------------------------------
	//	        (20) 	       | 20
	//	------------------------------------
	//	        (20)   	       |
	//       (15)  (35)	       | 8
	//	   (8) (18)            |
	//	------------------------------------
	//	        (20)           | 
	//	          (25)         | 20
	//	            (90)       |
	//	------------------------------------
	//	        (20)           | 
	//	      (12)             | 8
	//	     (8)               | 
	//	------------------------------------

	private T findMin(BinTreeNode<T> a) {
		//Denbora	: O(log_2 n)
		//Espazioa	: O(log_2 n)
		if (a.left == null) {
			return a.elem;
		}
		else return findMin(a.left);
	}

	public T findMinItr() {
		//bertsio iteratiboa
		BinTreeNode<T> unekoa = root;
		while(unekoa.left != null) {
			unekoa = unekoa.left;
		}
		return unekoa.elem;
	}

	public T removeMinItr() {
		if(root.left == null) {
			T elementua = root.elem;
			root = root.right;
			count = 0;
			return elementua;
		} else {
			BinTreeNode<T> gurasoa = root;
			BinTreeNode<T> unekoa = root;
			while (unekoa.left != null) {
				gurasoa = unekoa;
				unekoa = unekoa.left;
			}
			gurasoa.left = unekoa.right;
			count--;
			return unekoa.elem;
		}
	}

	

}
