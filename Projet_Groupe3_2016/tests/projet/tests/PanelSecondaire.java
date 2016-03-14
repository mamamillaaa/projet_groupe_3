package projet.tests;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
 
public class PanelSecondaire extends PanelPrincipal {

	private JPanel panelSecondaire = null;
 
	public PanelSecondaire() {
 
		//getPanelSecondaire();
		BorderLayout disposition = new BorderLayout();
	}
 
	public JPanel getPanelSecondaire() {
		if(panelSecondaire == null) {
			panelSecondaire = new JPanel();
			panelSecondaire.setBackground(Color.blue);
			panelSecondaire.setSize(200,200);			
		}
		return panelSecondaire;
	}
 
 }
