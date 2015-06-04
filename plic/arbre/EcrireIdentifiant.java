package plic.arbre;

import plic.arbre.tds.Tds;
import plic.exception.PasDeDeclarationException;

public class EcrireIdentifiant extends DeclarationConstantes{

	private String idf ;
	
	public EcrireIdentifiant(String idf){
		this.idf = idf;
	}
	
	public String generer() throws PasDeDeclarationException {
		StringBuilder ecrire = new StringBuilder();
		ecrire.append("	li $v0, 1 \n");
		ecrire.append("	lw $a0,"+ Tds.getInstance().identifier(idf).getDeplacement() +"($sp) \n");
		ecrire.append("	syscall\n\n");
				
		return ecrire.toString() ;
	}
}

	
	
