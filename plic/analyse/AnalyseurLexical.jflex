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
idf = [a-zA-Z][a-zA-Z0-9]*
statut = publique | privee
type = entier | double | boolean
cstchaine = \"[^;]*\"
LineTerminator= \r|\n|\r\n

%%

<YYINITIAL> "classe" 	{ return symbol(CodesLexicaux.classe); }
<YYINITIAL> "fin" 		{ return symbol(CodesLexicaux.fin); }
<YYINITIAL> {entier} 	{ return symbol(CodesLexicaux.cste_ent, yytext()); }
<YYINITIAL> {bool} 		{ return symbol(CodesLexicaux.bool, yytext()); }
<YYINITIAL> {idf} 		{ return symbol(CodesLexicaux.idf, yytext()); }
<YYINITIAL> "+" 	 	{ return symbol(CodesLexicaux.plus); }
<YYINITIAL> "-" 	 	{ return symbol(CodesLexicaux.moins); }
<YYINITIAL> "*" 	 	{ return symbol(CodesLexicaux.fois); }
<YYINITIAL> "/"			{ return symbol(CodesLexicaux.diviser); }
<YYINITIAL> "<" 	 	{ return symbol(CodesLexicaux.inf); }
<YYINITIAL> ">" 	 	{ return symbol(CodesLexicaux.sup); }
<YYINITIAL> "==" 	 	{ return symbol(CodesLexicaux.egale); }
<YYINITIAL> "!=" 		{ return symbol(CodesLexicaux.different); }
<YYINITIAL> "(" 		{ return symbol(CodesLexicaux.parenthese_ouvert); }
<YYINITIAL> ")" 		{ return symbol(CodesLexicaux.parenthese_fermer); }
<YYINITIAL> ";" 		{ return symbol(CodesLexicaux.pointvirgule); }


<YYINITIAL>	 "//"		{ yybegin(Commentaire) ; }
<Commentaire>{LineTerminator}	 { yybegin(YYINITIAL) ; }
. 					 	{}
\n 					 	{}
