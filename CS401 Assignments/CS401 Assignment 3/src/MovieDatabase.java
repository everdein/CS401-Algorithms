import edu.princeton.cs.algs4.RedBlackBST;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovieDatabase
{
    public static void addFieldIndex(Movie[] database, String field, Map<String, RedBlackBST<String, Set<Integer>>> movieFieldsRBTMap)
    {
        switch(field)
        {
            case "color":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> colorRBT = new RedBlackBST<>();


                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {

                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (colorRBT.contains(database[i].getColor()))
                    {
                        Set<Integer> set = colorRBT.get(database[i].getColor());
                        set.add(Integer.parseInt(database[i].getId()));
                        colorRBT.put(database[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, colorRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        colorRBT.put(database[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, colorRBT);
                    }
                }
                break;
            case "movie_title":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> movie_titleRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(movie_titleRBT.contains(database[i].getMovie_title()))
                    {
                        Set<Integer> set = movie_titleRBT.get(database[i].getMovie_title());
                        set.add(Integer.parseInt(database[i].getId()));
                        movie_titleRBT.put(database[i].getMovie_title(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movie_titleRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movie_titleRBT.put(database[i].getMovie_title(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movie_titleRBT);
                    }
                }
                break;
            case "duration":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> durationRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(durationRBT.contains(database[i].getDuration()))
                    {
                        Set<Integer> set = durationRBT.get(database[i].getDuration());
                        set.add(Integer.parseInt(database[i].getId()));
                        durationRBT.put(database[i].getDuration(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, durationRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        durationRBT.put(database[i].getDuration(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, durationRBT);
                    }
                }
                break;
            case "director_name":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> director_nameRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(director_nameRBT.contains(database[i].getDirector_name()))
                    {
                        Set<Integer> set = director_nameRBT.get(database[i].getDirector_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        director_nameRBT.put(database[i].getDirector_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, director_nameRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        director_nameRBT.put(database[i].getDirector_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, director_nameRBT);
                    }
                }
                break;
            case "actor_1_name":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> actor_1_nameRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(actor_1_nameRBT.contains(database[i].getActor_1_name()))
                    {
                        Set<Integer> set = actor_1_nameRBT.get(database[i].getActor_1_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        actor_1_nameRBT.put(database[i].getActor_1_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_1_nameRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        actor_1_nameRBT.put(database[i].getActor_1_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_1_nameRBT);
                    }
                }
                break;
            case "actor_2_name":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> actor_2_nameRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(actor_2_nameRBT.contains(database[i].getActor_2_name()))
                    {
                        Set<Integer> set = actor_2_nameRBT.get(database[i].getActor_2_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        actor_2_nameRBT.put(database[i].getActor_2_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_2_nameRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        actor_2_nameRBT.put(database[i].getActor_2_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_2_nameRBT);
                    }
                }
                break;
            case "actor_3_name":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> actor_3_nameRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(actor_3_nameRBT.contains(database[i].getActor_3_name()))
                    {
                        Set<Integer> set = actor_3_nameRBT.get(database[i].getActor_3_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        actor_3_nameRBT.put(database[i].getActor_3_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_3_nameRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        actor_3_nameRBT.put(database[i].getActor_3_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, actor_3_nameRBT);
                    }
                }
                break;
            case "movie_imdb_link":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> movie_imdb_linkRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(movie_imdb_linkRBT.contains(database[i].getMovie_imdb_link()))
                    {
                        Set<Integer> set = movie_imdb_linkRBT.get(database[i].getMovie_imdb_link());
                        set.add(Integer.parseInt(database[i].getId()));
                        movie_imdb_linkRBT.put(database[i].getMovie_imdb_link(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movie_imdb_linkRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movie_imdb_linkRBT.put(database[i].getMovie_imdb_link(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movie_imdb_linkRBT);
                    }
                }
                break;
            case "language":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> languageRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(languageRBT.contains(database[i].getLanguage()))
                    {
                        Set<Integer> set = languageRBT.get(database[i].getLanguage());
                        set.add(Integer.parseInt(database[i].getId()));
                        languageRBT.put(database[i].getLanguage(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, languageRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        languageRBT.put(database[i].getLanguage(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, languageRBT);
                    }
                }
                break;
            case "country":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> countryRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(countryRBT.contains(database[i].getCountry()))
                    {
                        Set<Integer> set = countryRBT.get(database[i].getCountry());
                        set.add(Integer.parseInt(database[i].getId()));
                        countryRBT.put(database[i].getCountry(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, countryRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        countryRBT.put(database[i].getCountry(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, countryRBT);
                    }
                }
                break;
            case "content_rating":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> content_ratingRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(content_ratingRBT.contains(database[i].getContent_rating()))
                    {
                        Set<Integer> set = content_ratingRBT.get(database[i].getContent_rating());
                        set.add(Integer.parseInt(database[i].getId()));
                        content_ratingRBT.put(database[i].getContent_rating(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, content_ratingRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        content_ratingRBT.put(database[i].getContent_rating(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, content_ratingRBT);
                    }
                }
                break;
            case "title_year":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> title_yearRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(title_yearRBT.contains(database[i].getTitle_year()))
                    {
                        Set<Integer> set = title_yearRBT.get(database[i].getTitle_year());
                        set.add(Integer.parseInt(database[i].getId()));
                        title_yearRBT.put(database[i].getTitle_year(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, title_yearRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        title_yearRBT.put(database[i].getTitle_year(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, title_yearRBT);
                    }
                }
                break;
            case "imdb_score":
                // Creates Red Black Tree
                RedBlackBST<String, Set<Integer>> imdb_scoreRBT = new RedBlackBST<>();
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if(imdb_scoreRBT.contains(database[i].getImdb_score()))
                    {
                        Set<Integer> set = imdb_scoreRBT.get(database[i].getImdb_score());
                        set.add(Integer.parseInt(database[i].getId()));
                        imdb_scoreRBT.put(database[i].getImdb_score(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, imdb_scoreRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        Set<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        imdb_scoreRBT.put(database[i].getImdb_score(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, imdb_scoreRBT);
                    }
                }
                break;
            default:
                System.out.println("Field not found.");
        }
    }
}
