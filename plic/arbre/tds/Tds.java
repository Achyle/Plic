package plic.arbre.tds;

import java.util.HashMap;
import java.util.Set;

import plic.arbre.DeclarationChamps.Statut;
import plic.arbre.DeclarationChamps.Type;
import plic.exception.DoubleDeclarationException;
import plic.exception.PasDeDeclarationException;

public class Tds {
	
	HashMap<String, Symbole> tds;
	private int deplacement = 0;

	public Tds(){
		tds =  new HashMap<String, Symbole>();
	}
	
	private static Tds instance = new Tds();
	
	public static Tds getInstance(){
		return instance ;
	}
	
	public void ajouterChamp(Statut statut, Type type, String idf) throws DoubleDeclarationException{
		// si la variable est deja declarée lance une exception 
		if (tds.containsKey(idf)){
			throw new DoubleDeclarationException(idf +" est déja déclaré");
		}else{ // sinon ajoute la variable dans la hashMap
			tds.put(idf, new Symbole(statut, type, deplacement));
			this.deplacement += 4;
		}
	}	
	
	public Symbole identifier(String key) throws PasDeDeclarationException{
		Symbole s = tds.get(key);
		if(s==null){
			throw new PasDeDeclarationException(key +" n'a pas été déclaté !");
		}
		return tds.get(key);
	}

	public Object generer() throws PasDeDeclarationException {
		// TODO Auto-generated method stub
		StringBuilder rep = new StringBuilder();
		Set<String> cles = tds.keySet();
		for (String cle : cles) {
			rep.append("	lw $v0,"+ Tds.getInstance().identifier(cle).getDeplacement()+"($s7)\n");
			rep.append("	sw $v0,($sp)\n");
			rep.append("	add $sp ,$sp,-4\n");
		}
		return rep.toString();
	}

}
