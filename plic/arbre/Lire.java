package plic.arbre;

import plic.arbre.expression.Expression;
import plic.arbre.tds.Tds;
import plic.exception.PasDeDeclarationException;

public class Lire extends DeclarationConstantes {

	private String idf;
	private int cpt = 0;

	public Lire(String idf) {
		super();
		this.idf = idf;
	}

	public String generer() throws PasDeDeclarationException {
		incCptEtiquette();
		cpt = Expression.cptEtiquette;
		StringBuilder lire = new StringBuilder(); 
		lire.append("\n.data \n");
		lire.append("fonc"+cpt+": .asciiz \"Saisissez un entier pour " + idf +"/\n \n");
		lire.append(".text \n");
		lire.append("	li $v0, 4 \n");
		lire.append("	la $a0, fonc"+cpt+" \n");
		lire.append("	syscall\n");
		lire.append("	li  $v0, 5\n");
		lire.append("	syscall\n");
		lire.append("	sw $v0,"+ Tds.getInstance().identifier(idf).getDeplacement() +"($s7)\n");
		
		return lire.toString();
	}

}
