package system;

public class StaticValues {
	
	static XmlParser xml = new XmlParser("access.xml");
	
	/**
	 * Get email login from XML
	 * @return
	 */
	public static String getEmailLogin() {
		return xml.getValues("emailLogin").get(0);
	}
	
	/**
	 * Get email pass from XML
	 * @return
	 */
	public static String getEmailPass() {
		return xml.getValues("emailPass").get(0);
	}
	
	/**
	 * Get list of mail from XML
	 * @return
	 */
	public static String [] getEmailList() {
		 int toSize = xml.getValues("emailTo").size();
		 String [] to = new String [toSize];
		 to = xml.getValues("emailTo").toArray(to); 
		
		 return to;
	}
	
	/**
	 * Get JDBC driver name
	 * @return
	 */
	public static String getJdbcDriver() {
		return xml.getValues("jdbcDriver").get(0);
	}
	
	/**
	 * Get database url
	 * @return
	 */
	public static String getDbUrl() {
		return xml.getValues("dbUrl").get(0);
	}
	
	/**
	 * Get database user
	 * @return
	 */
	public static String getDbUser() {
		return xml.getValues("dbUser").get(0);
	}
	
	/**
	 * Get database pass
	 * @return
	 */
	public static String getDbPass() {
		return xml.getValues("dbPass").get(0);
	}

}
