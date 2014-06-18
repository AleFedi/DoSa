package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScadenzaFrame extends JInternalFrame {
	
	MainFrame fatherFrame;

	public ScadenzaFrame(MainFrame mainFrame) {
		
		setTitle("Donatori in scadenza");
		setDefaultCloseOperation(2);
		
		fatherFrame = mainFrame;
		
		int anno = new GregorianCalendar().get(GregorianCalendar.YEAR);
		int mese = new GregorianCalendar().get(GregorianCalendar.MONTH) + 1;
		String query = "SELECT nome,cognome,telefono,cellulare,email FROM donatori WHERE MONTH(prossimadatadonazione) = "
				+ mese + " AND YEAR(prossimadatadonazione) =" + anno + ";";
		ResultSet result = fatherFrame.query(query);
		
		JTextArea scadenzaArea = new JTextArea(15,60);
		JScrollPane scrollPane = new  JScrollPane(scadenzaArea);

		try {
			while (result.next()) {
				scadenzaArea.append("DONATORE: " + result.getString(1) + " "
						+ result.getString(2) + " TELEFONO: " + result.getString(3) + " CELLULARE: "
						+ result.getString(4) + " EMAIL: " + result.getString(5) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		add(scrollPane);
		pack();
		
	}

}
