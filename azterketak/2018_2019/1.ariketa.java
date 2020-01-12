public class Pertsona {
	String id;
	Pertsona[] lagunak;
}

public class Adabegi {
	Pertsona info;
	Adabegi next;
}

public class Lista {
	Adabegi first;

	public void gehitu(String pId, String[] kideak) {
		if(first == null) {
			Pertsona[] kideakLag = null;
			first = new Pertsona(id, kideakLag);
		} else {
			Adabegi unekoa = first;
			while(unekoa != null) {
				if(pId.compareTo(unekoa.info.id)>0) {
					Pertsona[] kideakLag = null;
					for(int i = 0; i < kideak.length; i++) {
						Adabegi kide = aurkitu(kideak[i]);
						kideakLag[i] = kide.info;
						for(int j = 0; kide.info.lagunak.length; j++) {
							if(kide.info.lagunak[i] == null) {
								kide.info.lagunak[i] = pBerria;
							}
						}
					}
					Pertsona pBerria = new Pertsona(pId, kideakLag);
					Adabegi aBerria = Adabegi(pBerria);
				}
				unekoa = unekoa.next;

			}
		}
	}

	public Adabegi aurkitu(String pId) {
		Adabegi unekoa = first;
		while(unekoa != null) {
			if(unekoa.info.id.equals(pId))
				break;
			unekoa = unekoa.next;
		}
		return unekoa;
	}
}
