// Algs-4 Imports.
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

// Java Imports.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class UserArtistGraph
{
    // Creates edge weighted directed graph.
    EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(18746);

    // Creates the user artists graph.
    public EdgeWeightedDigraph createUserArtistsGraph(String fileName2)
    {
        List<Integer> list = getVerticesAndUserArtistsFileSize(fileName2);
        int fileSize = list.get(1);

        In in = new In(fileName2);
        in.readLine();
        for(int i = 0; i < fileSize; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge directedEdge = new DirectedEdge(v, w, weight);
            edgeWeightedDigraph.addEdge(directedEdge);
        }
        return edgeWeightedDigraph;
    }

    // Creates the Reads the file to get vertices and file size.
    private List getVerticesAndUserArtistsFileSize(String fileName2)
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
}
