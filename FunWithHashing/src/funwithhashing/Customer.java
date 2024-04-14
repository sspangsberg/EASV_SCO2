package funwithhashing;

import java.util.Objects;

/**
 *
 * @author Søren Spangsberg
 */
public class Customer {
    private String phoneNumber;
    private String name;
    private String email;

    public Customer(String phoneNumber, String name, String email) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /*
    @Override
    public int hashCode() {

        return 0;



        int result = phoneNumber != null ? phoneNumber.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    */


    @Override
    public String toString() {
        return "Customer{" + "phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + '}';
    }
}
