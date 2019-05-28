public class Movie <T extends Comparable<T>>
{
    T id;
    T color;
    T movie_title;
    T duration;
    T director_name;
    T actor_1_name;
    T actor_2_name;
    T actor_3_name;
    T movie_imdb_link;
    T language;
    T country;
    T content_rating;
    T title_year;
    T imdb_score;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getColor() {
        return color;
    }

    public void setColor(T color) {
        this.color = color;
    }

    public T getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(T movie_title) {
        this.movie_title = movie_title;
    }

    public T getDuration() {
        return duration;
    }

    public void setDuration(T duration) {
        this.duration = duration;
    }

    public T getDirector_name() {
        return director_name;
    }

    public void setDirector_name(T director_name) {
        this.director_name = director_name;
    }

    public T getActor_1_name() {
        return actor_1_name;
    }

    public void setActor_1_name(T actor_1_name) {
        this.actor_1_name = actor_1_name;
    }

    public T getActor_2_name() {
        return actor_2_name;
    }

    public void setActor_2_name(T actor_2_name) {
        this.actor_2_name = actor_2_name;
    }

    public T getActor_3_name() {
        return actor_3_name;
    }

    public void setActor_3_name(T actor_3_name) {
        this.actor_3_name = actor_3_name;
    }

    public T getMovie_imdb_link() {
        return movie_imdb_link;
    }

    public void setMovie_imdb_link(T movie_imdb_link) {
        this.movie_imdb_link = movie_imdb_link;
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

    public T getContent_rating() {
        return content_rating;
    }

    public void setContent_rating(T content_rating) {
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
