package lexique;

import variables.Variables;
import exception.ExceptionPasDeDeclaration;
import expression.Expression;

public class Affectation extends Action {

	private String idf ;
	private Expression e ;
	
	public Affectation(String idf, Expression e) {
		super();
		this.idf = idf;
		this.e = e;
	}
	
	public String generer() throws ExceptionPasDeDeclaration{
		 StringBuilder affectation = new StringBuilder();
		 affectation.append("\n" + e.generer() + "\n");
		 affectation.append("	add $sp,$sp,4 \n" +
		 					"	lw $v0,($sp) \n" +
		 					"	sw $v0,"+ Variables.getInstance().getDeplacement(idf) +"($s7)\n");
		 return affectation.toString() ;
	}

}
