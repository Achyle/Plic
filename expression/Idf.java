package expression;

import exception.ExceptionPasDeDeclaration;
import variables.Variables;

public class Idf implements Expression{

	private String idf;
	
	public Idf(String idf) {
		this.idf = idf;
	}
	
	public String generer() throws ExceptionPasDeDeclaration{
		return "	lw $v0,"+Variables.getInstance().getDeplacement(idf)+"($s7) \n" +
			   "	sw $v0,($sp) \n" +
			   "	add $sp ,$sp,-4 \n";
	}

	public int valeur() {
		return 0;
	}

	public String toString() {
		return null;
	}

	public int nbOperateurs() {
		return 0;
	}

}
