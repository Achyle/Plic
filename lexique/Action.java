package lexique;

import exception.ExceptionPasDeDeclaration;

public abstract class Action {
	
	public abstract String generer() throws ExceptionPasDeDeclaration;

}
