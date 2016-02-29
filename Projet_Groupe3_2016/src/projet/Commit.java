package projet;

public class Commit extends GitObjectEnf {
	private Tree tree;
	
	public Commit(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Tree getTree (){
		return tree;
	}
	
	public void setTree (Tree tree){
		this.tree = tree;
	}
}
