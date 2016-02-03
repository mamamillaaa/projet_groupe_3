package paquet;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Arbre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JPanel jContentPane = null;
	private JTree jTree = null;
    private File[] dossiers = fils.listFiles();
	

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Arbre testJtree = new Arbre();
		testJtree.setVisible(true);

	}
	
	public static File getChemin(String fils){
		File chemin = new File(fils);
		return chemin;
	}
	
	//Exemple de base d'un arbre
	/*private JTree getJTree() {
		if (jTree == null) {
		jTree = new JTree();
		}
		return jTree;
		}*/
	
	//cree l'arbre souhaite (exemple)
	
	private JTree getJTree() {
		if (jTree == null) {
			
		DefaultMutableTreeNode racine = new DefaultMutableTreeNode("objects");
		
		for (int i = 0; i < this.dossiers.length; i++) {
			/*if (dossiers[i].isDirectory()){
				File fils = new File(dossiers[i]);
			    File[] noeuds = racine.listFiles();
			    Arbre enfant = new Arbre();
			    enfant.getJTree(noeuds);
			}*/
			DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(dossiers[i]);
			racine.add(noeud);
		}
		/*DefaultMutableTreeNode noeud1 = new DefaultMutableTreeNode("Noeud 1");
		racine.add(noeud1);
		DefaultMutableTreeNode noeud3 = new DefaultMutableTreeNode("Noeud 3");
		noeud1.add(noeud3);
		DefaultMutableTreeNode noeud2 = new DefaultMutableTreeNode("Noeud 2");
		racine.add(noeud2);*/
		
		
		jTree = new JTree(racine);
		}
		return jTree;
	}
	
	public Arbre() {
		super();
		initialize();
		}
	
	//initialise la fenetre de l'arbre
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		}
	
	//affiche l'arbre
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
		jContentPane = new javax.swing.JPanel();
		jContentPane.setLayout(new java.awt.BorderLayout());
		jContentPane.add(getJTree(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
		}
	

}
