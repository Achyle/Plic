package plic.arbre;

import java.util.ArrayList;

import plic.arbre.expression.Expression;

public class ArbreAbstrait {
	
	ArrayList<Classe> arbre;
	
	public ArbreAbstrait (Classe c){
		arbre = new ArrayList<Classe>();
		arbre.add(c);
	}
	
	public String generer(){
		StringBuilder strbr = new StringBuilder();
		for(Classe c : arbre) strbr.append(c.generer() +"\n");
		return strbr.toString();
	}

	public String toString(){
		StringBuilder res = new StringBuilder();
		for(Classe c : arbre) res.append(c.toString() + "\n")  ;
		return res.toString();
	}

}
