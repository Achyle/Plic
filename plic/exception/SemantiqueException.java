package plic.exception;

abstract class SemantiqueException extends Exception {
	
	public SemantiqueException(String message){
		super("ERREUR SEMANTIQUE :: "+message);
	}

}
