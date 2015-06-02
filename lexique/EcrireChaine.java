package lexique;

public class EcrireChaine  extends Action{
	
	private String chaine ;
	private int j;

	public EcrireChaine(String chaine, int j) {
		super();
		this.chaine = chaine;
		this.j = j;	
		
		//chaine = chaine.replaceAll("\"\"" ,"\\\\\"");
	}

	public String generer() {
		StringBuilder ecrire = new StringBuilder(); 
		ecrire.append(".data \n");
		ecrire.append("fonc"+j+": .asciiz " + chaine +"\n");
		ecrire.append(".text \n");
		ecrire.append("	li $v0, 4 \n");
		ecrire.append("	la $a0,fonc"+ j +"\n");
		ecrire.append("	syscall\n\n") ;
		 
		return ecrire.toString() ;
	}

}
