package temporaire2;

public class GitCommit extends GitObjectEnf {
	public static final String TYPE = "commit"; 

	private String parent;
	private String author;
	private String committer;
	private String name;
	
	public GitCommit(String id) {
		super(id, TYPE);
	}
	
	@Override
	public void setContent(byte[] s) {
		super.setContent(s);
		// TODO: interpréter le contenu en string
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

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
