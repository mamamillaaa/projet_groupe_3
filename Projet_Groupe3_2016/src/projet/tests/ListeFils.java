package projet.tests;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ListeFils {

	private File f = new File("/home/mmoren01/git/projet_groupe_3/.git/objects");
	private File[] liste_fils = f.listFiles();
	private ArrayList<File> list = new ArrayList<>();

	public void liste(File[] f){

		for (int i = 0; i < f.length; i++) {
			File file = f[i];

			if (file.isDirectory()){
				File[] subfiles = f[i].listFiles();
				for(int j=0 ; j<subfiles.length; j++){
					liste(subfiles);
				}
			}
			this.list.add(file);
			
		}
	}
	
	
	public static void main(String[] args) {
		ListeFils lst = new ListeFils();
		for (int k=0; k <lst.list.size(); k++){

			try {
				BufferedInputStream oos =new BufferedInputStream(new FileInputStream(lst.list.get(k)));
				System.out.println(oos);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}




