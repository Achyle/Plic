package plic.arbre.expression;

import plic.exception.TypeIncompatibleException;

public class Soustraction extends Binaire{
	
	public Soustraction(Expression expGauche, Expression expDroite) throws TypeIncompatibleException{
		super(expGauche,expDroite);
	}

	@Override
	public String generer(){
		return this.gauche.generer()+"\n" + this.droite.generer()+ "\n" +
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
		return this.gauche.valeur() - this.droite.valeur();
	}
	
	public String toString(){
		return this.gauche.valeur() +" - "+this.droite.valeur();
	}

}
