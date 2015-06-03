package plic.arbre;

import plic.arbre.tds.Tds;
import plic.exception.DoubleDeclarationException;

public class DeclarationChamps extends Declaration{
	
	public enum Statut {PRIVEE,PUBLIQUE};
	private Statut statut;
	
	public enum Type {ENTIER,BOOLEAN};
	private Type type;
	
	protected ListeIdentifiant listeIdentifiant;
	
	public DeclarationChamps(String s, String t, ListeIdentifiant listeIdentifiant) throws DoubleDeclarationException{
		if(s.equals("privee"))
			statut = Statut.PRIVEE;
		else if(s.equals("publique"))
			statut = Statut.PUBLIQUE;
		
		if(t.equals("entier"))
			type = Type.ENTIER;
		else if(t.equals("boolean"))
			type = Type.BOOLEAN;
		this.listeIdentifiant = listeIdentifiant;
		for (String idf : listeIdentifiant) {
			Tds.getInstance().ajouterChamp(statut, type, idf);
		}
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
