package plic.arbre;

import plic.arbre.expression.Expression;
import plic.arbre.tds.Tds;
import plic.exception.PasDeDeclarationException;

public class Affectation {

	private String idf ;
	private Expression e ;
	
	public Affectation(String idf, Expression e) {
		this.idf = idf;
		this.e = e;
	}
	
	public String generer() throws PasDeDeclarationException{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + e.generer() + "\n");
		 affectation.append("	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Tds.getInstance().identifier(idf).getDeplacement() +"($s7)\n");
		 return affectation.toString() ;
	}

}
