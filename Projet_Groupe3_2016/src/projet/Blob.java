package projet;

public class Blob extends GitObject {
	private Tree tree;

	public Blob(String id) {
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
