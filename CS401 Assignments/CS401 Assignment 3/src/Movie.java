// gets and sets all fields of each movie
public class Movie<T extends Comparable<T>> {
    private int id;
    private T color;
    private T title;
    private T duration;
    private T director;
    private T actor1;
    private T actor2;
    private T actor3;
    private T url;
    private T language;
    private T country;
    private T rating;
    private T year;
    private T score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getColor() {
        return color;
    }

    public void setColor(T color) {
        this.color = color;
    }

    public T getTitle() {
        return title;
    }

    public void setTitle(T title) {
        this.title = title;
    }

    public T getDuration() {
        return duration;
    }

    public void setDuration(T duration) {
        this.duration = duration;
    }

    public T getDirector() {
        return director;
    }

    public void setDirector(T director) {
        this.director = director;
    }

    public T getActor1() {
        return actor1;
    }

    public void setActor1(T actor1) {
        this.actor1 = actor1;
    }

    public T getActor2() {
        return actor2;
    }

    public void setActor2(T actor2) {
        this.actor2 = actor2;
    }

    public T getActor3() {
        return actor3;
    }

    public void setActor3(T actor3) {
        this.actor3 = actor3;
    }

    public T getUrl() {
        return url;
    }

    public void setUrl(T url) {
        this.url = url;
    }

    public T getLanguage() {
        return language;
    }

    public void setLanguage(T language) {
        this.language = language;
    }

    public T getCountry() {
        return country;
    }

    public void setCountry(T country) {
        this.country = country;
    }

    public T getRating() {
        return rating;
    }

    public void setRating(T rating) {
        this.rating = rating;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }

    // not needed, but is useful
    public void printMovie() {
        System.out.println(id + ", " + color + ", " + title + ", " + duration + ", " + director +
                ", " + actor1 + ", " + actor2 + ", " + actor3 + ", " + url + ", " + language + ", " +
                country + ", " + rating + ", " + year + ", " + score);
    }
}
