package plic.arbre;

import plic.arbre.expression.Expression;
import plic.arbre.tds.Tds;
import plic.exception.semantique.PasDeDeclarationException;
import plic.exception.semantique.TypeIncompatibleException;

public class Affectation extends DeclarationConstantes{

	private String idf;
	private Expression e;
	
	public Affectation(String idf, Expression e) throws TypeIncompatibleException {
		super();
		this.idf = idf;
		this.e = e;
		if(e.type.equals(Expression.TypeExpression.BOOLEAN)){
			throw new TypeIncompatibleException();
		}
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
