package plic.arbre.tds;

import java.util.HashMap;

import plic.exception.DoubleDeclarationException;
import plic.exception.PasDeDeclarationException;

public class Tds {
	
	HashMap<String, Symbole> tds;
	public Tds(){
		tds =  new HashMap<String, Symbole>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public void ajouterVariable(String key, Symbole symbole) throws DoubleDeclarationException{
		// si la variable est deja declarée lance une exception 
		if (tds.containsKey(key)){
			throw new DoubleDeclarationException(key +" est déja déclaré");
		}else{ // sinon ajoute la variable dans la hashMap
			tds.put(key, symbole);
		}
	}	
	
	public Symbole identifier(String key) throws PasDeDeclarationException{
		Symbole s = tds.get(key);
		if(s==null){
			throw new PasDeDeclarationException(key +" n'a pas été déclaté !");
		}
		return tds.get(key);
	}

	public void ajouterChamp(Statut statut, Type type, String idf) {
		
	}
	
}
