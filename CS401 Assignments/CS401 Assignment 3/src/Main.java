import edu.princeton.cs.algs4.RedBlackBST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static MovieDatabase MDB;

    public static void main(String[] args)
    {
        // Creates map to store red black trees.
        Map<String, RedBlackBST<String, Set<Integer>>> movieFieldsRBTMap = new HashMap<>();

        // Gets file size to set array size.
        int fileSize = getFileSize();

        // Creates movie database array to store movie object.
        Movie[] movieDatabase = new Movie[fileSize];

        // Calls methods.
        loadArray(movieDatabase);
        addFieldToRBT(movieDatabase, movieFieldsRBTMap);
        printArray(movieDatabase);
    }

    // Counts each line in the file and returns file size for movie data base array size.
    private static int getFileSize()
    {
        int fileSize = 0;
        try
        {
            // Creates scanner to scan file.
            Scanner scanner = new Scanner(new File("movie_metadata.csv"));
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

    // Loads movie objects into movie database array.
    private static void loadArray(Movie[] movieDatabase)
    {
        try
        {
            // Creates scanner to scan file data.
            Scanner scanner = new Scanner(new File("movie_metadata.csv"));
            try
            {

                // Scans first line of file to skip categories.
                scanner.nextLine();

                // Declares movie index to increment category indices.
                int movieIndex = 0;

                // Scans every line in the file.
                while (scanner.hasNextLine()) {
                    // Creates movie object.
                    Movie movie = new Movie();

                    // Stores next line in csv.
                    String line = scanner.nextLine();

                    // Stores parsed line into categories array.
                    String[] categories = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                    // Initializes count to zero to increase index of movies.
                    int count = 0;

                    // Sets file data into movie categories.
                    movie.setId(categories[count++]);
                    movie.setColor(categories[count++]);
                    movie.setMovie_title(categories[count++]);
                    movie.setDuration(categories[count++]);
                    movie.setDirector_name(categories[count++]);
                    movie.setActor_1_name(categories[count++]);
                    movie.setActor_2_name(categories[count++]);
                    movie.setActor_3_name(categories[count++]);
                    movie.setMovie_imdb_link(categories[count++]);
                    movie.setLanguage(categories[count++]);
                    movie.setCountry(categories[count++]);
                    movie.setContent_rating(categories[count++]);
                    movie.setTitle_year(categories[count++]);
                    movie.setImdb_score(categories[count++]);

                    // Stores movie object into movie database.
                    movieDatabase[movieIndex] = movie;

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

    // Prints array of movie objects.
    private static void printArray(Movie[] movieDatabase)
    {
        for (Movie x : movieDatabase)
        {
            System.out.println(x.getId() + " " + x.getColor() + " " + x.getMovie_title() + " " +
                    x.getDuration() + " " + x.getDirector_name() + " " + x.getActor_1_name() + " " +
                    x.getActor_2_name() + " " + x.getActor_3_name() + " " + x.getMovie_imdb_link() + " " +
                    x.getLanguage() + " " + x.getCountry() + " " + x.getContent_rating() + " " +
                    x.getTitle_year() + " " + x.getImdb_score());
        }
    }

    // Adds field to red black tree.
    public static void addFieldToRBT(Movie[] movieDatabase, Map<String, RedBlackBST<String, Set<Integer>>> movieFieldsRBTMap)
    {
        MDB.addFieldIndex(movieDatabase, "color", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "movie_title", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "duration", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "director_name", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "actor_1_name", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "actor_2_name", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "actor_3_name", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "movie_imdb_link", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "language", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "country", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "content_rating", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "title_year", movieFieldsRBTMap);
        MDB.addFieldIndex(movieDatabase, "imdb_score", movieFieldsRBTMap);
    }
}