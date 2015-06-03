package plic.arbre;

import plic.arbre.tds.Tds;

public class Classe {
	
	protected ListeDeclaration listeDeclaration;
	protected String idf;
	
	public Classe(ListeDeclaration ldecl, String idf){
		this.listeDeclaration = ldecl;
		this.idf = idf;
	}

	public String generer() {
		StringBuilder res = new StringBuilder();
		res.append(Tds.getInstance().generer());
		return res.toString();
	}

}
