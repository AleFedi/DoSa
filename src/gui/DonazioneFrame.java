package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class DonazioneFrame extends JInternalFrame {

	JTextField nomeDonatoreField;
	JTextField cognomeDonatoreField;
	JTextField dataDonazioneField;
	JTextField cfDonatoreField;
	JTextField comuneField;
	JTextField aslField;
	JTextField puntoPrelievoField;
	JComboBox tipoDonazioneBox;
	JComboBox unitaRaccoltaBox;
	JButton addDonazione;
	String sezioni;
	MainFrame fatherFrame;

	public DonazioneFrame(MainFrame mainFrame) {
		fatherFrame = mainFrame;
		sezioni = "";
		setTitle("Aggiungi Donazione");
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

		builder.appendSeparator("Dati Donatore");
		nomeDonatoreField = new JTextField();
		builder.append("Nome Donatore:", nomeDonatoreField);

		cognomeDonatoreField = new JTextField();
		builder.append("Cognome Donatore:", cognomeDonatoreField);
		builder.nextLine();

		cfDonatoreField = new JTextField();
		builder.append("Codice Fiscale:", cfDonatoreField);
		builder.nextLine();

		builder.appendSeparator("");

		dataDonazioneField = new JTextField("gg/mm/aaaa");
		dataDonazioneField.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				dataDonazioneField.selectAll();

			}
		});
		builder.append("Data Donazione:", dataDonazioneField);

		builder.nextLine();

		String[] tipoDonazioni = { "Multicomponent", "Plasmaferesi",
				"Piastrinoaferesi", "Sangue Intero" };
		tipoDonazioneBox = new JComboBox(tipoDonazioni);
		builder.append("Tipo donazione:", tipoDonazioneBox);

		String[] unitaRaccola = { "Unità Raccolta Fissa" };
		unitaRaccoltaBox = new JComboBox(unitaRaccola);
		builder.append("Unità raccolta:", unitaRaccoltaBox);

		builder.nextLine();

		comuneField = new JTextField();
		builder.append("Comune Donazione:", comuneField);

		aslField = new JTextField();
		builder.append("Asl donazione:", aslField);

		builder.nextLine();

		puntoPrelievoField = new JTextField();
		builder.append("Punto Prelievo:", puntoPrelievoField);

		builder.nextLine();

		add(builder.getPanel(), BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		addDonazione = new JButton("Aggiungi Donazione");
		addDonazione.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addDonazioneClicked();

			}
		});

		buttonPanel.add(addDonazione);

		add(buttonPanel, BorderLayout.SOUTH);
		pack();

	}

	protected void addDonazioneClicked() {
		boolean allOk = true;
		if ((nomeDonatoreField.getText().compareTo("") == 0 && cognomeDonatoreField
				.getText().compareTo("") == 0)) {
			if((cfDonatoreField.getText().compareTo("") == 0)){
				nomeDonatoreField.setBackground(Color.RED);
				cognomeDonatoreField.setBackground(Color.red);
				cfDonatoreField.setBackground(Color.red);
				allOk = false;
			}
		} else {

			nomeDonatoreField.setBackground(Color.white);
			cfDonatoreField.setBackground(Color.white);
			cognomeDonatoreField.setBackground(Color.white);
		}

		if (comuneField.getText().compareTo("") == 0) {
			comuneField.setBackground(Color.red);
			allOk = false;
		} else
			comuneField.setBackground(Color.white);

		if (dataDonazioneField.getText().compareTo("") == 0
				|| dataDonazioneField.getText().compareTo("gg/mm/aaaa") == 0) {
			dataDonazioneField.setBackground(Color.red);
			allOk = false;
		} else
			dataDonazioneField.setBackground(Color.white);

		if (aslField.getText().compareTo("") == 0) {
			aslField.setBackground(Color.red);
			allOk = false;
		} else
			aslField.setBackground(Color.white);

		if (puntoPrelievoField.getText().compareTo("") == 0) {
			puntoPrelievoField.setBackground(Color.red);
			allOk = false;
		} else
			puntoPrelievoField.setBackground(Color.white);

		if (allOk) {

			String donazione = "***DONAZIONE*** - DONATORE: ";
			if (!(nomeDonatoreField.getText().compareTo("") == 0)
					&& !(cognomeDonatoreField.getText().compareTo("") == 0)) {
				donazione += "Nome:" + nomeDonatoreField.getText()
						+ "- Cognome:" + cognomeDonatoreField.getText();
			} else
				donazione += "- CODICE FISCALE:" + cfDonatoreField.getText();

			donazione += " - DATA DONAZIONE: " + dataDonazioneField.getText()
					+ " - TIPO DI DONAZIONE: "
					+ (tipoDonazioneBox.getSelectedItem()).toString()
					+ " - UNITA' RACCOLTA: "
					+ (unitaRaccoltaBox.getSelectedItem()).toString()
					+ " - COMUNE DONAZIONE: " + comuneField.getText()
					+ " - ASL DONAZIONE: " + aslField.getText()
					+ " - PUNTO PRELIEVO: " + puntoPrelievoField.getText()
					+ ";.";

			InputStream is = new ByteArrayInputStream(donazione.getBytes());
			fatherFrame.useParser(is);
			clean();
			setVisible(false);
			fatherFrame.donatoreButton.setEnabled(true);
			fatherFrame.gruppoButton.setEnabled(true);
			fatherFrame.scadenzaButton.setEnabled(true);
		}

	}

	protected void clean() {
		nomeDonatoreField.setText("");
		cognomeDonatoreField.setText("");
		dataDonazioneField.setText("gg/mm/aaaa");
		cfDonatoreField.setText("");
		comuneField.setText("");
		aslField.setText("");
		puntoPrelievoField.setText("");
		nomeDonatoreField.setBackground(Color.white);
		cognomeDonatoreField.setBackground(Color.white);
		cfDonatoreField.setBackground(Color.white);
		comuneField.setBackground(Color.white);
		dataDonazioneField.setBackground(Color.white);
		aslField.setBackground(Color.white);
		puntoPrelievoField.setBackground(Color.white);

	}

}
