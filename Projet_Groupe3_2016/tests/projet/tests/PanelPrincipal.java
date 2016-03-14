package projet.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class PanelPrincipal extends JPanel {
 
	private JButton blob = new JButton("blob");
	private JButton tree = new JButton("tree");
	private JButton commit = new JButton("commit");
	private JFrame fenetre;
	private JPanel panelNord = null;
	private JPanel panelCentre = null;
 
	public PanelPrincipal() {
 
		this.fenetre = new JFrame("Test application graphique JPanel impbriqués");
 
		this.fenetre.addWindowListener (new WindowAdapter()
		{ public void windowClosing(WindowEvent e){ 
			System.exit(0);}
		} );
 
		java.awt.Container container = this.fenetre.getContentPane();
		BorderLayout disposition = new BorderLayout();
 
		container.setLayout(disposition);
		container.setPreferredSize(new java.awt.Dimension(800, 600));
 
		fenetre.setSize(10, 100);
		fenetre.setLocationRelativeTo(getParent());
 
		container.add(getPanelNord(), BorderLayout.NORTH);
		container.add(getPanelCentre(), BorderLayout.CENTER);
 
		this.fenetre.pack();
		this.fenetre.setVisible(true);
		
		
		container.add(blob);
		container.add(tree);
		container.add(commit);
		blob.addActionListener((ActionListener) this);
		tree.addActionListener((ActionListener) this);
		commit.addActionListener((ActionListener) this);
	}
 
	public JPanel getPanelNord() {
		if(panelNord == null) {
			panelNord = new JPanel();
			panelNord.setBackground(Color.ORANGE);
		}		
		return panelNord;
	}
 
	public JPanel getPanelCentre() {
		if(panelCentre == null) {
			panelCentre =  new PanelSecondaire().getPanelSecondaire();
		}
		return panelCentre;
	}
 
	public static void main(String args[]) {
		new PanelPrincipal();
	}
}
