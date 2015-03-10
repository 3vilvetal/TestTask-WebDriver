package system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlConnection 
{
	private java.sql.Connection  connect = null;
	
	private String 
	
	dbHost = "localhost", 
	dbUsername = "root", 
	dbPassword =  "1111",
	dbName = "test";
	
    private int 
    dbPort = 3306;
    
    
    
	public Connection getConnection() throws SQLException, IOException
	{
		return java.sql.DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName, 
				dbUsername, dbPassword);
	}
	
	public void closeConection()
	{		
		try 
		{
			if(connect != null)
				connect.close();
			connect = null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		System.out.println("Connection Closed!");
	}
	
	/**
	 * Get result set from query
	 * @param query
	 * @return
	 */
	public ResultSet executeQuery(String query)
	{
		Statement stmt;
		ResultSet rs = null;
		
		//create connection
		Connection connect;
		try 
		{
			connect = getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//close connection
		closeConection();
		
		return rs;
	}
	
	/**
	 * Example
	 * @param args
	 */
	public static void main (String [] args) {
		MysqlConnection connection = new MysqlConnection();
		connection.executeQuery("INSERT INTO testresults (name, price) VALUES ('name', 'price')");
	}
}
