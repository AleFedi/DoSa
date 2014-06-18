package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hsqldb.server.Server;

import parser.DoSaParser;
import parser.syntaxtree.Scope;
import parser.visitor.DataBaseVisitor;
import parser.visitor.DepthFirstVoidVisitor;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

public class MainFrame extends JFrame {

	JTextField textField;
	JTextField esitoField;
	JPanel buttonPanel;
	JPanel textPanel;
	JButton gruppoButton;
	JButton donatoreButton;
	JButton donazioneButton;
	JButton scadenzaButton;
	Server hsqlServer;
	JDesktopPane desktopPane;
	GruppoFrame gruppoFrame;
	DonatoreFrame donatoreFrame;
	DonazioneFrame donazioneFrame;
	ScadenzaFrame scadenzaFrame;
	DoSaParser parser;
	boolean parserIsInstantiate;
	Connection connection;

	public MainFrame() {

		hsqlServer = new Server();
		hsqlServer
				.setDatabasePath(0,
						"file:C:/Users/Alessandro/Università/hsqldb-2.3.2/hsqldb/folderdb/db");
		hsqlServer.setDatabaseName(0, "donatoridb");
		hsqlServer.start();
		try {
			connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/donatoridb", "sa", "");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		parserIsInstantiate = false;
		setSize(700, 700);
		setTitle("DoSa: Donatori di Sangue");

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 153, 204));

		add(desktopPane, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
				new Color(0, 0, 0)));

		GridBagLayout buttonPanelLayout = new GridBagLayout();
		buttonPanelLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				1.0 };
		buttonPanelLayout.columnWidths = new int[] { 55, 55, 55, 55, 7 };
		buttonPanelLayout.rowWeights = new double[] { 1, 1 };
		buttonPanelLayout.rowHeights = new int[] { 1, 1 };
		buttonPanel.setLayout(buttonPanelLayout);

		add(buttonPanel, BorderLayout.NORTH);

		gruppoButton = new JButton();
		gruppoButton.setPreferredSize(new Dimension(50, 50));
		gruppoButton.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/gruppo.png")));
		gruppoButton.setBorderPainted(false);
		gruppoButton.setToolTipText("Crea un nuovo gruppo");
		gruppoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gruppoClicked();

			}
		});

		buttonPanel.add(gruppoButton);

		donatoreButton = new JButton();
		donatoreButton.setPreferredSize(new Dimension(50, 50));
		donatoreButton.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/donatore.png")));
		donatoreButton.setBorderPainted(false);
		donatoreButton.setToolTipText("Aggiungi un nuovo donatore");
		donatoreButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				donatoreClicked();

			}
		});

		buttonPanel.add(donatoreButton);

		donazioneButton = new JButton();
		donazioneButton.setPreferredSize(new Dimension(50, 50));
		donazioneButton.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/donazione.png")));
		donazioneButton.setBorderPainted(false);
		donazioneButton.setToolTipText("Aggiungi una nuova donazione");
		donazioneButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				donazioneClicked();

			}
		});

		buttonPanel.add(donazioneButton);

		scadenzaButton = new JButton();
		scadenzaButton.setPreferredSize(new Dimension(50, 50));
		scadenzaButton.setIcon(new ImageIcon(getClass().getClassLoader()
				.getResource("img/scadenza.png")));
		scadenzaButton.setBorderPainted(false);
		scadenzaButton.setToolTipText("Donatori in scadenza questo mese");
		scadenzaButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				scadenzaClicked();

			}
		});

		buttonPanel.add(scadenzaButton);

		textPanel = new JPanel();

		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(""));
		builder.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		builder.appendColumn("right:pref");
		builder.appendColumn("5dlu");
		builder.appendColumn("fill:max(pref; 480px)");
		builder.appendColumn("5dlu");
		builder.appendColumn("right:pref");

		builder.appendSeparator("Parser diretto");

		textField = new JTextField("");
		builder.append("Frase", textField);

		JButton analyzeButton = new JButton("analizza");
		analyzeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				analyzeClicked();

			}
		});

		builder.append(analyzeButton);

		esitoField = new JTextField();
		builder.append("Risultato Parser", esitoField);

		textPanel.add(builder.getPanel());

		add(textPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				hsqlServer.stop();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	protected void closed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hsqlServer.stop();

	}

	protected void scadenzaClicked() {
		if (scadenzaFrame == null) {
			scadenzaFrame = new ScadenzaFrame(this);
			gruppoButton.setEnabled(false);
			donatoreButton.setEnabled(false);
			donazioneButton.setEnabled(false);
			desktopPane.add(scadenzaFrame);
			try {
				scadenzaFrame.setSelected(true);
				scadenzaFrame.setVisible(true);
				return;
			} catch (PropertyVetoException e) {

			}

		}
		if (!scadenzaFrame.isShowing()) {
			scadenzaFrame.setVisible(true);
			gruppoButton.setEnabled(false);
			donatoreButton.setEnabled(false);
			donazioneButton.setEnabled(false);
		} else {
			scadenzaFrame.setVisible(false);
			gruppoButton.setEnabled(true);
			donatoreButton.setEnabled(true);
			donazioneButton.setEnabled(true);

		}
		this.validate();

	}

	protected void analyzeClicked() {

		InputStream is = new ByteArrayInputStream(
				(textField.getText()).getBytes());
		useParser(is);
		textField.setText("");

	}

	protected void gruppoClicked() {
		if (gruppoFrame == null) {
			gruppoFrame = new GruppoFrame(this);
			donatoreButton.setEnabled(false);
			donazioneButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
			desktopPane.add(gruppoFrame);
			try {
				gruppoFrame.setSelected(true);
				gruppoFrame.setVisible(true);
				return;
			} catch (PropertyVetoException e) {

			}

		}
		if (!gruppoFrame.isShowing()) {
			gruppoFrame.setVisible(true);
			donatoreButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
			donazioneButton.setEnabled(false);
		} else {
			gruppoFrame.setVisible(false);
			gruppoFrame.clean();
			donatoreButton.setEnabled(true);
			donazioneButton.setEnabled(true);
			scadenzaButton.setEnabled(true);

		}
		this.validate();
	}

	protected void donatoreClicked() {
		if (donatoreFrame == null) {
			donatoreFrame = new DonatoreFrame(this);
			gruppoButton.setEnabled(false);
			donazioneButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
			desktopPane.add(donatoreFrame);
			try {
				donatoreFrame.setSelected(true);
				donatoreFrame.setVisible(true);
				return;
			} catch (PropertyVetoException e) {

			}

		}
		if (!donatoreFrame.isShowing()) {
			donatoreFrame.setVisible(true);
			gruppoButton.setEnabled(false);
			donazioneButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
		} else {
			donatoreFrame.setVisible(false);
			donatoreFrame.clean();
			gruppoButton.setEnabled(true);
			donazioneButton.setEnabled(true);
			scadenzaButton.setEnabled(true);
		}
		this.validate();
	}

	protected void donazioneClicked() {
		if (donazioneFrame == null) {
			donazioneFrame = new DonazioneFrame(this);
			gruppoButton.setEnabled(false);
			donatoreButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
			desktopPane.add(donazioneFrame);
			try {
				donazioneFrame.setSelected(true);
				donazioneFrame.setVisible(true);
			} catch (PropertyVetoException e) {

			}
		}
		if (!donazioneFrame.isShowing()) {
			donazioneFrame.setVisible(true);
			gruppoButton.setEnabled(false);
			donatoreButton.setEnabled(false);
			scadenzaButton.setEnabled(false);
		} else {
			donazioneFrame.setVisible(false);
			donazioneFrame.clean();
			gruppoButton.setEnabled(true);
			scadenzaButton.setEnabled(true);
			donatoreButton.setEnabled(true);
		}
		this.validate();

	}

	public void useParser(InputStream is) {
		boolean goodFine = true;
		if (!parserIsInstantiate) {
			parser = new DoSaParser(is);
			parserIsInstantiate = true;
		} else
			parser.ReInit(is);

		try {
			Scope scope = parser.Scope();
			DepthFirstVoidVisitor v = new DataBaseVisitor();
			scope.accept(v);
		} catch (Exception e) {
			goodFine = false;
			esitoField.setBackground(Color.red);
			esitoField.setText("Errore");
			System.out.println(e.getMessage());
		}
		if (goodFine) {
			esitoField.setBackground(Color.green);
			esitoField.setText("Inserito correttamente");

		}

	}

	public ResultSet query(String query) {
		ResultSet result = null;
		try {
			result = connection.prepareStatement(query).executeQuery();
		} catch (SQLException e) {
			System.out.println("Errore nella query");
		}
		return result;
	}

}
