package plic.analyse ;

import java_cup.runtime.*;

%%

%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state Commentaire
entier = [0-9]+
bool = vrai | faux
classe = classe
idf = [a-zA-Z][a-zA-Z0-9]*
fin = fin 
statut = publique | privee
type = entier | double | boolean
lire = lire 
ecrire = ecrire
cstchaine = \"[^;]*\"
LineTerminator= \r|\n|\r\n

%%

<YYINITIAL> {entier} 	{ return symbol(CodesLexicaux.CSTE_ENT, yytext()); }
<YYINITIAL> {bool} 		{ return symbol(CodesLexicaux.BOOL, yytext()); }
<YYINITIAL> "+" 	 	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL> "-" 	 	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL> "*" 	 	{ return symbol(CodesLexicaux.FOIS); }
<YYINITIAL> "/"			{ return symbol(CodesLexicaux.DIVISER); }
<YYINITIAL> "<" 	 	{ return symbol(CodesLexicaux.INF); }
<YYINITIAL> ">" 	 	{ return symbol(CodesLexicaux.SUP); }
<YYINITIAL> "==" 	 	{ return symbol(CodesLexicaux.EGALE); }
<YYINITIAL> "!=" 		{ return symbol(CodesLexicaux.DIFFERENT); }
<YYINITIAL> "(" 		{ return symbol(CodesLexicaux.PARENTHESE_OUVERT); }
<YYINITIAL> ")" 		{ return symbol(CodesLexicaux.PARENTHESE_FERMER); }
<YYINITIAL>	 "//"		{ yybegin(Commentaire) ; }
<Commentaire>{LineTerminator}	 { yybegin(YYINITIAL) ; }
. 					 	{}
\n 					 	{}
