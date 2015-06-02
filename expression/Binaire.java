package expression;

public abstract class Binaire implements Expression{
	
	protected Expression operandeGauche ;
    protected Expression operandeDroite ;
    
    public Binaire ( Expression expGauche , Expression expDroite ) {
        this.operandeGauche = expGauche;
        this.operandeDroite = expDroite ;
    }
    
    public Expression getOperandeGauche(){
    	return operandeGauche;
    }
    public Expression getOperandeDroite(){
    	return operandeDroite;
    }
    
    public void setOperandeGauche(Expression exp){
    	this.operandeGauche = exp;
    }
    public void setOperandeDroite(Expression exp){
    	this.operandeDroite = exp;
    }
    
    public abstract int valeur();
    public abstract String toString();
    
    public int nbOperateurs(){
        return this.operandeGauche.nbOperateurs()+this.operandeDroite.nbOperateurs()+1 ;
    }

}
