package plic.arbre.expression;

import plic.exception.semantique.PasDeDeclarationException;
import plic.exception.semantique.TypeIncompatibleException;

public abstract class Binaire extends Expression {

	protected Expression droite;
	protected Expression gauche;
	public abstract String generer() throws PasDeDeclarationException;
	public abstract int valeur();
	public Binaire(Expression expGauche, Expression expDroite) throws TypeIncompatibleException{
		gauche = expGauche;
		droite = expDroite;	
		if(gauche.type == droite.type)
			type = gauche.type;
		else
			throw new TypeIncompatibleException();
	}

}
