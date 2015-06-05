package plic.arbre;

import java.util.ArrayList;

import plic.arbre.tds.Tds;
import plic.exception.semantique.PasDeDeclarationException;

public class ArbreAbstrait {
	
	ArrayList<Classe> arbre;
	
	public ArbreAbstrait (Classe c){
		arbre = new ArrayList<Classe>();
		arbre.add(c);
	}
	
	public String generer() throws PasDeDeclarationException{		
		StringBuilder strbr = new StringBuilder();
		strbr.append("# zone de reservation de memoire\n\n");
		strbr.append("	# initialise s7 avec sp \n"); 
		strbr.append("	la $s7,($sp) \n\n");
		for(int i=0;i<Tds.getInstance().getTds().size();i++){	
			strbr.append("	add $sp ,$sp,-4 \n");
		}
		strbr.append("\n# zone programme\n");
		strbr.append(".data\n");
		strbr.append("space: .asciiz \"\\n\"\n");
		strbr.append(".text\n");
		for(Classe c : arbre) strbr.append(c.generer() +"\n");
		return strbr.toString();
	}

	public String toString(){
		StringBuilder res = new StringBuilder();
		for(Classe c : arbre) res.append(c.toString() + "\n")  ;
		return res.toString();
	}

}
