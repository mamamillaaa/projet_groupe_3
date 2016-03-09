package paquet;

import java.io.File;


public class Parcours {
 // fonction de recherche qui renvois la liste des fils du dossier File("chemin")! 
	static void essai(File f){
		File[] liste_fils = f.listFiles();
		
		if(liste_fils!=null){
			System.out.println(f.getPath());
	 
			for(File fils:liste_fils)
			{
				essai(fils);
			}
		}
	}
}
