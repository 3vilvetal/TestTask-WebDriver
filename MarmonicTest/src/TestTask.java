import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class TestTask {
	
	private static String PACKETS_JSON = "resources/packets.json";
	
	/**
	 * Get all packets from packets.json file
	 * @return
	 */
	public static JSONArray getHelloPackets() {
		JSONArray array = null;
		try {
			array = TestUtils.getPackets(PACKETS_JSON).getJSONArray("packets");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	/**
	 * Start point of execution
	 * @param args
	 * @throws JSONException
	 */
	public static void main(String args[]) throws JSONException {
		JSONObject json = null;
		/** 
		 * TASK 1: Output all PID
		 */
		JSONArray array = getHelloPackets();
		for (int i = 0; i < array.length(); i++) {
			json = (JSONObject) array.get(i);
			System.out.println("Packet with next PID was in file: " + TestUtils.getPacketValue(json, "PID"));
		}
		
		/**
		 * TASK 2: Output the number of missing packets for each PID
		 */
		//STEP 1: Create new hash map to define the number of failed packets
		HashMap<Integer, ArrayList<Integer>> continuityPackets = new HashMap<Integer, ArrayList<Integer>>();
		
		//STEP 2: Gather all PID and continuity_counter in hash map
		for (int i = 0; i < array.length(); i++) {
			json = (JSONObject) array.get(i);
			
			int key = TestUtils.getPacketValue(json, "PID");
			int value =  TestUtils.getPacketValue(json, "continuity_counter");
			
			if (continuityPackets.keySet().contains(key)) {
				//add value to existing collection
				continuityPackets.get(key).add(value);
			} else {
				//create new collection and add value to it
				ArrayList<Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(value);
				
				//put new collection to hash map
				continuityPackets.put(key, arrayList);
			}
		}
		//STEP 3: Define missing packets and output them
		Set<Integer> keySet = continuityPackets.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			
			//get max continuity_counter value for each PID
			int max = TestUtils.getMaxValueArray(continuityPackets.get(key));
			int size = continuityPackets.get(key).size();
			int missed = max - size;		
			
			//console output
			System.out.println("Packet with PID " + key + " was missed " + missed + " times");
		}
	}
}
