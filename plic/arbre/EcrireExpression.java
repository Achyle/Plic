package plic.arbre;

import plic.arbre.expression.Expression;
import plic.arbre.tds.Tds;
import plic.exception.semantique.PasDeDeclarationException;

public class EcrireExpression extends DeclarationConstantes{

	private Expression expression ;
	
	public EcrireExpression(Expression e){
		this.expression = e;
	}
	
	public String generer() throws PasDeDeclarationException {
		StringBuilder ecrire = new StringBuilder();
		ecrire.append("	# Ecrire "+expression.generer()+"\n");
		ecrire.append(	expression.generer()+"\n");
		ecrire.append("	li $v0, 1 \n");
		ecrire.append("	lw $a0,($sp) \n");
		ecrire.append("	syscall\n\n");
				
		return ecrire.toString() ;
	}
}

	
	

