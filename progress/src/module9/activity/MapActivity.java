package module9.activity;
//Needs to be completed

import java.util.HashMap;
import java.util.Map;


public class MapActivity {
	public static void main(String[] args) {
		//1 - Type code to create a HashMap of key value pair
		//where key is id of type String and value is a name
		Map<String, String> idNameMap = new HashMap<>();
		idNameMap.put("01", "John");
		idNameMap.put("02", "Mike");
		idNameMap.put("03", "Shanti");

		//2 - Call print method to print the map passed as its parameter.
		MapActivity myMap = new MapActivity();
		myMap.print(idNameMap);

	}

	//3 - Type code to print this map
	void print(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());

		}
	}
}