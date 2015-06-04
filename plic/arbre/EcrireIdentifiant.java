package plic.arbre;

import plic.arbre.tds.Tds;
import plic.exception.semantique.PasDeDeclarationException;

public class EcrireIdentifiant extends DeclarationConstantes{

	private String idf ;
	
	public EcrireIdentifiant(String idf){
		this.idf = idf;
	}
	
	public String generer() throws PasDeDeclarationException {
		StringBuilder ecrire = new StringBuilder();
		ecrire.append("	# Ecrire "+idf+"\n");
		ecrire.append("	li $v0, 1 \n");
		ecrire.append("	lw $a0,"+ Tds.getInstance().identifier(idf).getDeplacement() +"($s7) \n");
		ecrire.append("	syscall\n\n");
				
		return ecrire.toString() ;
	}
}

	
	

