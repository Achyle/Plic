package plic.exception.semantique;

import plic.Plic;

public abstract class SemantiqueException extends Exception {
	
	public SemantiqueException(String message){
		super("ERREUR SEMANTIQUE a la ligne "+(Plic.ligne+1)+" :: "+message);
	}

}
