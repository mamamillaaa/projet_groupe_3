package projet;

public class GitTree extends GitObjectEnf{
	private GitTree tree;

	public GitTree(String id) {
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
