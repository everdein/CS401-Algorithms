import java.util.LinkedList;

public class Graph
{
    private int vertices;
    private int edges;
    private LinkedList<Integer>[] adj;
    public Graph(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int vertices, int w)
    {
        adj[vertices].add(w);
        adj[w].add(vertices);
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

    public Iterable<Integer> adj(int vertices)
    {
        return adj[vertices];
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
            for(int w: adj[i])
            {
                graphString.append(w + " ");
            }
            graphString.append("\n");
        }
        return graphString.toString();
    }
}
