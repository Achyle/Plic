package plic.arbre.expression;

public class Unaire extends Expression {

	private int valeur;
	
	public Unaire(int val,boolean isBoolean){
		this.valeur = val;
		type = isBoolean?TypeExpression.BOOLEAN:TypeExpression.ARITHMETIQUE;
	}

	public String generer() {
		return "	# Range "+ this.valeur +" dans $v0 et l'empile\n" +
				   "	li $v0, " + this.valeur + "\n" +
				   "	sw $v0,($sp) \n" +
				   "	add $sp ,$sp,-4 \n";
	}

	public int valeur() {
		return valeur;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return valeur+"";
	}

}
