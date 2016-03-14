package projet;

import java.awt.Color;

import javax.swing.JPanel;
 
public class PanelSecondaire extends JPanel {

	private JPanel panelSecondaire = null;
 
	public PanelSecondaire() {
 
		//getPanelSecondaire();
 
	}
 
	public JPanel getPanelSecondaire() {
		if(panelSecondaire == null) {
			panelSecondaire = new JPanel();
			panelSecondaire.setBackground(Color.blue);
			panelSecondaire.setSize(100,100);			
		}
		return panelSecondaire;
	}
 
 }
