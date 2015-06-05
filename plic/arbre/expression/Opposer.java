package plic.arbre.expression;

import plic.exception.semantique.PasDeDeclarationException;

public class Opposer extends Expression{
	
	private Expression expression;
	private int val;
	
	public Opposer(Expression e){
		expression = e;
		if(expression.type.equals(Expression.TypeExpression.BOOLEAN))
			val = (expression.valeur()==1)?0:1;
		else
			val = expression.valeur() - (expression.valeur()*2);
	} 
	
	public String generer() throws PasDeDeclarationException {
		StringBuilder opposer = new StringBuilder();
		opposer.append("	# Range "+ val +" dans $v0 et l'empile\n"+
				  "	li $v0, " + val + "\n" +
				  "	sw $v0,($sp) \n" +
				  "	add $sp ,$sp,-4 \n");

		return opposer.toString() ;
	}

	public int valeur() {
		return val;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return val+"";
	}
	
}
