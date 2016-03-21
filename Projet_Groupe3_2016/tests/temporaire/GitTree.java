package temporaire;

public class GitTree extends GitObjectEnf{
	private String tree;

	public GitTree(String id) {
		super(id);
	}

	public String getTree (){
			return tree;
		}
	
	public void setTree (String s){
			this.tree = s;
		}
	
	
	
}
