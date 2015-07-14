import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;


public class TestUtils {
	/**
	 * Gets text with pointed separators
	 * @param path
	 * @param separator
	 * @return
	 */
	private static String getTextStructure (String path, String separator){
		File file = new File (path);
        BufferedReader input;
        String data = "", temp; 
        try {
             input = new BufferedReader(new FileReader(file));
             while ((temp = input.readLine())!= null){
                 data += temp + separator;
             }
             input.close();
         } 
         catch (FileNotFoundException e){
             e.printStackTrace();
         } 
         catch (IOException e){
             e.printStackTrace();
         }    
         return data;
	}
	
	/**
	 * Gets text with line brakes
	 * @param path
	 * @return
	 */
	public static String getText(String path)
	{
		return getTextStructure(path, "\n");
	}
	
	/**
	 * Read JSON from file
	 * @param filePath
	 * @return
	 */
	public static JSONObject getJSONfromFile (String filePath) {
		//Read JSON file
		String fileString = getText(filePath);
		//Read search JSON
		JSONObject json = null;
		try {
			json = new JSONObject(fileString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * Get all packets from JSON file
	 * @param filePath
	 * @return
	 */
	public static JSONObject getPackets(String filePath) {
		return getJSONfromFile(filePath);
	}
	
	/**
	 * Get any value from packet by key
	 * @param json
	 * @param key
	 * @return
	 */
	public static int getPacketValue(JSONObject json, String key){
		int pid = 0;
		try {
			pid = Integer.parseInt(json.getString(key));
		} catch (NumberFormatException | JSONException e) {
			e.printStackTrace();
		}
		return pid;
	}
	
	/**
	 * Define max value in the ArrayList collection
	 * @param array
	 * @return
	 */
	public static int getMaxValueArray(ArrayList<Integer> array) {
		int max = array.get(0);
		for (int i = 1; i < array.size(); i++) {
			if (max < array.get(i)) max = array.get(i);
		}
		return max;
	}
}
