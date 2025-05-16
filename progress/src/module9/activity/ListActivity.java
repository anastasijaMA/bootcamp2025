package module9.activity;
//Needs to be completed

import java.util.ArrayList;
import java.util.List;

public class ListActivity {

	public static void main(String[] args) {
		//1 - Type code to create a list of names. Use ArrayList.
		List <String> names = new ArrayList<>();

		names.add("John");
		names.add("Mike");
		names.add("Shanti");
		names.add("Stacie");
		//2 - Call print method to print the list passed as its parameter.
		new ListActivity().print(names);
		
	}
	
	void print(List<String> list) {
		//3 - Type code to print this list
		//Notice the order in which elements get printed.

		for (String name : list) {
			System.out.println(name);
		}
	}
}
