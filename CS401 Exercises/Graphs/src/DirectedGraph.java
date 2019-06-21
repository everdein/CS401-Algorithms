import edu.princeton.cs.algs4.Bag;

public class DirectedGraph
{
    private int v;
    private int e;
    private Bag<Integer>[] adj;
    private int[] inDegree;

    public DirectedGraph(int v)
    {
        this.v = v;
        adj = new Bag[v];
        inDegree = new int[v];
        for (int i = 0; i < v; i++)
        {
            adj[i] = new Bag<>();
        }
        e = 0;
    }

    public void addEdge(int v, int w)
    {
        adj[v].add(w);
        inDegree[w]++;
        e++;
    }

    public Iterable<Integer> adj(int v)
    {
        return adj[v];
    }

    public int inDegree(int v)
    {
        return inDegree[v];
    }

    public int outDegree(int v)
    {
        return adj[v].size();
    }

    public int v()
    {
        return v;
    }

    public int e()
    {
        return e;
    }

    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        for (int v = 0; v < adj.length; v++)
        {
            strBuilder.append(v + ":");
            for (int w : adj(v))
            {
                strBuilder.append(w + " ");
            }
            strBuilder.append("\n");

        }
        return strBuilder.toString();
    }
}