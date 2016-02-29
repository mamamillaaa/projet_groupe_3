package projet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("/home/mmoren01/git/projet_groupe_3/.git/objects");
		File[] liste_fils = f.listFiles();

		for (int i = 0; i < liste_fils.length; i++) {
			File file = liste_fils[i];

			if (file.isDirectory()){
				File[] subfiles = liste_fils[i].listFiles();
				for(int j=0 ; j<subfiles.length; j++){
					System.out.println(subfiles[j].getName());
				}
			}
			try {
				BufferedInputStream oos =new BufferedInputStream(
						new FileInputStream(file));
				System.out.println(oos);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
