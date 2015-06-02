package expression;

import exception.ExceptionPasDeDeclaration;
import exception.ExceptionSemantique;

public class Inferieur extends TypeBoolean{

	public Inferieur(Expression expGauche, Expression expDroite, int i) throws ExceptionSemantique {
		super(expGauche, expDroite, i);
		if(expGauche.getClass().getSuperclass().getSimpleName().equals("TypeBoolean") || expDroite.getClass().getSuperclass().getSimpleName().equals("TypeBoolean"))
	      	  throw new ExceptionSemantique("Erreur format : boolean < boolean ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generer() throws ExceptionPasDeDeclaration{
		return this.getOperandeGauche().generer()+"\n" + this.getOperandeDroite().generer()+ "\n" +
	           "	# Compare "+this.toString()+"\n"+
	      	   "	add $sp,$sp,4\n" +	
	      	   "	lw $v0,($sp)\n" +
	      	   "	add $sp,$sp,4\n" +
	      	   "	lw $t8,($sp)\n" +
	      	   "	sub $v0,$t8,$v0\n" +
			   "	bgez $v0 sinon"+i+"\n" +
	           "	alors"+i+":\n" +
	           "	li $v0, 1\n" + 
	           "	sw $v0,0($sp)\n" +
	           "	add $sp,$sp,-4\n" +
	           "	j finsi"+i+"\n" + 
	           "	sinon"+i+":\n" + 
	           "	li $v0, 0\n" + 
	       	   "	sw $v0,0($sp)\n" + 
	           "	add $sp,$sp,-4\n" +
	       	   "	finsi"+i+":\n"; 
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		if(this.getOperandeGauche().valeur() < this.getOperandeDroite().valeur())
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return this.getOperandeGauche().valeur() + "<" + this.getOperandeDroite().valeur();
	}

}
