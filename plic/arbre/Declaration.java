package plic.arbre;

import plic.exception.semantique.PasDeDeclarationException;

public abstract class Declaration {
	public abstract String generer() throws PasDeDeclarationException;
}
