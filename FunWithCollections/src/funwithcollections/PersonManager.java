package funwithcollections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Søren Spangsberg
 */
public class PersonManager {

    //List<Person> persons = new ArrayList();
    //LinkedList<Person> persons = new LinkedList();
    Deque<Person> persons = new ArrayDeque();
    //Deque<Person> persons = new LinkedList();
    
    //PriorityQueue<Person> persons = new PriorityQueue();
    
    
    private static PersonManager _instance = null;

    private PersonManager() {
    }

    /**
     *
     * @return
     */
    public static PersonManager getInstance() {
        if (_instance == null) {
            _instance = new PersonManager();
        }

        return _instance;
    }

    // ArrayList START **************************************************
    
//    /**
//     * 
//     * @return 
//     */
//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    /**
//     * 
//     * @param persons 
//     */
//    public void setPersons(List<Person> persons) {
//        this.persons = persons;
//    }    
    
    // ArrayList END **************************************************
    
    
    // LinkedList START **************************************************
    
//    /**
//     * 
//     * @return 
//     */
//    public LinkedList<Person> getPersons() {
//        return persons;
//    }
//
//    /**
//     * 
//     * @param persons 
//     */
//    public void setPersons(LinkedList<Person> persons) {
//        this.persons = persons;
//    }
//    
//    /**
//     * 
//     * @return 
//     */
//    public Person getNextPerson() {        
//        return this.persons.removeFirst();
//    }
    
//    
//    /**
//     * 
//     * @return 
//     */
//    public Person whoIsNext() {
//        return this.persons.getFirst();
//    }
        
    // LinkedList END **************************************************
        
    
    
    
    
    // DeQue START **************************************************
    
    /**
     *
     * @return
     */
    public Deque<Person> getPersons() {
        return persons;
    }

    /**
     *
     * @param persons
     */
    public void setPersons(Deque<Person> persons) {
        this.persons = persons;
    }

    /**
     *
     * @return
     */
    public Person getNextPerson() {
        return this.persons.poll();
    }
    /**
     *
     * @return
     */
    public Person whoIsNext() {
        return this.persons.peek();
    }

//    
    // DeQueue END **************************************************
    
    
    
    
    // PriorityQueue START **************************************************
    
//    /**
//     *
//     * @return
//     */
//    public PriorityQueue<Person> getPersons() {
//        return persons;
//    }
//
//    /**
//     *
//     * @param persons
//     */
//    public void setPersons(PriorityQueue<Person> persons) {
//        this.persons = persons;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Person getNextPerson() {
//        return this.persons.poll();
//    }
//
//    /**
//     *
//     * @return
//     */
//    public Person whoIsNext() {
//        return this.persons.peek();
//    }
    
    // PriorityQueue END **************************************************
    
    
    
    

    /**
     *
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     *
     * @param newPersons
     */
    public void addPersons(List<Person> newPersons) {
        this.persons.addAll(newPersons);
    }

    /**
     *
     * @param p
     */
    public void addPersons(Person... p) {
        for (Person person : p) {
            this.persons.add(person);
        }
    }

}
