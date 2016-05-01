package paquet;

import java.io.File;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = JOptionPane.showInputDialog(null, "Veuillez entrer le chemin pour acceder au dossier !",
				JOptionPane.QUESTION_MESSAGE);
		Recherche finder = new Recherche();
		finder.afficheConsole(nom);
		Parcours.essai(new File(nom));
	}
}
