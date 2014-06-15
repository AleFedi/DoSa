package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hsqldb.server.Server;

public class ServerModeConnection {

	public static void main(String[] args) {
		// Server server = new Server();
		// server.setDatabasePath(0,
		// "file:C:/Users/Alessandro/Università/hsqldb-2.3.2/hsqldb/folderdb/db");
		// server.setDatabaseName(0, "donatoridb");
		// server.start();
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/donatoridb", "sa", "");
			 connection
			 .prepareStatement("INSERT INTO gruppi (nome,numero,datafondazione,indirizzo,cap,comune,email,npresidente,cpresidente,nsegretario,csegretario,niscritti ) VALUES  ( 'Frates Pistoia',240,'2014-10-12','Via le mani dal naso',51100,'Pistoia',fratres@misericordia.pistoia.it,'Sergio','Fedi','Alessandro','Fedi',2000 );")
			 .execute();
			// connection
			// .prepareStatement(
			// "INSERT INTO sezioni (gruppo, nome) VALUES (215, 'PISTOIA 1');")
			// .execute();
			// connection
			// .prepareStatement(
			// "INSERT INTO sezioni (gruppo, nome) VALUES (215, 'QUARRATA 5');")
			// .execute();
			// connection
			// .prepareStatement(
			// "INSERT INTO donatore (sesso,nome,datanascita,statonascita,codicefiscale,indirizzo,cap,comune,stato,telefono,cellulare,email,cittadinanza,grupposanguigno,rh,dataiscrizione,gruppo,tesseragruppo,idoneo,prossimadatadonazione,tipodonatore,nomesezione, numerodonazioni) "
			// +
			// "VALUES ('M','Pippo dei Pippi', '1985-07-28', 'Italia', 'FDELSN85L28G713L', 'Via bellaria 15b', 51100, 'Pistoia', 'Italia', 057325580, 3289676688, 'alefedi85@gmail.com', 'Italia','A','positivo', '2010-08-28', 215, 1050, 'I', '2014-05-26', 'Socio Donatore', 'PISTOIA 1', 10  );")
			// .execute();
			// connection.prepareStatement("INSERT INTO donazioni(donatore,nome,datadonazione,tipodonazione,unitaraccolta,comunedonazione,asl,puntoprelievo) VALUES (2, 'Alessandro Nesti', '2014-05-06', 'Sangue intero', 'unità raccolta fissa', 'pistoia', 'pt103', 9);").execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// server.stop();

	}
}
