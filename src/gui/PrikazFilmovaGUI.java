package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

import main.Film;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import sistemskeoperacije.SOUcitajIzFajla;

public class PrikazFilmovaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblFilmovi;
	private JComboBox comboBox;
	private JLabel Slika;
	private LinkedList<Film> lista =SOUcitajIzFajla.ucitajIzFajla();
	private JScrollPane scrollPane;
	private JTextArea Tekst;

	/**
	 * Launch the application.
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
					PrikazFilmovaGUI frame = new PrikazFilmovaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrikazFilmovaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.NORTH);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getSlika());
			panel.add(getScrollPane());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblFilmovi());
			panel_1.add(getComboBox());
		}
		return panel_1;
	}
	private JLabel getLblFilmovi() {
		if (lblFilmovi == null) {
			lblFilmovi = new JLabel("Filmovi:");
		}
		return lblFilmovi;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String value=comboBox.getSelectedItem().toString();
					for (int i = 0; i < lista.size(); i++) {
					if(value==lista.get(i).getNazivFilma()){
					
						Tekst.setText(lista.get(i).getOpis());
						Slika.setIcon(new ImageIcon(PrikazFilmovaGUI.class.getResource(lista.get(i).getAdresaSlike())));
					}
					}
				}
			});
			for (int i = 0; i < lista.size(); i++) {
				comboBox.addItem(lista.get(i));
			}
			
		}
		return comboBox;
	}
	private JLabel getSlika() {
		if (Slika == null) {
			Slika = new JLabel("");
			Slika.setHorizontalTextPosition(SwingConstants.LEFT);
			Slika.setHorizontalAlignment(SwingConstants.LEFT);
			Slika.setPreferredSize(new Dimension(150, 200));
		}
		return Slika;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(150, 200));
			scrollPane.setViewportView(getTekst());
		}
		return scrollPane;
	}
	private JTextArea getTekst() {
		if (Tekst == null) {
			Tekst = new JTextArea();
			Tekst.setWrapStyleWord(true);
			Tekst.setLineWrap(true);
			Tekst.setEditable(false);
		}
		return Tekst;
	}
}
