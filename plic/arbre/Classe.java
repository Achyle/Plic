package plic.arbre;

public class Classe {
	
	protected ListeDeclaration listeDeclaration;
	protected String idf;
	
	public Classe(ListeDeclaration ldecl, String idf){
		this.listeDeclaration = ldecl;
		this.idf = idf;
	}

	public String generer() {
		StringBuilder res = new StringBuilder();
		for(Declaration d : listeDeclaration) res.append(d.generer()+"\n");
		return res.toString();
	}

}
