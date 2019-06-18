// Algs-4 Imports.
import edu.princeton.cs.algs4.*;

// Jupiter Imports.
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Java imports.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class SocialNetworkSystemTest
{
    // Declares class objects.
    private static UserFriendGraph userFriendGraph = new UserFriendGraph();
    private static UserArtistGraph userArtistGraph = new UserArtistGraph();
    private static ArtistsMap artistsMap = new ArtistsMap();

    @Test
    @DisplayName("Checks Equality for List Artists:")
    public void listFriends()
    {
        // Declares filename and gets directed grpah.
        String fileName1 = "user_friends.dat";
        Digraph directedGraph = userFriendGraph.createUserFriendGraph(fileName1);

        // Creates two array lists to store user data.
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        // Declares user.
        int user = 3;

        // Lists the users friends.
        for (int friend : directedGraph.adj(user))
        {
            arrayList1.add(friend);
        }

        // Adds data to arrayList2 to compare against arrayList1.
        arrayList2.add(1975);
        arrayList2.add(1801);
        arrayList2.add(1740);
        arrayList2.add(837);
        arrayList2.add(460);
        arrayList2.add(255);
        arrayList2.add(78);

        // Compares arrayList1 data against arrayList2 data.
        for(int i = 0; i < arrayList1.size(); i++)
        {
            assertEquals(arrayList1.get(i), arrayList2.get(i));
        }
    }

    @Test
    @DisplayName("Checks Common Friends Between Two Users.")
    public void commonFriends()
    {
        // Declares filename and gets directed grpah.
        String fileName1 = "user_friends.dat";
        Digraph directedGraph = userFriendGraph.createUserFriendGraph(fileName1);

        // Creates two array lists to store user data.
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        // Declares two users.
        int user1 = 3;
        int user2 = 31;

        // Gets common friends between both users.
        for (int friend1 : directedGraph.adj(user1))
        {
            for (int friend2 : directedGraph.adj(user2))
            {
                if(friend1 == friend2)
                {
                    arrayList1.add(friend1);
                }
            }
        }

        // Adds data to arrayList2 to compare against arrayList1.
        arrayList2.add(534);
        arrayList2.add(520);
        arrayList2.add(211);
        arrayList2.add(99);

        // Compares arrayList1 data against arrayList2 data.
        for(int i = 0; i < arrayList1.size(); i++)
        {
            assertEquals(arrayList1.get(i), arrayList2.get(i));
        }
    }

    @Test
    @DisplayName("Checks Equality for List Artists:")
    public void listArtists()
    {
        // Declares two users.
        int user1 = 3;
        int user2 = 4;

        // Lists artists both users listen to and check their equality.
        for (DirectedEdge directedEdge1 : userArtistGraph.edgeWeightedDigraph.adj(user1))
        {
            for (DirectedEdge directedEdge2 : userArtistGraph.edgeWeightedDigraph.adj(user2))
            {
                if(directedEdge1.to() == directedEdge2.to())
                {
                    assertEquals(directedEdge1.to(), directedEdge2.to());
                }
            }
        }
    }

    @Test
    @DisplayName("Checks Top 10 is accurate.")
    public void listTop10()
    {
        // Declares filename 2 and gets edge weighted directed graph.
        String fileName2 = "user_artists.dat";
        EdgeWeightedDigraph edgeWeightedDigraph = userArtistGraph.createUserArtistsGraph(fileName2);

        // Creates two array lists to store user data.
        ArrayList<Double> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();

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
                    arrayList1.add(sortedArray[i]);
                }
            }
        }

        // Adds data to arrayList2 to compare against arrayList1.
        arrayList2.add(2393140.0);
        arrayList2.add(1301308.0);
        arrayList2.add(1291387.0);
        arrayList2.add(1058405.0);
        arrayList2.add(963449.0);
        arrayList2.add(921198.0);
        arrayList2.add(905423.0);
        arrayList2.add(688529.0);
        arrayList2.add(662116.0);
        arrayList2.add(532545.0);

        // Compares arrayList1 data against arrayList2 data.
        for(int i = 0; i < arrayList1.size(); i++)
        {
            assertEquals(arrayList1.get(i), arrayList2.get(i));
        }
    }

    @Test
    @DisplayName("Checks Recommend 10 Data for User 3:")
    public void recommend10()
    {
        // Declares filename 1 and gets edge weighted direct graph.
        String fileName2 = "user_artists.dat";
        EdgeWeightedDigraph edgeWeightedDigraph = userArtistGraph.createUserArtistsGraph(fileName2);

        // Declares filename 2 and gets directed graph.
        String fileName1 = "user_friends.dat";
        Digraph directedGraph = userFriendGraph.createUserFriendGraph(fileName1);

        // Declares filename 3 and gets hash map.
        String fileName3 = "artists.dat";
        HashMap artistMap = artistsMap.getArtists(fileName3);

        // Creates array list objects.
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        // Creates user 3.
        int user = 3;

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
            arrayList1.add(artist.getID());
        }

        // Adds data to arrayList2 to compare against arrayList1.
        arrayList2.add(101);
        arrayList2.add(3502);
        arrayList2.add(1975);
        arrayList2.add(1109);
        arrayList2.add(7079);
        arrayList2.add(8068);
        arrayList2.add(154);
        arrayList2.add(418);
        arrayList2.add(2667);
        arrayList2.add(16404);

        // Compares arrayList1 data against arrayList2 data.
        for(int i = 0; i < arrayList1.size(); i++)
        {
            assertEquals(arrayList1.get(i), arrayList2.get(i));
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

    @Test
    @DisplayName("Checks for Not Null Artist Object:")
    public void fillingMapWithArtists()
    {
        // Creates artist object.
        Artist artist = new Artist();

        // Adds artist information.
        artist.setID(10);
        artist.setName("matt");
        artist.setWeight(0.0);

        // Checks if artist object is null.
        assertNotNull(artist);
    }
}
