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
	
	private String fichierSource;
	private String fichierDestination;
	
	public Plic(String fs,String fr ){
		fichierSource = fs;
		fichierDestination = fr;
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
			pw.write("# zone de reservation de memoire\n");
			pw.write(".data\n");
			pw.write("stri: .asciiz # Si le test concerne un boolean alors true = 1 et false = 0 \n\n");
			pw.write("# zone programme\n");
			pw.write(".text\n");
			String res = arbre.generer() ;
			pw.write(res+"\n");
			
			pw.write("	# retourne le resultat\n");
			pw.write("	li $v0, 4\n");
			pw.write("	la $a0, stri\n");
			pw.write("	syscall\n");
			pw.write("	li $v0, 1\n");
			pw.write("	lw $a0, 4($sp)\n");
			pw.write("	syscall\n");
			
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
