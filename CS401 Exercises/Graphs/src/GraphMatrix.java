import java.util.ArrayList;
import java.util.List;

public class GraphMatrix
{

    private int v; // vertices
    private int e; // edges
    private boolean[][] adj;

    public GraphMatrix(int v)
    {
        this.v = v;
        this.e = 0;
        adj = new boolean[v][v];
    }

    // two vertices passed as parameters
    public void addEdge(int v, int w)
    {
        if(!adj[v][w])
        {
            e++;
        }
        adj[v][w] = true;
        adj[w][v] = true;
    }

    public void removeEdge(int v, int w)
    {
        if(!adj[v][w])
        {
            e--;
        }
        adj[v][w] = false;
        adj[w][v] = false;
    }

    public boolean hasEdge(int v, int w)
    {
        return adj[v][w];
    }

    // return # of vertices
    public int v()
    {
        return v;
    }

    // return # of edges
    public int e()
    {
        return e;
    }

    public Iterable<Integer> adj(int s)
    {
        List<Integer> adjList = new ArrayList<Integer>();
        for(int i = 0; i < v; i++)
        {
            if(adj[s][i])
            {
                adjList.add(i);
            }
        }
        return adjList;
    }

    public int degree(int s)
    {
        int degree = 0;
        for(int w: adj(s))
        {
            degree++;
        }
        return degree;
    }

    @Override
    public String toString()
    {
        StringBuilder graphStr = new StringBuilder("");
        for(int i = 0; i < v; i++)
        {
            graphStr.append(i + ":");
            for(int j = 0; j < v; j++)
            {
                if(adj[i][j])
                {
                    graphStr.append(j + " ");
                }
            }
            graphStr.append("\n");
        }
        return graphStr.toString();
    }
}