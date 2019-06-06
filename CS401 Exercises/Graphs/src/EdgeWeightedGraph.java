import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraph
{
    private int v;
    private int e;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int v)
    {
        this.v = v;
        adj = new Bag[v];
        for(int i = 0; i < v; i++)
        {
            adj[i] = new Bag<Edge>();
        }
    }

    public void addEdge(Edge edge)
    {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v)
    {
        return adj[v];
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
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < v; i++)
        {
            stringBuffer.append(i + ":");
            for(Edge e : adj(i))
            {
                stringBuffer.append(e);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
