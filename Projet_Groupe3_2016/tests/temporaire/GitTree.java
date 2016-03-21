package temporaire;

public class GitTree extends GitObjectEnf{
	private String tree;
	private String numero;

	public GitTree(String id) {
		super(id);
	}

	public String getTree (){
			return tree;
		}
	
	public void setTree (String s){
			this.tree = s;
		}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/*public String toString() {
		String s = new String();
		int fin = this.tree.length();
		
		for (int i=1;i<=fin;i++) {
		    s += this.valeurs[i]+ " "; 
		}
		return s;
	    }*/
	
}
