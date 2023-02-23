package fr.epsi.b32223g1.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
	
	private static DBConnection single;
	
	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle( "db" );
		DB_URL = bundle.getString( "db.url" );
		DB_USER = bundle.getString( "db.user" );
		DB_PWD = bundle.getString( "db.password" );
	}
	
	
	private Connection sqlConnection;
	
	private DBConnection() throws SQLException {
		
		sqlConnection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
	}
	
	public Connection getSqlConnection() throws SQLException {
		if ( sqlConnection == null || sqlConnection.isClosed()) {
			sqlConnection = DriverManager.getConnection( DB_URL, DB_USER, DB_PWD );
		}
		return sqlConnection;
	}
	
	public void closeSQLConnection() throws SQLException {
		if (sqlConnection != null && !sqlConnection.isClosed()) {
			sqlConnection.close();
		}
 	}
	
	public static DBConnection getSingle() throws SQLException {
		
		if (null == single) {
			single = new DBConnection();
		}
		return single;
	}
}
