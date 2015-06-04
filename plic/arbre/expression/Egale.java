package plic.arbre.expression;

import plic.exception.semantique.PasDeDeclarationException;
import plic.exception.semantique.TypeIncompatibleException;

public class Egale extends Binaire{
	
	private int cpt = 0;
	public Egale(Expression expGauche, Expression expDroite) throws TypeIncompatibleException{
		super(expGauche,expDroite);
	}

	@Override
	public String generer() throws PasDeDeclarationException{
		incCptEtiquette();
		cpt = Expression.cptEtiquette;
		return this.gauche.generer()+"\n" + this.droite.generer()+ "\n" +
	           "	# Compare "+this.toString()+"\n"+
	      	   "	add $sp,$sp,4\n" +	
	      	   "	lw $v0,($sp)\n" +
	      	   "	add $sp,$sp,4\n" +
	      	   "	lw $t8,($sp)\n" +
	      	   "	bne $v0,$t8 sinon"+cpt+"\n" +
			   "	alors"+cpt+":\n" +
	           "	li $v0, 1\n" + 
	           "	sw $v0,0($sp)\n" +
	           "	add $sp,$sp,-4\n" +
	           "	j finsi"+cpt+"\n" + 
	           "	sinon"+cpt+":\n" + 
	           "	li $v0, 0\n" + 
	       	   "	sw $v0,0($sp)\n" + 
	           "	add $sp,$sp,-4\n" +
	       	   "	finsi"+cpt+":\n";
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		if(this.gauche.valeur() == this.droite.valeur())
			return 1;
		return 0;
	}
	
	public String toString(){
		return this.gauche.valeur() +" == "+this.droite.valeur();
	}

}
