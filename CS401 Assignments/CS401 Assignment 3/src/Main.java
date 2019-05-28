import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main  <T extends Comparable<T>>
{


    public static MovieDatabase MDB;

    public static void main(String[] args)
    {
        Main MovieDB = new Main();
        // Gets file size to set array size.
        int fileSize = getFileSize();

        // Creates movie database array to store movie object.
        Movie[] movieDatabase = new Movie[fileSize];

        // Creates map to store red black trees.
//        Map<String, RedBlackBST<T, HashSet<Integer>>> movieFieldsRBTMap = new HashMap<>();

        // Calls methods.
        loadArray(movieDatabase);
        printArray(movieDatabase);
        MDB.addFieldToRBT(movieDatabase);
//        MovieDatabase.add

        // To-Do
        // Setup Queries

        // Equal to query.
        Query query = (Query) new EqualTo("color", "Color");

//        Query query = (Query) new EqualTo("color", "Color");

        // Less than query.
//        Query query = new LessThan("title_year", "2012");

        // Greater than query.
//        Query query = new GreaterThan("title_year", "2012");

        // Or query.
//        Query query = new Or(new EqualTo("color", " Black and White"), new EqualTo("title_year", "2012"));

        // And query.
//        Query query = new And(new EqualTo("color", " Black and White"), new EqualTo("title_year", "2012"));


        // Not query.
//        Query query = new Not(new EqualTo("color", "Color"));

        // Query Execute.
        HashSet<Integer> result = query.execute(MDB.movieFieldsRBTMap);

//        if (result != null)
//        {
//            System.out.println("Red Black Tree Index Results:");
//            System.out.println(result + "\n");
//        }
        Iterator<Integer> idIterator = result.iterator();
        while(idIterator.hasNext())
        {
            int id = idIterator.next();
            print(movieDatabase, id);
        }

    }

    // Counts each line in the file and returns file size for movie data base array size.
    public static int getFileSize()
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
    public static void loadArray(Movie[] movieDatabase)
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
    public static void printArray(Movie[] movieDatabase)
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

    // Prints returned hash set.
    public static void print(Movie[] movieDatabase, int id)
    {
        id = id - 1;
        System.out.println(movieDatabase[id].getId() + " " + movieDatabase[id].getColor() + " " + movieDatabase[id].getMovie_title() + " " +
                movieDatabase[id].getDuration() + " " + movieDatabase[id].getDirector_name() + " " + movieDatabase[id].getActor_1_name() + " " +
                movieDatabase[id].getActor_2_name() + " " + movieDatabase[id].getActor_3_name() + " " + movieDatabase[id].getMovie_imdb_link() + " " +
                movieDatabase[id].getLanguage() + " " + movieDatabase[id].getCountry() + " " + movieDatabase[id].getContent_rating() + " " +
                movieDatabase[id].getTitle_year() + " " + movieDatabase[id].getImdb_score());
    }
}