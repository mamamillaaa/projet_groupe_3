package projet;

import java.io.IOException;
import java.util.zip.DataFormatException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException, DataFormatException {


		JFrame fenetre = new JFrame();
		Interface i = new Interface();

		fenetre.add(i);
		fenetre.setSize(400, 400);
		fenetre.setVisible(true);
		
/*		
		ListeHashGit lst = new ListeHashGit();
		lst.listeHash("/home/ragez/git/projet_groupe_3/.git/objects");

		System.out.println(lst.listeHashCode.size());
		System.out.println(lst.cheminHashCode.size());
		lst.trierHash();
		/*lst.informationsHash();
		System.out.println(lst.listeGitTree.get(1).getContent());*/
/*
		System.out.println(lst.listeGitCommit.get(0).getHeader());
*/

		/*for (int i = 0; i < Test.size(); i++) {
			byte[] truc = Decompression.decompress(Decompression.LireFichier(Test.get(i)));
			byte s = truc[1];
			if (s==108)
				System.out.println("blob");
			else if (s==97)
				System.out.println("tag");
			else if (s==114)
				System.out.println("tree");
			else if (s==111)
				System.out.println("commit");
		}*/
	}


}