package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

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
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
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
	public GlavniProzor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ugasiAplikaciju();
			}
		});
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
			panel_1.add(getBtnPrikaz());
			panel_1.add(getBtnRezervisiKarte());
		}
		return panel_1;
	}
	private JButton getBtnPrikaz() {
		if (btnPrikaz == null) {
			btnPrikaz = new JButton("Vidi dostupne filmove");
		}
		return btnPrikaz;
	}
	private JButton getBtnRezervisiKarte() {
		if (btnRezervisiKarte == null) {
			btnRezervisiKarte = new JButton("Rezervisi karte");
			btnRezervisiKarte.setPreferredSize(new Dimension(133, 23));
		}
		return btnRezervisiKarte;
	}
	
	private void ugasiAplikaciju(){
		int returnVal =JOptionPane.showConfirmDialog(contentPane, "Da li ste sigurni da zelite da izadjete", "Exit", JOptionPane.YES_NO_OPTION);
		if(returnVal == JOptionPane.YES_OPTION){
			System.exit(0);
		}
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
					ugasiAplikaciju();
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
			tabbedPane.addTab("Galerija", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setName("");
			panel.setLayout(null);
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
					System.out.println(adresa);
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
					System.out.println(adresa);
					lblNewLabel.setIcon(new ImageIcon(GlavniProzor.class.getResource(adresa)));
					
				}
			});
			button_1.setBounds(236, 228, 50, 23);
		}
		return button_1;
	}
}
