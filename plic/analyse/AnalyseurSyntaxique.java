
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20150326 (SVN rev 63)
//----------------------------------------------------

package plic.analyse;

import plic.arbre.ArbreAbstrait;
import plic.arbre.expression.Different;
import plic.arbre.expression.Division;
import plic.arbre.expression.Egale;
import plic.arbre.expression.Expression;
import plic.arbre.expression.Inferieur;
import plic.arbre.expression.Multiplication;
import plic.arbre.expression.Somme;
import plic.arbre.expression.Soustraction;
import plic.arbre.expression.Superieur;
import plic.arbre.expression.Unaire;

/** CUP v0.11b 20150326 (SVN rev 63) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return CodesLexicaux.class;
}

  /** Default constructor. */
  @Deprecated
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\017\000\002\002\004\000\002\002\003\000\002\003" +
    "\003\000\002\004\003\000\002\004\005\000\002\004\004" +
    "\000\002\004\005\000\002\004\005\000\002\004\005\000" +
    "\002\004\005\000\002\004\005\000\002\004\005\000\002" +
    "\004\005\000\002\004\005\000\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\034\000\012\004\006\005\011\010\005\017\010\001" +
    "\002\000\004\002\036\001\002\000\012\004\006\005\011" +
    "\010\005\017\010\001\002\000\026\002\ufffe\006\ufffe\007" +
    "\ufffe\010\ufffe\011\ufffe\012\ufffe\013\ufffe\014\ufffe\015\ufffe" +
    "\016\ufffe\001\002\000\024\002\uffff\007\017\010\022\011" +
    "\023\012\015\013\020\014\024\015\014\016\016\001\002" +
    "\000\026\002\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3\012" +
    "\ufff3\013\ufff3\014\ufff3\015\ufff3\016\ufff3\001\002\000\012" +
    "\004\006\005\011\010\005\017\010\001\002\000\004\002" +
    "\000\001\002\000\024\006\021\007\017\010\022\011\023" +
    "\012\015\013\020\014\024\015\014\016\016\001\002\000" +
    "\012\004\006\005\011\010\005\017\010\001\002\000\012" +
    "\004\006\005\011\010\005\017\010\001\002\000\012\004" +
    "\006\005\011\010\005\017\010\001\002\000\012\004\006" +
    "\005\011\010\005\017\010\001\002\000\012\004\006\005" +
    "\011\010\005\017\010\001\002\000\026\002\ufffd\006\ufffd" +
    "\007\ufffd\010\ufffd\011\ufffd\012\ufffd\013\ufffd\014\ufffd\015" +
    "\ufffd\016\ufffd\001\002\000\012\004\006\005\011\010\005" +
    "\017\010\001\002\000\012\004\006\005\011\010\005\017" +
    "\010\001\002\000\012\004\006\005\011\010\005\017\010" +
    "\001\002\000\026\002\ufff6\006\ufff6\007\017\010\022\011" +
    "\023\012\015\013\ufff6\014\ufff6\015\ufff6\016\ufff6\001\002" +
    "\000\026\002\ufff9\006\ufff9\007\ufff9\010\ufff9\011\ufff9\012" +
    "\ufff9\013\ufff9\014\ufff9\015\ufff9\016\ufff9\001\002\000\026" +
    "\002\ufffa\006\ufffa\007\ufffa\010\ufffa\011\023\012\015\013" +
    "\ufffa\014\ufffa\015\ufffa\016\ufffa\001\002\000\026\002\ufff7" +
    "\006\ufff7\007\017\010\022\011\023\012\015\013\ufff7\014" +
    "\ufff7\015\ufff7\016\ufff7\001\002\000\026\002\ufffb\006\ufffb" +
    "\007\ufffb\010\ufffb\011\023\012\015\013\ufffb\014\ufffb\015" +
    "\ufffb\016\ufffb\001\002\000\026\002\ufff4\006\ufff4\007\017" +
    "\010\022\011\023\012\015\013\ufff4\014\ufff4\015\ufff4\016" +
    "\ufff4\001\002\000\026\002\ufff8\006\ufff8\007\ufff8\010\ufff8" +
    "\011\ufff8\012\ufff8\013\ufff8\014\ufff8\015\ufff8\016\ufff8\001" +
    "\002\000\026\002\ufff5\006\ufff5\007\017\010\022\011\023" +
    "\012\015\013\ufff5\014\ufff5\015\ufff5\016\ufff5\001\002\000" +
    "\026\002\ufffc\006\ufffc\007\ufffc\010\ufffc\011\023\012\015" +
    "\013\ufffc\014\ufffc\015\ufffc\016\ufffc\001\002\000\004\002" +
    "\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\034\000\010\002\003\003\011\004\006\001\001\000" +
    "\002\001\001\000\004\004\034\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\004\012\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\004\033" +
    "\001\001\000\004\004\032\001\001\000\004\004\031\001" +
    "\001\000\004\004\030\001\001\000\004\004\027\001\001" +
    "\000\002\001\001\000\004\004\026\001\001\000\004\004" +
    "\025\001\001\000\004\004\024\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public void report_error(String message, Object info) {
   
        StringBuffer m = new StringBuffer("Error");
        if (info instanceof java_cup.runtime.Symbol) {
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
            if (s.left >= 0) {                
                m.append(" in line "+(s.left+1));   
                if (s.right >= 0)                    
                    m.append(", column "+(s.right+1));
            }
        }

        m.append(" : "+message);
        System.err.println(m);
    }

    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"unused"})
class CUP$AnalyseurSyntaxique$actions {

 
			
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action_part00000000(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= SYSTEME EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait start_val = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // SYSTEME ::= LEXP 
            {
              ArbreAbstrait RESULT =null;
		int lxleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int lxright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		ArbreAbstrait lx = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = lx; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("SYSTEME",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LEXP ::= EXP 
            {
              ArbreAbstrait RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 ArbreAbstrait arbre = new ArbreAbstrait();
	      arbre.ajouterAction(e);
	      RESULT = arbre; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("LEXP",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // EXP ::= CSTE_ENT 
            {
              Expression RESULT =null;
		int csteleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int csteright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String cste = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Unaire(Integer.parseInt(""+cste),false); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // EXP ::= PARENTHESE_OUVERT EXP PARENTHESE_FERMER 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 RESULT = e; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // EXP ::= MOINS EXP 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Multiplication(new Unaire(-1,false),e); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXP ::= EXP PLUS EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Somme(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXP ::= EXP MOINS EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Soustraction(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXP ::= EXP FOIS EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Multiplication(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXP ::= EXP DIVISER EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT = new Division(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXP ::= EXP INF EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT=new Inferieur(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXP ::= EXP SUP EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT=new Superieur(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXP ::= EXP EGALE EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT=new Egale(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXP ::= EXP DIFFERENT EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT=new Different(e1,e2); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXP ::= BOOL 
            {
              Expression RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 RESULT=new Unaire(b=="vrai"?1:0,true); 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",2, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$AnalyseurSyntaxique$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
              return CUP$AnalyseurSyntaxique$do_action_part00000000(
                               CUP$AnalyseurSyntaxique$act_num,
                               CUP$AnalyseurSyntaxique$parser,
                               CUP$AnalyseurSyntaxique$stack,
                               CUP$AnalyseurSyntaxique$top);
    }
}

}
