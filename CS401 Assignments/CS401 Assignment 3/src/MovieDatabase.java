import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class MovieDatabase <T extends Comparable<T>>
{
    // Creates map to store red black tree fields.
    public Map<T, RedBlackBST<T, HashSet<Integer>>> movieFieldsRBTMap = new HashMap<>();

    // Adds field to red black tree.
    public void addFieldToRBT(Movie[] movieDatabase)
    {
        addFieldIndex(movieDatabase, (T) "color");
        addFieldIndex(movieDatabase, (T) "movie_title");
        addFieldIndex(movieDatabase, (T) "duration");
        addFieldIndex(movieDatabase, (T) "director_name");
        addFieldIndex(movieDatabase, (T) "actor_1_name");
        addFieldIndex(movieDatabase, (T) "actor_2_name");
        addFieldIndex(movieDatabase, (T) "actor_3_name");
        addFieldIndex(movieDatabase, (T) "movie_imdb_link");
        addFieldIndex(movieDatabase, (T) "language");
        addFieldIndex(movieDatabase, (T) "country");
        addFieldIndex(movieDatabase, (T) "content_rating");
        addFieldIndex(movieDatabase, (T) "title_year");
        addFieldIndex(movieDatabase, (T) "imdb_score");
    }

    public void addFieldIndex(Movie[] database, T field)
    {
        // Creates Red Black Tree
        RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

        // Switch case by movie field and calls store more field RBT.
        if ("color".equals(field)) {
            // Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getColor())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getColor());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getColor(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getColor(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("movie_title".equals(field)) {
            // Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getMovie_title())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getMovie_title());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getMovie_title(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getMovie_title(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("duration".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getDuration())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getDuration());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getDuration(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getDuration(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("director_name".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getDirector_name())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getDirector_name());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getDirector_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getDirector_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("actor_1_name".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getActor_1_name())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getActor_1_name());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getActor_1_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getActor_1_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("actor_2_name".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getActor_2_name())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getActor_2_name());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getActor_2_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getActor_2_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("actor_3_name".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getActor_3_name())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getActor_3_name());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getActor_3_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getActor_3_name(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("movie_imdb_link".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getMovie_imdb_link())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getMovie_imdb_link());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getMovie_imdb_link(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getMovie_imdb_link(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("language".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getLanguage())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getLanguage());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getLanguage(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getLanguage(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("country".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getCountry())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getCountry());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getCountry(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getCountry(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("content_rating".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getContent_rating())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getContent_rating());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getContent_rating(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getContent_rating(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("title_year".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getTitle_year())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getTitle_year());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getTitle_year(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getTitle_year(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else if ("imdb_score".equals(field)) {// Populates the red black true with movie title and id as key value pairs.
            for (int i = 0; i < database.length; i++) {
                // If movie title is already stored in the rbt, append duplicate
                // movie title id to existing movie title hash set.
                if (movieFieldRBT.contains((T) database[i].getImdb_score())) {
                    HashSet<Integer> set = movieFieldRBT.get((T) database[i].getImdb_score());
                    set.add((Integer) database[i].getId());
                    movieFieldRBT.put((T) database[i].getImdb_score(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                } else {
                    // Creates hash set.
                    HashSet<Integer> set = new HashSet<>();

                    // Converts String ID to integer and adds to hash set.
                    set.add((Integer) database[i].getId());

                    // Puts movie title and hash set movie id into red black tree.
                    movieFieldRBT.put((T) database[i].getImdb_score(), set);

                    // Puts red black tree into index tree map.
                    movieFieldsRBTMap.put((T) field, movieFieldRBT);
                }
            }
        } else {
            System.out.println("Field not found.");
        }
    }
}
