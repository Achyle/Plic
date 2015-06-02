package expression;

import exception.ExceptionPasDeDeclaration;

public class TestNonEgal extends TypeBoolean{

	public TestNonEgal(Expression expGauche, Expression expDroite, int i) {
		super(expGauche, expDroite, i);
	}

	@Override
	public String generer() throws ExceptionPasDeDeclaration{
		return this.getOperandeGauche().generer()+"\n" + this.getOperandeDroite().generer()+ "\n" +
	           "	# Compare "+this.toString()+"\n"+
	           "	add $sp,$sp,4\n" +	
	      	   "	lw $v0,($sp)\n" +
	      	   "	add $sp,$sp,4\n" +
	      	   "	lw $t8,($sp)\n" +
	      	   "	sub $v0,$t8,$v0\n" +
			   "	beqz $v0 sinon"+i+"\n" +
	           "	alors"+i+":\n" +
	           "	li $v0, 1\n" + 
	           "	sw $v0,0($sp)\n" +
	           "	add $sp,$sp,-4\n" +
	           "	j finsi"+i+"\n" + 
	           "	sinon"+i+":\n" + 
	           "	li $v0, 0\n" + 
	       	   "	sw $v0,0($sp)\n" + 
	           "	add $sp,$sp,-4\n" +
	       	   "	finsi"+i+":\n";
	}

	@Override
	public int valeur() {
		// TODO Auto-generated method stub
		if(this.getOperandeGauche().valeur() != this.getOperandeDroite().valeur())
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return this.getOperandeGauche().valeur() + "!=" + this.getOperandeDroite().valeur();
	}

}
