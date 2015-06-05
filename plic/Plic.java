package plic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;


public class Plic {
	
	public static int ligne = 0;
	private String fichierSource;
	private String fichierDestination;
	
	public static String derniereGrammaire = "";
	
	public Plic(String fs,String fr ){
		fichierSource = fs;
		fichierDestination = fr;
	}
	
	public static void setLigne(int ligne){
		Plic.ligne = ligne;
	}
	
	@SuppressWarnings({ "deprecation" })
	public void gereCodeAssembleur(){
		PrintWriter pw;
		AnalyseurSyntaxique as;
		ArbreAbstrait arbre = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fichierDestination+".asm")));	
			as = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichierSource)));
			arbre = (ArbreAbstrait) as.parse().value;
			String res = arbre.generer();
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
