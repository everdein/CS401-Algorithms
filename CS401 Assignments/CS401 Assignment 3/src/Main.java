import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        String line = null;
        String[] categories;
        Movie[] movieDatabase = new Movie[5];
        Movie movie;
        int movieIndex = 0;

        try (Scanner scanner = new Scanner(new File("movie_metadata5.csv")))
        {
            scanner.nextLine();
            while(scanner.hasNextLine())
            {
                // Creates movie object.
                movie = new Movie();
                // Stores next line in csv.
                line = scanner.nextLine();
                // Stores parsed line into categories array.
                categories = line.split(",");
                // Sets categories into movie object.

                System.out.println(categories[2]);

                // Initializes count to zero to increase index of movies.
                int count = 0;

                movie.setId(Integer.parseInt(categories[count++]));
                movie.setColor(categories[count++]);
                movie.setMovie_title(categories[count++]);
                movie.setDuration(Integer.parseInt(categories[count++]));
                movie.setDirector_name(categories[count++]);
                movie.setActor_1_name(categories[count++]);
                movie.setActor_2_name(categories[count++]);
                movie.setActor_3_name(categories[count++]);
                movie.setMovie_imdb_link(categories[count++]);
                movie.setLanguage(categories[count++]);
                movie.setCountry(categories[count++]);
                movie.setContent_rating(categories[count++]);
                movie.setTitle_year(Integer.parseInt(categories[count++]));
                movie.setImdb_score(Double.parseDouble(categories[count++]));

                // Stores movie object into movie database.
                movieDatabase[movieIndex] = movie;
                movieIndex++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        for (Movie x : movieDatabase)
        {
            System.out.println(x);
        }

        System.out.println();

        for(int i =0; i < movieDatabase.length; i++)
        {
            System.out.println(movieDatabase[i]);
        }

        System.out.println();

        System.out.println(movieDatabase.toString());
    }
}
