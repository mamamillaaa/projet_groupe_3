package projet;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Interface extends JPanel {
	private JTextField txtobject;
	public String a = "";
	JPanel panel_1;
	JTextArea txtrRrr;
	/**
	 * Create the panel.
	 */
	public Interface() throws IOException, DataFormatException {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		add(panel, BorderLayout.NORTH);

		JTextPane txtpnEntrezLeChemin = new JTextPane();
		txtpnEntrezLeChemin.setBackground(Color.PINK);
		txtpnEntrezLeChemin.setEditable(false);
		txtpnEntrezLeChemin.setText("Entrez le chemin:");
		panel.add(txtpnEntrezLeChemin);

		txtobject = new JTextField();
		txtobject.setHorizontalAlignment(SwingConstants.RIGHT);
		txtobject.setText("/objects");
		panel.add(txtobject);
		txtobject.setColumns(10);

		txtobject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListeHashGit lst = new ListeHashGit();
				File directory = new File(e.getActionCommand());
				if (!directory.exists()) {
					System.out.println("Le fichier/répertoire '" + e.getActionCommand() + "' n'existe pas");
				} else if (!directory.isDirectory()) {
					System.out.println(
							"Le chemin '" + e.getActionCommand() + "' correspond à un fichier et non à un répertoire");
				} else {
					File[] subfiles = lst.listeHash(e.getActionCommand());
					String message = "Le répertoire '" + e.getActionCommand() + "' contient " + subfiles.length
							+ " fichier" + (subfiles.length > 1 ? "s" : "");
					System.out.println(message);

					for (int i = 0; i < subfiles.length; i++) {
						a += (subfiles[i].getName()) + "\n";
					}
					System.out.println(a);
					machin();
					repaint();
					/*
					 * try { lst.trierHash(); } catch (IOException |
					 * DataFormatException e1) { // TODO Auto-generated catch
					 * block e1.printStackTrace(); }
					 */
				}
			}
		});

		panel_1 = new JPanel();

		add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 90, 89, 110, 0 };
		gbl_panel_1.rowHeights = new int[] { 25, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton btnGitTree = new JButton("Git Tree");
		GridBagConstraints gbc_btnGitTree = new GridBagConstraints();
		gbc_btnGitTree.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGitTree.insets = new Insets(0, 0, 5, 5);
		gbc_btnGitTree.gridx = 0;
		gbc_btnGitTree.gridy = 0;
		panel_1.add(btnGitTree, gbc_btnGitTree);

		btnGitTree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cette méthode ne sera appelée que pour les événements sur le
				// bouton monBouton.
			}
		});

		JButton btnGitBlob = new JButton("Git Blob");
		GridBagConstraints gbc_btnGitBlob = new GridBagConstraints();
		gbc_btnGitBlob.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGitBlob.insets = new Insets(0, 0, 5, 5);
		gbc_btnGitBlob.gridx = 1;
		gbc_btnGitBlob.gridy = 0;
		panel_1.add(btnGitBlob, gbc_btnGitBlob);

		JButton btnGitCommit = new JButton("Git Commit");
		GridBagConstraints gbc_btnGitCommit = new GridBagConstraints();
		gbc_btnGitCommit.insets = new Insets(0, 0, 5, 0);
		gbc_btnGitCommit.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnGitCommit.gridx = 2;
		gbc_btnGitCommit.gridy = 0;
		panel_1.add(btnGitCommit, gbc_btnGitCommit);

		txtrRrr = new JTextArea();
		
		
		machin();
		
		GridBagConstraints gbc_txtrRrr = new GridBagConstraints();
		gbc_txtrRrr.gridwidth = 4;
		gbc_txtrRrr.fill = GridBagConstraints.BOTH;
		gbc_txtrRrr.gridx = 0;
		gbc_txtrRrr.gridy = 1;
		txtrRrr.setEditable(false);
		panel_1.add(txtrRrr, gbc_txtrRrr);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPane.setBackground(Color.WHITE);
		add(textPane, BorderLayout.CENTER);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(Color.LIGHT_GRAY);
		add(textPane_1, BorderLayout.SOUTH);

	}

	void machin() {

	
		txtrRrr.setText(a);
		

	}

}
