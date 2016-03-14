package projet.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
 
public class PanelPrincipal extends JPanel implements ActionListener {
 
	private JButton blob = new JButton("blob");
	private JButton tree = new JButton("tree");
	private JButton commit = new JButton("commit");
	private JFrame fenetre;
	private JPanel panelNord = null;
	private JPanel panelCentre = null;
	private JPanel panelWest = null;
	private JPanel panelEast = null;
 
	public PanelPrincipal() {
 
		this.fenetre = new JFrame("Test application graphique JPanel impbriqués");
 
		this.fenetre.addWindowListener (new WindowAdapter()
		{ public void windowClosing(WindowEvent e){ 
			System.exit(0);}
		} );
 
		java.awt.Container container = this.fenetre.getContentPane();
		BorderLayout disposition = new BorderLayout();
		
		container.setLayout(disposition);
		container.setPreferredSize(new java.awt.Dimension(1000, 1000));
		/*
		fenetre.setSize(100, 100);
		fenetre.setLocationRelativeTo(getParent());
		*/

		/*
		
		container.add(getPanelCentre(), BorderLayout.CENTER);

		*/
		container.add(getPanelCentre(), BorderLayout.CENTER);
		container.add(getPanelWest(), BorderLayout.WEST);
		container.add(getPanelEast(), BorderLayout.EAST);
		container.add(getPanelNord(), BorderLayout.NORTH);
		
		this.fenetre.pack();
		this.fenetre.setVisible(true);
		this.fenetre.setPreferredSize(new Dimension(1000, 1000));
		/*
		
		container.add(blob);
		container.add(tree);
		container.add(commit);
		blob.addActionListener((ActionListener) this);
		tree.addActionListener((ActionListener) this);
		commit.addActionListener((ActionListener) this);*/
	}
 
	private Component getPanelEast() {
		if(panelEast == null) {
			panelEast = new JPanel();
			panelEast.setBackground(Color.RED);
			panelEast.setPreferredSize(new Dimension(100, 100));
		}
		return panelEast;
	}

	private Component getPanelWest() {
		if(panelWest == null) {
			panelWest = new JPanel();
			panelWest.setBackground(Color.BLUE);
			panelWest.setPreferredSize(new Dimension(100, 200));
		}
		return panelWest;
		
	}

	public JPanel getPanelCentre() {
		if(panelCentre == null) {
			panelCentre = new JPanel();
			panelCentre.setBackground(Color.ORANGE);
		}		
		return panelCentre;
	}
 
	public JPanel getPanelNord() {
		BorderLayout disposition = new BorderLayout();
		if(panelNord == null) {
		
			
			//java.awt.Container container = panelCentre.get;
			FlowLayout disposition1 = new FlowLayout();
			panelNord = new JPanel(disposition1);
			panelNord.setPreferredSize(new Dimension(500, 60));
			
			blob.setPreferredSize(new Dimension(100, 50));
			tree.setPreferredSize(new Dimension(100, 50));
			commit.setPreferredSize(new Dimension(100, 50));
			panelNord.add(blob);
			panelNord.add(tree);
			panelNord.add(commit);
		}
		return panelNord;
	}
 
	public static void main(String args[]) {
		new PanelPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getSource().toString());
	}
}
