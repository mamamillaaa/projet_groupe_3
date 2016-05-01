package paquet;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {

		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();

		String nom = JOptionPane.showInputDialog(null, "Veuillez entrer le chemin pour acceder au dossier !",
				JOptionPane.QUESTION_MESSAGE);

		JOptionPane.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);

	}

}