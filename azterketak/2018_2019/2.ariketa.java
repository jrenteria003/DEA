import java.util.Queue;

public class Eskaera {
	
	String kontainerKode;
	int nasa;

}

public class Ontzia {

	int mota;//0 (deskarga), 1 (karga)
	String izena;
	Queue<Eskaera> eskaerak;

}

public class Portua {

	Stack<String>[] nasak;
	Queue<Ontzia> ontziak;

	public void portuaSimulatu(Queue<Ontzia> ontziak, int maxEskaera, int nasaKop) {
		//Nasak sortu
		nasak = new Stack<String>()[nasaKop];

		//Portuaren jarduera simulatu
		while(ontziak.peek() == null) {
			Ontzia unekoOntzia = ontziak.poll();
			while(unekoOntzia.eskaerak.peek() == null) {
				Eskaera unekoEskaera = unekoOntzia.eskaerak.poll();
				if(unekoOntzia.mota == 0) {
					nasak[unekoEskaera.nasa].push(unekoEskaera.kontainerKode);
				} else {
					boolean aurkitua = false;
					boolean zeroNasn = false;
					int n = unekoEskaera.nasa;
					while(!aurkitua) {
						String unekoKontainer = nasak[n].peek();
						if(unekoKontainer.equals(unekoEskaera.kontainerKode)) {
							nasak[n].pop();
							aurkitua = true;
						} else {
							nasak[0].push(nasak[n].pop());
							zeroNasn = true;
						}
					}
					while(zeroNasn) {
						if(nasak[0] == null) zeroNasn = false;
						else {
							nasak[n].push(nasak[0].pop());
						}
					}
				}
			}
		}
	}
}
