package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;


import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JButton btnPrikaz;
	private JButton btnRezervisiKarte;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private int brojac = 1;
	private JButton button;
	private JButton button_1;
	private JPanel panel_2;
	private JLabel lblDobrodosliUBioskop;
	private JLabel lblInfo;
	private JLabel lblLokacijaNepoznata;
	private JLabel lblBrojSala;
	private JLabel lblApsolutnoNebitan;
	private JLabel label;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDostupniFilmovi;
	private JMenuItem mntmRezerviiKarte;
	private JMenuItem mntmExit_1;
	private JPopupMenu popupMenu_1;
	private JPopupMenu popupMenu_2;
	private JMenuItem mntmExit_2;
	private JMenuItem mntmDostupniFilmovi_1;
	private JMenuItem mntmRezerviiKarte_1;
	
	
	

	
	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		setResizable(false);
		setTitle("Bioskop Eclipse\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GlavniProzor.class.getResource("/icons/logo.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setJMenuBar(getMenuBar_1());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel_1(), BorderLayout.SOUTH);
		contentPane.add(getTabbedPane(), BorderLayout.CENTER);
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(500, 40));
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnPrikaz());
			panel_1.add(getBtnRezervisiKarte());
		}
		return panel_1;
	}
	private JButton getBtnPrikaz() {
		if (btnPrikaz == null) {
			btnPrikaz = new JButton("Vidi dostupne filmove");
			btnPrikaz.setToolTipText("Otvorite stranu sa prikazima najnovijih filmova!");
			btnPrikaz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziFilmove();
				}
			});
		}
		return btnPrikaz;
	}
	private JButton getBtnRezervisiKarte() {
		if (btnRezervisiKarte == null) {
			btnRezervisiKarte = new JButton("Rezervi\u0161i karte");
			btnRezervisiKarte.setToolTipText("Otvorite stranu za rezervacije!");
			btnRezervisiKarte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziRezervacije();			}
			});
			btnRezervisiKarte.setPreferredSize(new Dimension(133, 23));
		}
		return btnRezervisiKarte;
	}
	
	
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.setIcon(new ImageIcon(GlavniProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		}
		return mntmExit;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("O nama", null, getPanel_2_1(), null);
			tabbedPane.addTab("Galerija", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setName("");
			panel.setLayout(null);
			addPopup(panel, getPopupMenu_2());
			panel.add(getLblNewLabel());
			panel.add(getButton());
			panel.add(getButton_1());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(34, 5, 400, 220);
			lblNewLabel.setPreferredSize(new Dimension(400, 220));
			lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource("/galerija/1.jpg")));
		}
		return lblNewLabel;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					brojac--;
					if(brojac == 0) brojac=3;
					String adresa = "/galerija/"+brojac +".jpg";
					
					lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource(adresa)));
					
				}
			});
			button.setBounds(176, 228, 50, 23);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton(">");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					brojac++;
					if(brojac == 4) brojac=1;
					String adresa = "/galerija/"+brojac +".jpg";
				
					lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource(adresa)));
					
				}
			});
			button_1.setBounds(236, 228, 50, 23);
		}
		return button_1;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			addPopup(panel_2, getPopupMenu());
			panel_2.add(getLblDobrodosliUBioskop());
			panel_2.add(getLblInfo());
			panel_2.add(getLblLokacijaNepoznata());
			panel_2.add(getLblBrojSala());
			panel_2.add(getLblApsolutnoNebitan());
			panel_2.add(getLabel());
		}
		return panel_2;
	}
	private JLabel getLblDobrodosliUBioskop() {
		if (lblDobrodosliUBioskop == null) {
			lblDobrodosliUBioskop = new JLabel("Dobrodosli u bioskop Eclipse");
			lblDobrodosliUBioskop.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblDobrodosliUBioskop.setBounds(21, 11, 208, 28);
		}
		return lblDobrodosliUBioskop;
	}
	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("Info:");
			lblInfo.setBounds(50, 50, 46, 14);
		}
		return lblInfo;
	}
	private JLabel getLblLokacijaNepoznata() {
		if (lblLokacijaNepoznata == null) {
			lblLokacijaNepoznata = new JLabel("Lokacija: Java");
			lblLokacijaNepoznata.setBounds(60, 87, 116, 14);
		}
		return lblLokacijaNepoznata;
	}
	private JLabel getLblBrojSala() {
		if (lblBrojSala == null) {
			lblBrojSala = new JLabel("Broj sala: 4");
			lblBrojSala.setBounds(60, 112, 63, 14);
		}
		return lblBrojSala;
	}
	private JLabel getLblApsolutnoNebitan() {
		if (lblApsolutnoNebitan == null) {
			lblApsolutnoNebitan = new JLabel("Radno vreme bioskopa zavisi od poèetka prve projekcije.");
			lblApsolutnoNebitan.setBounds(60, 137, 388, 14);
		}
		return lblApsolutnoNebitan;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(GlavniProzor.class.getResource("/galerija/4.gif")));
			label.setBounds(348, 24, 100, 90);
		}
		return label;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDostupniFilmovi());
			popupMenu.add(getMntmRezerviiKarte());
			popupMenu.add(getMntmExit_1());
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
	private JMenuItem getMntmDostupniFilmovi() {
		if (mntmDostupniFilmovi == null) {
			mntmDostupniFilmovi = new JMenuItem("Dostupni filmovi");
			mntmDostupniFilmovi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziFilmove();
				}
			});
		}
		return mntmDostupniFilmovi;
	}
	private JMenuItem getMntmRezerviiKarte() {
		if (mntmRezerviiKarte == null) {
			mntmRezerviiKarte = new JMenuItem("Rezervi\u0161i karte");
			mntmRezerviiKarte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziRezervacije();
				}
			});
		}
		return mntmRezerviiKarte;
	}
	private JMenuItem getMntmExit_1() {
		if (mntmExit_1 == null) {
			mntmExit_1 = new JMenuItem("Exit");
			mntmExit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
		}
		return mntmExit_1;
	}
	
	private JPopupMenu getPopupMenu_2() {
		if (popupMenu_2 == null) {
			popupMenu_2 = new JPopupMenu();
			popupMenu_2.add(getMntmDostupniFilmovi_1());
			popupMenu_2.add(getMntmRezerviiKarte_1());
			popupMenu_2.add(getMntmExit_2());
		}
		return popupMenu_2;
	}
	private JMenuItem getMntmExit_2() {
		if (mntmExit_2 == null) {
			mntmExit_2 = new JMenuItem("Exit");
			mntmExit_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
		}
		return mntmExit_2;
	}
	private JMenuItem getMntmDostupniFilmovi_1() {
		if (mntmDostupniFilmovi_1 == null) {
			mntmDostupniFilmovi_1 = new JMenuItem("Dostupni filmovi");
			mntmDostupniFilmovi_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziFilmove();
				}
			});
		}
		return mntmDostupniFilmovi_1;
	}
	private JMenuItem getMntmRezerviiKarte_1() {
		if (mntmRezerviiKarte_1 == null) {
			mntmRezerviiKarte_1 = new JMenuItem("Rezervi\u0161i karte");
			mntmRezerviiKarte_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziRezervacije();
				}
			});
		}
		return mntmRezerviiKarte_1;
	}
}
