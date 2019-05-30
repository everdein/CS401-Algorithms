import edu.princeton.cs.algs4.RedBlackBST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class MoviesDB<T extends Comparable<T>>
{
    private static String fileName = "simple.csv";
    private Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap = new HashMap<>();
    private static Movie[] db;
    private static int fileSize;

    // Load the array with the data given in the csv file.
    public static void MoviesDB() // throws FileNotFoundException
    {
        try
        {
            // Creates scanner to scan file data.
            Scanner scanner = new Scanner(new File(fileName));
            try
            {

                // Scans first line of file to skip categories.
                scanner.nextLine();

                // Declares movie index to increment category indices.
                int movieIndex = 0;

                // Scans every line in the file.
                while (scanner.hasNextLine())
                {
                    // Creates movie object.
                    Movie movie = new Movie();

                    // Stores next line in csv.
                    String line = scanner.nextLine();

                    // Stores parsed line into categories array.
                    String[] categories = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                    // Initializes count to zero to increase index of movies.
                    int count = 0;

                    // Sets file data into movie categories.
                    movie.setId(Integer.parseInt(categories[count++]));
                    movie.setColor(categories[count++]);
                    movie.setMovie_title(categories[count++]);

                    //                                 //
                    //// Duration string to integer. ////
                    //                                 //
                    String duration = categories[count++];
                    if(duration.isEmpty())
                    {
                        duration = "-1";
                        movie.setDuration(Integer.parseInt(duration));
                    }
                    else
                    {
                        movie.setDuration(Integer.parseInt(duration));
                    }

                    movie.setDirector_name(categories[count++]);
                    movie.setActor_1_name(categories[count++]);
                    movie.setActor_2_name(categories[count++]);
                    movie.setActor_3_name(categories[count++]);
                    movie.setMovie_imdb_link(categories[count++]);
                    movie.setLanguage(categories[count++]);
                    movie.setCountry(categories[count++]);
                    movie.setContent_rating(categories[count++]);

                    //                                   //
                    //// Title year string to integer. ////
                    //                                   //
                    String title_year = categories[count++];
                    if(title_year.isEmpty())
                    {
                        title_year = "-1";
                        movie.setTitle_year(Integer.parseInt(title_year));
                    }
                    else
                    {
                        movie.setTitle_year(Integer.parseInt(title_year));
                    }

                    //                                  //
                    //// IMDB score string to double. ////
                    //                                  //
                    String imdb_score = categories[count++];
                    if(imdb_score.isEmpty())
                    {
                        imdb_score = "-1";
                        movie.setImdb_score(Double.parseDouble(imdb_score));
                    }
                    else
                    {
                        movie.setImdb_score(Double.parseDouble(imdb_score));
                    }

                    // Stores movie object into movie database.
                    db[movieIndex] = movie;

                    // Increases movie database index after movie object is stored.
                    movieIndex++;
                }
            }
            // Closes scanner.
            finally
            {
                scanner.close();
            }
        }
        // Catches file not found exception.
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // Create a new red black tree by field.
    public void addFieldIndex(String field)
    {
        // Creates Red Black Tree
        RedBlackBST<T, HashSet<Integer>> movieFieldRBT = new RedBlackBST<>();

        // Switch case by movie field and calls store more field RBT.
        switch(field)
        {
            case "color":
                // Populates the red black true with movie title and id as key value pairs.
                for (int i = 0; i < db.length; i++) {
                    // If movie title is already stored in the rbt, append duplicate
                    // movie title id to existing movie title hash set.
                    if (movieFieldRBT.contains((T) db[i].getColor())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getColor());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        // Creates hash set.
                        HashSet<Integer> set = new HashSet<>();

                        // Converts String ID to integer and adds to hash set.
                        set.add(db[i].getId());

                        // Puts movie title and hash set movie id into red black tree.
                        movieFieldRBT.put((T) db[i].getColor(), set);

                        // Puts red black tree into index tree map.
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "movie_title":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getMovie_title())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getMovie_title());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getMovie_title(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getMovie_title(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "duration":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getDuration())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getDuration());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getDuration(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getDuration(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "director_name":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getDirector_name())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getDirector_name());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getDirector_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getDirector_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_1_name":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getActor_1_name())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getActor_1_name());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getActor_1_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add((db[i].getId()));
                        movieFieldRBT.put((T) db[i].getActor_1_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_2_name":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getActor_2_name())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getActor_2_name());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getActor_2_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getActor_2_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "actor_3_name":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getActor_3_name())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getActor_3_name());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getActor_3_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add((Integer) db[i].getId());
                        movieFieldRBT.put((T) db[i].getActor_3_name(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "movie_imdb_link":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getMovie_imdb_link())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getMovie_imdb_link());
                        set.add((db[i].getId()));
                        movieFieldRBT.put((T) db[i].getMovie_imdb_link(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getMovie_imdb_link(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "language":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getLanguage())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getLanguage());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getLanguage(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getLanguage(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "country":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getCountry())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getCountry());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getCountry(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add( db[i].getId());
                        movieFieldRBT.put((T) db[i].getCountry(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "content_rating":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getContent_rating())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getContent_rating());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getContent_rating(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getContent_rating(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "title_year":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getTitle_year()))
                    {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getTitle_year());
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getTitle_year(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getTitle_year(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            case "imdb_score":
                for (int i = 0; i < db.length; i++) {
                    if (movieFieldRBT.contains((T) db[i].getImdb_score())) {
                        HashSet<Integer> set = movieFieldRBT.get((T) db[i].getImdb_score());
                        set.add((db[i].getId()));
                        movieFieldRBT.put((T) db[i].getImdb_score(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    } else {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(db[i].getId());
                        movieFieldRBT.put((T) db[i].getImdb_score(), set);
                        indexTreeMap.put(field, movieFieldRBT);
                    }
                }
                break;
            default:
                System.out.println("Field not found.");
        }
    }

    public Map<String, RedBlackBST<T, HashSet<Integer>>> getIndexTreeMap()
    {
        return indexTreeMap;
    }

    // Prints returned hash set.
    public void print(int id)
    {
        id = id - 1;
        System.out.println(db[id].getId() + " " + db[id].getColor() + " " + db[id].getMovie_title() + " " +
                db[id].getDuration() + " " + db[id].getDirector_name() + " " + db[id].getActor_1_name() + " " +
                db[id].getActor_2_name() + " " + db[id].getActor_3_name() + " " + db[id].getMovie_imdb_link() + " " +
                db[id].getLanguage() + " " + db[id].getCountry() + " " + db[id].getContent_rating() + " " +
                db[id].getTitle_year() + " " + db[id].getImdb_score());
    }

    // Counts each line in the file and returns file size for movie data base array size.
    public static int getFileSize()
    {
        int fileSize = 0;
        try
        {
            // Creates scanner to scan file.
            Scanner scanner = new Scanner(new File(fileName));
            try
            {
                // Scans category line, because it shouldn't be stored.
                scanner.nextLine();
                //
                while (scanner.hasNextLine())
                {
                    scanner.nextLine();
                    fileSize++;
                }
            }
            // Closes scanner when no longer needed.
            finally
            {
                scanner.close();
            }
        }
        // Catches file not found exception.
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return fileSize;
    }

    // Prints array of movie objects.
    public static void printMovieDatabase(Movie[] db)
    {
        for (Movie x : db)
        {
            System.out.println(x.getId() + " " + x.getColor() + " " + x.getMovie_title() + " " +
                    x.getDuration() + " " + x.getDirector_name() + " " + x.getActor_1_name() + " " +
                    x.getActor_2_name() + " " + x.getActor_3_name() + " " + x.getMovie_imdb_link() + " " +
                    x.getLanguage() + " " + x.getCountry() + " " + x.getContent_rating() + " " +
                    x.getTitle_year() + " " + x.getImdb_score());
        }
    }

    // Returns the hash map for index trees (red black trees).
    public static void main(String[] args) throws FileNotFoundException {
        MoviesDB movieDB = new MoviesDB();
        fileSize = getFileSize();
        db = new Movie[fileSize];
        MoviesDB();
//        printMovieDatabase(db);

        //        To Do      //
        //// Setup Queries ////
        //                   //

        movieDB.addFieldIndex("country");
        movieDB.addFieldIndex("content_rating");
        Query<Integer> query = new Equal("country", "Australia");
        HashSet<Integer> result = query.execute(movieDB.getIndexTreeMap());
        if (result != null)
        {
            System.out.println("Red Black Tree Index Results:");
            System.out.println(result + "\n");
        }
        Iterator<Integer> idIterator = result.iterator();
        while(idIterator.hasNext())
        {
            int id = idIterator.next();
            movieDB.print(id);
        }

    }
}