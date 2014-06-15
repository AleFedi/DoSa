package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hsqldb.server.Server;

public class ConnectionDB {

	Connection connection;

	public ConnectionDB() throws SQLException {
		connection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/donatoridb", "sa", "");

	}

}
