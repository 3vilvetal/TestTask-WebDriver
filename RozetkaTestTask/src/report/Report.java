package report;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import system.Email;
import system.MysqlConnection;
import system.StaticValues;

public class Report {
	
	String from = StaticValues.getEmailLogin();
    String pass = StaticValues.getEmailPass();
    String [] to = StaticValues.getEmailList();
	
	/**
	 * Sample: send report for current date items
	 * @param args
	 */
	 public static void main(String[] args) {
		 Report report = new Report();
		 report.sendReport(system.Date.getYesterdayDate(), system.Date.getTomorowDate());
	 }
	 
	 /**
	  * Send report with results on email list from access.xml file
	  * @param dateFrom
	  * @param dateTo
	  */
	 public void sendReport(String dateFrom, String dateTo) {
		
		String body = "Today we found this list of test data: \n";
		
		Email email = new Email();
		MysqlConnection connection = new MysqlConnection();
		
		ResultSet rs = connection.selectFromTable("SELECT * FROM test_results where timestmp between '" + 
				dateFrom +"' AND '" + dateTo +"'");
		      try {
		    	  while(rs.next()) {
		    		  //Retrieve by column name
		    		  int id  = rs.getInt("id");
		    		  String name = rs.getString("name");
		    		  String price = rs.getString("price");
		    		  Date date = rs.getDate("timestmp");

		    		  //Put values to body
		    		  body += "id: " + id;
		    		  body += ", name: " + name;
		    		  body += ", price: " + price;
		    		  body += ", date: " + date;
		    		  body += "\n";
		    	  }
		    	  MysqlConnection.closeAll();
		      } catch (SQLException e) {
		    	  e.printStackTrace();
		      }
		      String subject = "Test results, " + system.Date.getCurrentDate();
		      //Send email message
		      email.sendFromGMail(from, pass, to, subject, body);
	}
}
