package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnection 
{
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/test";

	//Database credentials
	static final String USER = "root";
	static final String PASS = "1111";
	
	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	/**
	 * Method for updates or inserts in the database table
	 * @param sqlQuery
	 */
	public void updateTable(String sqlQuery) {
		try {
			//Register JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//Open a connection
			System.out.println("Connecting to a selected database...");
			connect = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		      
			//Execute a query
			System.out.println("Inserting records into the table...");
			statement = connect.createStatement();
			
			statement.executeUpdate(sqlQuery);
			System.out.println("Inserted record into the table...");

		} catch(SQLException exception) {
			//Handle errors for JDBC
			exception.printStackTrace();
		} catch(Exception exception) {
			//Handle errors for Class.forName
			exception.printStackTrace();
		} 
		//Close all stuff
		closeAll();
		System.out.println("SQL Connection closed");
	}
	
	/**
	 * Close everything
	 */
	private static void closeAll() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception exception) {
			//Handle exception with closing stuff
			exception.printStackTrace();
		}
	}
	
	/**
	 * Example
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main (String [] args) throws ClassNotFoundException, SQLException {
		MysqlConnection connection = new MysqlConnection();
		connection.updateTable("INSERT INTO test_results (name, price) VALUES ('name', 'price')");
	}
}
