package projet;

public class GitCommit extends GitObjectEnf {
	private GitTree tree;
	
	public GitCommit(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public GitTree getTree (){
		return tree;
	}
	
	public void setTree (GitTree tree){
		this.tree = tree;
	}
}
