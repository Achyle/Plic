package plic.arbre.expression;

import plic.exception.TypeIncompatibleException;

public class Inferieur extends Binaire{
	
	public Inferieur(Expression expGauche, Expression expDroite) throws TypeIncompatibleException{
		super(expGauche,expDroite);
	}

	@Override
	public String generer(){
		incCptEtiquette();
		return this.gauche.generer()+"\n" + this.droite.generer()+ "\n" +
	           "	# Compare "+this.toString()+"\n"+
	      	   "	add $sp,$sp,4\n" +	
	      	   "	lw $v0,($sp)\n" +
	      	   "	add $sp,$sp,4\n" +
	      	   "	lw $t8,($sp)\n" +
	      	   "	sub $v0,$t8,$v0\n" +
			   "	bgez $v0 sinon"+Expression.cptEtiquette+"\n" +
	           "	alors"+Expression.cptEtiquette+":\n" +
	           "	li $v0, 1\n" + 
	           "	sw $v0,0($sp)\n" +
	           "	add $sp,$sp,-4\n" +
	           "	j finsi"+Expression.cptEtiquette+"\n" + 
	           "	sinon"+Expression.cptEtiquette+":\n" + 
	           "	li $v0, 0\n" + 
	       	   "	sw $v0,0($sp)\n" + 
	           "	add $sp,$sp,-4\n" +
	       	   "	finsi"+Expression.cptEtiquette+":\n"; 
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		if(this.gauche.valeur() < this.droite.valeur())
			return 1;
		return 0;
	}
	
	public String toString(){
		return this.gauche.valeur() +" < "+this.droite.valeur();
	}

}
