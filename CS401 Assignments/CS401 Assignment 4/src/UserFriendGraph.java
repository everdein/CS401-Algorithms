// Algs-4 Imports.
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

// Java Imports.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class UserFriendGraph
{
    // Creates directed graph object.
    Digraph directedGraph = new Digraph(2101);

    // Creates the user friend graph.
    public Digraph createUserFriendGraph(String fileName1)
    {
        List<Integer> list = getVerticesAndUserFriendsFileSize(fileName1);
        int fileSize = list.get(1);

        In in = new In(fileName1);
        in.readLine();
        for(int i = 0; i < fileSize; i++)
        {
            int v = in.readInt();
            int w = in.readInt();
            directedGraph.addEdge(v, w);
        }
        return directedGraph;
    }

    // Gets the vertices and user friends file size.
    private List getVerticesAndUserFriendsFileSize(String fileName1)
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
}
