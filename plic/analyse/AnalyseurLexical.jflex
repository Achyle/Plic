package plic.analyse ;

import java_cup.runtime.*;
import plic.exception.lexical.LexicalException;
import plic.Plic;

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
type = entier|booleen
chaine = \"([^[\"]]|([\"]{2}))*\"
commentaireSlashSlash = [/][/].*

%%

{commentaireSlashSlash}	{}
"classe" 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.classe); }
"ecrire" 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.ecrire); }
"lire" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.lire); }
"fin" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.fin); }
{entier} 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.cste_ent, yytext()); }
{statut} 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.statut, yytext()); }
{type} 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.type, yytext()); }
{bool} 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.bool, yytext()); }
{chaine} 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.cste_chaine, yytext()); }
{idf} 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.idf, yytext()); }
"+" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.plus); }
"-" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.moins); }
"*" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.fois); }
"/"			{ Plic.setLigne(yyline); return symbol(CodesLexicaux.diviser); }
"<" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.inf); }
">" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.sup); }
"==" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.test_egale); }
"!=" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.test_different); }
"=" 	 	{ Plic.setLigne(yyline); return symbol(CodesLexicaux.egale); }
"(" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.parenthese_ouvert); }
")" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.parenthese_fermer); }
";" 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.pointvirgule); }
"," 		{ Plic.setLigne(yyline); return symbol(CodesLexicaux.virgule); }

\s			{Plic.setLigne(yyline); }
.	{ throw new LexicalException(yyline, yytext());}
