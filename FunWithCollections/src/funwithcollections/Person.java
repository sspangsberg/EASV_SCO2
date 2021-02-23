
package funwithcollections;

import java.time.LocalDate;

/**
 *
 * @author Søren Spangsberg
 */
public class Person { //implements Comparable<Person> {
    private int id;
    private String name;
    private LocalDate birthDate;

    /**
     * 
     * @param id
     * @param name
     * @param birthDate 
     */
    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return name + " (" + birthDate + ")";
    }

//    @Override
//    public int compareTo(Person other) {
//        return this.name.compareTo(other.name); // if you know there wont be an overflow.
//    }
}
