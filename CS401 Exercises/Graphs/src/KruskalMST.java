import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST
{
    private Queue<Edge> mst;
    private UF uf;
    private MinPQ<Edge> pq;
    private double weight;

    //Compute a minimum spanning tree (or forest) of an edge-weighted graph.
    public KruskalMST(EdgeWeightedGraph graph)
    {
        mst = new Queue<Edge>();
        uf = new UF(graph.v());
        pq = new MinPQ<Edge>();

        for(int v=0;v<graph.v();v++)
        {
            for (Edge edge: graph.adj(v))
            {
                if(edge.other(v)>v)
                {
                    pq.insert(edge);
                }
            }
        }

        while(!pq.isEmpty() && mst.size()!=graph.v()-1)
        {
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if(!uf.connected(v, w)) // v-w does not create a cycle
            {
                uf.union(v, w);			// merge v and w components
                mst.enqueue(minEdge);   // add edge e to mst
                weight +=minEdge.weight();
            }

        }

    }
    //Returns the edges in a minimum spanning tree (or forest).
    public Iterable<Edge> mst(){
        return mst;
    }

    //Returns the sum of the edge weights in a minimum spanning tree (or forest).
    public double weight() {
        return weight;
    }

}
