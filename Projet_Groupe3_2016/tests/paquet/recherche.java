package paquet;

import java.io.File;
import javax.swing.JOptionPane;

public class Recherche {
	public Recherche() {
		super();
	}

	// fonction qui affiche le nombre de sous dossier contenue dans le lien
	// donné
	public void afficheConsole(String directoryPath) {
		File directory = new File(directoryPath);
		if (!directory.exists()) {
			System.out.println("Le fichier/répertoire '" + directoryPath + "' n'existe pas");
		} else if (!directory.isDirectory()) {
			System.out.println("Le chemin '" + directoryPath + "' correspond à un fichier et nom à un répertoire");
		} else {
			File[] subfiles = directory.listFiles();
			String message = "Le répertoire '" + directoryPath + "' contient " + subfiles.length + " dossier"
					+ (subfiles.length > 1 ? "s" : "");
			System.out.println(message);
			for (int i = 0; i < subfiles.length; i++) {
				System.out.println(subfiles[i].getName());
			}
		}
	}

}
