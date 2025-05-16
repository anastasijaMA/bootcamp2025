package module9.activity;

//Needs to be completed
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetActivity {

    public static void main(String[] args) {
        //1 - Type code to create a set of names.
        //Names must be sorted by their natural order.
        //Do research to find if you already have such a class.
        //Also try adding a few duplicate entries to this set.
        Set<String> name = new TreeSet<>();


        name.add("John");
        name.add("Mike");
        name.add("Shanti");
        name.add("Mike");
        name.add("John");

        //2 - Call print method to print the set passed as its parameter.
        new SetActivity().print(name);
    }

    void print(Set<String> set) {
        //3 - Type code to print this set
        //Notice the order in which elements get printed.
        for (String name : set) {
            System.out.println(name);
        }
    }
}
