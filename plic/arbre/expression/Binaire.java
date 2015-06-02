package plic.arbre.expression;

import plic.exception.TypeIncompatibleException;

public abstract class Binaire extends Expression {

	protected Expression droite;
	protected Expression gauche;
	public abstract String generer();
	public abstract int valeur();
	public Binaire(Expression expGauche, Expression expDroite) throws TypeIncompatibleException{
		gauche = expGauche;
		droite = expDroite;
		incCptEtiquette();
		if(gauche.type == droite.type)
			type = gauche.type;
		else
			throw new TypeIncompatibleException();
	}

}
