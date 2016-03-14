package temporaire;

public class GitBlob extends GitObject {
	private String blob;

	public GitBlob(String id) {
		super(id);
	}
	
	public String getBlob (){
		return blob;
	}

	public void setBlob (String s){
		this.blob = s;
	}

}
