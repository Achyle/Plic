package expression;

public abstract class TypeBoolean extends Binaire{
	
	protected int i;
	
	public TypeBoolean(Expression expGauche, Expression expDroite, int i) {
		super(expGauche, expDroite);
		this.i = i;
		// TODO Auto-generated constructor stub
	}

}
