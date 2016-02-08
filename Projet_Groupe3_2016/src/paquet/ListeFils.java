package paquet;

import java.io.File;

public class ListeFils {
    File[] dossiers;
	
	public ListeFils(File chemin){
		this.dossiers = chemin.listFiles();
	}

}
