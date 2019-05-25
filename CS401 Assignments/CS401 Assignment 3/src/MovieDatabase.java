import edu.princeton.cs.algs4.RedBlackBST;
import java.util.HashSet;
import java.util.Map;

public class MovieDatabase
{
    public static void addFieldIndex(Movie[] database, String field, Map<String, RedBlackBST<String, HashSet<Integer>>> movieFieldsRBTMap)
    {
        // Creates Red Black Tree
        RedBlackBST<String, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();
        // Switch case by movie field and calls store more field RBT.
        switch(field)
        {
            case "color":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getColor()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getColor());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "movie_title":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getMovie_title()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getMovie_title());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getMovie_title(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getMovie_title(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "duration":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getDuration()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getDuration());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getDuration(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getDuration(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "director_name":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getDirector_name()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getDirector_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getDirector_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getDirector_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_1_name":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getActor_1_name()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getActor_1_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getActor_1_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getActor_1_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_2_name":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getActor_2_name()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getActor_2_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getActor_2_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getActor_2_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_3_name":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getActor_3_name()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getActor_3_name());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getActor_3_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getActor_3_name(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "movie_imdb_link":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getMovie_imdb_link()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getMovie_imdb_link());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getMovie_imdb_link(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getMovie_imdb_link(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "language":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getLanguage()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getLanguage());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getLanguage(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getLanguage(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "country":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getCountry()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getCountry());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getCountry(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getCountry(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "content_rating":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getContent_rating()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getContent_rating());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getContent_rating(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getContent_rating(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "title_year":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getTitle_year()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getTitle_year());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getTitle_year(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getTitle_year(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "imdb_score":
                // Populates the red black true with movie title and id as key value pairs.
                for(int i = 0; i < database.length; i++)
                {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains(database[i].getImdb_score()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get(database[i].getImdb_score());
                        set.add(Integer.parseInt(database[i].getId()));
                        movieFieldRBT.put(database[i].getImdb_score(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                    else
                    {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(Integer.parseInt(database[i].getId()));

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put(database[i].getImdb_score(), set);

                        // Puts red black tree into index tree map.
                        movieFieldsRBTMap.put(field, movieFieldRBT);
                    }
                }
                break;
            default:
                System.out.println("Field not found.");
        }
    }
}
