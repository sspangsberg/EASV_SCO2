package funwithsearching;

import java.util.Objects;

public class Movie implements Comparable<Movie> {

    private int id;
    private String title;

    /**
     * Constructor
     * @param id
     * @param title
     */
    public Movie(int id, String title)  {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Default IntelliJ IDEA toString() implementation
     * @return
     */
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * Default IntelliJ IDEA equals() implementation
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Movie movie = (Movie) other;

        if (id != movie.id) return false;
        if (!Objects.equals(title, movie.title)) return false;

        return false;
    }

    /**
     * Default IntelliJ IDEA hashCode() implementation
     * @return
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);

        return result;
    }

    /**
     * Enables objects of this class to be compared by title and sorted...
     * @param other
     * @return
     */
    @Override
    public int compareTo(Movie other) {
        return this.title.compareTo(other.title);
    }
}
