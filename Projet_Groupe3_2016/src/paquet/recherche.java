package paquet;
import java.io.File;

import javax.swing.JOptionPane;
 
public class recherche {
	public recherche() {
		super();
	}
	
	public  void findFiles(String directoryPath) {
		File directory = new File(directoryPath);
		if(!directory.exists()){
			System.out.println("Le fichier/répertoire '"+directoryPath+"' n'existe pas");
		}else if(!directory.isDirectory()){
			System.out.println("Le chemin '"+directoryPath+"' correspond à un fichier et non à un répertoire");
		}else{
			File[] subfiles = directory.listFiles();
			String message = "Le répertoire '"+directoryPath+"' contient "+ subfiles.length+" fichier"+(subfiles.length>1?"s":"");
			System.out.println(message);
			for(int i=0 ; i<subfiles.length; i++){
				System.out.println(subfiles[i].getName());
			}
		}
	}

	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = JOptionPane.showInputDialog(null, "Veuillez entrer le chemin pour acceder au dossier !", JOptionPane.QUESTION_MESSAGE);
		recherche finder = new recherche();
		finder.findFiles(nom);
		JOptionPane.showMessageDialog(null, "Votre fichier " + nom, "est introuvable", JOptionPane.INFORMATION_MESSAGE);
	}
}
