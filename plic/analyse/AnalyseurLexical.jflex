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

entier = [0-9]+
bool = vrai | faux
idf = [a-zA-Z][a-zA-Z0-9]*
statut = publique | privee
type = entier
chaine = \"[^;]*\"
commentaireSlashSlash = [/][/].*

%%

{commentaireSlashSlash}	{}
"classe" 	{ return symbol(CodesLexicaux.classe); }
"ecrire" 	{ return symbol(CodesLexicaux.ecrire); }
"lire" 		{ return symbol(CodesLexicaux.lire); }
"fin" 		{ return symbol(CodesLexicaux.fin); }
{entier} 	{ return symbol(CodesLexicaux.cste_ent, yytext()); }
{statut} 	{ return symbol(CodesLexicaux.statut, yytext()); }
{type} 		{ return symbol(CodesLexicaux.type, yytext()); }
{bool} 		{ return symbol(CodesLexicaux.bool, yytext()); }
{chaine} 	{ return symbol(CodesLexicaux.cste_chaine, yytext()); }
{idf} 		{ return symbol(CodesLexicaux.idf, yytext()); }
"+" 	 	{ return symbol(CodesLexicaux.plus); }
"-" 	 	{ return symbol(CodesLexicaux.moins); }
"*" 	 	{ return symbol(CodesLexicaux.fois); }
"/"			{ return symbol(CodesLexicaux.diviser); }
"<" 	 	{ return symbol(CodesLexicaux.inf); }
">" 	 	{ return symbol(CodesLexicaux.sup); }
"==" 	 	{ return symbol(CodesLexicaux.test_egale); }
"!=" 		{ return symbol(CodesLexicaux.test_different); }
"=" 	 	{ return symbol(CodesLexicaux.egale); }
"(" 		{ return symbol(CodesLexicaux.parenthese_ouvert); }
")" 		{ return symbol(CodesLexicaux.parenthese_fermer); }
";" 		{ return symbol(CodesLexicaux.pointvirgule); }
"," 		{ return symbol(CodesLexicaux.virgule); }

\s			{}
.	{ throw new LexicalException(yyline, yytext());}
