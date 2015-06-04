package plic.arbre;

import java.util.ArrayList;
import java.util.Iterator;

import plic.exception.PasDeDeclarationException;

public class ListeDeclaration implements Iterable<Declaration>{
	
	ArrayList<Declaration> listeDeclaration;
	
	public ListeDeclaration(){
		this.listeDeclaration = new ArrayList<Declaration>();
	}
	
	public void ajouterDeclaration(Declaration declaration){
		this.listeDeclaration.add(declaration);
	}

	public String generer(){
		StringBuilder strbr = new StringBuilder();
		strbr.append("	# initialise s7 avec sp \n"); 
		strbr.append("	la $s7,($sp) \n\n");
		strbr.append("\n# zone programme\n");;
		for(Declaration decl : listeDeclaration)
			try {
				strbr.append(decl.generer()+"\n");
			} catch (PasDeDeclarationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return strbr.toString();
	}

	@Override
	public Iterator<Declaration> iterator() {
		return listeDeclaration.iterator();
	}
}
