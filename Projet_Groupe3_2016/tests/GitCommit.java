package temporaire;

public class GitCommit extends GitObjectEnf {
	private String commit;
	private String parent;
	private String author;
	private String committer;
	
	public GitCommit(String id) {
		super(id);
	}
	
	public String getCommit (){
		return commit;
	}
	
	public void setCommit (String s){
		this.commit = s;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCommitter() {
		return committer;
	}

	public void setCommitter(String committer) {
		this.committer = committer;
	}
	
	
}
