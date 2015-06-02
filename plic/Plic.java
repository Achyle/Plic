package plic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import lexique.Lexique;

import analyse.AnalyseurLexical;
import analyse.AnalyseurSyntaxique;

public class Plic {
	
	private String fichierSource;
	private String fichierDestination;
	
	public Plic(String fs,String fr ){
		fichierSource = fs;
		fichierDestination = fr;
	}
	
	@SuppressWarnings("deprecation")
	public void gereCodeAssembleur(){
		PrintWriter pw;
		AnalyseurSyntaxique as;
		Lexique lexique = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fichierDestination+".asm")));	
			as = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichierSource)));
			lexique = (Lexique) as.parse().value;
			String res = lexique.generer() ;
			pw.write(res+"\n");
			pw.close();
			 
			System.out.println("La compilation a reussie\n");
			System.out.println("Le fichier " + fichierDestination+".asm" + " a etait generer");
		} catch(FileNotFoundException e){// retourne erreur lorsque le fichier destination est incorrect
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println("Erreur  : " + e.toString());
		}
	}
}
