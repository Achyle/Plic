package plic.arbre.tds;

import java.util.HashMap;

import plic.exception.DoubleDeclarationException;

public class Tds {
	
	HashMap<String, Symbole> tds;
	public Tds(){
		tds =  new HashMap<String, Symbole>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public void ajouterVariable(String idf, Symbole symbole) throws DoubleDeclarationException{
		// si la variable est deja declarée lance une exception 
		if (tds.containsKey(idf)){
			throw new DoubleDeclarationException(idf +" est déja déclaré");
		}else{ // sinon ajoute la variable dans la hashMap
			tds.put(idf, symbole);
		}
	}
	
	
	
	
	

}
