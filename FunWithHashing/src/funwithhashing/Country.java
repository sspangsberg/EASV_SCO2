package funwithhashing;

public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return name != null ? name.equals(country.name) : country.name == null;
    }
    */

    @Override
    public int hashCode()
    {
        return 1;
        //return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
