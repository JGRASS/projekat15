package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.PomocnaProjekcija;
import main.PomocnaProjekcija;

public class RezervacijeGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblFilm;

	private JLabel lblVreme;
	private JComboBox comboBoxFilmovi;
	private JLabel lblUnesiteImeI;
	private JTextField textFieldUnesiImeIPrezime;
	private JComboBox comboBoxSala;
	private JComboBox comboBoxVreme;
	private JButton btnRezervii;
	
	
	private JLabel lblSala;
	private JLabel lblUkupnoUlaznica;
	private JCheckBox checkBox1;
	private JTextField textFieldCena;
	private JLabel lblCenaUlaznice;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JRadioButton radioButton5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	int broj; //svaka sala moze da primi odredjeni broj ljudi
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervacijeGUI frame = new RezervacijeGUI();
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
	public RezervacijeGUI() {
		setTitle("Rezervacije");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblFilm());

		contentPane.add(getLblVreme());
		contentPane.add(getComboBoxFilmovi());
		contentPane.add(getLblUnesiteImeI());
		contentPane.add(getTextFieldUnesiImeIPrezime());
		contentPane.add(getComboBoxSala());
		contentPane.add(getComboBoxVreme());
		contentPane.add(getBtnRezervii());
		contentPane.add(getLblSala());
		contentPane.add(getLblUkupnoUlaznica());
		contentPane.add(getTextFieldCena());
		contentPane.add(getLblCenaUlaznice());
		contentPane.add(getRadioButton1());
		contentPane.add(getRadioButton2());
		contentPane.add(getRadioButton3());
		contentPane.add(getRadioButton4());
		contentPane.add(getRadioButton5());
		
	}
	
	
	LinkedList<PomocnaProjekcija> lista = new LinkedList<>();
	
	private JLabel getLblFilm() {
		if (lblFilm == null) {
			lblFilm = new JLabel("Filmovi");
			lblFilm.setBounds(67, 33, 46, 14);
		}
		return lblFilm;
	}
	
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme");
			lblVreme.setBounds(371, 33, 46, 14);
		}
		return lblVreme;
	}
	
	private JComboBox getComboBoxSala() {
		if (comboBoxSala == null) {
			comboBoxSala = new JComboBox();
			comboBoxSala.setEnabled(false);
			comboBoxSala.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBoxFilmovi.getSelectedItem().toString().equals("Bezvremenska Adaline") && comboBoxSala.getSelectedItem().toString().equals("Sala 2")) {
						comboBoxVreme.setEnabled(true);
						comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"16", "22"}));
					} else {
						if(comboBoxSala.getSelectedItem().toString().equals("Sala 2")) {
							comboBoxVreme.setEnabled(true);
							comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"18"}));
			} else {
				if(comboBoxSala.getSelectedItem().toString().equals("Sala 1")) {
					comboBoxVreme.setEnabled(true);
					comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"17", "19", "21"}));
			} else {
				if(comboBoxSala.getSelectedItem().toString().equals("Sala 3")) {
					comboBoxVreme.setEnabled(true);
					comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"20", "22"}));
			} else {
				if(comboBoxSala.getSelectedItem().toString().equals("Sala 4")) {
					comboBoxVreme.setEnabled(true);
					comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"20", "23"}));
			}
					}
				}
			}
					}
				}
		
			});
			
		
			comboBoxSala.setBounds(217, 58, 101, 20);
		}
		return comboBoxSala;
	}

	
	
	private JComboBox getComboBoxFilmovi() {
		if (comboBoxFilmovi == null) {
			comboBoxFilmovi = new JComboBox();
			comboBoxFilmovi.setModel(new DefaultComboBoxModel(new String[] {"Paklene ulice 7", "Bezvremenska Adaline", "Vruca potera"}));
			comboBoxFilmovi.setBounds(10, 58, 177, 20);
			comboBoxFilmovi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comboBoxFilmovi.getSelectedItem().toString().equals("Bezvremenska Adaline")) {
						comboBoxSala.setEnabled(true);
						comboBoxSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2"}));
						textFieldCena.setText("350");
					}else {
						if(comboBoxFilmovi.getSelectedItem().toString().equals("Paklene ulice 7")) {
							comboBoxSala.setEnabled(true);
							comboBoxSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 3"}));
							textFieldCena.setText("400");
						} else {
							if(comboBoxFilmovi.getSelectedItem().toString().equals("Vruca potera")) {
								comboBoxSala.setEnabled(true);
								comboBoxSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 2", "Sala 4"}));
								textFieldCena.setText("350");
							}
						}
					}
				}
			});
		}
		return comboBoxFilmovi;
	}
	private JLabel getLblUnesiteImeI() {
		if (lblUnesiteImeI == null) {
			lblUnesiteImeI = new JLabel("Unesite ime i prezime");
			lblUnesiteImeI.setBounds(41, 188, 160, 14);
		}
		return lblUnesiteImeI;
	}
	private JTextField getTextFieldUnesiImeIPrezime() {
		if (textFieldUnesiImeIPrezime == null) {
			textFieldUnesiImeIPrezime = new JTextField();
			textFieldUnesiImeIPrezime.setBounds(10, 207, 177, 20);
			textFieldUnesiImeIPrezime.setColumns(10);
		}
		return textFieldUnesiImeIPrezime;
	}

		
	
	
	private JComboBox getComboBoxVreme() {
		if (comboBoxVreme == null) {
			comboBoxVreme = new JComboBox();
			comboBoxVreme.setEnabled(false);
			
			comboBoxVreme.setBounds(360, 58, 73, 20);
		}
		return comboBoxVreme;
	}
	private JButton getBtnRezervii() {
		if (btnRezervii == null) {
			btnRezervii = new JButton("Rezervi\u0161i");
			btnRezervii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textFieldUnesiImeIPrezime.getText().isEmpty()) {    // ako je ime i prezime prazno, poruka da se obavezno popuni
					JOptionPane.showConfirmDialog(contentPane,
							"Obavezno popuniti polje Ime i prezime!", "Obaveštenje",
							JOptionPane.OK_CANCEL_OPTION);
				} else {   
					broj = 0;
					
					PomocnaProjekcija rez = new PomocnaProjekcija();
					
					
					rez.setVreme(Integer.parseInt((comboBoxVreme.getSelectedItem().toString())));
					rez.setNazivFilma(comboBoxFilmovi.getSelectedItem().toString());
					rez.setSala(comboBoxSala.getSelectedItem().toString());
					
					
					for(int i = 0; i<vratiBrojUlaznica(); i++) {          // punimo listu rezervisanih karata
						lista.add(rez);
					}
					
					for(int j = 0; j<lista.size(); j++) {
						if(rez.equals(lista.get(j))) {
							broj++;
						}
					}
					
					
					
					
					if(broj>50) {									
						for(int i = 0; i<vratiBrojUlaznica(); i++) {   //neophodno da bi se nakon neuspesne rezervacija ostvarila uspesna(npr. nema mesta za 3 osobe, vec za 1)
							lista.removeLast();
							broj--;
						}
					
						JOptionPane.showConfirmDialog(contentPane, "U izabranoj sali nema slobodnih mesta", "Popunjena sala", JOptionPane.OK_CANCEL_OPTION);
						
						
						
					} else {
					
					
					
					int s = textFieldUnesiImeIPrezime.hashCode();
					
				
					JOptionPane.showConfirmDialog(contentPane, "Vas kod je "+s+"\nFilm: " 
					+comboBoxFilmovi.getSelectedItem().toString()+"\n"
							+comboBoxSala.getSelectedItem().toString()+" \nVreme "+comboBoxVreme.getSelectedItem().toString()
							+"\nUkupna cena ulaznica je "+ Integer.parseInt(textFieldCena.getText().toString())*vratiBrojUlaznica(),"Uspesno obavljena rezervacija", JOptionPane.OK_CANCEL_OPTION);
				}
				}
				
					
				}
			});
			btnRezervii.setBounds(280, 188, 151, 50);
		}
		return btnRezervii;
	}
	
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala");
			lblSala.setBounds(246, 33, 46, 14);
		}
		return lblSala;
	}
	private JLabel getLblUkupnoUlaznica() {
		if (lblUkupnoUlaznica == null) {
			lblUkupnoUlaznica = new JLabel("Ukupno ulaznica");
			lblUkupnoUlaznica.setBounds(49, 107, 114, 14);
		}
		return lblUkupnoUlaznica;
	}
	
	
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setEditable(false);
			textFieldCena.setBounds(317, 129, 86, 20);
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
	private JLabel getLblCenaUlaznice() {
		if (lblCenaUlaznice == null) {
			lblCenaUlaznice = new JLabel("Cena ulaznice");
			lblCenaUlaznice.setBounds(325, 107, 73, 14);
		}
		return lblCenaUlaznice;
	}
	private JRadioButton getRadioButton1() {
		if (radioButton1 == null) {
			radioButton1 = new JRadioButton("1");
			buttonGroup.add(radioButton1);
			radioButton1.setBounds(6, 128, 37, 23);
		}
		return radioButton1;
	}
	private JRadioButton getRadioButton2() {
		if (radioButton2 == null) {
			radioButton2 = new JRadioButton("2");
			buttonGroup.add(radioButton2);
			radioButton2.setBounds(39, 128, 37, 23);
		}
		return radioButton2;
	}
	private JRadioButton getRadioButton3() {
		if (radioButton3 == null) {
			radioButton3 = new JRadioButton("3");
			buttonGroup.add(radioButton3);
			radioButton3.setBounds(74, 128, 37, 23);
		}
		return radioButton3;
	}
	private JRadioButton getRadioButton4() {
		if (radioButton4 == null) {
			radioButton4 = new JRadioButton("4");
			buttonGroup.add(radioButton4);
			radioButton4.setBounds(109, 128, 37, 23);
		}
		return radioButton4;
	}
	private JRadioButton getRadioButton5() {
		if (radioButton5 == null) {
			radioButton5 = new JRadioButton("5");
			buttonGroup.add(radioButton5);
			radioButton5.setBounds(143, 128, 44, 23);
		}
		return radioButton5;
	}
	
	private int vratiBrojUlaznica() {
		int brojUlaznica = 0;
		if(radioButton1.isSelected()) {
			brojUlaznica = 1;
		}else {
		if(radioButton2.isSelected()) {
			brojUlaznica = 2;
		} else {
			
		if(radioButton3.isSelected()) {
			brojUlaznica = 3;
		} else {
		if(radioButton4.isSelected()) {
			brojUlaznica = 4;
		}else {
		if(radioButton5.isSelected()) brojUlaznica = 5;
		}
		}
		}
		}
		return brojUlaznica;
	}
	
	
	
}