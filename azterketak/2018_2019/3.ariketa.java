public class Pertsona {
	String izena;
	String jaioterria;
}

public class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left, right;
}

public class ZuhaitzGenealogikoa {
	BinaryTreeNode<Pertsona> root;

	public boolean bizkaitarPetoPetoaDa(String izena,
			HashMap<String,String> herriak) {
		BinaryTreeNode<Pertsona> adabg =
			unekoaAdabegia(izena, this.root);
		return bizkaitarPetoPetoaDa(adabg, herriak);
	}

	private boolean bizkaitarPetoPetoaDa(BinaryTreeNode<Pertsona>
			adabg, HashMap<String,String> herriak, boolean egoera) {
		if(!egoera) return false;
		else if(adabg == null) return true;
		else {
			egoera = bizkaitarraDa(adabg.data);
			boolean ezker = bizkaitarPetoPetoaDa(adabg.left, herriak, egoera);
			boolean eskum = bizkaitarPetoPetoaDa(adabg.right, herriak, egoera);
			return ezker && eskum;
		}
	}

	private BinaryTreeNode<T> aurkituAdabegia(String pIzena,
			BinaryTreeNode<T> unekoaAdabegia) {
		if(unekoaAdabegia == null) return null;
		else if(unekoaAdabegia.data.izena.equals(pIzena)) {
			return unekoaAdabegia;
		} else {
			BinaryTreeNode<T> emaitza = aurkituAdabegia(pIzena,
					unekoaAdabegia.left);
			if(emaitza != null) return emaitza;
			return aurkituAdabegia(pIzena,
					unekoaAdabegia.right);
		}
	}

	private boolean bizkaitarraDa(Pertsona p, 
			HashMap<String,String> herriak) {
		return herriak.get(p.jaioterria)=="Bizkaia";
	}
}
