package plic.exception.semantique;

public abstract class SemantiqueException extends Exception {
	
	public SemantiqueException(String message){
		super("ERREUR SEMANTIQUE :: "+message);
	}

}
