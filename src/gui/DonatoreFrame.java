package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class DonatoreFrame extends JInternalFrame {

	String gruppoSelezionato;
	JTextField nomeField;
	JTextField cognomeField;
	JTextField dataNascitaField;
	JTextField codiceFiscaleField;
	JTextField viaField;
	JTextField capField;
	JTextField comuneField;
	JTextField statoField;
	JTextField telefonoField;
	JTextField cellulareField;
	JTextField emailField;
	JTextField dataIscrizioneField;
	JTextField nTesseraField;
	JTextField nDonazioniField;
	JTextField dataProssimaDonazioneField;
	JTextField statoNascitaField;
	JTextField cittadinanzaField;
	MainFrame fatherFrame;
	JComboBox sessoBox;
	JComboBox gruppoSanguignoBox;
	JComboBox rhBox;
	JComboBox idoneoBox;
	JComboBox tipoDonatoreBox;
	JComboBox gruppoLocaleBox;
	JComboBox sezioneBox;
	JButton addDonatoreButton;

	public DonatoreFrame(MainFrame mainFrame) {
		fatherFrame = mainFrame;
		setTitle("Nuovo Donatore");
		setSize(650, 500);
		setDefaultCloseOperation(2);

		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");
		builder.appendColumn("5dlu");
		builder.appendColumn("right:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");

		nomeField = new JTextField();
		builder.append("Nome", nomeField);

		cognomeField = new JTextField();
		builder.append("Cognome", cognomeField);
		builder.nextLine();

		String[] sesso = { "M", "F" };
		sessoBox = new JComboBox<Object>(sesso);
		builder.append("Sesso", sessoBox);

		dataNascitaField = new JTextField("gg/mm/aaaa");
		dataNascitaField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				dataNascitaField.selectAll();

			}
		});
		builder.append("Data di Nascita", dataNascitaField);
		builder.nextLine();

		statoNascitaField = new JTextField();
		builder.append("Comune di Nascita", statoNascitaField);

		codiceFiscaleField = new JTextField();
		builder.append("Codice Fiscale", codiceFiscaleField);
		builder.nextLine();

		builder.appendSeparator("Indirizzo");

		viaField = new JTextField();
		builder.append("Via", viaField);

		capField = new JTextField();
		builder.append("CAP", capField);
		builder.nextLine();

		comuneField = new JTextField();
		builder.append("Comune", comuneField);

		statoField = new JTextField();
		builder.append("Stato", statoField);
		builder.nextLine();

		builder.appendSeparator("");

		telefonoField = new JTextField();
		builder.append("Telefono Fisso", telefonoField);

		cellulareField = new JTextField();
		builder.append("Telefono Cellulare", cellulareField);
		builder.nextLine();

		emailField = new JTextField();
		builder.append("Email", emailField);
		builder.nextLine();

		cittadinanzaField = new JTextField();
		builder.append("Cittadinanza", cittadinanzaField);
		builder.nextLine();

		builder.appendSeparator("");

		String[] gruppiSanguigni = { "A", "B", "AB", "0", "NS" };
		gruppoSanguignoBox = new JComboBox(gruppiSanguigni);
		builder.append("Gruppo Sanguigno", gruppoSanguignoBox);

		String[] rh = { "POSITIVO", "NEGATIVO", "NS" };
		rhBox = new JComboBox(rh);
		builder.append("RH", rhBox);
		builder.nextLine();

		dataIscrizioneField = new JTextField("gg/mm/aaaa");
		dataIscrizioneField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				dataIscrizioneField.selectAll();

			}
		});

		builder.append("Data Iscrizione", dataIscrizioneField);

		gruppoLocaleBox = new JComboBox();
		builder.append("Gruppo locale", gruppoLocaleBox);
		builder.nextLine();

		nTesseraField = new JTextField();
		builder.append("Numero tessera", nTesseraField);

		nDonazioniField = new JTextField();
		builder.append("Numero donazioni", nDonazioniField);
		builder.nextLine();

		String[] idoneo = { "I", "N" };
		idoneoBox = new JComboBox(idoneo);
		builder.append("Idoneo", idoneoBox);

		dataProssimaDonazioneField = new JTextField("gg/mm/aaaa");
		dataProssimaDonazioneField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				dataProssimaDonazioneField.selectAll();

			}
		});
		builder.append("Prossima data possibile per donazione",
				dataProssimaDonazioneField);
		builder.nextLine();

		String[] tipoDonatore = { "Socio Donatore", "Socio Benemerito",
				"Occasionale", "Socio Collaboratore" };
		tipoDonatoreBox = new JComboBox<Object>(tipoDonatore);
		builder.append("Tipo di Donatore", tipoDonatoreBox);

		String[] sezioni = {};
		sezioneBox = new JComboBox<Object>(sezioni);
		builder.append("Sezione", sezioneBox);
		final DefaultComboBoxModel sezioneModel = (DefaultComboBoxModel) sezioneBox
				.getModel();

		try {
			DefaultComboBoxModel gruppoModel = (DefaultComboBoxModel) gruppoLocaleBox
					.getModel();
			gruppoModel.removeAllElements();
			ResultSet gruppiResultSet = fatherFrame
					.query("SELECT numero FROM gruppi;");
			while (gruppiResultSet.next()) {
				gruppoModel.addElement(((Integer) gruppiResultSet.getInt(1))
						.toString());

			}
			gruppoLocaleBox.setModel(gruppoModel);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		gruppoLocaleBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gruppoSelezionato = (gruppoLocaleBox.getSelectedItem())
						.toString();
				sezioneModel.removeAllElements();
				ResultSet sezioniResultSet = fatherFrame
						.query("SELECT nome,numero FROM sezioni WHERE gruppo = "
								+ gruppoSelezionato + ";");
				ResultSet nIscritti = fatherFrame
						.query("SELECT niscritti FROM gruppi WHERE numero ="
								+ gruppoSelezionato + ";");
				try {
					while (sezioniResultSet.next())
						sezioneModel.addElement(sezioniResultSet.getString(1)
								+ " " + sezioniResultSet.getInt(2));
					nIscritti.next();
					nTesseraField.setText(((Integer) (nIscritti.getInt(1) + 1))
							.toString());
				} catch (SQLException e1) {
					System.out.println("Errore nel Box delle Sezioni");
				}
			}
		});

		add(builder.getPanel(), BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		addDonatoreButton = new JButton("Aggiungi Donatore");
		addDonatoreButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addDonatoreClicked();

			}
		});

		buttonPanel.add(addDonatoreButton);
		add(buttonPanel, BorderLayout.SOUTH);
		// pack();

	}

	protected void addDonatoreClicked() {
		boolean allOk = true;
		if (nomeField.getText().compareTo("") == 0) {
			nomeField.setBackground(Color.RED);
			allOk = false;
		} else
			nomeField.setBackground(Color.white);

		if (cognomeField.getText().compareTo("") == 0) {
			cognomeField.setBackground(Color.RED);
			allOk = false;
		} else
			cognomeField.setBackground(Color.white);

		if (dataNascitaField.getText().compareTo("") == 0
				|| dataNascitaField.getText().compareTo("gg/mm/aaaa") == 0) {
			dataNascitaField.setBackground(Color.RED);
			allOk = false;
		} else
			dataNascitaField.setBackground(Color.white);

		if (codiceFiscaleField.getText().compareTo("") == 0) {
			codiceFiscaleField.setBackground(Color.RED);
			allOk = false;
		} else
			codiceFiscaleField.setBackground(Color.white);

		if (viaField.getText().compareTo("") == 0) {
			viaField.setBackground(Color.RED);
			allOk = false;
		} else
			viaField.setBackground(Color.white);

		if (capField.getText().compareTo("") == 0) {
			capField.setBackground(Color.RED);
			allOk = false;
		} else
			capField.setBackground(Color.white);

		if (comuneField.getText().compareTo("") == 0) {
			comuneField.setBackground(Color.RED);
			allOk = false;
		} else
			comuneField.setBackground(Color.white);

		if (dataIscrizioneField.getText().compareTo("") == 0
				|| dataIscrizioneField.getText().compareTo("gg/mm/aaaa") == 0) {
			dataIscrizioneField.setBackground(Color.RED);
			allOk = false;
		} else
			dataIscrizioneField.setBackground(Color.white);

		if (nTesseraField.getText().compareTo("") == 0) {
			nTesseraField.setBackground(Color.RED);
			allOk = false;
		} else
			nTesseraField.setBackground(Color.white);

		if (nDonazioniField.getText().compareTo("") == 0) {
			nDonazioniField.setBackground(Color.RED);
			allOk = false;
		} else
			nDonazioniField.setBackground(Color.white);

		if (dataProssimaDonazioneField.getText().compareTo("") == 0
				|| dataProssimaDonazioneField.getText().compareTo("gg/mm/aaaa") == 0) {
			dataProssimaDonazioneField.setBackground(Color.RED);
			allOk = false;
		} else
			dataProssimaDonazioneField.setBackground(Color.white);

		if (statoNascitaField.getText().compareTo("") == 0) {
			statoNascitaField.setBackground(Color.RED);
			allOk = false;
		} else
			statoNascitaField.setBackground(Color.white);

		if (cittadinanzaField.getText().compareTo("") == 0) {
			cittadinanzaField.setBackground(Color.RED);
			allOk = false;
		} else
			cittadinanzaField.setBackground(Color.white);

		if (allOk) {
			String donatore = "***DONATORE*** - NOME: " + nomeField.getText()
					+ " - COGNOME: " + cognomeField.getText() + " - SESSO: "
					+ (sessoBox.getSelectedItem()).toString()
					+ " - DATA NASCITA: " + dataNascitaField.getText()
					+ " - STATO NASCITA: " + statoNascitaField.getText()
					+ " - CODICE FISCALE: " + codiceFiscaleField.getText()
					+ " - INDIRIZZO: " + viaField.getText() + " - CAP: "
					+ capField.getText() + " - COMUNE: "
					+ comuneField.getText();

			if (!(statoField.getText().compareTo("") == 0))
				donatore += " - STATO: " + statoField.getText();

			if (!(telefonoField.getText().compareTo("") == 0))
				donatore += " - TELEFONO FISSO: " + telefonoField.getText();

			if (!(cellulareField.getText().compareTo("") == 0))
				donatore += " - TELEFONO CELLULARE: "
						+ cellulareField.getText();

			if (!(emailField.getText().compareTo("") == 0))
				donatore += " - EMAIL: " + emailField.getText();

			donatore += " - CITTADINANZA: " + cittadinanzaField.getText()
					+ " - GRUPPO SANGUIGNO:" +  (gruppoSanguignoBox.getSelectedItem()).toString()
					+ " - RH: " + (rhBox.getSelectedItem()).toString()
					+ " - DATA ISCRIZIONE: " + dataIscrizioneField.getText()
					+ " - GRUPPO LOCALE: "
					+ (gruppoLocaleBox.getSelectedItem()).toString()
					+ " - TESSERA GRUPPO LOCALE: " + nTesseraField.getText()
					+ " - NUMERO DI DONAZIONI: " + nDonazioniField.getText()
					+ " - IDONEO: " + (idoneoBox.getSelectedItem()).toString()
					+ " - PROSSIMA DATA DISPONIBILE PER DONAZIONE: "
					+ dataProssimaDonazioneField.getText()
					+ " - TIPOLOGIA DONATORE: "
					+ (tipoDonatoreBox.getSelectedItem()).toString()
					+ " - SEZIONE: "
					+ (sezioneBox.getSelectedItem()).toString() + " ;.";
			
			System.out.println(donatore);

			InputStream is = new ByteArrayInputStream(donatore.getBytes());
			fatherFrame.useParser(is);
			setVisible(false);
			clean();
			fatherFrame.gruppoButton.setEnabled(true);
			fatherFrame.donazioneButton.setEnabled(true);
			fatherFrame.scadenzaButton.setEnabled(true);
		}

	}

	protected void clean() {
		nomeField.setText("");
		cognomeField.setText("");
		dataNascitaField.setText("gg/mm/aaaa");
		codiceFiscaleField.setText("");
		viaField.setText("");
		capField.setText("");
		comuneField.setText("");
		statoField.setText("");
		telefonoField.setText("");
		cellulareField.setText("");
		emailField.setText("");
		dataIscrizioneField.setText("gg/mm/aaaa");
		nTesseraField.setText("");
		nDonazioniField.setText("");
		dataProssimaDonazioneField.setText("gg/mm/aaaa");
		statoNascitaField.setText("");
		cittadinanzaField.setText("");
		nomeField.setBackground(Color.white);
		cognomeField.setBackground(Color.white);
		dataNascitaField.setBackground(Color.white);
		codiceFiscaleField.setBackground(Color.white);
		viaField.setBackground(Color.white);
		capField.setBackground(Color.white);
		comuneField.setBackground(Color.white);
		dataIscrizioneField.setBackground(Color.white);
		nTesseraField.setBackground(Color.white);
		nDonazioniField.setBackground(Color.white);
		dataProssimaDonazioneField.setBackground(Color.white);
		statoNascitaField.setBackground(Color.white);
		cittadinanzaField.setBackground(Color.white);

	}
}
