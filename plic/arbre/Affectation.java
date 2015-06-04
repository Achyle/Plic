package plic.arbre;

import plic.arbre.expression.Expression;
import plic.arbre.tds.Tds;
import plic.exception.semantique.PasDeDeclarationException;

public class Affectation extends DeclarationConstantes{

	private String idf ,idf2;
	private Expression e ;
	
	public Affectation(String idf, Expression e) {
		super();
		this.idf = idf;
		this.e = e;
	}
	
	public Affectation(String idf, String idf2) {
		super();
		this.idf = idf;
		this.idf2 = idf2;
	}
	
	public String generer() throws PasDeDeclarationException{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + e.generer() + "\n");
		 affectation.append("	# Affectation "+idf+" = "+e.valeur()+"\n"+
				 			"	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Tds.getInstance().identifier(idf).getDeplacement() +"($s7)\n");
		 return affectation.toString() ;
	}

}
