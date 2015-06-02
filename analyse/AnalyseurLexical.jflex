package analyse ;

import java_cup.runtime.*;

%%

%public
%class AnalyseurLexical
%public

%line
%column
%state Commentaire
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cupsym Codeslexicaux
%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

entier = [0-9]+
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
<YYINITIAL> "+" 	 	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL> "-" 	 	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL> "*" 	 	{ return symbol(CodesLexicaux.FOIS); }
<YYINITIAL> "<" 	 	{ return symbol(CodesLexicaux.INF); }
<YYINITIAL> ">" 	 	{ return symbol(CodesLexicaux.SUP); }
<YYINITIAL> "==" 	 	{ return symbol(CodesLexicaux.TEST_EGAL); }
<YYINITIAL> "!=" 		{ return symbol(CodesLexicaux.TEST_NON_EGAL); }
<YYINITIAL> "(" 		{ return symbol(CodesLexicaux.PARENTHESE_OUVERT); }
<YYINITIAL> ")" 		{ return symbol(CodesLexicaux.PARENTHESE_FERMER); }
<YYINITIAL> "="			{ return symbol(CodesLexicaux.EGALE); }
<YYINITIAL> ","	 	 	{ return symbol(CodesLexicaux.VIRGULE); }
<YYINITIAL> ";"		 	{ return symbol(CodesLexicaux.POINT_VIRGULE); }
<YYINITIAL> {classe}	{ return symbol(CodesLexicaux.CLASS, yytext()); }
<YYINITIAL> {fin}	 	{ return symbol(CodesLexicaux.FIN, yytext()); }
<YYINITIAL> {statut} 	{ return symbol(CodesLexicaux.STATUT, yytext()); }
<YYINITIAL> {type}	 	{ return symbol(CodesLexicaux.TYPE, yytext()); }
<YYINITIAL> {lire}	 	{ return symbol(CodesLexicaux.LIR, yytext()); }
<YYINITIAL> {ecrire}    { return symbol(CodesLexicaux.ECRIR, yytext()); }
<YYINITIAL> {idf}		{ return symbol(CodesLexicaux.IDF, yytext()); }
<YYINITIAL> {cstchaine} { return symbol(CodesLexicaux.CSTE_CHAINE, yytext()); }
<YYINITIAL>	 "//"		{ yybegin(Commentaire) ; }
<Commentaire>{LineTerminator}	 { yybegin(YYINITIAL) ; }
. 					 	{}
\n 					 	{}
