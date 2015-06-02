package expression;

public class Nombre implements Expression{
	
	private int nombre ;

    public Nombre ( int nb ) {
        this.nombre = nb ;
    }
    
    public Nombre () {
      this.nombre = 0 ;
    }

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		return nombre;
	}

	//@Override
	public int nbOperateurs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String generer() {
		return "	# Range "+ this.nombre +" dans $v0\n" +
			   "	li $v0, " + this.nombre + "\n" +
			   "	# permet d'empiler " + this.nombre + "\n" +
			   "	sw $v0,($sp) \n" +
			   "	add $sp ,$sp,-4 \n";
	} 

}
