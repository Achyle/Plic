package plic.arbre;

import plic.arbre.expression.Expression;

public class EcrireChaine extends DeclarationConstantes{
	
	private String chaine ;
	private int cpt = 0;

	public EcrireChaine(String chaine) {
		super();
		this.chaine = chaine;
		chaine = chaine.replaceAll("\"\"" ,"\\\\\"");
	}

	public String generer() {
		incCptEtiquette();
		cpt = Expression.cptEtiquette;
		StringBuilder ecrire = new StringBuilder(); 
		ecrire.append("	# Ecrirechaine\n");
		ecrire.append("	.data \n");
		ecrire.append("	stri"+cpt+": .asciiz " + chaine +"\n");
		ecrire.append("	.text \n");
		ecrire.append("	li $v0, 4 \n");
		ecrire.append("	la $a0, stri"+ cpt +"\n");
		ecrire.append("	syscall\n\n") ;
		 
		return ecrire.toString() ;
	}

}
