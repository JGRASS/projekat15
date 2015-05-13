package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sistemskeoperacije.SODeserialize;
import sistemskeoperacije.SOSerialize;
import sistemskeoperacije.SOUcitajIzFajla;
import main.Film;
import main.PomocnaProjekcija;

public class RezervacijeGUI extends JFrame implements Serializable{

	/**
	 * panel na kome se nalaze polja za unos, radioButtons i comboBoxes
	 */
	private JPanel contentPane;
	
	/**
	 * tekstualna komponenta Film
	 */
	private JLabel lblFilm;

	/**
	 * tekstualna komponenta Vreme
	 */
	private JLabel lblVreme;
	
	/**
	 * comboBox cije su stavke dostupni filmovi u bioskopu
	 */
	private JComboBox comboBoxFilmovi;
	
	/**
	 * tekstualna komponenta Unesite ime i prezime
	 */
	private JLabel lblUnesiteImeI;
	
	/**
	 * polje za unos imena i prezimena osobe koja rezervise
	 */
	
	private JTextField textFieldUnesiImeIPrezime;
	
	/**
	 * comboBox cije stavke su sale u kojima se održava izabrani film
	 */
	private JComboBox comboBoxSala;
	
	/**
	 * dostupna vremena za izabrani film i salu
	 */
	
	private JComboBox comboBoxVreme;
	
	/**
	 * dugme za rezervisanje
	 */
	private JButton btnRezervii;
	
	/**
	 * tekstualna komponenta Sala
	 */
	private JLabel lblSala;
	
	/**
	 * tekstualna komponenta Ukupno ulaznica
	 */
	private JLabel lblUkupnoUlaznica;
	
	/**
	 * polje u kome izlazi cena ulaznice za izabranu projekciju
	 */
	private JTextField textFieldCena;
	/**
	 * tekstualna komponenta Cena ulaznice
	 */
	private JLabel lblCenaUlaznice;
	/**
	 * radioButton koji oznacava da nam je potrebna jedna karta
	 */
	private JRadioButton radioButton1;
	/**
	 *  radioButton koji oznacava da su nam potrebne dve karte
	 */
	private JRadioButton radioButton2;
	/**
	 *  radioButton koji oznacava da su nam potrebne tri karte
	 */
	private JRadioButton radioButton3;
	/**
	 *  radioButton koji oznacava da su nam potrebne cetiri karte
	 */
	private JRadioButton radioButton4;
	/**
	 *  radioButton koji oznacava da nam je potrebno pet karata
	 */
	private JRadioButton radioButton5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * oznacava broj vec rezervisanih ulaznica za odredjenu projekciju
	 */
	int broj; 
	
	/**
	 * lista u kojoj se nalaze podaci o svim rezervisanjima
	 */
	LinkedList<PomocnaProjekcija> lista = SODeserialize.deserialize();
	

	private JLabel label;

	/**
	 * dugme koje nas vraca na pocetnu stranu
	 */
	private JButton btnNazad;
	
	/**
	 * lista filmova koja je ucitana iz fajla
	 */
	private LinkedList<Film> listaFilmova =SOUcitajIzFajla.ucitajIzFajla();
	


	/**
	 * Create the frame.
	 */
	public RezervacijeGUI(){
		setResizable(false);
		setTitle("Rezervacije");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 289);
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
		contentPane.add(getBtnNazad());
		
		
		contentPane.add(getLabel());
		
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon(GlavniProzor.class.getResource("/galerija/4.gif")));
			label.setBounds(333, 93, 100, 90);
		}
		return label;
	}

	/**
	 * metoda koja vraca label Film
	 * @return label Film
	 */
	
	private JLabel getLblFilm() {
		if (lblFilm == null) {
			lblFilm = new JLabel("Filmovi");
			lblFilm.setBounds(67, 33, 46, 14);
		}
		return lblFilm;
	}
	
	/**
	 * metoda koja vraca label Vreme
	 * @return label Vreme
	 */
	
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("Vreme");
			lblVreme.setBounds(371, 33, 62, 14);
		}
		return lblVreme;
	}
	
	/**
	 * metoda koja vraca combobox sa odgovarajucim salama. Pri izboru sale postavlja vremena(comboBoxVreme) davanja filma u toj sali.
	 * @return combobox Sala
	 */
	private JComboBox getComboBoxSala() {
		if (comboBoxSala == null) {
			comboBoxSala = new JComboBox();
			comboBoxSala.setToolTipText("Odaberite salu u kojoj \u0107ete gledati film!");
			comboBoxSala.setEnabled(false);
			comboBoxSala.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i<listaFilmova.size(); i++) {
						for(int j = 1; j<5; j++) {
							if(comboBoxSala.getSelectedItem().toString().equals("Sala "+j) && comboBoxFilmovi.getSelectedItem().toString().equals(listaFilmova.get(i).getNazivFilma())) {
								comboBoxVreme.setEnabled(true);
								if(j%2 == 1) {
									comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {((j+30)/2+i+1)+":"+(j/2)+0, ((j+38)/2+i-1)+":"+(j/3)+5}));
								} else
									comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {((j+30)/2+i+1)+":"+(j/2)+0}));
							}
						}
					}
					if(comboBoxSala.getSelectedItem().toString().equals("Sala 2") && comboBoxFilmovi.getSelectedItem().toString().equals(listaFilmova.get(2).getNazivFilma())) {
						comboBoxVreme.setEnabled(true);
						comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"15:35"}));
					}
					
				}
		
			});
			
		
			comboBoxSala.setBounds(217, 58, 101, 28);
		}
		return comboBoxSala;
	}

	/**
	 * metoda koja vraca combobox sa filmovima koji se prikazuju u bioskopu. Pri izboru filma, postavljaju se sale u kojima se prikazuje film.
	 * @return combobox Filmovi
	 */
	
	private JComboBox getComboBoxFilmovi() {
		if (comboBoxFilmovi == null) {
			comboBoxFilmovi = new JComboBox();
			for (int i = 0; i < listaFilmova.size(); i++) {
				comboBoxFilmovi.addItem(listaFilmova.get(i));
			}
			comboBoxFilmovi.setBounds(10, 58, 177, 28);
		comboBoxFilmovi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(comboBoxFilmovi.getSelectedItem().toString().equals(listaFilmova.get(0).getNazivFilma())) {
						 comboBoxSala.setEnabled(true);
							comboBoxSala.setModel(new DefaultComboBoxModel(new String[] {"Sala 4"}));
							textFieldCena.setText("300");
					}
					
					for(int j = 1; j<listaFilmova.size(); j++) {
						
						 if(comboBoxFilmovi.getSelectedItem().toString().equals(listaFilmova.get(j).getNazivFilma())) {
							 comboBoxSala.setEnabled(true);
								comboBoxSala.setModel(new DefaultComboBoxModel(new String[] {"Sala "+j, "Sala "+(j+1)}));
								textFieldCena.setText(+j*100+150+"");
						 }
					}
			
					
				}
			});
		}
		return comboBoxFilmovi;
	}
	
	/**
	 * metoda koja vraca label Unesite ime i prezime
	 * @return label Unesite ime i prezime
	 */
	private JLabel getLblUnesiteImeI() {
		if (lblUnesiteImeI == null) {
			lblUnesiteImeI = new JLabel("Unesite ime i prezime");
			lblUnesiteImeI.setBounds(39, 169, 160, 14);
		}
		return lblUnesiteImeI;
	}
	
	/**
	 * metoda koja vraca tekstualno polje u koje se unosi ime i prezime
	 * @return tekstualno polje UnesiImeIPrezime
	 */
	private JTextField getTextFieldUnesiImeIPrezime() {
		if (textFieldUnesiImeIPrezime == null) {
			textFieldUnesiImeIPrezime = new JTextField();

			textFieldUnesiImeIPrezime.setToolTipText("Unesite svoje ime i prezime!");

			textFieldUnesiImeIPrezime.setBounds(10, 194, 177, 28);

			textFieldUnesiImeIPrezime.setColumns(10);
		}
		return textFieldUnesiImeIPrezime;
	}

	/**
	 * metoda koja vraca combobox sa vremenima prikazivanja filma
	 * @return combobox Vreme
	 */
	private JComboBox getComboBoxVreme() {
		if (comboBoxVreme == null) {
			comboBoxVreme = new JComboBox();
			comboBoxVreme.setToolTipText("Odaberite vreme kada \u0107ete gledati film!");
			comboBoxVreme.setEnabled(false);
			
			comboBoxVreme.setBounds(360, 58, 73, 28);
		}
		return comboBoxVreme;
	}
	
	/**
	 * metoda koja vraca dugme Rezervisi i pri kliku na ovo dugme dodajemo rezervaciju
	 * u listu rezervisanih karata, pri cemu se vodi racuna o kapacitetu sala.
	 * @return dugme Rezervisi
	 */
	private JButton getBtnRezervii() {
		if (btnRezervii == null) {
			btnRezervii = new JButton("Rezervi\u0161ite");
			btnRezervii.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textFieldUnesiImeIPrezime.getText().isEmpty()) {    // ako je ime i prezime prazno, poruka da se obavezno popuni
					JOptionPane.showMessageDialog(contentPane,
							"Obavezno popuniti polje Ime i prezime", "Obaveštenje",
							JOptionPane.INFORMATION_MESSAGE);
				} else {   
					broj = 0;
					
					PomocnaProjekcija rez = new PomocnaProjekcija();
				
					rez.setVreme(((comboBoxVreme.getSelectedItem().toString())));
					rez.setNazivFilma(comboBoxFilmovi.getSelectedItem().toString());
					rez.setSala(comboBoxSala.getSelectedItem().toString());
				
		
					for(int j = 0; j<lista.size(); j++) {          // proverava koliko ima vec rezervisanih karata za tu projekciju
						if(rez.equals(lista.get(j))) {
							broj++;
						}
					}
						if(broj+vratiBrojUlaznica()>150) {				// kapacitet sale		
							JOptionPane.showConfirmDialog(contentPane, "U izabranoj sali nema slobodnih mesta", "Popunjena sala", JOptionPane.OK_CANCEL_OPTION);
						} else {
							for(int i = 0; i<vratiBrojUlaznica(); i++) {          // punimo listu rezervisanih karata
								lista.add(rez);
							}
							SOSerialize.serialize(lista);
					
					
					int s = textFieldUnesiImeIPrezime.hashCode();
					
					JOptionPane.showMessageDialog(contentPane, "Vas kod je "+s+"\nFilm: " 
					+comboBoxFilmovi.getSelectedItem().toString()+"\n"
							+comboBoxSala.getSelectedItem().toString()+" \nVreme "+comboBoxVreme.getSelectedItem().toString()
							+"\nUkupna cena ulaznica je "+ Integer.parseInt(textFieldCena.getText().toString())*vratiBrojUlaznica(),"Uspesno obavljena rezervacija", JOptionPane.INFORMATION_MESSAGE);
						}
					}
									}
			});


			btnRezervii.setBounds(197, 194, 162, 44);

		}
		return btnRezervii;
	}
	
	/**
	 * metoda koja vraca label Sala
	 * @return label Sala
	 */
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala");
			lblSala.setBounds(246, 33, 46, 14);
		}
		return lblSala;
	}
	
	/**
	 * metoda koja vraca label za broj potrebnih ulaznica
	 * @return label Ukupno ulaznica
	 */
	private JLabel getLblUkupnoUlaznica() {
		if (lblUkupnoUlaznica == null) {
			lblUkupnoUlaznica = new JLabel("Ukupno ulaznica");
			lblUkupnoUlaznica.setBounds(49, 107, 114, 14);
		}
		return lblUkupnoUlaznica;
	}
	
	/**
	 * metoda koja vraca tekstualno polje cena karte za odredjeni film
	 * @return tekstualno polje Cena
	 */
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setToolTipText("Cena jedne ulaznice!");
			textFieldCena.setEditable(false);
			textFieldCena.setBounds(206, 136, 86, 28);
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
	
	/**
	 * metoda koja vraca label cena ulaznice
	 * @return label cena ulaznice
	 */
	private JLabel getLblCenaUlaznice() {
		if (lblCenaUlaznice == null) {
			lblCenaUlaznice = new JLabel("Cena ulaznice");
			lblCenaUlaznice.setBounds(208, 107, 84, 14);
		}
		return lblCenaUlaznice;
	}
	
	/**
	 * metoda koja vraca radioButton koji oznacava da je potrebna jedna ulaznica
	 * @return radioButton jedna ulaznica
	 */
	private JRadioButton getRadioButton1() {
		if (radioButton1 == null) {
			radioButton1 = new JRadioButton("1");
			buttonGroup.add(radioButton1);
			radioButton1.setBounds(6, 128, 37, 23);
		}
		return radioButton1;
	}
	
	/**
	 * metoda koja vraca radioButton koji oznacava da su potrebne dve ulaznice
	 * @return radioButton dve ulaznice
	 */
	private JRadioButton getRadioButton2() {
		if (radioButton2 == null) {
			radioButton2 = new JRadioButton("2");
			buttonGroup.add(radioButton2);
			radioButton2.setBounds(39, 128, 37, 23);
		}
		return radioButton2;
	}
	
	/**
	 * metoda koja vraca radioButton koji oznacava da su potrebne tri ulaznice
	 * @return radioButton tri ulaznice
	 */
	private JRadioButton getRadioButton3() {
		if (radioButton3 == null) {
			radioButton3 = new JRadioButton("3");
			buttonGroup.add(radioButton3);
			radioButton3.setBounds(74, 128, 37, 23);
		}
		return radioButton3;
	}
	
	/**
	 * metoda koja vraca radioButton koji oznacava da su potrebne cetiri ulaznice
	 * @return radioButton cetiri ulaznice
	 */
	private JRadioButton getRadioButton4() {
		if (radioButton4 == null) {
			radioButton4 = new JRadioButton("4");
			buttonGroup.add(radioButton4);
			radioButton4.setBounds(109, 128, 37, 23);
		}
		return radioButton4;
	}
	
	/**
	 * metoda koja vraca radioButton koji oznacava da je potrebno pet ulaznica
	 * @return radioButton pet ulaznica
	 */
	private JRadioButton getRadioButton5() {
		if (radioButton5 == null) {
			radioButton5 = new JRadioButton("5");
			buttonGroup.add(radioButton5);
			radioButton5.setBounds(143, 128, 44, 23);
		}
		return radioButton5;
	}
	
	/**
	 * metoda koja vraca broj ulaznica u zavisnosti od toga koji radioButton je oznacen
	 * @return brojUlaznica
	 */
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
	
	/**
	 * metoda koja vraca dugme koje nas vodi na pocetnu stranu 
	 * @return dugme nazad
	 */
	private JButton getBtnNazad() {
		if (btnNazad == null) {
			btnNazad = new JButton("Nazad");
			btnNazad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNazad.setBounds(371, 205, 78, 23);
		}
		return btnNazad;
	}
	}
	
	
