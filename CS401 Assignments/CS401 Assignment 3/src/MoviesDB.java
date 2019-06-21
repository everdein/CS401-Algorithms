// Author       :   Alex Kourkoumelis, Matthew Clark
// Date         :   5/28/2019
// Title        :   IMDB Movie Database and Query Generator
// Class        :   CS401, Algorithms
// Assignment   :   Assignment 3
// Description  :   Develop a movie database and query generator for IMDB movie data.
//              :   Stores .csv data into an array of Movie objects.
//              :   Creates RedBlackTrees of each field, with the key being the
//              :   field-value and value being a HashSet of all movie ID's containing
//              :   the same field-value.
//              :   All RedBlackTrees are stored in a HashMap with their fields as the
//              :   key and the RBT as value.
//              :   Allows creation of queries by combining one or more of the following
//              :   queries:
//              :   &&, ||, ^, <, <=, >, >=, =, ==, !=, !
//              :   Executes the queries and prints the resulting set.

//              :   General Layout:
//              :   Query (interface) -> And, Or, Not, UnaryExpression
//              :       -execute, getField
//              :   UnaryExpression (abstract) -> Equal, GT, GTE, LT, LTE, NotEqual
//              :       -execute, field, value, getField


import edu.princeton.cs.algs4.RedBlackBST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MoviesDB<T extends Comparable<T>> {

    private Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap
            = new HashMap<String, RedBlackBST<T, HashSet<Integer>>>();
    private static Movie[] db;

    public static void main(String[] args) {
        MoviesDB movieDB = new MoviesDB("movie_metadata.csv");

        // these don't all need to be added, just the fields being queries on
        movieDB.addFieldIndex("color");
        movieDB.addFieldIndex("title");
        movieDB.addFieldIndex("duration");
        movieDB.addFieldIndex("director");
        movieDB.addFieldIndex("actor1");
        movieDB.addFieldIndex("actor2");
        movieDB.addFieldIndex("actor3");
        movieDB.addFieldIndex("url");
        movieDB.addFieldIndex("language");
        movieDB.addFieldIndex("country");
        movieDB.addFieldIndex("rating");
        movieDB.addFieldIndex("year");
        movieDB.addFieldIndex("score");

        // queries can be customized here
        Query query = new LT("duration", 300);
        HashSet<Integer> result = (HashSet<Integer>) query.execute(movieDB.getIndexTreeMap());

        // prints results
        if(result != null) {
            Iterator<Integer> idIterator = result.iterator();
            int i = 0;
            while(idIterator.hasNext()) {
                int id = idIterator.next();
                movieDB.print(id);
                i++;
            }
            System.out.println("\nTotal Number of Results: " + i);
        }
    }

    // prints all the information of a movie pertaining to the given ID
    public void print(int id) {
        System.out.println("============================================");
        System.out.println("id: " + db[id-1].getId());
        System.out.println("color: " + db[id-1].getColor());
        System.out.println("title: " + db[id-1].getTitle());
        System.out.println("duration: " + db[id-1].getDuration());
        System.out.println("director: " + db[id-1].getDirector());
        System.out.println("actor1: " + db[id-1].getActor1());
        System.out.println("actor2: " + db[id-1].getActor2());
        System.out.println("actor3: " + db[id-1].getActor3());
        System.out.println("url: " + db[id-1].getUrl());
        System.out.println("language: " + db[id-1].getLanguage());
        System.out.println("country: " + db[id-1].getCountry());
        System.out.println("rating: " + db[id-1].getRating());
        System.out.println("year: " + db[id-1].getYear());
        System.out.println("score: " + db[id-1].getScore());

    }

    // loads the file and its contents. Some data is off, so Regex is utilized or the data is casted.
    // An int, lineCount, is used to iterate through the data easily. This makes the code
    // more expandable. If more columns were added or removed we could simply comment the line out
    // that pertains to it, or add a line to represent the new column.
    public MoviesDB(String filename) {
        String line;
        String[] categories;
        int row = 0;
        int lineCount = getLineCount(filename);
        db = new Movie[lineCount];
        Movie movie;
        int column = 0;

        // scans .csv and stores movie objects into array
        try (Scanner scanner = new Scanner(new File(filename))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                movie = new Movie();

                line = scanner.nextLine();
                // splits by commas, unless the commas are between two quotes
                categories = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // sets each field
                // some fields are empty, in these cases we catch them
                // and replace with "-1" or -1.
                movie.setId(Integer.parseInt(categories[column++]));
                if(categories[column].equals("")) {
                    movie.setColor("-1");
                    column++;
                } else {
                    movie.setColor(categories[column++]);
                }
                movie.setTitle(categories[column++]);
                if(categories[column].equals("")) {
                    movie.setDuration(-1);
                    column++;
                } else {
                    movie.setDuration(Integer.parseInt(categories[column++]));
                }
                movie.setDirector(categories[column++]);
                movie.setActor1(categories[column++]);
                movie.setActor2(categories[column++]);
                movie.setActor3(categories[column++]);
                movie.setUrl(categories[column++]);
                movie.setLanguage(categories[column++]);
                movie.setCountry(categories[column++]);
                movie.setRating(categories[column++]);
                if(categories[column].equals("")) {
                    movie.setYear(-1);
                    column++;
                } else {
                    movie.setYear(Integer.parseInt(categories[column++]));
                }
                if(categories[column].equals("")) {
                    movie.setScore(-1);
                } else {
                    movie.setScore(Double.parseDouble(categories[column]));
                }

                column = 0;
                db[row] = movie;
                row++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // returns the HashMap with all the loaded fields
    public Map<String, RedBlackBST<T, HashSet<Integer>>> getIndexTreeMap() {
        return indexTreeMap;
    }

    // finds the number of lines in the file
    private static int getLineCount(String fileName) {
        int lineCount = 0;
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

    // this is ugly but necessary
    // creates a RBT and populates it depending on the desired field passed
    // then stores the RBT into the HashMap
    public void addFieldIndex(String field) {
        RedBlackBST<T, HashSet<Integer>> fieldRBT = new RedBlackBST<>();

        switch(field) {
            case "color":
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getColor())) {
                        // if the colorRBT already has this color, then grab the
                        // hash set and add the id
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getColor());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getColor(), setofIds);
                    } else {
                        // otherwise, we add a new color into the colorRBT
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getColor(), setofIds);
                    }
                }
                break;

            case "title":
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getTitle())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getTitle());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getTitle(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getTitle(), setofIds);
                    }
                }
                break;

            case "duration" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getDuration())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getDuration());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getDuration(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getDuration(), setofIds);
                    }
                }
                break;

            case "director" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getDirector())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getDirector());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getDirector(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getDirector(), setofIds);
                    }
                }
                break;

            case "actor1" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getActor1())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getActor1());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor1(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor1(), setofIds);
                    }
                }
                break;

            case "actor2" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getActor2())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getActor2());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor2(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor2(), setofIds);
                    }
                }
                break;

            case "actor3" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getActor3())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getActor3());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor3(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getActor3(), setofIds);
                    }
                }
                break;

            case "url" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getUrl())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getUrl());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getUrl(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getUrl(), setofIds);
                    }
                }
                break;

            case "language" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getLanguage())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getLanguage());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getLanguage(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getLanguage(), setofIds);
                    }
                }
                break;

            case "country" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getCountry())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getCountry());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getCountry(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getCountry(), setofIds);
                    }
                }
                break;

            case "rating" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getRating())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getRating());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getRating(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getRating(), setofIds);
                    }
                }
                break;

            case "year" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getYear())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getYear());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getYear(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getYear(), setofIds);
                    }
                }
                break;

            case "score" :
                for (Movie movie: db) {
                    if(fieldRBT.contains((T) movie.getScore())) {
                        HashSet<Integer> setofIds = fieldRBT.get((T) movie.getScore());
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getScore(), setofIds);
                    } else {
                        HashSet<Integer> setofIds = new HashSet<>();
                        setofIds.add(movie.getId());
                        fieldRBT.put((T) movie.getScore(), setofIds);
                    }
                }
                break;

            default:
                System.out.println("field is confusing, try that again");
        }
        indexTreeMap.put(field, fieldRBT);
    }
}
