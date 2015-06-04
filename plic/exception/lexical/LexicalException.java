package plic.exception.lexical;

public class LexicalException extends Exception {
	
	public LexicalException(int ligne, String symbole){
		super("ERREUR LEXICAL : ligne "+(ligne+1)+" : symbole \""+symbole+"\" non reconnu");
	}
}
