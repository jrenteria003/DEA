public class GraphADT<T> {

	public boolean konektatuta(T a, T b) {
		// grafoa adjList bidez
		// kostua O(n+a) (a=arku kopurua)
		int pa = bilatu(a);
		int pb = bilatu(b);
		boolean[] aztertuak = new boolean[numVertices];
		return konektatuta(pa, pb, aztertuak);
	}

	private boolean konektatuta(int a, int b, boolean[] aztertuak) {
		if(a == b) return true;
		else{
			aztertuak[a] = true;
			for(int x : adjList[a]) {
				if(!aztertuak[x]) {
					boolean e = konektatuta(x, b, aztertuak);
					bidea[x] = a;
					// bidea (backpointers)
					//
					// | a | b | c | d | e | f | g | h | i | j | k ...
					// -----------------------------------------------
					// | - | a | b | c | d | - | b | - | - | e | j ...
					//
					if(e) return true;
				}
			}
		}
	}
}
