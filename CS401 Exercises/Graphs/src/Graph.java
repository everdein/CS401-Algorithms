import java.util.LinkedList;

public class Graph
{
    private int v;
    private int e;
    private LinkedList<Integer>[] adj;
    public Graph(int v)
    {
        this.v = v;
        this.e = 0;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

//    public void removeEdge(int v, int w)
//    {
//
//    }
//
//    public boolean hasEdge(int v, int w)
//    {
//
//    }

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
    public Iterable<Integer> adj(int v)
    {
        return adj[v];
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
            graphStr.append(i + ": ");
            for(int w: adj[i])
            {
                graphStr.append(w + " ");
            }
            graphStr.append("\n");
        }
        return graphStr.toString();
    }
}
