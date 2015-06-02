package expression;

import exception.ExceptionPasDeDeclaration;
import exception.ExceptionSemantique;

public class Difference extends Binaire{

	public Difference(Expression expGauche, Expression expDroite) throws ExceptionSemantique {
		super(expGauche, expDroite);
		if(expGauche.getClass().getSuperclass().getSimpleName().equals("TypeBoolean") || expDroite.getClass().getSuperclass().getSimpleName().equals("TypeBoolean"))
	      	  throw new ExceptionSemantique("Erreur format : boolean + boolean ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generer() throws ExceptionPasDeDeclaration{
		return this.getOperandeGauche().generer()+"\n" + this.getOperandeDroite().generer()+ "\n" +
	           "	# soustrait "+this.toString()+"\n"+
	      	   "	add $sp,$sp,4\n" +	
	      	   "	lw $v0,($sp)\n" +
	      	   "	add $sp,$sp,4\n" +
	      	   "	lw $t8,($sp)\n" +
	      	   "	sub $v0,$t8,$v0\n" +
	           "	sw $v0,($sp)\n" +
	           "	add $sp,$sp,-4\n";
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		return this.getOperandeGauche().valeur() - this.getOperandeDroite().valeur();
	}

	@Override
	public String toString() {
		return this.getOperandeGauche().valeur() + "-" + this.getOperandeDroite().valeur();
	}

}
