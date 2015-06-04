package plic.arbre;

import plic.arbre.expression.Expression;
import plic.exception.PasDeDeclarationException;

public abstract  class Instruction {
	public static int cptEtiquette = 0;
	public void incCptEtiquette(){
		Expression.cptEtiquette++;
	}
	public abstract String generer() throws PasDeDeclarationException;
}