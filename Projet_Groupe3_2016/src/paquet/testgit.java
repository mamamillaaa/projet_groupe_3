package paquet;

import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Color;


public class testgit {	
	public static void main(String[] args) {
		// pour lancer une commande unix
        //        String cmd;
        //       cmd = "gedit";
        // lance la commande precedente
		/*try {
			Runtime r = Runtime.getRuntime();
                        Process p = r.exec(cmd);
                        p.waitFor();//si l'application doit attendre a ce que ce process fini
		}catch(Exception e) {
			System.out.println("erreur d'execution " + cmd + e.toString());
                }*/
		//ouvre une fenetre
		JFrame cadre = new javax.swing.JFrame("Selection du git");
		JPanel panneau = new JPanel();
		JTextField git = new JTextField();
		Container contentpane = cadre.getContentPane();
		contentpane.add (git);
		
		panneau.setPreferredSize(new Dimension(350, 200));
	
		panneau.setBackground(Color.white);
		cadre.setContentPane(panneau);
		cadre.setLocation(600, 400);
		cadre.pack();
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    }
}