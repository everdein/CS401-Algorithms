import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDirectedGraph
{
    private int v;
    private int e;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDirectedGraph(int v)
    {
        this.v = v;
        adj = new Bag[v];
        for(int i = 0; i < v; i++)
        {
            adj[i] = new Bag<DirectedEdge>();
        }
    }

    public void addEdge(DirectedEdge directedEdge)
    {
//        int v = directedEdge.from();
//        int w = directedEdge.to();
//        adj[v].add(directedEdge);
//        adj[w].add(directedEdge);
//        e++;
        int v = directedEdge.from();
        adj[v].add(directedEdge);
        e++;
    }

    public Iterable<DirectedEdge> adj(int v)
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
            stringBuffer.append(i + ": ");
            for(DirectedEdge directedEdge : adj(i))
            {
                stringBuffer.append(directedEdge);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
