package variables;

import java.util.HashMap;

import exception.ExceptionDoubleDeclaration;
import exception.ExceptionPasDeDeclaration;

public class Variables {
	
	private HashMap<String, Integer> mapVariable ;
	
	public Variables(){
		mapVariable =  new HashMap<String, Integer>();
	}
	
	private static Variables instance = new Variables();
	
	public static Variables getInstance(){
		return instance ;
	}
	
	public void ajouterVariable(String key , Integer val ) throws ExceptionDoubleDeclaration{
		// si la variable est deja declarée lance une exception 
		if (mapVariable.containsKey(key)){
			throw new ExceptionDoubleDeclaration(key +" est déja déclaré");
		}else{ // sinon ajoute la variable dans la hashMap
			mapVariable.put(key, val);
		}
		
	}
	
	public int getDeplacement(String key) throws ExceptionPasDeDeclaration{
		// si la variable n'est pas dans la hashmap et donc n'est pas declarée lance une exception
		if(mapVariable.get(key)==null){
			throw new ExceptionPasDeDeclaration(key +" n'a pas été déclaré !");
		}
		return mapVariable.get(key);
	}
	
	public int getTailleMap(){
		return mapVariable.size() ;
	}

}
