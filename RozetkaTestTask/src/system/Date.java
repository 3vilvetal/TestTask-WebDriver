package system;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date 
{
	
	private static String DATE_FORMAT = "yyyy-MM-dd";
	/**
	 * Get current date in needed format
	 * @return
	 */
	public static String getCurrentDate()
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		return sdf.format(calendar.getTime());
	}
	
	public static String getYesterdayDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        
        calendar.add(Calendar.DATE, -1);    
        return sdf.format(calendar.getTime());
	}
	
	public static String getTomorowDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        
        calendar.add(Calendar.DATE, +1);    
        return sdf.format(calendar.getTime());
	}
}
