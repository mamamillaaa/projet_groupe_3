package temporaire2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipInputStream;

public class Decompression {

	public static byte[] decompression(byte[] donnees) throws IOException, DataFormatException {

		Inflater inflater = new Inflater();
		inflater.setInput(donnees);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(donnees.length);
		byte[] buffer = new byte[1024];
		while (!inflater.finished()) {
			int cpt = inflater.inflate(buffer);
			outputStream.write(buffer, 0, cpt);
		}

		outputStream.close();
		byte[] output = outputStream.toByteArray();

		return output;

	}

	public static byte[] lireFichier(String chemin) throws IOException {
		File fichier = new File(chemin);
		int longueur = (int) fichier.length();
		byte[] donnees = new byte[longueur];
		@SuppressWarnings("resource")
		BufferedInputStream contenu = new BufferedInputStream(new FileInputStream(fichier));
		contenu.read(donnees, 0, longueur);

		return donnees;
	}

	public static String byteToString(byte[] listeBytes) {
		String nomFichier = "";

		for (int i = 0; i < listeBytes.length; i++) {
			nomFichier += (char) listeBytes[i];
		}

		return nomFichier;
	}

	public static GitObject lireFichier(String chemin, String id) throws IOException {
		File path = new File(chemin);
		GitObject result = null;
		ZipInputStream zipInputStream = null;
		try {
			zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(path)));

			StringBuffer sb = new StringBuffer();
			int data = zipInputStream.read();
			int offset = 1;
			while (data != -1 && data != '\0') {
				sb.append((byte) data);
				zipInputStream.read();
				offset += 1;
			}

			if (data == -1) {
				// gérer le cas d'erreur
			}

			String header = sb.toString();
			String[] vars = header.split(" ");
			String type = vars[0];
			String size = vars[1];

			byte[] b = null;
			zipInputStream.read(b, offset, (int) path.length());

			switch (type) {
			case GitTree.TYPE:
				GitTree tree = new GitTree(id);
				// operation sur le tree
				result = tree;
				break;

			case GitBlob.TYPE:
				GitBlob blob = new GitBlob(id);
				result = blob;

			case GitCommit.TYPE:
				GitCommit commit = new GitCommit(id);
				result = commit;
			default:
				result = new GitObject(id, type);
				break;
			}

			result.setContent(b);
			result.setTaille(size);
			result.setHeader(header);

		} catch (FileNotFoundException e) {
			// TODO: gerer le cas d'erreur
		} finally {
			if (zipInputStream != null) {
				try {
					zipInputStream.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}

		return result;
	}
}
