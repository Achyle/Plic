package plic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.expression.Expression;

public class Plic {
	
	private String fichierSource;
	private String fichierDestination;
	
	public Plic(String fs,String fr ){
		fichierSource = fs;
		fichierDestination = fr;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public void gereCodeAssembleur(){
		PrintWriter pw;
		AnalyseurSyntaxique as;
		ArrayList<Expression> e = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fichierDestination+".asm")));	
			as = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichierSource)));
			e = (ArrayList<Expression>) as.parse().value;
			String res = "";
			for (Expression expression : e) {
				res += expression.generer();
			}
			
			pw.write(res+"\n");
			pw.close();
			 
			System.out.println("COMPILATION OK\n");
			System.out.println("Le fichier " + fichierDestination+".asm" + " a été generé");
		} catch(FileNotFoundException ex){// retourne erreur lorsque le fichier destination est incorrect
			System.out.println(ex.toString());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
