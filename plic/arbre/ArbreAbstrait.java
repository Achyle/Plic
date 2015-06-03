package plic.arbre;

import java.util.ArrayList;

import plic.arbre.expression.Expression;

public class ArbreAbstrait {
	
	ArrayList<Expression> arbre;
	public ArbreAbstrait (){
		arbre = new ArrayList<Expression>();
	}
	
	public ArbreAbstrait (Classe c){
		arbre = new ArrayList<Expression>();
	}
	
	public void ajouterAction(Expression exp){
		this.arbre.add(exp);
	}	
	
	public String generer(){
		StringBuilder strbr = new StringBuilder();
		for(Expression e : arbre) strbr.append(e.generer() +"\n");
		return strbr.toString();
	}

	public String toString(){
		StringBuilder res = new StringBuilder();
		for(Expression e : arbre) res.append(e.toString() + "\n")  ;
		return res.toString();
	}

}
