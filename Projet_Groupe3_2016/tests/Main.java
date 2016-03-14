package temporaire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class Main {

	public static void main(String[] args) throws IOException, DataFormatException {

		ListeHashGit lst = new ListeHashGit();
		lst.listeHash("/home/ragez/git/projet_groupe_3/.git/objects");
		System.out.println("lst "+lst.ListeHashCode.get(6));
		
		lst.TrierHash();
		System.out.println(lst.ListeGitBlob.get(1).getBlob());

		

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