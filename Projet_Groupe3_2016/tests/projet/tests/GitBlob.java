package projet.tests;

public class GitBlob extends GitObject {
	private GitTree tree;

	public GitBlob(String id) {
		super(id);
	}
	
	public GitTree getTree (){
		return tree;
	}

	public void setTree (GitTree tree){
		this.tree = tree;
	}

}
