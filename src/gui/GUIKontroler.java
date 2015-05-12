package gui;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.ColorUIResource;



public class GUIKontroler {
	
	private static GlavniProzor gp;
	/**
	 * Launch the application.
	 * @throws Exception
	 */
	public static void main(String[] args) {
		try {
			
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            UIManager.put("nimbusBase", new ColorUIResource(13, 140, 165));
                    UIManager.put("control", new ColorUIResource(250,250,255));
                    UIManager.put("textForeground", new ColorUIResource(25, 9, 64));
                   
                    break;
		        }
		    }
		} catch (Exception e) {
		   
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gp = new GlavniProzor();
					gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Metoda koja gasi aplikaciju.
	 */
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(gp.getContentPane(),
				"Da li ZAISTA želite da izaðete iz aplikacije?", "Izlazak",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);
	}
	/**
	  * Metoda koja otvara prozor za rezervacije.
	  */
	
	public static void prikaziRezervacije(){
		RezervacijeGUI rezervacije = new RezervacijeGUI();
		rezervacije.setVisible(true);
		rezervacije.setLocationRelativeTo(gp.getContentPane());	
	}
	/**
	  * Metoda koja otvara prozor za prikaz filmova.
	  */
	public static void prikaziFilmove() {
		PrikazFilmovaGUI prikazi = new PrikazFilmovaGUI();
		prikazi.setVisible(true);
		prikazi.setLocationRelativeTo(gp.getContentPane());
		
	}

}