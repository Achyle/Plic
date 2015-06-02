package expression;

import exception.ExceptionPasDeDeclaration;

public interface Expression {
	public int valeur();
	public String toString() ;
	public int nbOperateurs();
	public String generer() throws ExceptionPasDeDeclaration;
}
