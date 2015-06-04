package plic.analyse ;

import java_cup.runtime.*;
import plic.exception.lexical.LexicalException;

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
type = entier
chaine = \"[^;]*\"
LineTerminator= \r|\n|\r\n
%%

<YYINITIAL> "classe" 	{ return symbol(CodesLexicaux.classe); }
<YYINITIAL> "ecrire" 	{ return symbol(CodesLexicaux.ecrire); }
<YYINITIAL> "lire" 		{ return symbol(CodesLexicaux.lire); }
<YYINITIAL> "fin" 		{ return symbol(CodesLexicaux.fin); }
<YYINITIAL> {entier} 	{ return symbol(CodesLexicaux.cste_ent, yytext()); }
<YYINITIAL> {statut} 	{ return symbol(CodesLexicaux.statut, yytext()); }
<YYINITIAL> {type} 		{ return symbol(CodesLexicaux.type, yytext()); }
<YYINITIAL> {bool} 		{ return symbol(CodesLexicaux.bool, yytext()); }
<YYINITIAL> {chaine} 	{ return symbol(CodesLexicaux.cste_chaine, yytext()); }
<YYINITIAL> {idf} 		{ return symbol(CodesLexicaux.idf, yytext()); }
<YYINITIAL> "+" 	 	{ return symbol(CodesLexicaux.plus); }
<YYINITIAL> "-" 	 	{ return symbol(CodesLexicaux.moins); }
<YYINITIAL> "*" 	 	{ return symbol(CodesLexicaux.fois); }
<YYINITIAL> "/"			{ return symbol(CodesLexicaux.diviser); }
<YYINITIAL> "<" 	 	{ return symbol(CodesLexicaux.inf); }
<YYINITIAL> ">" 	 	{ return symbol(CodesLexicaux.sup); }
<YYINITIAL> "==" 	 	{ return symbol(CodesLexicaux.test_egale); }
<YYINITIAL> "!=" 		{ return symbol(CodesLexicaux.test_different); }
<YYINITIAL> "=" 	 	{ return symbol(CodesLexicaux.egale); }
<YYINITIAL> "(" 		{ return symbol(CodesLexicaux.parenthese_ouvert); }
<YYINITIAL> ")" 		{ return symbol(CodesLexicaux.parenthese_fermer); }
<YYINITIAL> ";" 		{ return symbol(CodesLexicaux.pointvirgule); }
<YYINITIAL> "," 		{ return symbol(CodesLexicaux.virgule); }

<YYINITIAL>	 "//"		{ yybegin(Commentaire) ; }
<Commentaire>{LineTerminator}	 { yybegin(YYINITIAL) ; }

<YYINITIAL> \s			{}
<YYINITIAL> .	{ throw new LexicalException(yyline, yytext());}
