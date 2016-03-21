package temporaire;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class Main {

	public static void main(String[] args) throws IOException, DataFormatException {

		ListeHashGit lst = new ListeHashGit();
		lst.listeHash("/home/ragez/git/projet_groupe_3/.git/objects");
		
		lst.TrierHash();
		lst.InformationsHash();
		System.out.println(lst.ListeGitTree.get(0).getTree());

		

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