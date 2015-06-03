package plic.arbre.expression;

import plic.exception.TypeIncompatibleException;

public class Division extends Binaire{

	public Division(Expression expGauche, Expression expDroite) throws TypeIncompatibleException {
		super(expGauche, expDroite);
	}

	@Override
	public String generer() {
		return this.gauche.generer()+"\n" + this.droite.generer()+ "\n" +
		           "	# divise "+this.toString()+"\n"+
		      	   "	add $sp,$sp,4\n" +	
		      	   "	lw $v0,($sp)\n" +
		      	   "	add $sp,$sp,4\n" +
		      	   "	lw $t8,($sp)\n" +
		      	   "	div $t8,$v0\n" +
				   "	mflo $v0\n" +
		           "	sw $v0,($sp)\n" +
		           "	add $sp,$sp,-4\n";	
	}

	@Override
	public int valeur() {
		return this.gauche.valeur() * this.droite.valeur();
	}

	@Override
	public String toString() {
		return this.gauche +" / "+this.droite;
	}

}
