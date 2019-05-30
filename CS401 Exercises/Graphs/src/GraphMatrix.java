import java.util.ArrayList;
import java.util.List;

public class GraphMatrix
{

    private int vertices; // vertices
    private int edges; // edges
    private boolean[][] adj;

    public GraphMatrix(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        adj = new boolean[vertices][vertices];
    }

    // two vertices passed as parameters
    public void addEdge(int vertices, int w)
    {
        if(!adj[vertices][w])
        {
            edges++;
        }
        adj[vertices][w] = true;
        adj[w][vertices] = true;
    }

    public void removeEdge(int vertices, int w)
    {
        if(!adj[vertices][w])
        {
            edges--;
        }
        adj[vertices][w] = false;
        adj[w][vertices] = false;
    }

    public boolean hasEdge(int vertices, int w)
    {
        return adj[vertices][w];
    }

    // return # of vertices
    public int v()
    {
        return vertices;
    }

    // return # of edges
    public int e()
    {
        return edges;
    }

    public Iterable<Integer> adj(int start)
    {
        List<Integer> adjList = new ArrayList<Integer>();
        for(int i = 0; i < vertices; i++)
        {
            if(adj[start][i])
            {
                adjList.add(i);
            }
        }
        return adjList;
    }

    public int degree(int start)
    {
        int degree = 0;
        for(int w: adj(start))
        {
            degree++;
        }
        return degree;
    }

    @Override
    public String toString()
    {
        StringBuilder graphString = new StringBuilder("");
        for(int i = 0; i < vertices; i++)
        {
            graphString.append(i + ": ");
            for(int j = 0; j < vertices; j++)
            {
                if(adj[i][j])
                {
                    graphString.append(j + " ");
                }
            }
            graphString.append("\n");
        }
        return graphString.toString();
    }
}