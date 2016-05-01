package projet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import temporaire2.Decompression;
import temporaire2.GitBlob;
import temporaire2.GitCommit;
import temporaire2.GitObject;
import temporaire2.GitTree;

public class ListeHashGit {

	public ArrayList<String> listeHashCode = new ArrayList<String>();
	public ArrayList<String> cheminHashCode = new ArrayList<String>();
	public ArrayList<GitCommit> listeGitCommit = new ArrayList<GitCommit>();
	public ArrayList<GitBlob> listeGitBlob = new ArrayList<GitBlob>();
	public ArrayList<GitTree> listeGitTree = new ArrayList<GitTree>();

	public File[] listeHash(String chemin) {
		/*
		 * prend en paramètre le chemin du dossier "objects" et renvoie une
		 * liste contenant les hashcodes et une liste des chemins de ces hash
		 */
		File fichier = new File(chemin);
		File[] listeFic = fichier.listFiles();
		String pack = chemin + "/pack"; // permet de savoir quand on est dans le
										// dossier "pack"
		for (int i = 0; listeFic != null && i < listeFic.length; i++) {
			try {

				if (listeFic[i].isDirectory()) {
					File[] sousFichiers = listeFic[i].listFiles();
					for (int j = 0; j < sousFichiers.length; j++) {
						regardeSousFichier(pack, sousFichiers, j);
					}

				} else if (listeFic[i].isFile()) {
					String cheminAbsolu = (String) listeFic[i].getAbsolutePath();
					this.cheminHashCode.add(cheminAbsolu);
					String[] splitHash = (cheminAbsolu).split("/");
					String hash = splitHash[splitHash.length - 2] + splitHash[splitHash.length - 1];
					this.listeHashCode.add(hash);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return listeFic;
	}

	private void regardeSousFichier(String pack, File[] sousFichiers, int j) {
		if (sousFichiers[j].isFile() && !(sousFichiers[j].getParent().equals(pack))) {
			String cheminAbsolu = (String) sousFichiers[j].getAbsolutePath();
			this.cheminHashCode.add(cheminAbsolu);// on rajoute
													// le chemin
													// du hash
			String[] splitHash = (cheminAbsolu).split("/");
			String hash = splitHash[splitHash.length - 2] + splitHash[splitHash.length - 1];
			this.listeHashCode.add(hash);
		}
	}

	public void trierHash() throws IOException, DataFormatException {

		for (int i = 0; i < this.cheminHashCode.size(); i++) {
			System.out.println(cheminHashCode.get(i));
			System.out.println(listeHashCode.get(i));

			/*
			 * byte[] tabByte = Decompression.decompression(Decompression
			 * .lireFichier(this.cheminHashCode.get(i))); byte element =
			 * tabByte[1];
			 */ // element récupérant le 2nd byte ("r",
				// "o" ou "l") pour determiner son type
			GitObject type = Decompression.lireFichier(cheminHashCode.get(i), listeHashCode.get(i));
			if (type.getType() == "blob") {
				listeGitBlob.add((GitBlob) type);
			} else if (type.getType() == "commit") {
				listeGitCommit.add((GitCommit) type);
			}
			if (type.getType() == "tree") {
				listeGitTree.add((GitTree) type);
			}
			/*
			 * if (element == 108) { GitBlob titi = new
			 * GitBlob(this.listeHashCode.get(i));
			 * titi.setContent(Decompression.byteToString(tabByte)); //test
			 * listeGitBlob.add(titi); }
			 * 
			 * else if (element == 114) { listeGitTree.add(new
			 * GitTree(this.listeHashCode.get(i)));
			 * listeGitTree.get(listeGitTree.size() - 1).setContent(
			 * Decompression.byteToString(tabByte)); } else if (element == 111)
			 * { listeGitCommit.add(new GitCommit(this.listeHashCode.get(i)));
			 * listeGitCommit.get(listeGitCommit.size() - 1).setContent(
			 * Decompression.byteToString(tabByte)); }
			 */
		}
	}

	/*
	 * public void informationsHash() { for (int i = 0; i <
	 * listeGitCommit.size(); i++) { String[] tabSplit =
	 * listeGitCommit.get(i).getContent());
	 * listeGitCommit.get(i).setTaille(tabSplit[0].substring(7));
	 * listeGitCommit.get(i).setParent(tabSplit[1].substring(7));
	 * listeGitCommit.get(i).setAuthor(tabSplit[2].substring(7));
	 * listeGitCommit.get(i).setCommitter(tabSplit[3].substring(10));
	 * listeGitCommit.get(i).setName(tabSplit[5]); }
	 * 
	 * for (int i = 0; i < listeGitBlob.size(); i++) { int tabSplit =
	 * listeGitBlob.get(i).getContent().length;
	 * listeGitBlob.get(i).setTaille(tabSplit[0].substring(5));
	 * listeGitBlob.get(i).setContent(
	 * listeGitBlob.get(i).getContent().substring(9)); }
	 * 
	 * for (int i = 0; i < listeGitTree.size(); i++) { String[] tabSplit =
	 * listeGitTree.get(i).getContent().split("\n");
	 * listeGitTree.get(i).setTaille(tabSplit[0].substring(5)); //
	 * ListeGitTree.get(i).setBlob(ListeGitBlob.get(i).getBlob().substring(9));
	 * }
	 * 
	 * }
	 */

}
