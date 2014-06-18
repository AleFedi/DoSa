package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class SezioneFrame extends JFrame {

	JTextField nomeSezioneField;
	JTextField numeroSezioneField;
	GruppoFrame gruppoFrame;
	JPanel bottonPanel;
	JButton addButton;

	public SezioneFrame(final GruppoFrame gruppoFrame) {
		this.gruppoFrame = gruppoFrame;

		setTitle("Sezione");
		setDefaultCloseOperation(2);
		setBounds(200, 200, 230, 130);

		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("center:pref");
		builder.appendColumn("3dlu");
		builder.appendColumn("fill:max(pref; 100px)");

		nomeSezioneField = new JTextField();
		builder.append("Nome Gruppo:", nomeSezioneField);
		builder.nextLine();

		numeroSezioneField = new JTextField();
		builder.append("Numero Gruppo:", numeroSezioneField);

		add(builder.getPanel(), BorderLayout.CENTER);

		addButton = new JButton("Aggiungi Sezione");
		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (nomeSezioneField.getText().compareTo("") == 1
						|| numeroSezioneField.getText().compareTo("") == 1) {
					gruppoFrame.addSezione(nomeSezioneField.getText(),
							numeroSezioneField.getText());
				}
				clean();
				setVisible(false);

			}
		});

		bottonPanel = new JPanel();
		bottonPanel.add(addButton);
		add(bottonPanel, BorderLayout.SOUTH);

	}

	protected void clean() {
		nomeSezioneField.setText("");
		numeroSezioneField.setText("");
		return;

	}

}
