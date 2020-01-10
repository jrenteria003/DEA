
public class NTree<T> {

	//public boolean badago(Integer elem) {
	//	boolean aurk = false;
	//	if(zuhaitz hutsa) return false;
	//	else {
	//		unekoa = root;
	//		while(!aurk && unekoa != null) {
	//			bilatu array-an; //i indizea
	//			if array-a amaitu da {
	//				unekoa = semeak[i];
	//			} else if elem == balioak[i] {
	//				aurk = true;
	//			} else { unekoa = semeak[i];}
	//		}
	//	}
	//	return aurk;
	//}
	
	public boolean badago(Integer elem) {
		//kostua O(log_2 n)
		TreeNode<Integer> unekoa = root;
		boolean aurk = false;
		while(!aurk && unekoa != null) {
			int i = 0;
			while(!aurk && i < unekoa.balioak.length) {
				if(elem <= unekoa.balioak[i]) {
					aurk = true;
				} else i++;
			}
			if(aurk && elem == unekoa.balioak[i]) {}
			else { unekoa = unekoa.balioak[i];
				aurk = false;
			}
		}
		return unekoa != null;
	}

}
