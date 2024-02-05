package testlambda.BE;


public class Movie {

    private int id;
    private String title;
    private int year;
    private double rating;

    /**
     *
     * @param year
     * @param title
     * @param rating
     */
    public Movie(int year, String title, double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    /**
     *
     * @param id
     * @param year
     * @param title
     * @param rating
     */
    public Movie(int id, int year, String title, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double year) {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return id + ": " + title + " ("+year+", rating: " + rating + ")";
    }
}
