public class GrafoJokoa {
	private HashMap<Integer, ArrayList<Laukia>> ondokoak;

	public SimpleLinkedList<Laukia> bilatuBidea(Laukia hasiera, Laukia bukaera) {
		aztGabeak.insert(hasiera);
		aztertuak[hasiera.balioa];
		while(!aurk && !aztGabeak.isEmpty()) {
			unekoa = aztGabeak.remove();
			if(unekoa bukaera da) aurk = true;
			else {
				for(x:unekoaren auzokideak) {
					if(x unekoa kolore desberdinak
							eta x ez aztertua) {
						aztGabeak.insert(x);
						aztertuak[x.balioa] = true;
						bide[x.balioa] = unekoa.balioa;
					}
				}
			}
		}
		LinkedList<Laukia> emaitza = new LinkedList<Laukia>();
		if(!aurk) return emaitza;
		else {
			emaitza.addFirst(bukaera);
			unekoa = bidea[bukaera.balioa];
			while(unekoa.balioa != -1) {
				emaitza.addFirst(unekoa);
				unekoa = bidea[unekoa.balioa];
			}
			return emaitza;
		}
	}
}
