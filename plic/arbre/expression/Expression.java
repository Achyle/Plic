package plic.arbre.expression;

public abstract class Expression {
	public static int cptEtiquette = 0;
	public abstract String toString();
	public abstract String generer();
	public abstract int valeur();
	public void incCptEtiquette(){
		Expression.cptEtiquette++;
	}
	public enum TypeExpression {BOOLEAN, ARITHMETIQUE};
	protected TypeExpression type;
}
