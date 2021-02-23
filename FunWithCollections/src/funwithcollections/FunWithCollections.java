package funwithcollections;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Søren Spangsberg
 */
public class FunWithCollections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PersonManager pm = PersonManager.getInstance();

        pm.addPerson(new Person(1, "Bill Gates", LocalDate.of(1955, 10, 28)));
        pm.addPerson(new Person(2, "Steve Jobs", LocalDate.of(1955, 2, 24)));
        pm.addPerson(new Person(3, "Mark Zuckerberg", LocalDate.of(1984, 5, 14)));
        pm.addPerson(new Person(4, "Jeff Bezos", LocalDate.of(1964, 1, 12)));
        pm.addPerson(new Person(5, "Larry Page", LocalDate.of(1973, 3, 26)));
        pm.addPerson(new Person(6, "Sergin Brin", LocalDate.of(1973, 8, 21)));

        //System.out.println(pm.getPersons().);
        Iterator it = pm.getPersons().iterator();

        while (it.hasNext()) {
            Person p = (Person) it.next();

            if (p.getName().equals("Mark Zuckerberg")) //remove item at traversal
            {
                it.remove();
            } else {
                System.out.println(p);
            }
        }

//        for (Person person:  pm.getPersons()) {
//            
//            if (person.getName().equals("Mark Zuckerberg")) //remove item at traversal
//                pm.getPersons().remove(person);
//            
//            System.out.println(person);
//        }
//        for (Person p : pm.getPersons()) {
//            if (p.getName().equals("Mark Zuckerberg")) //remove item at traversal
//                pm.getPersons().remove(p);
//            else
//                System.out.println(p);
//            
//            
//            //System.out.println(p);
//        }
        System.out.println("Next person in line: " + pm.getNextPerson());
        System.out.println("Next person in line: " + pm.getNextPerson());
        System.out.println("Who is next in line: " + pm.whoIsNext());
        
        System.out.println("Next person in line: " + pm.getNextPerson());
    }
}
