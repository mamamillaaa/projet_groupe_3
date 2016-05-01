package temporaire2;

public class GitBlob extends GitObject {
	public static final String TYPE = "blob";

	public GitBlob(String id) {
		super(id, TYPE);
	}

}
