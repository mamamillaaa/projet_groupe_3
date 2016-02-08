package paquet;

import java.io.File;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String chemin = JOptionPane.showInputDialog(null, "Veuillez entrer le chemin pour acceder au dossier !", JOptionPane.QUESTION_MESSAGE);
	    Recherche finder = new Recherche();
	    finder.afficheConsole(chemin);
	    
	    File racine = new File(chemin);
	    File[] noeuds = racine.listFiles();
		
		
		
		Parcours.essai(new File(chemin));
	}
}
