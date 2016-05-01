package temporaire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class ListeHashGit {

	public String[] temp;
	public String temp2;
	public ArrayList<String> ListeHashCode = new ArrayList<String>();
	public ArrayList<String> CheminHashCode = new ArrayList<String>();
	public ArrayList<GitCommit> ListeGitCommit = new ArrayList<GitCommit>();
	public ArrayList<GitBlob> ListeGitBlob = new ArrayList<GitBlob>();
	public ArrayList<GitTree> ListeGitTree = new ArrayList<GitTree>();

	public void listeHash(String Chemin) {
		File fichier = new File(Chemin);
		File[] fic = fichier.listFiles();
		String pack = Chemin + "/pack";
		for (int i = 0; i < fic.length; i++) {
			try {

				if (fic[i].isDirectory()) {
					File[] subfiles = fic[i].listFiles();
					for (int j = 0; j < subfiles.length; j++) {
						if (subfiles[j].isFile() && !(subfiles[j].getParent().equals(pack))) {
							this.temp2 = (String) subfiles[j].getAbsolutePath();
							this.CheminHashCode.add(temp2);
							temp = (temp2).split("/");
							String hash = temp[temp.length - 2] + temp[temp.length - 1];
							this.ListeHashCode.add(hash);
						}
					}

				} else if (fic[i].isFile()) {
					this.temp2 = (String) fic[i].getAbsolutePath();
					this.CheminHashCode.add(temp2);
					temp = (temp2).split("/");
					String hash = temp[temp.length - 2] + temp[temp.length - 1];
					this.ListeHashCode.add(hash);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	public void TrierHash() throws IOException, DataFormatException {

		for (int i = 0; i < this.CheminHashCode.size(); i++) {
			byte[] truc = Decompression.decompress(Decompression.LireFichier(this.CheminHashCode.get(i)));
			byte s = truc[1];
			if (s == 108) {
				ListeGitBlob.add(new GitBlob(this.ListeHashCode.get(i)));
				byte[] troc = Decompression.decompress(Decompression.LireFichier(this.CheminHashCode.get(i)));
				ListeGitBlob.get(ListeGitBlob.size() - 1).setBlob(ByteToString.byteToString(troc));
			}

			else if (s == 114) {
				ListeGitTree.add(new GitTree(this.ListeHashCode.get(i)));
				byte[] troc = Decompression.decompress(Decompression.LireFichier(this.CheminHashCode.get(i)));
				ListeGitTree.get(ListeGitTree.size() - 1).setTree(ByteToString.byteToString(troc));
			} else if (s == 111) {
				ListeGitCommit.add(new GitCommit(this.ListeHashCode.get(i)));
				byte[] troc = Decompression.decompress(Decompression.LireFichier(this.CheminHashCode.get(i)));
				ListeGitCommit.get(ListeGitCommit.size() - 1).setCommit(ByteToString.byteToString(troc));
			}
		}
	}

	public void InformationsHash() {
		for (int i = 0; i < ListeGitCommit.size(); i++) {
			String[] Split = ListeGitCommit.get(i).getCommit().split("\n");
			ListeGitCommit.get(i).setNumero(Split[0].substring(7));
			ListeGitCommit.get(i).setParent(Split[1].substring(7));
			ListeGitCommit.get(i).setAuthor(Split[2].substring(7));
			ListeGitCommit.get(i).setCommitter(Split[3].substring(10));
			ListeGitCommit.get(i).setName(Split[5]);
		}

		for (int i = 0; i < ListeGitBlob.size(); i++) {
			String[] Split = ListeGitBlob.get(i).getBlob().split("\n");
			ListeGitBlob.get(i).setNumero(Split[0].substring(5));
			ListeGitBlob.get(i).setBlob(ListeGitBlob.get(i).getBlob().substring(9));
		}

		for (int i = 0; i < ListeGitBlob.size(); i++) {
			String[] Split = ListeGitBlob.get(i).getBlob().split("\n");
			ListeGitTree.get(i).setNumero(Split[0].substring(5));
			// ListeGitTree.get(i).setBlob(ListeGitBlob.get(i).getBlob().substring(9));
		}

	}

}
