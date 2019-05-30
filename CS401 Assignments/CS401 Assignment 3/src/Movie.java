public class Movie <T extends Comparable<T>>
{
    int id;
    String color;
    String movie_title;
    T duration;
    String director_name;
    String actor_1_name;
    String actor_2_name;
    String actor_3_name;
    String movie_imdb_link;
    String language;
    String country;
    String content_rating;
    T title_year;
    T imdb_score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public T getDuration() {
        return duration;
    }

    public void setDuration(T duration) {
        this.duration = duration;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public String getActor_1_name() {
        return actor_1_name;
    }

    public void setActor_1_name(String actor_1_name) {
        this.actor_1_name = actor_1_name;
    }

    public String getActor_2_name() {
        return actor_2_name;
    }

    public void setActor_2_name(String actor_2_name) {
        this.actor_2_name = actor_2_name;
    }

    public String getActor_3_name() {
        return actor_3_name;
    }

    public void setActor_3_name(String actor_3_name) {
        this.actor_3_name = actor_3_name;
    }

    public String getMovie_imdb_link() {
        return movie_imdb_link;
    }

    public void setMovie_imdb_link(String movie_imdb_link) {
        this.movie_imdb_link = movie_imdb_link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContent_rating() {
        return content_rating;
    }

    public void setContent_rating(String content_rating) {
        this.content_rating = content_rating;
    }

    public T getTitle_year() {
        return title_year;
    }

    public void setTitle_year(T title_year) {
        this.title_year = title_year;
    }

    public T getImdb_score() {
        return imdb_score;
    }

    public void setImdb_score(T imdb_score) {
        this.imdb_score = imdb_score;
    }
}
