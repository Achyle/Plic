package lexique;

import java.util.ArrayList;

import exception.ExceptionPasDeDeclaration;

import variables.Variables;

public class Lexique {

	ArrayList<Action> action;
	
	public Lexique(){
		this.action = new ArrayList<Action>();
	}
	
	public void ajouterAction(Action action){
		this.action.add(action);
	}
	
	public String generer() throws ExceptionPasDeDeclaration{
		StringBuilder strbr = new StringBuilder();
		strbr.append("# zone de reservation de memoire\n\n");
		strbr.append("	# initialise s7 avec sp \n"); 
		strbr.append("	la $s7,($sp) \n\n");
		for(int i=0;i<Variables.getInstance().getTailleMap();i++){	
			strbr.append("	add $sp ,$sp,-4 \n");
		}
		strbr.append("\n# zone programme\n");;
		for(Action act : action)
			strbr.append(act.generer()+"\n");
		return strbr.toString();
	}

}
