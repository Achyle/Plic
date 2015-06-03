package plic.arbre;

import java.util.Iterator;

import plic.arbre.tds.Tds;

public class DeclarationChamps extends Declaration{
	
	public enum Statut {PRIVEE,PUBLIQUE};
	private Statut statut;
	
	public enum Type {ENTIER,BOOLEAN,CLASSE};
	private Type type;
	
	protected ListeIdentifiant listeIdentifiant;
	
	public DeclarationChamps(Statut statut, Type type, ListeIdentifiant listeIdentifiant){
		this.setStatut(statut);
		this.setType(type);
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
