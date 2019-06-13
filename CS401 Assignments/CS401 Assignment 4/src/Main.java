import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class Main
{
    public static Digraph directedGraph1 = new Digraph(2101);
    public static EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(18746);
    public static Map<Integer, String> hashMap = new HashMap<>();


    public static void main(String[] args)
    {
        // Sets file name.
        String fileName1 = "user_friends.dat";
        createUserFriendGraph(fileName1);

        // Sets file name.
        String fileName2 = "user_artists.dat";
        createUserArtistsGraph(fileName2);

        // Sets file name.
        String fileName3 = "artists.dat";
        getArtists(fileName3);

        // Declares user ID.
        int user = 3;
        int user1 = 4;
        int user2 = 31;

        // Calls queries.
        listFriends(user);
        commonFriends(user1, user2);
        listArtists(user1, user2);
//        recommend10(user);
        listTop10();
    }

    public static void createUserFriendGraph(String fileName1)
    {
        List<Integer> list = getVerticesAndUserFriendsFileSize(fileName1);
        int numberOfVertices = list.get(0);
        int fileSize = list.get(1);

        In in = new In(fileName1);
        in.readLine();
        for(int i = 0; i < fileSize; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            directedGraph1.addEdge(v, w);
        }
    }

    public static List getVerticesAndUserFriendsFileSize(String fileName1)
    {
        In in = new In(fileName1);
        in.readLine();
        HashSet hashSet = new HashSet();

        int fileSize = 0;
        while(!in.isEmpty())
        {
            int userID = in.readInt();
            int friendID = in.readInt();
            hashSet.add(userID);
            fileSize++;
        }
        List<Integer> list = new ArrayList();
        list.add(hashSet.size());
        list.add(fileSize);
        return list;
    }

    public static void createUserArtistsGraph(String fileName2)
    {
        List<Integer> list = getVerticesAndUserArtistsFileSize(fileName2);
        int numberOfVertices = list.get(0);
        int fileSize = list.get(1);

        In in = new In(fileName2);
        in.readLine();
        for(int i = 0; i < fileSize; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            int weight = in.readInt();
            DirectedEdge directedEdge = new DirectedEdge(v, w, weight);
            edgeWeightedDigraph.addEdge(directedEdge);
        }
    }

    public static List getVerticesAndUserArtistsFileSize(String fileName2)
    {
        In in = new In(fileName2);
        in.readLine();
        HashSet hashSet = new HashSet();

        int fileSize = 0;
        while(!in.isEmpty())
        {
            int userID = in.readInt();
            int friendID = in.readInt();
            int weight = in.readInt();
            hashSet.add(userID);
            fileSize++;
        }
        List<Integer> list = new ArrayList();
        list.add(hashSet.size());
        list.add(fileSize);
        return list;
    }

    public static void getArtists(String fileName3)
    {
        In in = new In(fileName3);
        in.readLine();
        while(!in.isEmpty())
        {
            String line = in.readLine();
            String[] parts = line.split("\\s+");
            String artist = "";
            for(int i = 1; i < parts.length - 2; i++)
            {
                artist += parts[i] + " ";
            }
            hashMap.put(Integer.parseInt(parts[0]), artist);
        }
    }

    public static void listFriends(int user)
    {
        System.out.print("User "+ user + "'s friend's list contains: ");
        for (int friend : directedGraph1.adj(user))
        {
            System.out.print(" " + friend);
        }
        System.out.println("\n");
    }

    public static void commonFriends(int user1, int user2)
    {
        for (int friend1 : directedGraph1.adj(user1))
        {
            for (int friend2 : directedGraph1.adj(user2))
            {
                if(friend1 == friend2)
                {
                    System.out.println("User: "+ user1 + " and User: " + user2 + " have user " + friend1 + " in common.");
                }
            }
        }
        System.out.println();

    }

    public static void listArtists(int user1, int user2)
    {
        for (DirectedEdge directedEdge1 : edgeWeightedDigraph.adj(user1))
        {
            for (DirectedEdge directedEdge2 : edgeWeightedDigraph.adj(user2))
            {
                if(directedEdge1.to() == directedEdge2.to())
                {
                    System.out.println("User: "+ user1 + " and User: " + user2 + " have user " + hashMap.get(directedEdge1.to()) + "in common.");
                }
            }
        }
        System.out.println();
    }

    public static void listTop10()
    {
        // TODO
        Double[] unsortedArray = new Double[18746];
        Double[] sortedArray = new Double[18746];

        for(int i = 0; i < unsortedArray.length; i++)
        {
            unsortedArray[i] = 0.0;
            sortedArray[i] = 0.0;
        }

        for(int i = 2; i < 2101; i++)
        {
            for (DirectedEdge directedEdge : edgeWeightedDigraph.adj(i))
            {
                unsortedArray[directedEdge.to()] = unsortedArray[directedEdge.to()] + directedEdge.weight();
                sortedArray[directedEdge.to()] = sortedArray[directedEdge.to()] + directedEdge.weight();
            }
        }

        Arrays.sort(sortedArray);

        for(int i = sortedArray.length - 1; i >= sortedArray.length - 10; i--)
        {
            System.out.println(sortedArray[i]);
        }

        for(int i = sortedArray.length - 1; i >= sortedArray.length - 10; i--)
        {
            System.out.println("Sorted Array Index: " + i);
            for(int j = 0; j <= unsortedArray.length - 1; j++)
            {
                System.out.println("Unsorted Array Index: " + j);
                if(unsortedArray[j] == sortedArray[i])
                {
                    System.out.println("Artist ID: " + j + " has " + sortedArray[i] + " plays.");
                }
            }
        }

    }

    public static void recommend10(int user)
    {
        // TODO

    }
}