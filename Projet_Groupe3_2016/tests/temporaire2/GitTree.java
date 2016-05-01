package temporaire2;

public class GitTree extends GitObjectEnf {
	public static final String TYPE = "tree";

	public GitTree(String id) {
		super(id, TYPE);
	}

	/*
	 * public String toString() { String s = new String(); int fin =
	 * this.tree.length();
	 * 
	 * for (int i=1;i<=fin;i++) { s += this.valeurs[i]+ " "; } return s; }
	 */

}
