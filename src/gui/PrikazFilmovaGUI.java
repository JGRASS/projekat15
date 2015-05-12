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
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

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
	private JPanel panel_2;
	private JButton btnRezerviite;
	private JButton btnNaPoetnu;
	private JPopupMenu popupMenu;
	private JMenuItem mntmRezerviite;
	private JMenuItem mntmNazad;

	

	/**
	 * Create the frame.
	 */
	public PrikazFilmovaGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrikazFilmovaGUI.class.getResource("/icons/logo.png")));
		setTitle("Filmovi u ponudi");
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
			addPopup(panel, getPopupMenu());
			panel.add(getSlika());
			panel.add(getScrollPane());
			panel.add(getPanel_2());
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
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setPreferredSize(new Dimension(100, 200));
			panel_2.add(getBtnRezerviite());
			panel_2.add(getBtnNaPoetnu());
		}
		return panel_2;
	}
	/**Dugme Rezervisite. Klikom na ovo dugme pokrece se prozor za rezervaciju karata i nestaje prozor za prikaz filmova.
	 * @return JButton
	 */
	private JButton getBtnRezerviite() {
		if (btnRezerviite == null) {
			btnRezerviite = new JButton("Rezervi\u0161ite");
			btnRezerviite.setToolTipText("Otvorite stranu za rezervacije!");
			btnRezerviite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziRezervacije();
					dispose();
				}
			});
			btnRezerviite.setAlignmentX(Component.RIGHT_ALIGNMENT);
			btnRezerviite.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		}
		return btnRezerviite;
	}
	private JButton getBtnNaPoetnu() {
		if (btnNaPoetnu == null) {
			btnNaPoetnu = new JButton("Nazad");
			btnNaPoetnu.setToolTipText("Vratite se na po\u010Detnu stranu.");
			btnNaPoetnu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnNaPoetnu;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmRezerviite());
			popupMenu.add(getMntmNazad());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmRezerviite() {
		if (mntmRezerviite == null) {
			mntmRezerviite = new JMenuItem("Rezervi\u0161ite");
			mntmRezerviite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziRezervacije();
					dispose();
				}
			});
		}
		return mntmRezerviite;
	}
	private JMenuItem getMntmNazad() {
		if (mntmNazad == null) {
			mntmNazad = new JMenuItem("Nazad");
			mntmNazad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				dispose();
				}
			});
		}
		return mntmNazad;
	}
}
