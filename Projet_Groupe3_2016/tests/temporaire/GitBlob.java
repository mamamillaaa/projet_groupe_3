package temporaire;

public class GitBlob extends GitObject {
	private String blob;
	private String numero;

	public GitBlob(String id) {
		super(id);
	}

	public String getBlob() {
		return blob;
	}

	public void setBlob(String s) {
		this.blob = s;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
