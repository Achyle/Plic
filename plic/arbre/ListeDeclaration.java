package plic.arbre;

import java.util.ArrayList;

public class ListeDeclaration {
	
	ArrayList<Declaration> listeDeclaration;
	
	public ListeDeclaration(){
		this.listeDeclaration = new ArrayList<Declaration>();
	}
	
	public void ajouterAction(Declaration declaration){
		this.listeDeclaration.add(declaration);
	}
	
	public String generer(){
		StringBuilder strbr = new StringBuilder();
		strbr.append("# zone de reservation de memoire\n\n");
		strbr.append("	// initialise s7 avec sp \n"); 
		strbr.append("	la $s7,($sp) \n\n");
		//for(int i=0;i<Tds.getInstance().getTailleMap();i++){	
			//strbr.append("	add $sp ,$sp,-4 \n");
		//}
		strbr.append("\n# zone programme\n");;
		for(Declaration decl : listeDeclaration)
			strbr.append(decl.generer()+"\n");
		return strbr.toString();
	}
}
