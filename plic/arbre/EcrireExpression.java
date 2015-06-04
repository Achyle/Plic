package plic.arbre;

import plic.arbre.expression.Expression;
import plic.exception.PasDeDeclarationException;

public class EcrireExpression extends Instruction{

	private Expression expression;
	
	public EcrireExpression(Expression e){
		this.expression = e ;
	}
	
	public String generer() throws PasDeDeclarationException {
		StringBuilder ecrire = new StringBuilder();
		ecrire.append( expression.generer()+"\n");
		ecrire.append("	add $sp,$sp,4 \n");
		ecrire.append("	li $v0, 1 \n");
		ecrire.append("	lw $a0,($sp) \n");
		ecrire.append("	syscall\n\n");
				
		return ecrire.toString() ;
	}
}

	
	

