// Algs-4 Imports.
import edu.princeton.cs.algs4.*;

// Java Imports.
import java.util.Arrays;
import java.util.HashMap;

class Queries
{
    // Prints the list of friends of the given user.
    public void listFriends(int user, Digraph directedGraph)
    {
        System.out.println("List Friends Method:\n--------------------");
        System.out.print("User "+ user + " is friends with");
        for (int friend : directedGraph.adj(user))
        {
            System.out.print(" " + friend);
        }
        System.out.println(".\n");
    }

    // Prints the user1's friends in common with user2.
    public void commonFriends(int user1, int user2, Digraph directedGraph)
    {
        System.out.println("Common Friends Method:\n----------------------");
        for (int friend1 : directedGraph.adj(user1))
        {
            for (int friend2 : directedGraph.adj(user2))
            {
                if(friend1 == friend2)
                {
                    System.out.println("User: "+ user1 + " and User: " + user2 + " have artist " + friend1 + " in common.");
                }
            }
        }
        System.out.println();
    }

    // Prints the list of artists listened by both users.
    public void listArtists(int user1, int user2, EdgeWeightedDigraph edgeWeightedDigraph, HashMap artistMap)
    {
        System.out.println("List Artists Method:\n--------------------");
        for (DirectedEdge directedEdge1 : edgeWeightedDigraph.adj(user1))
        {
            for (DirectedEdge directedEdge2 : edgeWeightedDigraph.adj(user2))
            {
                if(directedEdge1.to() == directedEdge2.to())
                {
//                    System.out.println("User: "+ user1 + " and User: " + user2 + " have user " + artistMap.hashMap.get(directedEdge1.to()) + "in common.");
                    System.out.println("User: "+ user1 + " and User: " + user2 + " have user " + artistMap.get(directedEdge1.to()) + "in common.");

                }
            }
        }
        System.out.println();
    }

    // Prints the list of top 10 most popular artists by all users.
    public void listTop10(EdgeWeightedDigraph edgeWeightedDigraph)
    {
        System.out.println("Top 10 Method:\n--------------");

        // Creates two arrays to store artist weights.
        Double[] unsortedArray = new Double[18746];
        Double[] sortedArray = new Double[18746];

        // Sets all indices to 0.0.
        for(int i = 0; i < unsortedArray.length; i++)
        {
            unsortedArray[i] = 0.0;
            sortedArray[i] = 0.0;
        }

        // Adds up how many plays artists have.
        for(int i = 2; i < 2101; i++)
        {
            for (DirectedEdge directedEdge : edgeWeightedDigraph.adj(i))
            {
                unsortedArray[directedEdge.to()] = unsortedArray[directedEdge.to()] + directedEdge.weight();
                sortedArray[directedEdge.to()] = sortedArray[directedEdge.to()] + directedEdge.weight();
            }
        }

        // Sorts array.
        Arrays.sort(sortedArray);

        // Prints top 10 most listened to artists.
        for(int i = sortedArray.length - 1; i >= sortedArray.length - 10; i--)
        {
            for(int j = 0; j <= unsortedArray.length - 1; j++)
            {
                if(sortedArray[i].equals(unsortedArray[j]))
                {
                    System.out.println("Artist ID: " + j + " has " + sortedArray[i] + " plays.");
                }
            }
        }
        System.out.println();
    }

    // Recommends 10 most listened to artists by the user and friends.
    public void recommend10(int user, Digraph directedGraph, EdgeWeightedDigraph edgeWeightedDigraph, HashMap artistMap)
    {
        System.out.println("Recommend 10 Method:\n--------------------");

        // Creates hash map to store artist id and object.
        HashMap<Integer, Artist> artistHashMap = new HashMap<>();

        // Sets artist attributes for user.
        for(DirectedEdge directedEdge : edgeWeightedDigraph.adj(user))
        {
            fillingMapWithArtists(artistHashMap, directedEdge, artistMap);
        }

        // Sets artist attribute for users friends.
        for(int friend : directedGraph.adj(user))
        {
            for (DirectedEdge directedEdge : edgeWeightedDigraph.adj(friend))
            {
                fillingMapWithArtists(artistHashMap, directedEdge, artistMap);
            }
        }

        // Creates minimum priority queue to store artists.
        MinPQ<Artist> pq = new MinPQ<>();

        // Inserts artists into priority queue.
        for(int id : artistHashMap.keySet())
        {
            pq.insert(artistHashMap.get(id));
        }

        // Delete minimum artist weight until the priority queue is of size 10.
        int pqSize = pq.size();
        for(int i = 0; i < pqSize - 10; i++)
        {
            pq.delMin();
        }

        // Flips the priority queue using a stack to show descending artist order by weight.
        Stack<Artist> flipPQ = new Stack<>();
        for (Artist artist : pq)
        {
            flipPQ.push(artist);
        }

        // Prints most listened to artist.
        for(Artist artist : flipPQ)
        {
            System.out.println("Artist ID: " + artist.getID());
            System.out.println("Artist Name: " + artist.getName());
            System.out.println("Number of Plays: " + artist.getWeight());
            System.out.println();
        }
    }

    // Fills map with artists the user and friends listen to, and updates artist weight to maximum weight.
    private void fillingMapWithArtists(HashMap<Integer, Artist> artistHashMap, DirectedEdge directedEdge, HashMap artistMap)
    {
        // Creates artist object.
        Artist artist = new Artist();

        // Sets artist id, name and weight.
        artist.setID(directedEdge.to());
        artist.setName((String) artistMap.get(directedEdge.to()));
        artist.setWeight(directedEdge.weight());

        // Checks if current artist weight is greater than artist wait already stored.
        if(artistHashMap.containsKey(directedEdge.to()) &&
                artistHashMap.get(directedEdge.to()).getWeight() < artist.getWeight())
        {
            artistHashMap.put(directedEdge.to(), artist);
        }
        // Puts the artist into the hash map if not already contained.
        else if(!artistHashMap.containsKey(directedEdge.to()))
        {
            artistHashMap.put(directedEdge.to(), artist);
        }
    }
}
