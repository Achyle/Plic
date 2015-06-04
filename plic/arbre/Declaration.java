package plic.arbre;

import plic.exception.PasDeDeclarationException;

public abstract class Declaration {
	public abstract String generer() throws PasDeDeclarationException;
}
