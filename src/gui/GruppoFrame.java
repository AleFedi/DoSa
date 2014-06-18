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
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import parser.DoSaParser;
import parser.syntaxtree.Scope;
import parser.visitor.DataBaseVisitor;
import parser.visitor.DepthFirstVoidVisitor;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class GruppoFrame extends JInternalFrame {

	JTextField nomeGruppoField;
	JTextField numeroGruppoField;
	JTextField dataFondazioneField;
	JTextField viaField;
	JTextField capField;
	JTextField comuneField;
	JTextField statoField;
	JTextField emailField;
	JTextField nomePresidenteField;
	JTextField cognomePresidenteField;
	JTextField nomeSegretarioField;
	JTextField cognomeSegretarioField;
	JTextField numeroIscrittiField;
	JButton okButton;
	JButton addSezione;
	String sezioni;
	SezioneFrame sezioneFrame;
	Boolean sezioniBoolean;
	MainFrame fatherFrame;

	public GruppoFrame(MainFrame mainFrame) {
		fatherFrame = mainFrame;
		sezioni = "";
		sezioniBoolean = false;

		setTitle("Gruppo Donatori");
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

		nomeGruppoField = new JTextField();
		builder.append("Nome Gruppo:", nomeGruppoField);
		builder.nextLine();

		numeroGruppoField = new JTextField();
		builder.append("Numero Gruppo:", numeroGruppoField);
		builder.nextLine();

		dataFondazioneField = new JTextField("gg/mm/aaaa");
		dataFondazioneField.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {

			}

			public void focusGained(FocusEvent e) {
				dataFondazioneField.selectAll();

			}
		});
		builder.append("Data Fondazione:", dataFondazioneField);
		builder.nextLine();

		builder.appendSeparator("Indirizzo Sede");

		viaField = new JTextField();
		builder.append("Via:", viaField);

		capField = new JTextField();
		builder.append("CAP", capField);
		builder.nextLine();

		comuneField = new JTextField();
		builder.append("Comune:", comuneField);

		statoField = new JTextField();
		builder.append("Stato:", statoField);
		builder.nextLine();

		builder.appendSeparator("Presidente");
		nomePresidenteField = new JTextField();
		builder.append("Nome:", nomePresidenteField);
		cognomePresidenteField = new JTextField();
		builder.append("Cognome:", cognomePresidenteField);

		builder.appendSeparator("Segretario");
		nomeSegretarioField = new JTextField();
		builder.append("Nome:", nomeSegretarioField);
		cognomeSegretarioField = new JTextField();
		builder.append("Cognome:", cognomeSegretarioField);

		builder.appendSeparator("");

		emailField = new JTextField();
		builder.append("Email:", emailField);
		builder.nextLine();

		numeroIscrittiField = new JTextField();
		builder.append("Numero Iscritti:", numeroIscrittiField);
		builder.nextLine();

		add(builder.getPanel(), BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		addSezione = new JButton("Aggiungi Sezione");
		addSezione.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sezioneClicked();

			}
		});

		buttonPanel.add(addSezione);

		okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				okClicked();

			}
		});

		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();

	}

	protected void okClicked() {
		boolean allOk = true;
		if (nomeGruppoField.getText().compareTo("") == 0) {
			nomeGruppoField.setBackground(Color.RED);
			allOk = false;
		} else
			nomeGruppoField.setBackground(Color.white);

		if (numeroGruppoField.getText().compareTo("") == 0) {
			numeroGruppoField.setBackground(Color.red);
			allOk = false;
		} else
			numeroGruppoField.setBackground(Color.white);

		if (viaField.getText().compareTo("") == 0) {
			viaField.setBackground(Color.red);
			allOk = false;
		} else
			viaField.setBackground(Color.white);

		if (capField.getText().compareTo("") == 0) {
			capField.setBackground(Color.red);
			allOk = false;

		} else
			capField.setBackground(Color.white);

		if (comuneField.getText().compareTo("") == 0) {
			comuneField.setBackground(Color.red);
			allOk = false;
		} else
			comuneField.setBackground(Color.white);

		if (dataFondazioneField.getText().compareTo("") == 0
				|| dataFondazioneField.getText().compareTo("gg/mm/aaaa") == 0) {
			dataFondazioneField.setBackground(Color.red);
			allOk = false;
		} else
			dataFondazioneField.setBackground(Color.white);

		if (emailField.getText().compareTo("") == 0) {
			emailField.setBackground(Color.red);
			allOk = false;
		} else
			emailField.setBackground(Color.white);

		if (nomePresidenteField.getText().compareTo("") == 0) {
			nomePresidenteField.setBackground(Color.red);
			allOk = false;
		} else
			nomePresidenteField.setBackground(Color.white);

		if (cognomePresidenteField.getText().compareTo("") == 0) {
			cognomePresidenteField.setBackground(Color.red);
			allOk = false;
		} else
			cognomePresidenteField.setBackground(Color.white);

		if (nomeSegretarioField.getText().compareTo("") == 0) {
			nomeSegretarioField.setBackground(Color.red);
			allOk = false;
		} else
			nomeSegretarioField.setBackground(Color.white);

		if (cognomeSegretarioField.getText().compareTo("") == 0) {
			cognomeSegretarioField.setBackground(Color.red);
			allOk = false;
		} else
			cognomeSegretarioField.setBackground(Color.white);

		if (numeroIscrittiField.getText().compareTo("") == 0) {
			numeroIscrittiField.setBackground(Color.red);
			allOk = false;
		} else
			numeroIscrittiField.setBackground(Color.white);

		if (allOk) {

			String gruppo = "***GRUPPO DONATORI*** - NOME: "
					+ nomeGruppoField.getText() + " - NUMERO: "
					+ numeroGruppoField.getText() + " - DATA FONDAZIONE: "
					+ dataFondazioneField.getText() + " - INDIRIZZO: "
					+ viaField.getText() + " - CAP: " + capField.getText()
					+ " - COMUNE: " + comuneField.getText();

			if (!(statoField.getText().compareTo("") == 0))
				gruppo += "- STATO: " + statoField.getText();

			gruppo += " - EMAIL: " + emailField.getText()
					+ " - PRESIDENTE: Nome: " + nomePresidenteField.getText()
					+ " - Cognome: " + cognomePresidenteField.getText()
					+ " - SEGRETARIO: Nome: " + nomeSegretarioField.getText()
					+ " - Cognome: " + cognomeSegretarioField.getText()
					+ " - NUMERO ISCRITTI: " + numeroIscrittiField.getText();

			if (sezioniBoolean)
				gruppo += " - SEZIONE: " + sezioni;

			gruppo += ";.";

			InputStream is = new ByteArrayInputStream(gruppo.getBytes());
			fatherFrame.useParser(is);
			clean();
			setVisible(false);
			fatherFrame.donatoreButton.setEnabled(true);
			fatherFrame.donazioneButton.setEnabled(true);
			fatherFrame.scadenzaButton.setEnabled(true);
		}

	}

	protected void clean() {
		sezioni = "";
		sezioniBoolean = false;
		nomeGruppoField.setText("");
		numeroGruppoField.setText("");
		dataFondazioneField.setText("gg/mm/aaaa");
		viaField.setText("");
		capField.setText("");
		comuneField.setText("");
		statoField.setText("");
		emailField.setText("");
		nomePresidenteField.setText("");
		cognomePresidenteField.setText("");
		nomeSegretarioField.setText("");
		cognomeSegretarioField.setText("");
		numeroIscrittiField.setText("");
		nomeGruppoField.setBackground(Color.white);
		numeroGruppoField.setBackground(Color.white);
		viaField.setBackground(Color.white);
		capField.setBackground(Color.white);
		comuneField.setBackground(Color.white);
		dataFondazioneField.setBackground(Color.white);
		emailField.setBackground(Color.white);
		nomePresidenteField.setBackground(Color.white);
		cognomePresidenteField.setBackground(Color.white);
		nomeSegretarioField.setBackground(Color.white);
		cognomeSegretarioField.setBackground(Color.white);
		numeroIscrittiField.setBackground(Color.white);

	}

	protected void sezioneClicked() {
		if (sezioneFrame == null) {
			sezioneFrame = new SezioneFrame(this);
			sezioneFrame.setVisible(true);
			return;

		}
		if (!sezioneFrame.isShowing()) {
			sezioneFrame.setVisible(true);
		} else
			sezioneFrame.setVisible(false);
		this.validate();
	}

	public void addSezione(String nomeSezione, String numeroSezione) {
		if (sezioni.compareTo("") == 0)
			sezioni += nomeSezione + " " + numeroSezione;
		else
			sezioni += " - " + nomeSezione + " " + numeroSezione;
		sezioniBoolean = true;

	}

}
