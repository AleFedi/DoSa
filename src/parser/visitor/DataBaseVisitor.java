package parser.visitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import parser.syntaxtree.CodiceFiscale;
import parser.syntaxtree.Cognome;
import parser.syntaxtree.Data;
import parser.syntaxtree.DataProssimaDonazione;
import parser.syntaxtree.DatiDonatore;
import parser.syntaxtree.Donatore;
import parser.syntaxtree.Donazione;
import parser.syntaxtree.EMail;
import parser.syntaxtree.Gruppo;
import parser.syntaxtree.INode;
import parser.syntaxtree.Idoneo;
import parser.syntaxtree.Indirizzo;
import parser.syntaxtree.NodeChoice;
import parser.syntaxtree.NodeList;
import parser.syntaxtree.NodeListOptional;
import parser.syntaxtree.NodeOptional;
import parser.syntaxtree.NodeOptionalTelefono;
import parser.syntaxtree.NodeSequence;
import parser.syntaxtree.NodeTCF;
import parser.syntaxtree.NodeTelefono;
import parser.syntaxtree.NodeToken;
import parser.syntaxtree.Nome;
import parser.syntaxtree.NumeroDonazioni;
import parser.syntaxtree.Scope;
import parser.syntaxtree.Sezione;
import parser.syntaxtree.Stato;
import parser.syntaxtree.Telefono;
import parser.syntaxtree.TipoDonatore;
import parser.syntaxtree.TipoDonazione;

public class DataBaseVisitor extends DepthFirstVoidVisitor {

	String insert;
	String value;
	String database;
	String data;
	String gruppo;
	Integer numeroGruppo;
	String nome;
	String cognome;
	String cf;
	String tipodonazione;
	boolean indirizzo;
	boolean codiceFiscale;
	boolean asl;
	Connection connection;
	int idDonatore;

	public DataBaseVisitor() {
		tipodonazione = "";
		insert = "";
		value = "";
		database = "";
		data = "";
		gruppo = "";
		nome = "";
		cognome = "";
		cf = "";
		indirizzo = false;
		asl = false;
		codiceFiscale = false;
		try {
			connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/donatoridb", "sa", "");
//			connection.prepareStatement("DELETE FROM donazioni").execute();
//			connection.prepareStatement("DELETE FROM donatori").execute();
//			connection.prepareStatement("DELETE FROM sezioni").execute();
//			connection.prepareStatement("DELETE FROM gruppi;").execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void visit(final NodeChoice n) {
		n.choice.accept(this);

		return;
	}

	public void visit(final NodeList n) {
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			e.next().accept(this);
		}
		return;
	}

	public void visit(final NodeListOptional n) {
		if (n.present()) {
			for (final Iterator<INode> e = n.elements(); e.hasNext();) {
				// INode node = e.next();
				// System.out.println(node.getClass().getName());
				// node.accept(this);
				e.next().accept(this);
			}
			return;
		} else
			return;
	}

	public void visit(final NodeOptional n) {
		if (n.present()) {
			n.node.accept(this);
			return;
		} else
			return;
	}

	public void visit(final NodeSequence n) {
		for (final Iterator<INode> e = n.elements(); e.hasNext();) {
			e.next().accept(this);
		}
		return;
	}

	public void visit(final NodeTCF n) {
		@SuppressWarnings("unused")
		final String tkIm = n.tokenImage;
		return;
	}

	public void visit(final NodeToken n) {
		final String tkIm = n.tokenImage;
		if (indirizzo == true) {
			value = value + " " + tkIm;
		}
		if (codiceFiscale == true) {
			cf = cf + tkIm;
			value = value + tkIm;
		}
		if (asl == true) {
			value = value + tkIm;
		}
		return;
	}

	public void visit(final Scope n) {
		// f0 -> ( %0 Gruppo()
		// .. .. | %1 Donatore()
		// .. .. | %2 Donazione() )*
		n.f0.accept(this);
		// f1 -> "."
		n.f1.accept(this);
	}

	public void visit(final Gruppo n) {
		// f0 -> "***GRUPPO DONATORI***"
		gruppo = "";
		insert = "";
		value = "";
		database = "gruppi";
		n.f0.accept(this);

		// f1 -> Nome()
		insert = insert + "nome,";
		n.f1.accept(this);

		// f2 -> "- NUMERO:"
		n.f2.accept(this);

		// f3 -> <NUM>
		insert = insert + "numero,";
		gruppo = n.f3 + "";
		value = value + n.f3 + ",";
		n.f3.accept(this);

		// f4 -> "- DATA FONDAZIONE:"
		n.f4.accept(this);

		// f5 -> Data()
		insert = insert + "datafondazione,";
		n.f5.accept(this);

		// f6 -> Indirizzo()
		n.f6.accept(this);

		// f7 -> EMail()
		n.f7.accept(this);

		// f8 -> "- PRESIDENTE:"
		n.f8.accept(this);

		// f9 -> Nome()
		insert = insert + "npresidente,";
		n.f9.accept(this);

		// f10 -> "-"
		n.f10.accept(this);

		// f11 -> Cognome()
		insert = insert + "cpresidente,";
		n.f11.accept(this);

		// f12 -> "- SEGRETARIO:"
		n.f12.accept(this);

		// f13 -> Nome()
		insert = insert + "nsegretario,";
		n.f13.accept(this);

		// f14 -> "-"
		n.f14.accept(this);

		// f15 -> Cognome()
		insert = insert + "csegretario,";
		n.f15.accept(this);

		// f16 -> "- NUMERO ISCRITTI:"
		n.f16.accept(this);

		// f17 -> <NUM>
		insert = insert + "niscritti";
		value = value + n.f17;
		n.f17.accept(this);

		// f18 -> [ #0 "- SEZIONE:" #1 Sezione()
		// ... .. . #2 ( $0 "-" $1 Sezione() )* ]
		n.f18.accept(this);

		// f19 -> ";"
		n.f19.accept(this);
		try {
			System.out.println("INSERT INTO " + database + " (" + insert
					+ " ) VALUES  ( " + value + " );");
			connection.prepareStatement(
					"INSERT INTO " + database + " (" + insert + " ) VALUES  ( "
							+ value + " );").execute();
		} catch (SQLException e) {
			System.out.println("Errore nell'insert");
			e.printStackTrace();
		}
	}

	public void visit(final Donatore n) {
		insert = "";
		value = "";
		database = "donatori";

		// f0 -> "***DONATORE***"
		n.f0.accept(this);

		insert = insert + "nome,";
		// f1 -> Nome()
		n.f1.accept(this);

		insert = insert + "cognome,";
		// f2 -> Cognome()
		n.f2.accept(this);

		// f3 -> "- SESSO:"
		n.f3.accept(this);

		// f4 -> <SESSO>
		insert += "sesso,";
		value += "'" + n.f4 + "',";
		n.f4.accept(this);

		// f5 -> "- DATA NASCITA:"
		n.f5.accept(this);

		// f6 -> Data()
		insert += "datanascita,";
		n.f6.accept(this);

		// f7 -> "- STATO NASCITA:"
		n.f7.accept(this);

		// f8 -> <IDENTIFICATOR>
		insert += "statonascita,";
		value += "'" + n.f8 + "',";
		n.f8.accept(this);

		// f9 -> CodiceFiscale()
		insert += "codicefiscale,";
		n.f9.accept(this);

		// f10 -> Indirizzo()
		n.f10.accept(this);

		// f11 -> [ #0 "- TELEFONO FISSO:" #1 Telefono() ]
		n.f11.accept(this);

		// f12 -> [ #0 "- TELEFONO CELLULARE:" #1 Telefono() ]
		n.f12.accept(this);

		// f13 -> [ EMail() ]
		n.f13.accept(this);

		// f14 -> "- CITTADINANZA:"
		n.f14.accept(this);

		// f15 -> <IDENTIFICATOR>
		insert += "cittadinanza,";
		value += "'" + n.f15 + "',";
		n.f15.accept(this);

		// f16 -> "- GRUPPO SANGUIGNO:"
		n.f16.accept(this);

		// f17 -> <GRUPPOSANGUIGNO>
		insert += "grupposanguigno,";
		value += "'" + n.f17 + "',";
		n.f17.accept(this);

		// f18 -> "- RH:"
		n.f18.accept(this);

		// f19 -> <RH>
		insert += "rh,";
		value += "'" + n.f19 + "',";
		n.f19.accept(this);

		// f20 -> "- DATA ISCRIZIONE:"
		n.f20.accept(this);

		// f21 -> Data()
		insert += "dataiscrizione,";
		n.f21.accept(this);

		// f22 -> "- GRUPPO LOCALE:"
		n.f22.accept(this);

		// f23 -> <NUM>
		insert += "gruppo,";
		numeroGruppo = Integer.parseInt(n.f23.toString());
		value += n.f23 + ",";
		n.f23.accept(this);

		// f24 -> "- TESSERA GRUPPO LOCALE:"
		n.f24.accept(this);

		// f25 -> <NUM>
		insert += "tesseragruppo,";
		value += n.f25 + ",";
		n.f25.accept(this);

		// f26 -> NumeroDonazioni()
		n.f26.accept(this);

		// f27 -> Idoneo()
		n.f27.accept(this);

		// f28 -> DataProssimaDonazione()
		insert += "prossimadatadonazione,";
		n.f28.accept(this);

		// f29 -> TipoDonatore()
		insert += "tipodonatore,";
		n.f29.accept(this);

		// f30 -> "- SEZIONE:"
		n.f30.accept(this);

		// f31 -> Sezione()
		n.f31.accept(this);

		// f32 -> ";"
		n.f32.accept(this);
		try {
			System.out.println("INSERT INTO " + database + " (" + insert
					+ " ) VALUES  ( " + value + " );");
			connection.prepareStatement(
					"INSERT INTO " + database + " (" + insert + " ) VALUES  ( "
							+ value + " );").execute();
		} catch (SQLException e) {
			System.out.println("Errore nell'insert");
			e.printStackTrace();
		}
	}

	public void visit(final Donazione n) {
		nome = "";
		cognome = "";
		cf = "";
		insert = "";
		value = "";

		database = "donazioni";

		// f0 -> "***DONAZIONE***"
		n.f0.accept(this);

		// f1 -> DatiDonatore()
		n.f1.accept(this);

		insert += "donatore,";
		value += idDonatore + ",";

		// f2 -> "- DATA DONAZIONE:"
		n.f2.accept(this);

		// f3 -> Data()
		insert += "datadonazione,";
		n.f3.accept(this);

		// f4 -> TipoDonazione()
		n.f4.accept(this);

		// f5 -> "- UNITA' RACCOLTA:"
		n.f5.accept(this);

		// f6 -> <UNITARACCOLTA>
		insert += "unitaraccolta,";
		value += "'" + n.f6 + "',";
		n.f6.accept(this);

		// f7 -> "- COMUNE DONAZIONE:"
		n.f7.accept(this);

		// f8 -> <IDENTIFICATOR>
		insert += "comunedonazione,";
		value += "'" + n.f8 + "',";
		n.f8.accept(this);

		// f9 -> "- ASL DONAZIONE:"
		n.f9.accept(this);

		// f10 -> ( %0 <IDENTIFICATOR>
		// ... .. | %1 <NUM> )*
		insert += "asl,";

		value += "'";
		asl = true;
		n.f10.accept(this);
		asl = false;
		value += "',";

		// f11 -> "- PUNTO PRELIEVO:"
		n.f11.accept(this);

		// f12 -> <NUM>
		insert += "puntoprelievo";
		value += n.f12;
		n.f12.accept(this);

		// f13 -> ";"
		n.f13.accept(this);
		try {
			System.out.println("INSERT INTO " + database + " (" + insert
					+ " ) VALUES  ( " + value + " );");
			connection.prepareStatement(
					"INSERT INTO " + database + " (" + insert + " ) VALUES  ( "
							+ value + " );").execute();

		} catch (SQLException e) {
			System.out.println("Errore nell'insert");
			e.printStackTrace();
		}
		updateValue();
	}

	public void visit(final Indirizzo n) {
		// f0 -> "- INDIRIZZO:"
		insert = insert + "indirizzo,";
		value = value + "'";
		n.f0.accept(this);

		// f1 -> <IDENTIFICATOR>
		value = value + n.f1;
		n.f1.accept(this);

		indirizzo = true;
		// f2 -> ( %0 <IDENTIFICATOR>
		// .. .. | %1 <NUM> )*
		n.f2.accept(this);
		indirizzo = false;
		value = value + "'" + ",";

		// f3 -> "- CAP:"
		n.f3.accept(this);

		// f4 -> <NUM>
		insert = insert + "cap,";
		value = value + n.f4 + ",";
		n.f4.accept(this);

		// f5 -> "- COMUNE:"
		n.f5.accept(this);

		// f6 -> <IDENTIFICATOR>
		insert = insert + "comune,";
		value = value + "'" + n.f6 + "'" + ",";
		n.f6.accept(this);

		// f7 -> [ #0 "- STATO:" #1 <IDENTIFICATOR> ]
		n.f7.accept(this);
	}

	public void visit(final Sezione n) {
		if (database == "gruppi") {
			// System.out
			// .println("INSERT INTO sezioni (gruppo,nome,numero) VALUES ("
			// + gruppo + ",'" + n.f0 + "'," + n.f1 + ");");
			try {
				System.out
						.println("INSERT INTO sezioni (gruppo,nome,numero) VALUES ("
								+ gruppo + ",'" + n.f0 + "'," + n.f1 + ");");
				connection.prepareStatement(
						"INSERT INTO sezioni (gruppo,nome,numero) VALUES ("
								+ gruppo + ",'" + n.f0 + "'," + n.f1 + ");")
						.execute();
			} catch (SQLException e) {
				System.out.println("Errore nell'inserimento della sezione");
			}
		} else if (database == "donatori") {
			// System.out.println("SELECT id FROM sezioni WHERE (gruppo="
			// + numeroGruppo + ") " + "AND (nome = '" + n.f0 + "') "
			// + "AND (numero=" + n.f1 + ");");
			try {
				ResultSet id = connection.prepareStatement(
						"SELECT id FROM sezioni WHERE (gruppo=" + numeroGruppo
								+ ") " + "AND (nome = '" + n.f0 + "') "
								+ "AND (numero=" + n.f1 + ");").executeQuery();
				insert += "idsezione";
				id.next();
				// System.out.println("Id: " + id.getInt(1));
				value += id.getInt(1);

			} catch (SQLException e) {
				System.out
						.println("Errore nella query di ricerca della sezione");
			}
		}
		// f0 -> <IDENTIFICATOR>
		n.f0.accept(this);
		// f1 -> <NUM>
		n.f1.accept(this);
	}

	public void visit(final CodiceFiscale n) {
		// f0 -> "- CODICE FISCALE:"
		n.f0.accept(this);
		value += "'";
		codiceFiscale = true;
		// f1 -> ( %0 <IDENTIFICATOR>
		// .. .. | %1 <NUM> )*
		n.f1.accept(this);
		codiceFiscale = false;
		value += "',";
	}

	public void visit(final EMail n) {
		// f0 -> "- EMAIL:"
		n.f0.accept(this);

		// f1 -> <EMAIL>
		insert = insert + "email,";
		value = value + "'" + n.f1 + "'" + ",";
		n.f1.accept(this);
	}

	public void visit(final Idoneo n) {
		// f0 -> "- IDONEO:"
		n.f0.accept(this);

		// f1 -> <IDONEITA>
		insert += "idoneo,";
		value += "'" + n.f1 + "',";
		n.f1.accept(this);
	}

	public void visit(final DataProssimaDonazione n) {
		// f0 -> "- PROSSIMA DATA DISPONIBILE PER DONAZIONE:"
		n.f0.accept(this);
		// f1 -> Data()
		n.f1.accept(this);
	}

	public void visit(final TipoDonatore n) {
		// f0 -> "- TIPOLOGIA DONATORE:"
		n.f0.accept(this);
		// f1 -> <TIPO>
		value += "'" + n.f1 + "',";
		n.f1.accept(this);
	}

	public void visit(final TipoDonazione n) {
		tipodonazione = "";
		// f0 -> "- TIPO DI DONAZIONE:"
		n.f0.accept(this);

		// f1 -> <TIPODONAZIONE>
		insert += "tipodonazione,";
		tipodonazione = n.f1.toString();
		value += "'" + n.f1 + "',";
		n.f1.accept(this);
	}

	public void visit(final DatiDonatore n) {
		// f0 -> "- DONATORE:"
		n.f0.accept(this);
		// f1 -> ( %0 #0 Nome() #1 "-" #2 Cognome()
		// .. .. | %1 CodiceFiscale() )
		insert += n.f1.getInsert();
		n.f1.accept(this);

		try {
			ResultSet id = null;
			if (n.f1.getScelta() == "nomecognome") {
				id = connection.prepareStatement(
						"SELECT id FROM donatori WHERE (nome='" + nome + "') "
								+ "AND (cognome = '" + cognome + "');")
						.executeQuery();

			}
			if (n.f1.getScelta() == "codicefiscale") {
				id = connection.prepareStatement(
						"SELECT id FROM donatori WHERE (codicefiscale='" + cf
								+ "');").executeQuery();

			}
			id.next();
			idDonatore = id.getInt(1);
		} catch (SQLException e) {
			System.out.println("Donatore non trovato");
			e.printStackTrace();
		}
	}

	public void visit(final NumeroDonazioni n) {
		// f0 -> "- NUMERO DI DONAZIONI:"
		n.f0.accept(this);

		// f1 -> <NUM>
		insert += "numerodonazioni,";
		value += n.f1 + ",";
		n.f1.accept(this);
	}

	public void visit(final Stato n) {
		if (n.present()) {
			insert = insert + "stato,";
			value = value + "'" + n.f1 + "',";
			n.f0.accept(this);
			n.f1.accept(this);
			return;
		} else
			return;
	}

	public void visit(final NodeTelefono n) {
		if (n.present()) {
			if (n.f0.toString().equals("- TELEFONO FISSO:"))
				insert += "telefono,";
			if (n.f0.toString().equals("- TELEFONO CELLULARE:"))
				insert += "cellulare,";
			n.f0.accept(this);
			n.f1.accept(this);
			return;
		} else
			return;

	}

	public void visit(final Telefono n) {
		// f0 -> <NUM>
		n.f0.accept(this);
		value += "'" + n.f0;
		if (n.f1.present() == false) {
			value += "',";

		}
		// f1 -> [ #0 "/" #1 <NUM> ]
		n.f1.accept(this);
	}

	public void visit(final NodeOptionalTelefono n) {
		if (n.present()) {
			value += n.f1 + "',";
			n.f0.accept(this);
			n.f1.accept(this);
			return;
		} else
			return;

	}

	public void visit(final Nome n) {

		// f0 -> ( %0 "Nome:"
		// .. .. | %1 "- NOME:" )
		n.f0.accept(this);
		// f1 -> <IDENTIFICATOR>
		nome = n.f1 + "";
		value = value + "'" + n.f1 + "'" + ",";
		n.f1.accept(this);
	}

	public void visit(final Cognome n) {
		// f0 -> ( %0 "Cognome:"
		// .. .. | %1 "- COGNOME:" )
		n.f0.accept(this);
		// f1 -> <IDENTIFICATOR>
		cognome = n.f1 + "";
		value = value + "'" + n.f1 + "'" + ",";
		n.f1.accept(this);
	}

	public void visit(final Data n) {
		// f0 -> <NUM>
		data = "";
		data = n.f0 + "";
		n.f0.accept(this);

		// f1 -> "/"
		n.f1.accept(this);

		// f2 -> <NUM>
		n.f2.accept(this);
		data = n.f2 + "-" + data;

		// f3 -> "/"
		n.f3.accept(this);

		// f4 -> <NUM>
		n.f4.accept(this);
		data = n.f4 + "-" + data;

		data = "'" + data + "'";
		value = value + data + ",";

	}

	private void updateValue() {
		try {
			ResultSet sesso;
			ResultSet dataProssimaDonazione;
			ResultSet numerodonazioni;
			ResultSet newDataProssimaDonazione;

			sesso = connection.prepareStatement(
					"SELECT sesso FROM donatori WHERE id=" + idDonatore + ";")
					.executeQuery();
			sesso.next();

			dataProssimaDonazione = connection.prepareStatement(
					"SELECT prossimadatadonazione FROM donatori WHERE id="
							+ idDonatore + ";").executeQuery();
			dataProssimaDonazione.next();

			numerodonazioni = connection.prepareStatement(
					"SELECT numerodonazioni FROM donatori WHERE id ="
							+ idDonatore + ";").executeQuery();
			numerodonazioni.next();

			connection.prepareStatement(
					"UPDATE donatori SET numerodonazioni = "
							+ ((numerodonazioni.getInt(1)) + 1) + "WHERE id="
							+ idDonatore + ";").execute();

			if (tipodonazione == "Sangue Intero") {
				if (sesso.getString(1).compareToIgnoreCase("m") == 0) {
					connection.prepareStatement(
							"UPDATE donatori SET prossimadatadonazione = DATEADD('month',3, DATE "
									+ data + ") WHERE id=" + idDonatore + " ;")
							.execute();

				} else if (sesso.getString(1).compareToIgnoreCase("f") == 0) {
					connection.prepareStatement(
							"UPDATE donatori SET prossimadatadonazione = DATEADD('month',6, DATE "
									+ data + ") WHERE id=" + idDonatore + " ;")
							.execute();
				}

			} else {
				if (sesso.getString(1).compareToIgnoreCase("m") == 0) {
					connection.prepareStatement(
							"UPDATE donatori SET prossimadatadonazione = DATEADD('month',1, DATE "
									+ data + ") WHERE id=" + idDonatore + " ;")
							.execute();

				} else if (sesso.getString(1).compareToIgnoreCase("f") == 0) {
					connection.prepareStatement(
							"UPDATE donatori SET prossimadatadonazione = DATEADD('month',3, DATE "
									+ data + ") WHERE id=" + idDonatore + " ;")
							.execute();
				}

				newDataProssimaDonazione = connection.prepareStatement(
						"SELECT prossimadatadonazione FROM donatori WHERE id="
								+ idDonatore + ";").executeQuery();
				newDataProssimaDonazione.next();
				if (dataProssimaDonazione.getDate(1).compareTo(
						newDataProssimaDonazione.getDate(1)) == 1) {
					System.out.println(dataProssimaDonazione.getDate(1) + "");
					connection.prepareStatement(
							"UPDATE donatori SET prossimadatadonazione = DATEADD('month',3, DATE '"
									+ dataProssimaDonazione.getDate(1) + "') WHERE id="
									+ idDonatore + " ;").execute();

				}

			}
		} catch (SQLException e) {
			System.out.println("Errore nell'update");
			e.printStackTrace();
		}

	}

}
