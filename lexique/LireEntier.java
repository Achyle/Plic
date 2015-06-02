package lexique;

import variables.Variables;
import exception.ExceptionPasDeDeclaration;

public class LireEntier extends Action {

	private String idf;
	private int j;

	public LireEntier(String idf, int j) {
		super();
		this.idf = idf;
		this.j = j;
	}

	public String generer() throws ExceptionPasDeDeclaration  {
		StringBuilder lire = new StringBuilder(); 
		lire.append("\n.data \n");
		lire.append("fonc"+j+": .asciiz \"Saisissez un entier pour " + idf +" : /\n \n");
		lire.append(".text \n");
		lire.append("	li $v0, 4 \n");
		lire.append("	la $a0, fonc"+j+" \n");
		lire.append("	syscall\n") ;
		lire.append("	li  $v0, 5\n");      
		lire.append("	syscall\n");
		lire.append("	sw $v0,"+ Variables.getInstance().getDeplacement(idf) +"($s7)\n");
		
		return lire.toString();
	}

}
