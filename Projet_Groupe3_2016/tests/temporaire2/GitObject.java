package temporaire2;

public class GitObject {
	private String id;
	private byte[] content;
	private String taille;
	private String type;
	private String header;
	
	public GitObject (String id, String type){
		this.id = id;
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public String getId(){
		return this.id;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] s) {
		this.content = s;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
}
