package plic.arbre;

public class DeclarationChamp extends Declaration{
	
	public enum Status {PRIVEE,PUBLIQUE};
	private Status status;
	public enum Type {ENTIER,BOOLEAN,CLASSE};
	private Type type;
	protected ListeIdentifiant listeIdentifiant;
	
	public DeclarationChamp(Status status, Type type, ListeIdentifiant listeIdentifiant){
		this.setStatus(status);
		this.setType(type);
		this.listeIdentifiant = listeIdentifiant;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
