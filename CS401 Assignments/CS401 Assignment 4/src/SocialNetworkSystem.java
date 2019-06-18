/**
 * Matthew Clark
 * CS401 Algorithms
 * Assignment 4 - A Social-Network Based Recommendation System for last.fm.
**/

// Algs-4 Imports.
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

// Java imports.
import java.util.HashMap;

// Creates a social network recommendation system for artists.
public class SocialNetworkSystem
{
    private static Queries queries = new Queries();
    private static UserFriendGraph userFriendGraph = new UserFriendGraph();
    private static UserArtistGraph userArtistGraph = new UserArtistGraph();
    private static ArtistsMap artistsMap = new ArtistsMap();

    // Main method.
    public static void main(String[] args)
    {

        // Sets file name.
        String fileName1 = "user_friends.dat";
        Digraph directedGraph = userFriendGraph.createUserFriendGraph(fileName1);

        // Sets file name.
        String fileName2 = "user_artists.dat";
        EdgeWeightedDigraph edgeWeightedDigraph = userArtistGraph.createUserArtistsGraph(fileName2);

        // Sets file name.
        String fileName3 = "artists.dat";
        HashMap<Integer, String> artistMap = artistsMap.getArtists(fileName3);

        // Declares user ID.
        int user = 3;
        int user1 = 4;
        int user2 = 31;

        // Calls queries.
        queries.listFriends(user, directedGraph);
        queries.commonFriends(user1, user2, directedGraph);
        queries.listArtists(user1, user2, edgeWeightedDigraph, artistMap);
        queries.listTop10(edgeWeightedDigraph);
        queries.recommend10(user, directedGraph, edgeWeightedDigraph, artistMap);
    }
}